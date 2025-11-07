package com.mypetclinic.service;

import com.mypetclinic.model.Pet;

import java.util.List;

public interface PetService {

    Pet getPet(Integer petId);

    List<Pet> getPets(Integer ownerId);

    Boolean savePet(Pet pet);

    Boolean editPet(Pet pet);
}
