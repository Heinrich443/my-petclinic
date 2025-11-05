package com.mypetclinic.service;

import com.mypetclinic.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner showOwner(Integer id);

    List<Owner> getPage(int page, Owner owner);

    Boolean createOwner(Owner owner);

    Boolean editOwner(Owner owner);
}
