package com.upc.service;

import com.upc.domain.relations.CollectionRelation;
import com.upc.entity.CollectionGood;
import com.upc.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:49
 * @Description:
 **/

@Service
public class CollectionService {

    @Autowired
    CollectionMapper collectionMapper;
    @Autowired
    CollectionRelationService collectionRelationService;

    public List<CollectionGood> selInfo(String userId ,int page){
        int size = 10;
        int start = (page-1)*size;
        int end = size;
        List<CollectionGood> result = collectionMapper.selInfo(userId,start,end);
        return result;
    }

    public void eliminate(CollectionGood collectionGood){
        int userId = Integer.parseInt(collectionGood.getUserId());
        int goodId = Integer.parseInt(collectionGood.getGoodId());
        Date date = new Date();
        collectionGood.setCollectTime(date);

        collectionMapper.eliminate(collectionGood);
        collectionRelationService.deleteRelation(userId,goodId);
    }

    public void insert(CollectionGood collectionGood){
        //collectionMapper.insert(collectionGood);
        int userId = Integer.parseInt(collectionGood.getUserId());
        int goodId = Integer.parseInt(collectionGood.getGoodId());
        Date date = new Date();
        collectionGood.setCollectTime(date);
        collectionMapper.insert(collectionGood);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastTime = sdf.format(date);
        CollectionRelation result = collectionRelationService.findByUserAndPhone(userId,goodId);
        if (result == null){
            collectionRelationService.createBrowserRelation(userId,goodId,lastTime);
        }else {
            collectionRelationService.updateInfo(userId,goodId,lastTime);
        }
    }

}
