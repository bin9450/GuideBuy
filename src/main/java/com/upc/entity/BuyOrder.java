package com.upc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/4/18 18:50
 * @Description:
 **/

@Getter
@Setter
public class BuyOrder {

    private Integer id;
    private String  userId;
    private String goodId;
    private Date buyTime;

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
