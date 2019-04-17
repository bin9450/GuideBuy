package com.upc.Controller;

import com.upc.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Pan
 * @Date: 2019/3/30 17:39
 * @Description:
 **/

@RestController
@RequestMapping("/phonedata")
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @RequestMapping("getphone/{id}")
    public String GetPhoner(@PathVariable int id){
        return phoneService.Sel(id).toString();
    }
}
