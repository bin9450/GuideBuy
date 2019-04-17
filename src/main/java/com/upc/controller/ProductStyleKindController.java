package com.upc.controller;

import com.upc.domain.node.ProductStyleKind;
import com.upc.service.ProductStyleKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/2 17:12
 * @Description:
 **/

@RestController
@RequestMapping ("/ProductStyleKind")
public class ProductStyleKindController {

    @Autowired
    ProductStyleKindService productStyleKindService;

    @GetMapping("/findByName")
    public ProductStyleKind findByName(@RequestParam String name){
        return productStyleKindService.findByName(name);
    }

    @GetMapping("/likeName")
    public Collection<ProductStyleKind> findByNameLike(@RequestParam String name){
        return productStyleKindService.findByNameLike(name);
    }

    @GetMapping("/all")
    public Iterable<ProductStyleKind> findAll(){
        return productStyleKindService.findAll();
    }

}
