package com.mypetclinic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mypetclinic.model.Vet;
import com.mypetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class VetController {

    @Autowired
    private VetService service;

    public VetController(VetService service) {
        this.service = service;
    }

    @GetMapping("/vets.html")
    public String showVetList(@RequestParam(defaultValue = "1") int page, Model model) {
        // 向前端传递参数如下：listVets totalPages currentPage totalItems
        Page<Vet> vetPage = service.findAll(page);
        return "";
    }
}
