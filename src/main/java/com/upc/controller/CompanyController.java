package com.upc.controller;

import com.upc.domain.node.Company;
import com.upc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/1 20:18
 * @Description:
 **/

@RestController
@RequestMapping("/Company")

public class CompanyController {

    @Autowired
    private  CompanyService companyService;


    @GetMapping("/findByName")
    public Company findByName(@RequestParam String name){
        return companyService.findByShopName(name);
    }

    @GetMapping("/likeName")
    public Collection<Company> findByNameLike(@RequestParam String name) {
        return companyService.findByShopNameLike(name);
    }

    @GetMapping("/all")
    public Iterable<Company> findAll() {
        return companyService.findAll();
    }
}
