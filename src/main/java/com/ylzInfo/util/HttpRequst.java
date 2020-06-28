package com.ylzInfo.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class HttpRequst {
    private  int  code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResultBody() {
        return resultBody;
    }

    public void setResultBody(Object resultBody) {
        this.resultBody = resultBody;
    }

    private  String  message;
    private  Object resultBody;
    public HttpRequst(String url, Map<String,Object>parameter){
        try {
            String parm = parameter.toString();
            PostMethod post = new PostMethod(url);
            post.setRequestHeader("accept", "application/json");
            post.setRequestEntity(new StringRequestEntity(parm, "application/json", "UTF-8"));

            HttpClient hc = new HttpClient();
            hc.getParams().setContentCharset("UTF-8"); // ���ñ���
            int code = hc.executeMethod(post);
            System.err.println(" ���ص�״̬�룺" + code);
            String str = post.getResponseBodyAsString();
            System.err.println(" \n" + str);
            this.code = code;
            this.resultBody = JSONObject.toJSON(str);
            if(this.code==200){
                this.message = "请求成功！";
            }else {
                this.message = "请求失败！";
            }
            post.releaseConnection();
        }catch (Exception e){

        }
    }
}
