package com.upc.controller;

import com.upc.entity.ShopCar;
import com.upc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/19 16:07
 * @Description:
 **/

@RestController
@RequestMapping("/Car")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping("/selInfo")
    public List<ShopCar> selInfo(@RequestParam String userId ){
        List<ShopCar> result = carService.selInfo(userId);
        return result;
    }

    @RequestMapping("/insert")
    public void insert(ShopCar shopCar){
        if (shopCar.getGoodId() != null &&
                shopCar.getUserId() != null) {
            carService.insert(shopCar);
        }
    }

    @RequestMapping("/eliminate")
    public void eliminate(ShopCar shopCar){
        carService.eliminate(shopCar);
    }

/*
    @RequestMapping("/buyIt")
    public void buyIt(ShopCar shopCar){
        carService.buyIt(shopCar);
    }
    */


}