package com.mypetclinic.service;

import com.mypetclinic.model.Visit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitService service;

    @Test
    public void testGetVisits() {
        service.getVisits(8);
    }

    @Test
    public void testSaveVisit() {
        Visit visit = new Visit();
        visit.setPetId(2);
        visit.setDescription("Cancer");
        service.saveVisit(visit);
    }
}
