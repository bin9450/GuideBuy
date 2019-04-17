package com.upc.controller;

import com.upc.domain.node.UserNode;
import com.upc.entity.User;
import com.upc.service.UserInfoService;
import com.upc.service.UserNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * @Author: Pan
 * @Date: 2019/4/12 10:12
 * @Description:
 **/

@RestController
@RequestMapping("/usernode")
public class UserNodeController {

    @Autowired
    UserNodeService userNodeService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/findByNickName")
    public UserNode findByNickName(@RequestParam String nickName){
        return userNodeService.findByNickName(nickName);
    }

    @GetMapping("/findByNickNameLike")
    public Collection<UserNode> findByNickNameLike(@RequestParam String nickName){
        return userNodeService.findByNickNameLike(nickName);
    }

    @GetMapping("/findByUserId")
    public UserNode findByUserId(@RequestParam int userId){
        return userNodeService.findByUserId(userId);
    }

    @GetMapping("/getUser")
    public User showInfoBySession(HttpServletRequest request, HttpServletResponse response){

        return userInfoService.showInfoBySession(request,response);
    }

}
