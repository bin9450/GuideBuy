package com.upc.service;

import com.upc.entity.ShopCar;
import com.upc.mapper.ShopCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 16:28
 * @Description:
 **/

@Service
public class ShopCarService {

    @Autowired
    ShopCarMapper shopCarMapper;

    public List<ShopCar> selInfo(String userId ){
        List<ShopCar> result = shopCarMapper.selInfo(userId);
        return result;
    }

    public void insert(ShopCar shopCar){
        shopCarMapper.insert(shopCar);
    }

    public void eliminate(ShopCar shopCar){
        shopCarMapper.eliminate(shopCar);
    }
    public void buyIt(ShopCar shopCar){
        shopCarMapper.buyIt(shopCar);
    }

}
