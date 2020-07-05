package com.ylzInfo.service;

import com.ylzInfo.util.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-03
 */
public interface WithdrawalServer {
    Result  selectByUserid(HttpServletRequest request);

    Result withdrawalFinish(HttpServletRequest request);
}
