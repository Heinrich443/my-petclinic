package com.mypetclinic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mypetclinic.model.Pet;
import com.mypetclinic.repository.PetRepository;
import com.mypetclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository mapper;

    @Override
    public Pet getPet(Integer petId) {
        return mapper.selectById(petId);
    }

    @Override
    public List<Pet> getPets(Integer ownerId) {
        LambdaQueryWrapper<Pet> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Pet::getOwnerId, ownerId);
        return mapper.selectList(lqw);
    }

    @Override
    public Boolean savePet(Pet pet) {
        return mapper.insert(pet) > 0;
    }

    @Override
    public Boolean editPet(Pet pet) {
        return mapper.updateById(pet) > 0;
    }
}
