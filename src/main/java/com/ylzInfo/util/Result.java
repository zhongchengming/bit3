package com.ylzInfo.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Result implements Serializable {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public static final int NO_MESSAGE = 2;
	public static final int ACCESS_TOKEN_ERROR = 11;
	public static final int NOT_LOGGED_ON = 13;
	public static final int NOT_SI_AUTHENTICATED = 14;
	public static final int SI_INFO_ERROR = 12;
	public static final int BAD_REQUEST = 400;
	public static final int UNAUTHORIZED = 401;
	public static final int FORBIDDEN = 403;
	public static final int NOT_FOUND = 404;
	public static final int INTERNAL_SERVER_ERROR = 500;
	public static final int CJOB_ERROR = 1001;



	public static final String DATA_LIST = "queryList";//数据组的key名称
	public static final String DATA_TOTAL_COUNT = "totalCount";//数据总个数的key名称
	public static final String DATA_TOTAL_PAGE = "totalPage";//数据总页数key名称

	protected int resultCode;
	protected String resultMsg;
	protected Object resultBody;




	public Result(int resultCode) {
		this.resultCode = resultCode;
	}

	public Result(int resultCode, String resultMsg) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
	}


	public Result(int resultCode, Object resultBody) {
		this.resultCode = resultCode;
		this.resultBody = resultBody;
	}

	public Result(int resultCode, Map<String,Map<String,Object>> resultBodys) {
		this.resultCode = resultCode;
	}


	public Result(int resultCode, String resultMsg, Object resultBody) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultBody = resultBody;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public void setResultBody(Object resultBody) {
		this.resultBody = resultBody;
	}

	public Object getResultBody() {
		return resultBody;
	}



	@Override
	public String toString() {
		return "Result [resultCode=" + resultCode + ", resultMsg=" + resultMsg
				+ ", resultBody=" + resultBody + "]";
	}
	/**
	 *
	* @date 2017年9月11日 上午11:46:43
	* @author xuyajie
	* @return
	* @Description: 结果是否成功
	 */
	public boolean bisSuccess(){
		return getResultCode() == SUCCESS;
	}

	public static Result successResult(){
		return new Result(SUCCESS, "成功");
	}
	public static Result successResult(String message){
		return new Result(SUCCESS, message);
	}
	public static Result errorResult(String message){
		return new Result(FAIL, message);
	}
	public static Result noResult(String msg) {
		return new Result(NO_MESSAGE, msg == null ? "未查询到结果" : msg);
	}
	public static Result success(Object obj){
		return new Result(Result.SUCCESS,"请求成功",obj);
	}
	public static Result error(int code,String msg){
		return new Result(code,msg,null);
	}

	/**
	 *
	 * @param key
	 * @param value
	 * @description: 添加body属性(仅限body为map)
	 * @date: 2016年3月21日 上午9:37:03
	 * @author： Xu Yajie
	 */
	@SuppressWarnings("unchecked")
	public void setBodyAttr(String key, Object value) {
		if (this.resultBody == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(key, value);
			this.resultBody = map;
		}else if(this.resultBody instanceof Map){
			((Map<String, Object>) this.resultBody).put(key, value);
		}

	}
	/**
	 *
	* @date 2017年9月12日 上午11:50:31
	* @author xuyajie
	* @param key
	* @return
	* @Description: 获取body属性(仅限body为map)
	 */
	@SuppressWarnings("unchecked")
	public Object getBodyAttr(String key) {
		if (this.resultBody != null && this.resultBody instanceof Map) {
			return ((Map<String, Object>) this.resultBody).get(key);
		}
		return null;
	}


	/**
	 *
	* @date 2017年2月12日 上午10:31:28
	* @author xuyajie
	* @param counts
	* @Description: 设置数据总个数
	 */
	public void setDataTotalCount(int counts){
		setBodyAttr(DATA_TOTAL_COUNT,counts);
	}
	/**
	 *
	* @date 2017年2月12日 上午10:30:38
	* @author xuyajie
	* @param page
	* @Description: 设置数据总页数
	 */
	public void setDataTotalPage(int page){
		setBodyAttr(DATA_TOTAL_PAGE,page);
	}
	/**
	 *
	 * @param list
	 * @description: 保存数据列表
	 * @date: 2016年4月15日 上午11:37:18
	 * @author： Xu Yajie
	 */
	public void setDataList(List<?> list){
		setBodyAttr(DATA_LIST,list);
	}
}
