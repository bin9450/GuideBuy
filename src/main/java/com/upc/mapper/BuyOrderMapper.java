package com.upc.mapper;

import com.upc.entity.BuyOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 18:59
 * @Description:
 **/

@Repository
public interface BuyOrderMapper {
    List<BuyOrder> selInfo(String userId );
    void insert(BuyOrder buyOrder);
}
