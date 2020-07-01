package com.ylzInfo.controller;

import com.ylzInfo.bean.Invitation;
import com.ylzInfo.bean.User;
import com.ylzInfo.service.InvitationServer;
import com.ylzInfo.service.UserService;
import com.ylzInfo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
            String username = request.getParameter("username");
            List<User> listusername = userService.selectByUsername(username);
            if(listusername.size()!=0){
                return  new Result(0,"用户名已注册！");
            }
            //   查询用户表是否存在邀请码
            String invitationcode = request.getParameter("invitationcode");
            List<User> list = userService.selectByinvitatocode(invitationcode);
            if(list.size()!=1){
                List<Invitation> invitationList = invitationServer.selectByCode(invitationcode);
                if(invitationList.size()!=1){
                    return  new Result(0,"邀请码错误");
                }else {
                    userService.registerTwo(request);
                    return new Result(1,"注册成功！",null);
                }
            }else {
                User user = list.get(0);
                userService.register(request,user);
                return new Result(1,"注册成功！",null);
            }

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
                return new Result(0,"账号或者密码错误！",null);
            }
            return new Result(1,"登录成功！",list.get(0));
        }catch (Exception e){
            return  new Result(0,"服务器异常");
        }
    }

    @ResponseBody
    @RequestMapping("/messageList")
    public Result messageList(HttpServletRequest request){
        List messagelist = new ArrayList();
        messagelist.add("加载脚本...");
        messagelist.add("连接bite平台..");
        messagelist.add("嵌入脚本...");
        messagelist.add("加载数据..");
        messagelist.add("绑定数据....");
        messagelist.add("设置成功....");
        return new Result(1,"获取成功！",messagelist);
    }
}
