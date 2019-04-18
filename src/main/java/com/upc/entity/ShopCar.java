package com.upc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/4/18 16:17
 * @Description:
 **/

@Getter
@Setter
public class ShopCar {

    private Integer id;
    private String  userId;
    private String goodId;
    private Date doTime;
    private int state;

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", doTime=" + doTime +
                ", state=" + state +
                '}';
    }

}
