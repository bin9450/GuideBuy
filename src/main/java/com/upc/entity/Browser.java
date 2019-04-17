package com.upc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Pan
 * @Date: 2019/4/15 9:57
 * @Description:
 **/

@Data
public class Browser {

    private Integer id;
    private String  userId;
    private String goodId;
    private Date browserTime;

    @Override
    public String toString(){
        return  "id:"+id+
                "userId:"+userId+
                "goodId:"+goodId+
                "browserTime"+browserTime;
    }

}
