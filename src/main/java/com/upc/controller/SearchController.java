package com.upc.controller;

import com.upc.domain.node.PhoneNode;
import com.upc.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("/sethotsearch")
    public void setHotSearch(@RequestParam String search){
        List<PhoneNode> result = searchService.findByNameLike(search,1);
        if (result.size() > 0){
            searchService.setHotSearch(search);
        }

    }

    @RequestMapping("/gethotsearch")
    public List<HashMap<String,String>> getHotSearch(){
        return searchService.getHotSearch();
    }

    @RequestMapping("/findByNameLike")
    public List<PhoneNode> findByNameLike(String name , int page){
        return searchService.findByNameLike(name,page);
    }

}
