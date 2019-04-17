package com.upc.Controller;

import com.upc.Domain.Relations.BrowserRelation;
import com.upc.Service.BrowserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/16 10:04
 * @Description:
 **/

@RestController
@RequestMapping("/BrowserRelation")
public class BrowserRelationController {

    @Autowired
    BrowserRelationService browserRelationService;

    @RequestMapping("/findAll")
    public Iterable<BrowserRelation> findAll(){
        Iterable<BrowserRelation> result =browserRelationService.findAll();
        return result;
    }

    @RequestMapping("/findByUserNodeId")
    public Iterable<BrowserRelation> findByUserNodeId(@RequestParam int userId){
        Iterable<BrowserRelation> result = browserRelationService.findByUserNodeId(userId);
        return result;
    }

    @RequestMapping("/findByUserAndPhone")
    public BrowserRelation findByUserAndPhone(@RequestParam int userId,@RequestParam int goodId){
        BrowserRelation  result = browserRelationService.findByUserAndPhone(userId,goodId);
        return result;
    }

    @RequestMapping("/findByPhoneNodeId")
    public Iterable<BrowserRelation> findByPhoneNodeId(@RequestParam int goodId){
        Iterable<BrowserRelation> result = browserRelationService.findByPhoneNodeId(goodId);
        return result;
    }
}
