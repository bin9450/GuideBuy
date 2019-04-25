package com.upc.service;

import com.upc.domain.relations.BuyRelation;
import com.upc.entity.BuyOrder;
import com.upc.mapper.BuyOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 19:00
 * @Description:
 **/

@Service
public class BuyOrderService {

    @Autowired
    BuyOrderMapper buyOrderMapper;
    @Autowired
    BuyRelationService buyRelationService;

    public List<BuyOrder> selInfo(String userId,int page){
        int size = 10;
        int start = (page-1)*size;
        int end = size;
        List<BuyOrder> result = buyOrderMapper.selInfo(userId,start,end);
        return result;
    }

    public void insert(BuyOrder buyOrder){
        int userId = Integer.parseInt(buyOrder.getUserId());
        int goodId = Integer.parseInt(buyOrder.getGoodId());
        Date date = new Date();
        buyOrder.setBuyTime(date);
        buyOrderMapper.insert(buyOrder);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastTime = sdf.format(date);
        BuyRelation result = buyRelationService.findByUserAndPhone(userId,goodId);
        if (result == null){
            buyRelationService.createBuyRelation(userId,goodId,lastTime);
        }else {
            buyRelationService.updateInfo(userId,goodId,lastTime);
        }

    }

}
