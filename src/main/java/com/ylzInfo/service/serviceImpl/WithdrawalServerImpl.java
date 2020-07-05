package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.Withdrawal;
import com.ylzInfo.mapping.WithdrawalMapper;
import com.ylzInfo.service.WithdrawalServer;
import com.ylzInfo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-03
 */
@Service
public class WithdrawalServerImpl implements WithdrawalServer {
    @Autowired
    WithdrawalMapper withdrawalMapper;
    @Override
    public Result  selectByUserid(HttpServletRequest request) {
        try {
            String userid = request.getParameter("userid");
            String username = request.getParameter("username");

            String pageSize = request.getParameter("pageSize");
            String pageNumber = request.getParameter("pageNumber");
            if(pageSize==null){
                pageSize = "10";
            }
            if(pageNumber==null){
                pageNumber = "1";
            }
            HashMap param = new HashMap();

            Integer pageNumber1 = Integer.parseInt(pageNumber)-1;
            Integer pageSize1 = Integer.parseInt(pageSize);

            param.put("pageSize",Integer.parseInt(pageSize));
            param.put("start",pageNumber1*pageSize1);
            param.put("username",username);
            param.put("userid",userid);
            List<Withdrawal>list = withdrawalMapper.queryByMap(param);
            Integer count = withdrawalMapper.selectCount();
            HashMap resultMap = new HashMap();
            resultMap.put("totalCounts",count);
            resultMap.put("list",list);
            return new Result(1,"请求成功",resultMap);
        }catch (Exception e){
            return new Result(0,"服务器异常");
        }
    }

    @Override
    public Result withdrawalFinish(HttpServletRequest request) {
        try {
           String id =  request.getParameter("id");
            HashMap resultMap = new HashMap();
            resultMap.put("state","1");
            resultMap.put("id",id);
            withdrawalMapper.changeState(resultMap);
            return new Result(1,"操作成功");
        }catch (Exception e){
            return new Result(0,"服务器异常");
        }
    }
}
