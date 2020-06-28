package com.ylzInfo.util;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;

public class YlzEncryptUtil {

//	public static String encodePassword(String str) {
//		try {
//			return AesEncrypt.md5(AesEncrypt.sha1(str, "YLZ"), "MSW");
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static  String MD5Password(String str) {
//		return AesEncrypt.md5(str, "{PONY}");
//	}
//

	public static void main(String[] args){

		//加密
		try {
		    String	miwenofter = ConfigTools.encrypt("app_lzf");
			System.out.println("加密后"+miwenofter);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//解密
		try {
		String	mingwen = ConfigTools.decrypt("TrI3cU/9qCEI872nH7wVjsxpRQimE4BgEZXTORoXre9FTzLV+Qtlyti3HYdA/fITeuBO8R4q4keGAPDobdC3uA==");
			System.out.println("解密后："+mingwen);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
