package com.ylzInfo.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("login")
    public String login(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(StringUtils.equalsIgnoreCase((String) request.getSession().getAttribute("username"),"admin")){
            return "viewManage/viewHome";
        }
        if(StringUtils.equalsIgnoreCase(username,"admin")&&StringUtils.equalsIgnoreCase(password,"abcd123e45")){
            request.getSession().setAttribute("password",password);
            request.getSession().setAttribute("username",username);
            model.addAttribute("message", "登录成功");
            return "viewManage/viewHome";
        }else {
//            model.addAttribute("message", "登录失败");
            return "index";
        }
    }
}
