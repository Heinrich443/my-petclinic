package com.mypetclinic.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OwnerTest {

    @Test
    public void testOwner() {
        Owner owner = new Owner();
        owner.setId(1);
        owner.setLastName("aaa");
        owner.setFirstName("bbb");
        owner.setAddress("ccc");
        owner.setCity("ddd");
        owner.setTelephone("11111");
        List<Pet> pets = new ArrayList<>();
        owner.setPets(pets);
        System.out.println(owner);
    }
}
