package com.upc.mapper;

import com.upc.entity.CollectionGood;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:45
 * @Description:
 **/

@Repository
public interface CollectionMapper {
    List<CollectionGood> selInfo(String userId );
    void insert(CollectionGood collectionGood);
    void eliminate(String userId);
}
