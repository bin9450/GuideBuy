package com.upc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Pan
 * @Date: 2019/4/15 15:06
 * @Description:
 **/

@Controller
@RequestMapping("/meInfo")
public class MeController {


    @RequestMapping("/footprint")
    public String showFoot(){
        return "footprint";
    }
    @RequestMapping("/footprintdetail")
    public String showFootDetail(){
        return "footprintdetail";
    }

    @RequestMapping("/mycollecthistory")
    public String showCollecthistory(){
        return "mycollecthistory";
    }
    @RequestMapping("/mycollection")
    public String showMycollection(){
        return "mycollection";
    }

}
