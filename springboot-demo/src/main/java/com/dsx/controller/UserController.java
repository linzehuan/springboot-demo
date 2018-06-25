package com.dsx.controller;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dsx.utils.HttpClientUtil;
import com.dsx.utils.Message;
import com.dsx.utils.StaticDataUtil;
import com.dsx.utils.WxPayUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * 登录接口
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Message login(@RequestParam("code") String code) {
		
		logger.debug("登录接收参数code: " + code);
		
		//处理URL
		String url = String.format(StaticDataUtil.CODE_URL, StaticDataUtil.APPID,StaticDataUtil.SECRET,code);
		
		//发送GET请求取响应
		Map<String, Object> response = HttpClientUtil.sendGet(url);
		JSONObject json = (JSONObject) response.get("entity");
		String openid = json.getString("openid");
		String session_key = json.getString("session_key");
		
		String session_id = UUID.randomUUID().toString().substring(0, 13);
		String value = openid + session_key;
		
		redisTemplate.opsForValue().set(session_id, value,60,TimeUnit.SECONDS);
		
		logger.debug("登录成功返回session_id: " + session_id);
		return Message.success("登录成功").add("session_id", session_id);
	}
	
	/**
	 * 检查登录状态是否有效
	 * @param session_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkLoginStatus",method=RequestMethod.POST)
	public Message checkLoginStatus(@RequestParam("session_id")String session_id) {
		logger.debug("检查登录有效性，参数session_id: " + session_id);
		String status = redisTemplate.opsForValue().get(session_id);
		if(status != null) {
			logger.debug("登录成功！");
			return Message.success("登录成功");
		}else {
			logger.debug("登录失效！");
			return Message.fail("登录失效");
		}
	}
	
	/**
	 * 预支付接口
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/prePayment",method=RequestMethod.POST)
	public Message prePayment(@RequestParam("session_id")String session_id) {
		Map<String, String> params = WxPayUtil.getInstance().getParams();
		Map<String, Object> response = HttpClientUtil.sendPost(StaticDataUtil.PER_PAY_URL, params);
		System.out.println(response.get("status"));
		JSONObject object = (JSONObject) response.get("entity");
		System.out.println(object);
		return Message.success("success").add("response", object);
	}

}
