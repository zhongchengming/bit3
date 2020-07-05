package com.ylzInfo.controller;

import com.ylzInfo.bean.Invitation;
import com.ylzInfo.bean.Token;
import com.ylzInfo.bean.User;
import com.ylzInfo.bean.Withdrawal;
import com.ylzInfo.mapping.OrderMapper;
import com.ylzInfo.mapping.TokenMapper;
import com.ylzInfo.mapping.UserMapper;
import com.ylzInfo.mapping.WithdrawalMapper;
import com.ylzInfo.service.InvitationServer;
import com.ylzInfo.service.TokenServer;
import com.ylzInfo.service.UserService;
import com.ylzInfo.service.WithdrawalServer;
import com.ylzInfo.util.CommUtil;
import com.ylzInfo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    InvitationServer invitationServer;
    @Autowired
    TokenServer tokenServer;
    @Autowired
    TokenMapper tokenMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    WithdrawalMapper withdrawalMapper;
    @Autowired
    WithdrawalServer withdrawalServer;

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
            List <Token>tokenList = tokenServer.getTokenByUserid(request);
            String token = null;
            if(tokenList.size()==0){
                token =  tokenServer.insertToken(request,list.get(0).getId());
            }else {
                token =  tokenServer.updateToken(tokenList.get(0));
            }
            HashMap map = new HashMap();
            map.put("user",list.get(0));
            map.put("token",token);

            List list1 =   orderMapper.selectBankAndByUserId(list.get(0).getId());
             if(list1.size()>0){
                 HashMap map1 = (HashMap) list1.get(0);
                 String dataStr[] = CommUtil.distantTime((String) map1.get("createdate"));

                 String tcTime = (String) map1.get("time");
                 map.put("endDay",Integer.parseInt(tcTime)-Integer.valueOf(dataStr[0]));
             }
            return new Result(1,"登录成功！",map);
        }catch (Exception e){
            return  new Result(0,"服务器异常");
        }
    }
    @ResponseBody
    @RequestMapping("/outLogin")
    public Result outLogin(HttpServletRequest request){
        try {
            tokenServer.updateTokenValue(request);
            return new Result(1,"退出成功！");
        }catch (Exception e){
            return  new Result(0,"服务器异常");
        }
    }
    @ResponseBody
    @RequestMapping("/changePwd")
    public Result changePwd(HttpServletRequest request){
        Result resultToken = isunableToken(request);
        if(resultToken!=null){
            return resultToken;
        }
        try {
            Result result =  userService.changePwd(request);
            return result;
        }catch (Exception e){
            return  new Result(0,"修改失败");
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

    /**
     * 提现申请
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/withdrawalApply")
    public Result withdrawalApply(HttpServletRequest request){
        Result resultToken = isunableToken(request);
        if(resultToken!=null){
            return resultToken;
        }
      try {
          String realname = request.getParameter("realname");
          String cardno = request.getParameter("cardno");
          String userid = request.getParameter("userid");
          String bankName = request.getParameter("bankName");
          User user = userMapper.selectByPrimaryKey(Integer.valueOf(userid));
          if(user==null){
              return new Result(0,"用户不存在");
          }
          String money = request.getParameter("money");
          Withdrawal withdrawal = new Withdrawal();
          withdrawal.setBankname(bankName);
          withdrawal.setCreatetime(CommUtil.dateToString(new Date()));
          withdrawal.setMoney(money);
          withdrawal.setRealname(realname);
          withdrawal.setUserid(Integer.parseInt(userid));
          withdrawal.setBankno(cardno);
          withdrawal.setState("0");
          withdrawal.setUsername(user.getUsername());
          withdrawalMapper.insert(withdrawal);
          return new Result(1,"已提交申请","");
      }catch (Exception e){
          return new Result(0,"服务器异常");
      }
    }

    /**
     * 提现记录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/withdrawalHistroy")
    public Result withdrawalHistroy(HttpServletRequest request){
        Result resultToken = isunableToken(request);
        if(resultToken!=null){
            return resultToken;
        }
        try {
            Result result =  withdrawalServer.selectByUserid(request);
            return result;
        }catch (Exception e){
            return new Result(0,"服务器异常");
        }
    }

    /**
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/withdrawalFinish")
    public Result withdrawalFinish(HttpServletRequest request){
        try {
            Result result =  withdrawalServer.withdrawalFinish(request);
            return result;
        }catch (Exception e){
            return new Result(0,"服务器异常");
        }
    }
    private Result isunableToken(HttpServletRequest request){
        //表示前端请求
        String urlType = request.getParameter("urlType");
        if(urlType!=null){
            return  null;
        }
        HashMap map = new HashMap();
        String token = request.getParameter("token");
        if(token==null){
            return new Result(0,"token不能为空");
        }
        List<Token> tokenList =  tokenMapper.getTokenByUserid(map);
        if(tokenList.size()==0){
            return new Result(0,"token不存在，请重新登录");
        }
        if(tokenList.size()>0){
            Token token1 = tokenList.get(0);
            Long oldToken = Long.valueOf(token1.getCreatetime());
            Long sjc = System.currentTimeMillis();
            Long servenMillis = Long.valueOf(86400*7);
            if(sjc-oldToken>servenMillis){
                return new Result(0,"token失效，请重新登录！");
            }
            return new Result(0,"token不存在！");
        }
        return null;

    }
}
