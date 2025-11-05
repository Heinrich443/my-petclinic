package com.mypetclinic.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository mapper;

    @Test
    public void testSelectById() {
        Owner owner = mapper.selectById(11);
    }

    @Test
    public void testSelectAll() {
        List<Owner> owners = mapper.selectList(null);
    }

    @Test
    public void testUpdate() {
        Owner owner = new Owner();
        owner.setId(20);
        owner.setFirstName("aaaaa");
        owner.setLastName("bbbbb");
        owner.setCity("ccccc");
        owner.setAddress("ddddd");
        owner.setTelephone("eeeee");
        mapper.updateById(owner);
    }

    @Test
    public void testDelete() {
        mapper.deleteById(21);
    }

    @Test
    public void testInsert() {
        Owner owner = new Owner();
        owner.setFirstName("ccccc");
        owner.setLastName("ccccc");
        owner.setCity("ccccc");
        owner.setAddress("ccccc");
        owner.setTelephone("ccccc");
        mapper.insert(owner);
    }

    @Test
    public void testSelectPage() {
        Page<Owner> page = new Page<>(1, 5);
        mapper.selectPage(page, null);
    }

    @Test
    public void testSelectCondition() {
        Page<Owner> page = new Page<>(1, 5);
        LambdaQueryWrapper<Owner> lqw = new LambdaQueryWrapper<>();
        lqw.like(Owner::getLastName, "Davis");
        mapper.selectPage(page, lqw);
    }
}
