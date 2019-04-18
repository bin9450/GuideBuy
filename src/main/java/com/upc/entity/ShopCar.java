package com.upc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/4/18 16:17
 * @Description:
 **/

@Data
public class ShopCar {

    private Integer id;
    private String  userId;
    private String goodId;
    private Date doTime;
    private int state;

    @Override
    public String toString(){
        return  "id:"+id+
                "userId:"+userId+
                "goodId:"+goodId+
                "insertTime:"+doTime+
                "state"+state;
    }

}
