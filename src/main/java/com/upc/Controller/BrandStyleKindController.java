package com.upc.Controller;

import com.upc.Domain.Node.BrandStyleKind;
import com.upc.Service.BrandStyleKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/2 10:11
 * @Description:
 **/

@RestController
@RequestMapping("/BrandStyleKind")
public class BrandStyleKindController {

    @Autowired
    BrandStyleKindService brandStyleKindService;

    @GetMapping("/findByName")
    public BrandStyleKind findByName(@RequestParam String name){
        return brandStyleKindService.findByName(name);
    }

    @GetMapping("/likeName")
    public Collection<BrandStyleKind> findByNameLike(@RequestParam String name){
        return brandStyleKindService.findByNameLike(name);
    }

    @GetMapping("/all")
    public Iterable<BrandStyleKind> findAll(){
        return brandStyleKindService.findAll();
    }

/*
    @GetMapping("/allThree")
    public Iterable<BrandStyleKind> findAllByThree(){
        return brandStyleKindService.findAllByThree();
    }

*/

}
