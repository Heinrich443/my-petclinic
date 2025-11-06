package com.mypetclinic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner showOwner(Integer id);

    Page<Owner> getPage(int page, Owner owner);

    Boolean createOwner(Owner owner);

    Boolean editOwner(Owner owner);
}
