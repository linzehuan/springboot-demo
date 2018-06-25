package com.dsx.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口返回数据工具类
 * @author an
 *
 */
public class Message {
	
	//状态码
	private int code;
	
	//状态信息
	private String msg;
	
	//主体数据
	private Map<String, Object> data = new HashMap<String, Object>();
	
	/**
	 * 操作成功
	 * @return
	 */
	public static Message success(String msg) {
		Message message = new Message();
		message.setCode(100);
		message.setMsg(msg);
		return message;
	}
	
	/**
	 * 操作失败
	 * @return
	 */
	public static Message fail(String msg) {
		Message message = new Message();
		message.setCode(200);
		message.setMsg(msg);
		return message;
	}
	
	/**
	 * 特殊提示
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Message other(int code,String msg) {
		Message message = new Message();
		message.setCode(code);
		message.setMsg(msg);
		return message;
	}
	
	/**
	 * 添加数据
	 * @param key
	 * @param value
	 * @return
	 */
	public Message add(String key,Object value) {
		this.getData().put(key, value);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
