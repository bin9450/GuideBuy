package com.upc.Controller;

import com.upc.Entity.Browser;
import com.upc.Service.BrowserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/15 10:22
 * @Description:
 **/

@RestController
@RequestMapping("/Browser")
public class BrowserController {

    @Autowired
    BrowserService browserService;

    @RequestMapping("/selInfo")
    public List<Browser> selInfo(@RequestParam String userId ){
        return browserService.selInfo(userId);
    }

   @RequestMapping("/insert")
    public void insert(Browser browser){
        if (browser.getGoodId() != null &&
                browser.getUserId() != null){
            browserService.insert(browser);
           // System.out.println("success");
        }

    }

}
