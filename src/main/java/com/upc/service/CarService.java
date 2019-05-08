package com.upc.service;

import com.upc.domain.relations.CarRelation;
import com.upc.entity.BuyOrder;
import com.upc.entity.ShopCar;
import com.upc.mapper.ShopCarMapper;
import com.upc.repository.PhoneNodeRepository;
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
    @Autowired
    BuyOrderService buyOrderService;
    @Autowired
    PhoneNodeRepository phoneNodeRepository;

    public List<ShopCar> selInfo(String userId,int page){
        int size = 10;
        int start = (page-1)*size;
        int end = size;
        List<ShopCar> result = shopCarMapper.selInfo(userId,start,end);
        return result;
    }

    public CarRelation insert(ShopCar shopCar){
        int userId = Integer.parseInt(shopCar.getUserId());
        int goodId = Integer.parseInt(shopCar.getGoodId());
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String carTime = sdf.format(date);
        shopCar.setDoTime(date);
        CarRelation result = carRelationService.findByUserAndPhone(userId,goodId);

        if (result == null){
            int comment = 25;
            phoneNodeRepository.setComment(goodId,comment);

            shopCarMapper.insert(shopCar);
            carRelationService.createCarRelation(userId,goodId,carTime);
            return carRelationService.findByUserAndPhone(userId,goodId);
        }else{
            return null;
        }

    }

    public void eliminate(ShopCar shopCar){
        int userId = Integer.parseInt(shopCar.getUserId());
        int goodId = Integer.parseInt(shopCar.getGoodId());
        shopCarMapper.eliminate(shopCar);
        carRelationService.deleteRelation(userId,goodId);
    }

    public void buyIt(ShopCar shopCar){
        BuyOrder buyOrder = new BuyOrder(shopCar.getUserId(),shopCar.getGoodId());
        int userId = Integer.parseInt(shopCar.getUserId());
        int goodId = Integer.parseInt(shopCar.getGoodId());
        shopCarMapper.buyIt(shopCar);
        carRelationService.deleteRelation(userId,goodId);
        buyOrderService.insert(buyOrder);


    }

}
