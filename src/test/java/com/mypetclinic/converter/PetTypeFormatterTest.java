package com.mypetclinic.converter;

import com.mypetclinic.model.PetType;
import com.mypetclinic.model.PetTypeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@SpringBootTest
public class PetTypeFormatterTest {

    @Autowired
    private PetTypeFormatter formatter;

    @Test
    public void testPrint() {
        PetType petType = new PetType();
        petType.setName("tiger");
        String print = formatter.print(petType, Locale.ENGLISH);
        System.out.println(print);
    }
}
