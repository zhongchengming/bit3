package com.ylzInfo.controller;

import com.ylzInfo.bean.Appsetup;
import com.ylzInfo.bean.Bank;
import com.ylzInfo.bean.Exchange;
import com.ylzInfo.bean.User;
import com.ylzInfo.mapping.AppsetupMapper;
import com.ylzInfo.mapping.BankMapper;
import com.ylzInfo.mapping.ExchangeMapper;
import com.ylzInfo.mapping.UserMapper;
import com.ylzInfo.service.BankServer;
import com.ylzInfo.util.CommUtil;
import com.ylzInfo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-02
 */
@RequestMapping("other")
@Controller
public class OtherController {
    @Autowired
    BankServer bankServer;

    @Autowired
    BankMapper bankMapper;
    @Autowired
    AppsetupMapper appsetupMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ExchangeMapper exchangeMapper;

    /**
     * 获取银行卡
     */
    @ResponseBody
    @RequestMapping("bankList")
    public Result updateOrder(HttpServletRequest request) {
        try {
            List<Bank> list = bankMapper.selectAll();
            return new Result(1, "成功", list);
        } catch (Exception e) {
            return new Result(0, e.getMessage());
        }
    }

    /**
     * 获取app设置信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("appSetup")
    public Result appSetup(HttpServletRequest request) {
        Appsetup appsetup = appsetupMapper.selectByPrimaryKey(1);
        return new Result(1, "成功", appsetup);
    }

    /**
     * app参数设置
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("appSetupSet")
    public Result appSetupSet(HttpServletRequest request) {
        String jf = request.getParameter("integral");
        Appsetup appsetup = new Appsetup();
        appsetup.setId(1);
        appsetup.setIntegral(jf);
        appsetupMapper.updateByPrimaryKey(appsetup);
        return new Result(1, "成功", appsetup);
    }

    /**
     * 积分兑换
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("integralDuiH")
    public Result integralDuiH(HttpServletRequest request) {
        String type = request.getParameter("type");
        String userid = request.getParameter("userid");
        String number = request.getParameter("number");
        try {
            User user = userMapper.selectByPrimaryKey(Integer.valueOf(userid));
            Appsetup appsetup = appsetupMapper.selectByPrimaryKey(1);
            if(user==null){
                return new Result(0, "兑换失败，用户id不存在");
            }
            //0 人民币转积分
            if(type.equals("0")){
                if(user.getBalance()==null){
                    return new Result(0, "当前额度不足");
                }
                if(Float.valueOf(number)>Float.valueOf(user.getBalance())){
                    return new Result(0, "当前额度不足");
                }
               float  banlance = Float.valueOf(user.getBalance());
               String  fz = appsetup.getIntegral();//积分和一块钱的兑奖比值
               Integer finalJf = Integer.valueOf(number)*Integer.parseInt(fz)+user.getIntegral();//要充值的积分
                user.setIntegral(finalJf);
               Float finalMoney = banlance-Integer.parseInt(number);//充值后的额度
               user.setBalance(String.valueOf(finalMoney));
               userMapper.updateByPrimaryKeySelective(user);
            }
            //1 积分转人民币
            if(type.equals("1")){
                if(user.getIntegral()==null){
                    return new Result(0, "当前积分不足");
                }
                if(Integer.parseInt(number)>user.getIntegral()){
                    return new Result(0, "当前积分不足");
                }
                String  fz = appsetup.getIntegral();//积分和一块钱的兑奖比值
                float finalmoney =Float.valueOf(number)/Integer.parseInt(fz);//要充值金额
                float f1 = finalmoney+Float.valueOf(user.getBalance());
                user.setBalance(String.format("%.2f", f1));
                Integer finaljf =user.getIntegral()-Integer.parseInt(number);//充值后的额度
                user.setIntegral(finaljf);
                userMapper.updateByPrimaryKeySelective(user);
            }
            Exchange exchange = new Exchange();
            exchange.setCreatetime(CommUtil.dateToString(new Date()));
            exchange.setUserid(Integer.parseInt(userid));
            exchange.setType(type);
            exchange.setValue(number);
            exchangeMapper.insert(exchange);
            return new Result(1, "成功", user);
        }catch (Exception e){
            return new Result(0, "服务器错误");
        }
    }

    /**
     * 充值或者兑换记录
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("dhHistory")
    public Result dhHistory(HttpServletRequest request) {
     try {
         String userid = request.getParameter("userid");
         String type = request.getParameter("type");
         HashMap param  = new HashMap();
         param.put("userid",userid);
         param.put("type",type);
         List<Exchange> list =  exchangeMapper.selectByUseridAndType(param);
         return new Result(1, "成功", list);
     }catch (Exception e) {
         return new Result(0, "服务器错误");
     }
    }
}
