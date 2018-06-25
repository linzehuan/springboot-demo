package com.dsx.utils;

public class StaticDataUtil {
	
	//小程序标识
	public static final String APPID = "wx824b0e97de39662f";
	
	//商户号
	public static final String MCHID = "1318361401";
	
	//小程序密钥
	public static final String SECRET = "48fb9f1c65dc90d7f7229c53130810ab";
	
	//登录接口
	public static final String CODE_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
	
	//微信预支付接口
	public static final String PER_PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

}
