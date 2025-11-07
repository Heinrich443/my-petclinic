package com.mypetclinic.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mypetclinic.model.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PetRepositoryTest {

    @Autowired
    private PetRepository mapper;

    @Test
    public void testSelectList() {
        LambdaQueryWrapper<Pet> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Pet::getOwnerId, 3);
        List<Pet> pets = mapper.selectList(lqw);
        System.out.println(pets);
    }

    @Test
    public void testInsert() {
        Pet pet = new Pet();
        pet.setName("zhangsan");
        pet.setOwnerId(11);
        pet.setBirthDate(LocalDate.now());
        pet.setTypeId(5);
        mapper.insert(pet);
    }

    @Test
    public void testUpdateById() {
        Pet pet = new Pet();
        pet.setId(14);
        pet.setName("lisi");
        pet.setOwnerId(10);
        mapper.updateById(pet);
    }
}
