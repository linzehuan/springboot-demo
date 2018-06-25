package com.dsx.utils;

import java.util.HashMap;
import java.util.Map;

public class WxPayUtil {
	
	private static WxPayUtil payUtil = null;
	
	private WxPayUtil() {}
	
	public static WxPayUtil getInstance() {
		if(payUtil == null) {			
			payUtil = new WxPayUtil();
		}
		return payUtil;
	}
	
	public Map<String, String> getParams(){
		Map<String, String> params = new HashMap<String, String>();
		
		//AppID(微信分配的小程序ID)
		params.put("appid", StaticDataUtil.APPID);
		//商户号(微信支付分配的商户号)
		params.put("mch_id", StaticDataUtil.MCHID);
		//设备号(自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB") 可不填*
		params.put("device_info", "appid");
		//随机字符串(随机字符串，长度要求在32位以内。推荐随机数生成算法)
		params.put("nonce_str", "appid");
		//签名(通过签名算法计算得出的签名值，详见签名生成算法)  *
		params.put("sign", "appid");
		//签名类型(签名类型，默认为MD5，支持HMAC-SHA256和MD5) 可不填*
		params.put("sign_type", "MD5");
		//商品描述(商品简单描述，该字段请按照规范传递，具体请见参数规定) 可不填*
		params.put("body", "appid");
		//商品详情(商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”) 可不填*
		params.put("detail", "appid");
		//附加数据(附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用) 可不填*
		params.put("attach", "appid");
		//商户订单号(商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号)
		params.put("out_trade_no", "appid");
		//标价币种(符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型) 可不填*
		params.put("fee_type", "CHY");
		//标价金额(订单总金额，单位为分，详见支付金额)
		params.put("total_fee", "appid");
		//终端IP(APP和网页支付提交用户端IP，Native支付填调用微信支付API的机器IP)
		params.put("spbill_create_ip", "appid");
		//交易起始时间(订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则) 可不填*
		params.put("time_start", "appid");
		//交易结束时间() 可不填*
		params.put("time_expire", "appid");
		//订单优惠标记(订单优惠标记，使用代金券或立减优惠功能时需要的参数，说明详见代金券或立减优惠) 可不填*
		params.put("goods_tag", "appid");
		//通知地址(异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数) 
		params.put("notify_url", "appid");
		//交易类型(小程序取值如下：JSAPI，详细说明见参数规定)
		params.put("trade_type", "JSAPI");
		//商品ID(trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义) 可不填*
		params.put("product_id", "");
		//用户标识(trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识)
		params.put("openid", "openid");
		
		return params;
	}

}
