package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.User;
import com.ylzInfo.mapping.UserMapper;
import com.ylzInfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void register(HttpServletRequest request) {
        String invitationcode = request.getParameter("invitationcode");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String code = request.getParameter("code");
        User user = new User();
        user.setInvitationcode(invitationcode);
        user.setPassword(password);
        user.setUsername(username);
       int userid = userMapper.insert(user);
       User user1 =  userMapper.selectByPrimaryKey(userid);
       Random r = new Random(1);
       int size =String.valueOf(userid).length();

       StringBuffer  stringBuffer = new StringBuffer(userid);
       for(int i=0 ; i<5-size ;  i++) {
          int ran1 = r.nextInt(100);
         stringBuffer.append(String.valueOf(ran1));
       }
       user1.setInvitationcode(stringBuffer.toString());
       userMapper.updateByPrimaryKeySelective(user1);
    }

    @Override
    public List<User> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List list =  userMapper.selectByUserNameAndpwd(username,password);
        return list;
    }
}
