package com.ylzInfo.service;

import com.ylzInfo.bean.User;
import com.ylzInfo.util.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    void register(HttpServletRequest request,User user);

    List<User> login(HttpServletRequest request);

    List<User> selectByinvitatocode(String invitationcode);

    void update(int userid);

    void registerTwo(HttpServletRequest request);

    List<User> selectByUsername(String username);

    Result changePwd(HttpServletRequest request);
}
