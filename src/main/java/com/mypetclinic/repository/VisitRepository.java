package com.mypetclinic.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypetclinic.model.Visit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitRepository extends BaseMapper<Visit> {
}
