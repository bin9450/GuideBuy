package com.upc.controller;

import com.upc.domain.node.UserNode;
import com.upc.entity.User;
import com.upc.service.UserNodeService;
import com.upc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Pan
 * @Date: 2019/4/2 14:40
 * @Description:
 **/

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserNodeService userNodeService;

    //跳转首页（登录页）
    @RequestMapping("/toLogin")
    public String show(){
        return "login";
    }

    //@ResponseBody
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        String userName = user.getUserName();
        String password = user.getPassWord();
     //   System.out.println("dsadsa"+userName+"  "+password);
        User u1 = userService.login(userName,password);
        UserNode userNode = null;
        if(u1 == null ){
            return "redirect:/toLogin";
        }else {
            request.getSession().setAttribute("session_user",u1);
            userNode = userNodeService.findByUserId(u1.getUserId());
            if (userNode == null ){
               userNodeService.createUserNode(u1.getUserId(),u1.getNickName());
            }
            return "redirect:/index";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user){
        if(user.getUserName() == null||user.getPassWord() == null
                ||userService.isRepeat(user.getUserName()) != null ){
            return "register";
        }else{
            int u1 = userService.register(user);
            return "login";
        }
    }

    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
    }



}
