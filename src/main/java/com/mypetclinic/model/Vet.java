package com.mypetclinic.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("vets")
public class Vet {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @TableField(exist = false)
    private Set<Specialty> specialties;

    public Boolean isNew() {
        return id == null;
    }

    public int getNrOfSpecialties() {
        return specialties.size();
    }
}
