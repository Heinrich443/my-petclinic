package com.mypetclinic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Owner;
import com.mypetclinic.model.Pet;
import com.mypetclinic.service.OwnerService;
import com.mypetclinic.service.PetService;
import com.mypetclinic.service.VisitService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @Autowired
    private PetService petService;

    @Autowired
    private VisitService visitService;

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    public OwnerController(OwnerService service) {
        this.service = service;
    }

    @InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

    @ModelAttribute("owner")
	public Owner findOwner(@PathVariable(name = "ownerId", required = false) @Nullable Integer ownerId) {
        if (null == ownerId) return new Owner();
        return service.showOwner(ownerId);
	}

    /**
     * 显示主人信息
     * @param ownerId
     * @return
     */
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Integer ownerId) {
        Owner owner = service.showOwner(ownerId);
        List<Pet> pets = petService.getPets(ownerId);
        pets.forEach(pet -> pet.setVisits(visitService.getVisits(pet.getId())));
        owner.setPets(pets);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(owner);
        modelAndView.setViewName("owners/ownerDetails");
        return modelAndView;
    }

    /**
     * 跳转到查找页面
     * @return
     */
    @GetMapping("/find")
    public String initFindForm() {
        return "owners/findOwners";
    }

    /**
     * 查找主人（分页+条件查询）
     * @param currentPage
     * @param owner
     * @param result
     * @param model
     * @return
     */
    @GetMapping()
    public String processFindForm(@RequestParam(defaultValue = "1") int page, Owner owner, BindingResult result, Model model) {
        // Model中需要传四个参数：listOwner currentPage totalPages totalItems

        if (null == owner.getLastName()) {
            owner.setLastName("");
        }

        Page<Owner> ownerPage = service.getPage(page, owner);

        if (ownerPage.getRecords().isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
			return "owners/findOwners";
        }

        // 当前页码
        model.addAttribute("currentPage", ownerPage.getCurrent());
        // 总页数
        model.addAttribute("totalPages", ownerPage.getPages());
        // 总记录条数
        model.addAttribute("totalItems", ownerPage.getTotal());
        // 总记录
        model.addAttribute("listOwners", ownerPage.getRecords());
        return "owners/ownersList";
    }

    /**
     * 跳转到新增页面
     * @return
     */
    @GetMapping("/new")
    public String initCreateForm() {
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    /**
     * 进行新增操作
     * @param owner
     * @param result
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/new")
    public String processCreationForm(@Validated Owner owner, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            // 传入的owner为空，返回错误信息并跳转到新增/修改页面
            redirectAttributes.addFlashAttribute("error", "There was an error in creating the owner.");
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }

        // 传入的owner不为空，加入数据库
        Boolean flag = service.createOwner(owner);
        if (!flag) {
            redirectAttributes.addFlashAttribute("error", "There was an error in creating the owner.");
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        return "redirect:/owners/" + owner.getId();
    }

    /**
     * 跳转到修改页面
     * @return
     */
    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm() {
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Validated Owner owner, BindingResult result, @PathVariable("ownerId") Integer id, RedirectAttributes redirectAttributes) {
        // 传入的owner为空，返回错误信息并跳转至新增/修改页面。
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "There was an error in updating the owner.");
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }

        // id不匹配，返回错误信息，跳转至修改页面
        if (!id.equals(owner.getId())) {
            result.rejectValue("id", "mismatch", "The owner ID in the form does not match the URL.");
			redirectAttributes.addFlashAttribute("error", "Owner ID mismatch. Please try again.");
            return "redirect:/owners/edit";
        }

        // 新增owner
        owner.setId(id);
        Boolean flag = service.editOwner(owner);
        if (!flag) {
            redirectAttributes.addFlashAttribute("error", "There was an error in updating the owner.");
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        return "redirect:/owners/" + owner.getId();
    }
}
