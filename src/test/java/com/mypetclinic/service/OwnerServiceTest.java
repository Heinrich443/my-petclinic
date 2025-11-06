package com.mypetclinic.service;

import com.mypetclinic.model.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OwnerServiceTest {

    @Autowired
    private OwnerService service;

    @Test
    public void testShowOwner() {
        service.showOwner(17);
    }

    @Test
    public void testGetPage() {
        int page = 1;
        // int page = 2;
        Owner owner = new Owner();
        owner.setLastName("Davis");
        // owner.setLastName("");
        service.getPage(page, owner);
    }

    @Test
    public void testCreateOwner() {
        Owner owner = new Owner(null, "AAAAA", "BBBBB", "CCCCC", "DDDDD", "11111", null);
        service.createOwner(owner);
    }

    @Test
    public void testEditOwner() {
        Owner owner = new Owner(22, "AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA", null);
        service.editOwner(owner);
    }
}
