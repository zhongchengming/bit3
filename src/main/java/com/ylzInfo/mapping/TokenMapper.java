package com.ylzInfo.mapping;

import com.ylzInfo.bean.Token;

import java.util.HashMap;
import java.util.List;

public interface TokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table token
     *
     * @mbggenerated Thu Jul 02 11:32:31 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table token
     *
     * @mbggenerated Thu Jul 02 11:32:31 CST 2020
     */
    int insert(Token record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table token
     *
     * @mbggenerated Thu Jul 02 11:32:31 CST 2020
     */
    int insertSelective(Token record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table token
     *
     * @mbggenerated Thu Jul 02 11:32:31 CST 2020
     */
    Token selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table token
     *
     * @mbggenerated Thu Jul 02 11:32:31 CST 2020
     */
    int updateByPrimaryKeySelective(Token record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table token
     *
     * @mbggenerated Thu Jul 02 11:32:31 CST 2020
     */
    int updateByPrimaryKey(Token record);
    List<Token> getTokenByUserid(HashMap map);
}