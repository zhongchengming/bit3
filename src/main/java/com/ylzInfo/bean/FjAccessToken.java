package com.ylzInfo.bean;
import java.util.Date;

/**
 * Created by zhongchengming on 2018/7/6.
 */
public class FjAccessToken {
    /**
     * id
     */
  private String id;

    /**
     * 用户id
     */
  private String userid;
    /**
     * 验证码数量
     */
  private Long capthaCount;
    /**
     * 验证码
     */
  private Long capthcaCode;
    /**
     * 发送验证码时间
     */
  private Date capthcaCreatDate;
    /**
     * token过期时间设置
     */
    private Date expireAt;

    /**
     * userKey
     * @return
     */

    private String userKey;


    /**
     * 名字
     * @return
     */
    private String userName;

    /**
     * 密码
     * @return
     */
    private String passWord;


    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 短信类型
     * @return
     */
    private String  codeType;


    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }


    public Long getCapthcaCode() {
        return capthcaCode;
    }

    public void setCapthcaCode(Long capthcaCode) {
        this.capthcaCode = capthcaCode;
    }

    public Date getCapthcaCreatDate() {
        return capthcaCreatDate;
    }

    public void setCapthcaCreatDate(Date capthcaCreatDate) {
        this.capthcaCreatDate = capthcaCreatDate;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Long getCapthaCount() {
        return capthaCount;
    }

    public void setCapthaCount(Long capthaCount) {
        this.capthaCount = capthaCount;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}
