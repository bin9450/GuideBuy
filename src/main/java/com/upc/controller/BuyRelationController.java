package com.upc.controller;

import com.upc.service.BuyRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Pan
 * @Date: 2019/4/18 19:14
 * @Description:
 **/

@RestController
@RequestMapping("/BuyRelation")
public class BuyRelationController {

    @Autowired
    BuyRelationService buyRelationService;

}
