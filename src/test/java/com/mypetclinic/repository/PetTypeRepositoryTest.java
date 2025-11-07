package com.mypetclinic.repository;

import com.mypetclinic.model.PetType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PetTypeRepositoryTest {

    @Autowired
    private PetTypeRepository mapper;

    @Test
    public void testSelectList() {
        List<PetType> petTypes = mapper.selectList(null);
        System.out.println(petTypes);
    }
}
