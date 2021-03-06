package com.ylzInfo.mapping;

import com.ylzInfo.bean.Order;
import com.ylzInfo.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Wed Jul 01 17:25:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Wed Jul 01 17:25:18 CST 2020
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Wed Jul 01 17:25:18 CST 2020
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Wed Jul 01 17:25:18 CST 2020
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Wed Jul 01 17:25:18 CST 2020
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_order
     *
     * @mbggenerated Wed Jul 01 17:25:18 CST 2020
     */
    int updateByPrimaryKey(Order record);

    List<Order> queryOrder(HashMap param);

    int selectCount();

    List<Order> selectByUserId(Integer userid);


    List selectBankAndByUserId(Integer id);
}
