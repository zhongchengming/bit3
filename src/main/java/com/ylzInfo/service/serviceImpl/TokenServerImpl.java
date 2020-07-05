package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.Token;
import com.ylzInfo.mapping.TokenMapper;
import com.ylzInfo.service.TokenServer;
import com.ylzInfo.util.CommUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-02
 */
@Service
public class TokenServerImpl implements TokenServer {
    @Autowired
    TokenMapper tokenMapper;
    @Override
    public List<Token> getTokenByUserid(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String token = request.getParameter("token");
        HashMap map = new HashMap();
        map.put("userid",userid);
        map.put("token",token);
        List<Token> list =  tokenMapper.getTokenByUserid(map);
        return list;
    }

    @Override
    public String insertToken(HttpServletRequest request,Integer userid) {
        String createtime = String.valueOf(System.currentTimeMillis());
        String tokenValue = CommUtil.getRandomString(15);
        Token token1 = new Token();
        token1.setCreatetime(createtime);
        token1.setStatus(0);
        token1.setUserid(userid);
        token1.setToken(tokenValue);
        tokenMapper.insert(token1);
        return tokenValue;
    }

    @Override
    public String updateToken(Token token) {
        String createtime = String.valueOf(System.currentTimeMillis());
        String tokenValue = CommUtil.getRandomString(15);
        token.setToken(tokenValue);
        token.setCreatetime(createtime);
        tokenMapper.updateByPrimaryKey(token);
        return tokenValue;
    }

    @Override
    public void updateTokenValue(HttpServletRequest request) {
        String userid = request.getParameter("userid");
        String token = request.getParameter("token");
        HashMap map = new HashMap();
        map.put("userid",userid);
        map.put("token",token);
        List<Token> list =  tokenMapper.getTokenByUserid(map);
        if(list.size()>0){
            Token token1 = list.get(0);
            tokenMapper.deleteByPrimaryKey(token1.getId());
        }
    }
}
