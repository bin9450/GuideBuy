package com.upc.controller;

import com.upc.domain.relations.CollectionRelation;
import com.upc.service.CollectionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:24
 * @Description:
 **/


@RestController
@RequestMapping("/CollectionRelation")
public class CollectionRelationController {

    @Autowired
    CollectionRelationService collectionRelationService;

    @RequestMapping("/findByUserNodeId")
    public List<CollectionRelation> findByUserNodeId(@RequestParam int userId){
        List<CollectionRelation> result = collectionRelationService.findByUserNodeId(userId);
        return result;
    }

    @RequestMapping("/findByPhoneNodeId")
    public  List<CollectionRelation> findByPhoneNodeId(@RequestParam int goodId){
        List<CollectionRelation> result = collectionRelationService.findByPhoneNodeId(goodId);
        return result;
    }


}
