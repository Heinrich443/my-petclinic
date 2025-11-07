package com.mypetclinic.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("pets")
public class Pet {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private LocalDate birthDate;

    private Integer ownerId;

    private Integer typeId;

    @TableField(exist = false)
    private PetType type;

    @TableField(exist = false)
    private Set<Visit> visits = new LinkedHashSet<>();

    public Boolean isNew() {
        return id == null;
    }
}
