package com.upc.entity;

import lombok.Getter;
import lombok.Setter;

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
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }


}
