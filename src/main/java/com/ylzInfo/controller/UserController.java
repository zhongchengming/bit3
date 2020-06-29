package com.ylzInfo.controller;

import com.ylzInfo.bean.Invitation;
import com.ylzInfo.bean.User;
import com.ylzInfo.service.InvitationServer;
import com.ylzInfo.service.UserService;
import com.ylzInfo.util.Result;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
   @Autowired
    UserService userService;
   @Autowired
    InvitationServer invitationServer;

    @ResponseBody
    @RequestMapping("/register")
    public Result register(HttpServletRequest request){
        try {
            String invitationcode = request.getParameter("invitationcode");
            List<Invitation> list = invitationServer.selectByCode(invitationcode);
            if(list.size()!=1){
                return  new Result(0,"邀请码错误");
            }
            userService.register(request);
            return new Result(1,"注册成功！",null);
        }catch (Exception e){
            return  new Result(0,"服务器异常");
        }
    }
    @ResponseBody
    @RequestMapping("/login")
    public Result login(HttpServletRequest request){
        try {
             List<User> list = userService.login(request);
             if(list.size()!=1){
                 return new Result(1,"账号或者密码错误！",null);
             }
            return new Result(1,"登录成功！",list.get(0));
        }catch (Exception e){
            return  new Result(0,"服务器异常");
        }
    }
}
