package com.upc.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @Author: Pan
 * @Date: 2019/4/2 14:15
 * @Description:
 **/

@Getter
@Setter
public class User {
    private Integer userId;
    private String userName;
    private String passWord;
    private String nickName;

    @Override
    public String toString (){
        return "id:"+userId+"username:"+userName;
    }


}
