package com.upc.controller;
import com.upc.domain.node.PhoneNode;
import com.upc.service.PhoneNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


/**
 * @Author: Pan
 * @Date: 2019/4/1 20:28
 * @Description:
 **/
@RestController
@RequestMapping("/PhoneNode")
public class PhoneNodeController {

    @Autowired
    PhoneNodeService phoneNodeService;

    @RequestMapping("/findByName")
    public PhoneNode findByName(@RequestParam String name){
        return phoneNodeService.findByGoodName(name);
    }

    @RequestMapping("/likeName")
    public Collection<PhoneNode> findByNameLike(@RequestParam String name) {
        return phoneNodeService.findByGoodNameLike(name);
    }

    @RequestMapping("/findByGoodId")
    public PhoneNode findByGoodId(@RequestParam int goodId){
        return phoneNodeService.findByGoodId(goodId);
    }

    @RequestMapping ("/all")
    public Iterable<PhoneNode> findAll() {
        return phoneNodeService.findAll();
    }

   @RequestMapping ("/allPage")
    public List<PhoneNode> findAllPage(@RequestParam int pageNum ,@RequestParam int pageSize) {
      return phoneNodeService.findAllByPage(pageNum, pageSize);
    }

    @RequestMapping("/random")
    public  List<PhoneNode> findRandom(){

        return  phoneNodeService.findRandom();
    }

    @RequestMapping("/BrandStyle")
    public List<PhoneNode> findByBrandStyle(@RequestParam  String name){
        return phoneNodeService.findByBrandStyle(name);
    }

}
