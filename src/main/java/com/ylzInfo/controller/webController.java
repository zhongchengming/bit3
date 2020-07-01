package com.ylzInfo.controller;

import com.ylzInfo.bean.Grade;
import com.ylzInfo.bean.Order;
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
     * 获取列表
     */
    @ResponseBody
    @RequestMapping("orderList")
    public Result orderList (HttpServletRequest request){
        try {
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

}
