package com.upc.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Pan
 * @Date: 2019/3/30 17:31
 * @Description:
 **/

@Getter
@Setter
public class Phone {

    private Integer id;
    private String good_name;
    private String price;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", good_name='" + good_name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }




}
