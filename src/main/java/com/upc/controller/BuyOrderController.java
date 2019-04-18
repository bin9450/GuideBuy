package com.upc.controller;

import com.upc.service.BuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
