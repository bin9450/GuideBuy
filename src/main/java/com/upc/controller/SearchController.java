package com.upc.controller;

import com.upc.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: Pan
 * @Date: 2019/4/29 9:32
 * @Description:
 **/

@RestController
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping("/get")
    public HashMap<?,?> get(@RequestParam String content){
        return searchService.get(content);
    }


}
