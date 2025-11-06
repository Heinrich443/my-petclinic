package com.mypetclinic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Owner;
import com.mypetclinic.repository.OwnerRepository;
import com.mypetclinic.service.OwnerService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private static final Integer PAGESIZE = 5;

    @Autowired
    private OwnerRepository mapper;

    @Override
    public Owner showOwner(Integer id) {
        return mapper.selectById(id);
    }

    /**
     * 分页查询+条件查询
     * @param currentPage
     * @param owner
     * @return
     */
    @Override
    public Page<Owner> getPage(int currentPage, Owner owner) {
        String lastName = owner.getLastName();
        Page<Owner> page = new Page<>(currentPage, PAGESIZE);
        LambdaQueryWrapper<Owner> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(lastName), Owner::getLastName, lastName);
        return mapper.selectPage(page, lqw);
    }

    /**
     * 新增主人
     * @param owner
     * @return
     */
    @Override
    public Boolean createOwner(Owner owner) {
        int count = mapper.insert(owner);
        return count > 0;
    }

    /**
     * 修改主人
     * @param owner
     * @return
     */
    @Override
    public Boolean editOwner(Owner owner) {
        int count = mapper.updateById(owner);
        return count > 0;
    }
}
