package com.mypetclinic.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypetclinic.model.PetType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetTypeRepository extends BaseMapper<PetType> {
}
