package com.upc.Controller;

import com.upc.Domain.Node.ProductStyle;
import com.upc.Service.ProductStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/4 10:05
 * @Description:
 **/

@RestController
@RequestMapping("/ProductStyle")
public class ProductStyleController {
    @Autowired
    ProductStyleService productStyleService;

    @GetMapping("/findByName")
    public ProductStyle findByName(@RequestParam String name){
        return productStyleService.findByName(name);
    }

    @GetMapping("/likeName")
    public Collection<ProductStyle> findByNameLike(@RequestParam String name){
        return productStyleService.findByNameLike(name);
    }

    @GetMapping("/all")
    public Iterable<ProductStyle> findAll(){
        return productStyleService.findAll();
    }
}
