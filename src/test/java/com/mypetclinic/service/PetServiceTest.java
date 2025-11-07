package com.mypetclinic.service;

import com.mypetclinic.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class PetServiceTest {

    @Autowired
    private PetService service;

    @Test
    public void testGetPets() {
        service.getPets(6);
    }

    @Test
    public void testSavePet() {
        Pet pet = new Pet();
        pet.setName("wangwu");
        pet.setOwnerId(9);
        pet.setBirthDate(LocalDate.now());
        pet.setTypeId(4);
        service.savePet(pet);
    }

    @Test
    public void testEditPet() {
        Pet pet = new Pet();
        pet.setId(15);
        pet.setName("zhaoliu");
        pet.setOwnerId(6);
        pet.setTypeId(6);
        service.editPet(pet);
    }

    @Test
    public void testGetPet() {
        service.getPet(11);
    }
}
