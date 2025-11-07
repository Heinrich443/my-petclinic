package com.mypetclinic.controller;

import com.mypetclinic.model.Owner;
import com.mypetclinic.model.Pet;
import com.mypetclinic.model.Visit;
import com.mypetclinic.service.OwnerService;
import com.mypetclinic.service.PetService;
import com.mypetclinic.service.VisitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}/visits/new")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private PetService petService;

    public VisitController(VisitService visitService, OwnerService ownerService, PetService petService) {
        this.visitService = visitService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @ModelAttribute("visit")
    public Visit getVisit(@PathVariable("ownerId") Integer ownerId, @PathVariable("petId") Integer petId, Model model) {
        Owner owner = ownerService.showOwner(ownerId);
        Pet pet = petService.getPet(petId);
        pet.setVisits(visitService.getVisits(pet.getId()));

        model.addAttribute("owner", owner);
        model.addAttribute("pet", pet);

        Visit visit = new Visit();
        visit.setPetId(petId);
        return visit;
    }

    @GetMapping
    public String initNewVisitForm() {
		return "pets/createOrUpdateVisitForm";
	}

    @PostMapping
    public String processNewVisitForm(@ModelAttribute Owner owner, @PathVariable int petId, @Valid Visit visit, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        }

        visit.setPetId(petId);
        visitService.saveVisit(visit);
        List<Pet> pets = owner.getPets();
        for (Pet pet: pets) {
            if (pet.getId() == petId) {
                pet.getVisits().add(visit);
                break;
            }
        }
        return "redirect:/owners/{ownerId}";
    }
}
