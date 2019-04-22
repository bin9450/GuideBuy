package com.upc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Pan
 * @Date: 2019/4/8 16:38
 * @Description:
 **/
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("index")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("recommend")
    public String show(){
        return "reclistproducts";
    }

    @RequestMapping("me")
    public String showMe(){
        return "me";
    }

    @RequestMapping("classes")
    public String showClasses(){
        return "classes";
    }

    @RequestMapping("car")
    public String showCar(){
        return "car";
    }

    @RequestMapping("/carhistory")
    public String showCarHistory(){
        return "carhistory";
    }

    @RequestMapping("page")
    public String showPage(@RequestParam int goodId){
        return "page";
    }

}
