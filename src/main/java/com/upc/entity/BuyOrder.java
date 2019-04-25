package com.upc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/4/18 18:50
 * @Description:
 **/

@Getter
@Setter
@NoArgsConstructor
public class BuyOrder {

    private Integer id;
    private String  userId;
    private String goodId;
    private Date buyTime;

    public BuyOrder(String userId, String goodId) {
        this.userId = userId;
        this.goodId = goodId;
    }

    @Override
    public String toString() {
        return "BuyOrder{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", buyTime=" + buyTime +
                '}';
    }

}
