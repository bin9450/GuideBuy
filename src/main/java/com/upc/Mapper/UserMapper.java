package com.upc.Mapper;

import com.upc.Entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: Pan
 * @Date: 2019/4/2 14:26
 * @Description:
 **/
@Repository
public interface UserMapper {
    User sel(int id);
    User login(String userName,String passWord);
    User isRepeat(String userName);
    int register(User user);

}
