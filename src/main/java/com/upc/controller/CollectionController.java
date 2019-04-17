package com.upc.controller;

import com.upc.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:24
 * @Description:
 **/


@RestController
@RequestMapping("/Collection")
public class CollectionController {

    @Autowired
    CollectionService collectionService;


}
