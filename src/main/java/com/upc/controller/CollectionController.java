package com.upc.controller;

import com.upc.entity.CollectionGood;
import com.upc.service.CollectionRelationService;
import com.upc.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:51
 * @Description:
 **/

@RestController
@RequestMapping("/CollectionGood")
public class CollectionController {

    @Autowired
    CollectionService collectionService;

    @RequestMapping("/selInfo")
    public List<CollectionGood> selInfo(@RequestParam String userId , @RequestParam int page ){
        return collectionService.selInfo(userId,page);
    }

    @RequestMapping("/insert")
    public void insert(CollectionGood collectionGood){
        if (collectionGood.getGoodId() != null &&
                collectionGood.getUserId() != null){
            collectionService.insert(collectionGood);
            // System.out.println("success");
        }

    }

    @RequestMapping("/eliminate")
    public void eliminate(CollectionGood collectionGood){
        if (collectionGood.getGoodId() != null &&
                collectionGood.getUserId() != null){
            collectionService.eliminate(collectionGood);
        }
    }

}
