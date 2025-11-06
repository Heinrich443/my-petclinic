package com.mypetclinic.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.mapper.SpecialtyMapper;
import com.mypetclinic.mapper.VetMapper;
import com.mypetclinic.model.Vet;
import com.mypetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetServiceImpl implements VetService {

    private static final int PAGESIZE = 5;

    @Autowired
    private VetMapper vetMapper;

    @Autowired
    private SpecialtyMapper specialtyMapper;

    @Override
    public Page<Vet> findAll(int currentPage) {
        Page<Vet> page = new Page<>(currentPage, PAGESIZE);
        Page<Vet> vetPage = vetMapper.selectPage(page, null);
        List<Vet> vets = vetPage.getRecords();
        for (Vet vet: vets) {
            vet.setSpecialties(specialtyMapper.selectSpecialties(vet.getId()));
        }
        return page;
    }
}
