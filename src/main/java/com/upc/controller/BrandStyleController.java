package com.upc.controller;

import com.upc.domain.node.BrandStyle;
import com.upc.service.BrandStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/4 9:26
 * @Description:
 **/

@RestController
@RequestMapping("/BrandStyle")
public class BrandStyleController {

    @Autowired
    BrandStyleService brandStyleService;

    @GetMapping("/findByName")
    public BrandStyle findByName(@RequestParam String name){
        return brandStyleService.findByName(name);
    }

    @GetMapping("/likeName")
    public Collection<BrandStyle> findByNameLike(@RequestParam String name){
        return brandStyleService.findByNameLike(name);
    }

    @GetMapping("/all")
    public Iterable<BrandStyle> findAll(){
        return brandStyleService.findAll();
    }


}
