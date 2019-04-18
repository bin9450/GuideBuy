package com.upc.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/4/17 18:42
 * @Description:
 **/

@Getter
@Setter
public class CollectionGood {

    private Integer id;
    private String  userId;
    private String goodId;
    private Date collectTime;
    private int state;

    @Override
    public String toString() {
        return "CollectionGood{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", collectTime=" + collectTime +
                ", state=" + state +
                '}';
    }

}
