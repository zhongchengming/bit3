package com.ylzInfo.service.serviceImpl;
import com.ylzInfo.bean.Order;
import com.ylzInfo.bean.User;
import com.ylzInfo.mapping.OrderMapper;
import com.ylzInfo.mapping.UserMapper;
import com.ylzInfo.service.OrderServer;
import com.ylzInfo.util.CommUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-01
 */
@Service
public class OrderServerImpl implements OrderServer {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Override
    public void creatOrder(HttpServletRequest request) throws Exception {
        String bankcard = request.getParameter("bankcard");
        String money = request.getParameter("money");
        String username = request.getParameter("username");
        String beizhu = request.getParameter("beizhu");
        List<User> list = userMapper.selectByAccount(username);
        if(list.size()!=1){
            throw new Exception("用户不存在或者用户异常");
        }
        if(!CommUtil.isNumber(money)){
            throw new Exception("金额只能为纯数字");
        }
        String ordernumber = CommUtil.getRandomString(6);
        String sjc = String.valueOf(System.currentTimeMillis());
        Order order = new Order();
        order.setCreatedate(CommUtil.dateToString(new Date()));
        order.setBankcard(bankcard);
        order.setMoney(money);
        order.setOrdernumber(sjc+ordernumber);
        order.setOrderstate("0");
        order.setBeifen(beizhu);
        order.setUsername(username);
        User user = list.get(0);

        order.setUserid(user.getId());
        orderMapper.insert(order);
    }

    @Override
    public List<Order> orderList(HttpServletRequest request) {
        String pageSize = request.getParameter("pageSize");
        String pageNumber = request.getParameter("pageNumber");
        String username = request.getParameter("username");
        HashMap param = new HashMap();

        Integer pageNumber1 = Integer.parseInt(pageNumber)-1;
        Integer pageSize1 = Integer.parseInt(pageSize);

        param.put("pageSize",Integer.parseInt(pageSize));
        param.put("start",pageNumber1*pageSize1);
        param.put("username",username);
        List <Order> list = orderMapper.queryOrder(param);
        return list;
    }

    @Override
    public void updateOrder(HttpServletRequest request) {
        String status = request.getParameter("orderstate");
        String orderid = request.getParameter("id");
       Order order = new Order();
       order.setOrderstate(status);
       order.setId(Integer.valueOf(orderid));
        orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public int selectCount() {
       int count = orderMapper.selectCount();
        return count;
    }

    @Override
    public void updateOrderApp(HttpServletRequest request) throws Exception {
        String userid = request.getParameter("userid");
        String wbankid = request.getParameter("w_bankid");
        List<Order>list = orderMapper.selectByUserId(Integer.valueOf(userid));
        Boolean bool = false;
        if(list.size()>0){
            for(int i = 0;i<list.size();i++){
                Order order = list.get(i);
                String statue = order.getOrderstate();
                if(statue.equals("0")){
                    order.setOrderstate("1");
                    order.setWbankid(wbankid);
                    orderMapper.updateByPrimaryKeySelective(order);
                    bool = true;
                }
            }
            if(bool==false){
                throw new Exception("订单不存在，请联系客服");
            }
        }else {
            throw new Exception("订单不存在，请联系客服");
        }

    }

    @Override
    public List<Order> selectOrder(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        List<Order>list = orderMapper.selectByUserId(Integer.valueOf(userid));
        return list;
    }
}
