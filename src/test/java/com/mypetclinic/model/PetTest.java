package com.mypetclinic.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class PetTest {

    @Test
    public void testPet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("aaa");
        pet.setPetType(new PetType(1, "cat"));
        pet.setBirthDate(LocalDate.now());
        System.out.println(pet);
    }
}
