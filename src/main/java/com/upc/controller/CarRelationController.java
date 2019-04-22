package com.upc.controller;

import com.upc.domain.relations.CarRelation;
import com.upc.service.CarRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/19 16:07
 * @Description:
 **/

@RestController
@RequestMapping("/CarRelation")
public class CarRelationController {

    @Autowired
    CarRelationService carRelationService;

    @RequestMapping("/findByUserNodeId")
    public List<CarRelation> findByUserNodeId(@RequestParam int userId){
        List<CarRelation> result = carRelationService.findByUserNodeId(userId);
        return result;
    }

}
