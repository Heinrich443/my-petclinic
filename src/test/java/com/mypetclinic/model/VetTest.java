package com.mypetclinic.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VetTest {
    @Test
    public void testVet() {
        Vet vet = new Vet();
        vet.setId(10);
        vet.setLastName("aaaa");
        vet.setFirstName("bbbb");
        System.out.println(vet);
    }
}
