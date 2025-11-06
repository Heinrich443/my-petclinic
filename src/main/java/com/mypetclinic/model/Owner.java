package com.mypetclinic.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("owners")
public class Owner {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String telephone;

    @TableField(exist = false)
    private List<Pet> pets = new ArrayList<>();

    /**
     * Thymeleaf需要
     * @return
     */
    public Boolean isNew() {
        return id == null;
    }
}
