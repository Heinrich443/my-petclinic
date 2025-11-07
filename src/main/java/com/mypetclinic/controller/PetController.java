package com.mypetclinic.controller;

import com.mypetclinic.model.Owner;
import com.mypetclinic.model.Pet;
import com.mypetclinic.model.PetType;
import com.mypetclinic.model.PetValidator;
import com.mypetclinic.repository.PetTypeRepository;
import com.mypetclinic.service.OwnerService;
import com.mypetclinic.service.PetService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @InitBinder("pet")
	public void initPetBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new PetValidator());
	}

    @ModelAttribute("types")
    public Collection<String> getPetTypes() {
        List<PetType> petTypes = mapper.selectList(null);
        List<String> names = new ArrayList<>();
        for (PetType petType: petTypes) {
            names.add(petType.getName());
        }
        return names;
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Integer ownerId) {
        return ownerService.showOwner(ownerId);
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
        Pet pet = new Pet();
        owner.getPets().add(pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }
}
