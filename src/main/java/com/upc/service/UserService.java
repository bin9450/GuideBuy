package com.upc.service;

import com.upc.entity.User;
import com.upc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Pan
 * @Date: 2019/4/2 14:35
 * @Description:
 **/

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User sel(int id){
        return userMapper.sel(id);
    }

    public User login(String userName,String passWord){
        return userMapper.login(userName,passWord);
    }

    public User isRepeat(String userName){
        return userMapper.isRepeat(userName);
    }

    public int register(User user){
        return userMapper.register(user);
    }


}
