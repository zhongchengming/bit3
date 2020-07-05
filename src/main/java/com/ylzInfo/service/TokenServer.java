package com.ylzInfo.service;

import com.ylzInfo.bean.Token;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-02
 */
public interface TokenServer {
    List<Token> getTokenByUserid(HttpServletRequest request);

    String  insertToken(HttpServletRequest request, Integer userid);

    String  updateToken(Token token);

    void updateTokenValue(HttpServletRequest request);
}
