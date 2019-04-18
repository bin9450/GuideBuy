package com.upc.service;

import com.upc.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Pan
 * @Date: 2019/4/14 12:51
 * @Description:
 **/

@Service
public class UserInfoService {

    public User showInfoBySession(HttpServletRequest request, HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute("session_user");
        user.setPassWord(null);
       // System.out.println(user.getUserId());
        return user;
    }

}
