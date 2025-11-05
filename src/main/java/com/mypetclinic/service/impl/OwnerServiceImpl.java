package com.mypetclinic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Owner;
import com.mypetclinic.repository.OwnerRepository;
import com.mypetclinic.service.OwnerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private static final Integer PAGESIZE = 5;

    @Autowired
    private OwnerRepository mapper;

    @Override
    public Owner showOwner(Integer id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Owner> getPage(int currentPage, Owner owner) {
        String lastName = owner.getLastName();
        Page<Owner> page = new Page<>(currentPage, PAGESIZE);
        LambdaQueryWrapper<Owner> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(lastName), Owner::getLastName, lastName);
        return mapper.selectPage(page, lqw);
    }

    @Override
    public Boolean createOwner(Owner owner) {
        return null;
    }

    @Override
    public Boolean editOwner(Owner owner) {
        return null;
    }
}
