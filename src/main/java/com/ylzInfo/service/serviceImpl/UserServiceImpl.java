package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.Grade;
import com.ylzInfo.bean.User;
import com.ylzInfo.mapping.GradeMapper;
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
    @Autowired
    GradeMapper gradeMapper;
    @Override
    public void register(HttpServletRequest request,User vuser) {
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String code = request.getParameter("code");
        User user = new User();
        user.setInvitationcode(this.invitationcode(String.valueOf(vuser.getId())));
        user.setPassword(password);
        user.setUsername(username);
        String gradenew = null;
        if(vuser.getGrade()==null){
            gradenew = String.valueOf(vuser.getId());
        }else {
            gradenew = vuser.getId()+","+vuser.getGrade();
        }
        //获取用户id列表
        String[] idList = gradenew.split(",");

//        获取等级列表
        List<Grade> list =  gradeMapper.selectAll();
        for (int i = 0;i<idList.length;i++){
            Grade grade1 = null;
            if(i>=list.size()){
                grade1 =   list.get(list.size()-1);
            }else {
                grade1 = list.get(i);
            }
            String scoreuserid = idList[i];
            User addscoreUser = userMapper.selectByPrimaryKey(Integer.valueOf(scoreuserid));
            int addscore =  addscoreUser.getIntegral()==null?0:addscoreUser.getIntegral();
            int score =  Integer.valueOf(grade1.getScore())+addscore;
            User newuser = new User();
            newuser.setId(Integer.valueOf(scoreuserid));
            newuser.setIntegral(score);
            userMapper.updateByPrimaryKeySelective(newuser);
        }
        //        设计等级
        StringBuffer  stringBuffer = new StringBuffer();

//添加邀请码对应的那个用户id
        if(vuser.getGrade()==null){
            stringBuffer.append(vuser.getId());
        }else {
            stringBuffer.append(vuser.getId()+",");
            stringBuffer.append(vuser.getGrade());
        }
//        被邀请的用户
        user.setGrade(stringBuffer.toString());

        userMapper.insert(user);
    }

    @Override
    public List<User> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List list =  userMapper.selectByUserNameAndpwd(username,password);
        return list;
    }

    @Override
    public List<User> selectByinvitatocode(String invitationcode) {
        List list =  userMapper.selectByinvitatocode(invitationcode);
        return list;
    }

    @Override
    public void update(int userid) {

    }

    @Override
    public void registerTwo(HttpServletRequest request) {
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        User user = new User();
        user.setInvitationcode(this.invitationcode("T"));
        user.setPassword(password);
        user.setUsername(username);
        userMapper.insert(user);

    }

    @Override
    public List<User> selectByUsername(String username) {
        List<User>list =  userMapper.selectByAccount(username);
        return list;
    }

    public String invitationcode(String userid){
        Random r = new Random(1);
        int size =String.valueOf(userid).length();
        StringBuffer  stringBuffer = new StringBuffer(userid);
        for(int i=0 ; i<5-size ;  i++) {
            int randnum =  (int) (Math.random() * 10);
            stringBuffer.append(randnum);
        }
        return stringBuffer.toString();
    }
}
