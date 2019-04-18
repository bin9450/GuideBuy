package com.upc.mapper;

import com.upc.entity.ShopCar;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 16:25
 * @Description:
 **/

@Repository
public interface ShopCarMapper {

    List<ShopCar> selInfo(String userId );
    void insert(ShopCar shopCar);
    void eliminate(ShopCar shopCar);
    void buyIt(ShopCar shopCar);

}
