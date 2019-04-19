package com.upc.service;

import com.upc.entity.ShopCar;
import com.upc.mapper.ShopCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 16:28
 * @Description:
 **/

@Service
public class CarService {

    @Autowired
    ShopCarMapper shopCarMapper;
    @Autowired
    CarRelationService carRelationService;

    public List<ShopCar> selInfo(String userId ){
        List<ShopCar> result = shopCarMapper.selInfo(userId);
        return result;
    }

    public void insert(ShopCar shopCar){
        int userId = Integer.parseInt(shopCar.getUserId());
        int goodId = Integer.parseInt(shopCar.getGoodId());
        Date date = new Date();
        shopCar.setDoTime(date);
        shopCarMapper.insert(shopCar);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String carTime = sdf.format(date);
        carRelationService.createCarRelation(userId,goodId,carTime);
    }

    public void eliminate(ShopCar shopCar){
        int userId = Integer.parseInt(shopCar.getUserId());
        int goodId = Integer.parseInt(shopCar.getGoodId());
        shopCarMapper.eliminate(shopCar);
        carRelationService.deleteRelation(userId,goodId);
    }

    public void buyIt(ShopCar shopCar){
        int userId = Integer.parseInt(shopCar.getUserId());
        int goodId = Integer.parseInt(shopCar.getGoodId());
        shopCarMapper.buyIt(shopCar);
        carRelationService.deleteRelation(userId,goodId);
        /*
                添加购买关系
        */

    }

}
