package com.upc.controller;

import com.upc.entity.BuyOrder;
import com.upc.service.BuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 19:12
 * @Description:
 **/

@RestController
@RequestMapping("/BuyOrder")
public class BuyOrderController {

    @Autowired
    BuyOrderService buyOrderService;

    @RequestMapping("/selInfo")
    public List<BuyOrder> selInfo(@RequestParam String userId ,@RequestParam int page){
        List<BuyOrder> result = buyOrderService.selInfo(userId,page);
        return result;
    }

    @RequestMapping("/insert")
    void insert(BuyOrder buyOrder){
        if (buyOrder.getUserId() != null &&
                buyOrder.getGoodId() != null){
            buyOrderService.insert(buyOrder);
        }
    }

}
