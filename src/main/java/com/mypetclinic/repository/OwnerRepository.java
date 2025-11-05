package com.mypetclinic.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypetclinic.model.Owner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OwnerRepository extends BaseMapper<Owner> {
}
