package com.mypetclinic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypetclinic.model.Specialty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface SpecialtyMapper extends BaseMapper<Specialty> {

    Set<Specialty> selectSpecialties(Integer vetId);
}
