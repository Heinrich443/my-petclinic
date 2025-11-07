package com.mypetclinic.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.jspecify.annotations.Nullable;

import java.util.Objects;

@TableName("types")
public class PetType {

    @TableId(type = IdType.AUTO)
    private @Nullable Integer id;

    private @Nullable String name;

    public PetType() {
    }

    public PetType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetType petType = (PetType) o;
        return Objects.equals(id, petType.id) && Objects.equals(name, petType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
