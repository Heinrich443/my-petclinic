package com.mypetclinic.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Vet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VetMapperTest {

    @Autowired
    private VetMapper mapper;

    @Test
    public void testSelectById() {
         /*Vet vet = mapper.selectById(3);
         System.out.println(vet);*/
    }

    @Test
    public void testSelectAll() {
        /*List<Vet> vets = mapper.selectAll();
        for (Vet vet: vets) {
            System.out.println(vet);
        }*/
    }

    @Test
    public void testSelectPage() {
        Page<Vet> page = mapper.selectPage(new Page<>(1, 3), null);
    }
}
