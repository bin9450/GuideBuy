package com.upc.controller;

import com.upc.domain.node.Company;
import com.upc.domain.node.PhoneNode;
import com.upc.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/5/9 10:04
 * @Description:
 **/

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    RecommendService recommendService;

    @RequestMapping("/get")
    List<PhoneNode> getMorePhone(@RequestParam int userId){
        List<Company> bestCompany = recommendService.getRecommendCompany(userId);
        List<PhoneNode> result = new ArrayList<>();
        for (Company com:bestCompany){
            List<PhoneNode> phoneNode = recommendService.getRecommendPhone(userId,com.getShopName());
            if (phoneNode != null){
                result.addAll(phoneNode);
            }
        }
        result.addAll(recommendService.getMaxPhone());
        return result;
    }

}
