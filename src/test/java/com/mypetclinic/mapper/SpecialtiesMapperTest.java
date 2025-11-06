package com.mypetclinic.mapper;

import com.mypetclinic.model.Specialty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class SpecialtiesMapperTest {

    @Autowired
    private SpecialtyMapper mapper;

    @Test
    public void testSelectSpecialties() {
        Set<Specialty> specialties = mapper.selectSpecialties(3);
        System.out.println(specialties);
    }
}
