package com.mypetclinic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mypetclinic.model.Visit;
import com.mypetclinic.repository.VisitRepository;
import com.mypetclinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository mapper;

    @Override
    public Set<Visit> getVisits(Integer petId) {
        LambdaQueryWrapper<Visit> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Visit::getPetId, petId);
        List<Visit> visits = mapper.selectList(lqw);
        Set<Visit> set = new LinkedHashSet<>();
        set.addAll(visits);
        return set;
    }

    @Override
    public Boolean saveVisit(Visit visit) {
        return mapper.insert(visit) > 0;
    }
}
