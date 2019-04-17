package com.upc.Controller;

import com.upc.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

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

    @RequestMapping("page")
    public String showPage(@RequestParam int goodId){
        return "page";
    }

}
