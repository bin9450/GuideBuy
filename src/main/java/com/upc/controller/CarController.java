package com.upc.controller;

import com.upc.domain.relations.CarRelation;
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
    public List<ShopCar> selInfo(@RequestParam String userId ,@RequestParam int page ){
        List<ShopCar> result = carService.selInfo(userId,page);
        return result;
    }

    @RequestMapping("/insert")
    public CarRelation insert(ShopCar shopCar){
        if (shopCar.getGoodId() != null &&
                shopCar.getUserId() != null) {
            CarRelation is = carService.insert(shopCar);
            return is;
        }else{
            return null;
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
