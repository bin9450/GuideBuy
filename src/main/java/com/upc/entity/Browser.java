package com.upc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/4/15 9:57
 * @Description:
 **/

@Getter
@Setter
public class Browser {

    private Integer id;
    private String  userId;
    private String goodId;
    private Date browserTime;

    @Override
    public String toString() {
        return "Browser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", browserTime=" + browserTime +
                '}';
    }

}
