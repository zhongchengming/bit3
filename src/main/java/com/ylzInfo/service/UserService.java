package com.ylzInfo.service;

import com.ylzInfo.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    void register(HttpServletRequest request);

    List<User> login(HttpServletRequest request);
}
