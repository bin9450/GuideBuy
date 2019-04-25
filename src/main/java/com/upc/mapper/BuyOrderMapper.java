package com.upc.mapper;

import com.upc.entity.BuyOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Pan
 * @Date: 2019/4/18 18:59
 * @Description:
 **/

@Repository
public interface BuyOrderMapper {
    List<BuyOrder> selInfo(@Param("userId") String userId , @Param("start")int start, @Param("end")int end);
    void insert(BuyOrder buyOrder);
}
