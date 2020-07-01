package com.ylzInfo.service;

import com.ylzInfo.bean.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-01
 */
public interface OrderServer {
    void creatOrder(HttpServletRequest request) throws Exception;

    List<Order> orderList(HttpServletRequest request);

    void updateOrder(HttpServletRequest request);

    int selectCount();

    void updateOrderApp(HttpServletRequest request) throws Exception;

    List<Order> selectOrder(HttpServletRequest request);
}
