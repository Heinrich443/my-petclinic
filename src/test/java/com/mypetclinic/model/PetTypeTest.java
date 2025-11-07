package com.mypetclinic.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PetTypeTest {

    @Test
    public void testPetTest() {
        PetType petType = new PetType();
        petType.setName("tiger");
        System.out.println(petType);
    }
}
