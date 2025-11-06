package com.mypetclinic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Vet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class VetServiceTest {

    @Autowired
    private VetService service;

    @Test
    public void testFindAll() {
        Page<Vet> page = service.findAll(1);
        List<Vet> vets = page.getRecords();
        for (Vet vet: vets) {
            System.out.println(vet);
        }
    }
}
