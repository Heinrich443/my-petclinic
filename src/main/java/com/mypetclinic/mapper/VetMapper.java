package com.mypetclinic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mypetclinic.model.Vet;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VetMapper extends BaseMapper<Vet> {

    /*Vet selectById(Integer id);

    List<Vet> selectAll();*/
}
