package com.mypetclinic.controller;

import com.mypetclinic.model.Owner;
import com.mypetclinic.model.Pet;
import com.mypetclinic.model.PetType;
import com.mypetclinic.repository.PetTypeRepository;
import com.mypetclinic.service.OwnerService;
import com.mypetclinic.service.PetService;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PetService petService;

    @Autowired
    private PetTypeRepository mapper;

    public PetController(OwnerService ownerService, PetService petService, PetTypeRepository mapper) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.mapper = mapper;
    }

    @InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}


    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return mapper.selectList(null);
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Integer ownerId) {
        Owner owner = ownerService.showOwner(ownerId);
        List<Pet> pets = petService.getPets(ownerId);
        owner.setPets(pets);
        return owner;
    }

    @ModelAttribute("pet")
    public @Nullable Pet findPet(@PathVariable("ownerId") Integer ownerId, @PathVariable(value = "petId", required = false) Integer petId) {
        if (null == petId) {
            return new Pet();
        }

        return petService.getPet(petId);
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, ModelMap model) {
        // Pet pet = new Pet();
        // owner.getPets().add(pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }

        pet.setTypeId(pet.getType().getId());
        // owner.getPets().add(pet);
        petService.savePet(pet);
        redirectAttributes.addFlashAttribute("message", "New Pet has been Added");
        return "redirect:/owners/{ownerId}";
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm() {
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(Owner owner, @Valid Pet pet, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }

        petService.editPet(pet);
        redirectAttributes.addFlashAttribute("message", "New Pet has been Edited");
        return "redirect:/owners/{ownerId}";
    }
}
