package com.mypetclinic.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mypetclinic.model.Visit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class VisitRepositoryTest {

    @Autowired
    private VisitRepository mapper;

    @Test
    public void testSelectList() {
        LambdaQueryWrapper<Visit> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Visit::getPetId, 8);
        mapper.selectList(lqw);
    }

    @Test
    public void testInsert() {
        Visit visit = new Visit();
        visit.setPetId(1);
        visit.setVisitDate(LocalDate.now());
        visit.setDescription("Flu");
        mapper.insert(visit);
    }
}
