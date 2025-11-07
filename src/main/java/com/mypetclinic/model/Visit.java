package com.mypetclinic.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("visits")
public class Visit {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer petId;

    @TableField("visit_date")
    private LocalDate date;

    private String description;

    public Boolean isNew() {
        return id == null;
    }
}
