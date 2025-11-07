package com.mypetclinic.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypetclinic.model.Pet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetRepository extends BaseMapper<Pet> {
}
