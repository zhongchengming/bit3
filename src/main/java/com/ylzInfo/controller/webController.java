package com.ylzInfo.controller;

import com.ylzInfo.bean.Grade;
import com.ylzInfo.bean.Order;
import com.ylzInfo.bean.Token;
import com.ylzInfo.mapping.TokenMapper;
import com.ylzInfo.service.GradeServer;
import com.ylzInfo.service.OrderServer;
import com.ylzInfo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-06-30
 */
@RequestMapping("/web")
@Controller
public class webController {
    @Autowired
    GradeServer gradeServer;
    @Autowired
    OrderServer orderServer;
    @Autowired
    TokenMapper tokenMapper;

    /**
     * 获取等级
     * @return
     */
    @ResponseBody
    @RequestMapping("gradelist")
    public Result gradelist (){
        try {
            List<Grade> list = gradeServer.getAll();
            return new Result(1,"成功",list);
        }catch (Exception e){
            return new Result(0,"异常");
        }

    }

    /**
     * 添加积分等级
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("addAgrade")
    public Result addAgrade (HttpServletRequest request){
        try {
             gradeServer.addAgrade(request);
            return new Result(1,"成功");
        }catch (Exception e){
            return new Result(0,"异常");
        }

    }

    /**
     * 更新
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("updateAgrade")
    public Result updateAgrade (HttpServletRequest request){
        try {
            gradeServer.updateAgrade(request);
            return new Result(1,"成功");
        }catch (Exception e){
            return new Result(0,"异常");
        }
    }
    /**
     * 新增充值
     */
    @ResponseBody
    @RequestMapping("creatOrder")
    public Result creatOrder (HttpServletRequest request){
        try {
            orderServer.creatOrder(request);
            return new Result(1,"成功");
        }catch (Exception e){
            return new Result(0,e.getMessage());
        }
    }
    /**
     * 获取订单列表列表
     */
    @ResponseBody
    @RequestMapping("orderList")
    public Result orderList (HttpServletRequest request){
        try {
            Result result = isunableToken(request);
            if(result!=null){
                return result;
            }
           List <Order > list = orderServer.orderList(request);
           int count  = orderServer.selectCount();
            HashMap resultMap = new HashMap();
            resultMap.put("totalCounts",count);
            resultMap.put("data",list);
            return new Result(1,"成功",resultMap);
        }catch (Exception e){
            return new Result(0,e.getMessage());
        }
    }
    /**
     * 修改状态
     */
    @ResponseBody
    @RequestMapping("updateOrder")
    public Result updateOrder (HttpServletRequest request){
        try {
             orderServer.updateOrder(request);
            return new Result(1,"成功");
        }catch (Exception e){
            return new Result(0,e.getMessage());
        }
    }

    /**
     * 修改状态
     */
    @ResponseBody
    @RequestMapping("updateOrderApp")
    public Result updateOrderApp (HttpServletRequest request){
        String wbankid = request.getParameter("w_bankid");
        if(wbankid==null){
            return new Result(0,"所选套餐id不能为空");
        }
        try {
            orderServer.updateOrderApp(request);
            return new Result(1,"已提交充值申请，等待确认");
        }catch (Exception e){
            return new Result(0,e.getMessage());
        }
    }

    /**
     * 查询订单
     */
    @ResponseBody
    @RequestMapping("selectOrder")
    public Result selectOrder (HttpServletRequest request){
        try {
         List<Order> list = orderServer.selectOrder(request);
            return new Result(1,"查询成功",list);
        }catch (Exception e){
            return new Result(0,e.getMessage());
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
