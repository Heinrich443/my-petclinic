package com.mypetclinic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Vet;

import java.util.List;

public interface VetService {

    Page<Vet> findAll(int currentPage);
}
