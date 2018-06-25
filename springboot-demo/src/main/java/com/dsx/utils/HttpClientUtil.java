package com.dsx.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 第三方HTTP请求工具类
 * @author an
 *
 */
public class HttpClientUtil {
	
	/**
	 * GET
	 * @param url
	 * @return
	 */
	public static Map<String, Object> sendGet(String url) {
		Map<String, Object> map = new HashMap<>();
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpGet httpGet = null;
		JSONObject jsonObject = null;
		try {
			httpClient = HttpClients.createDefault();
			httpGet = new HttpGet(url);
			response = httpClient.execute(httpGet);
			try {
				//响应状态״̬
				map.put("status", response.getStatusLine());
				
				//响应头
				map.put("header", response.getHeaders(url));
				
				//响应实体JSON处理
				HttpEntity entity = response.getEntity();
				String string = EntityUtils.toString(entity);
				jsonObject = JSONObject.parseObject(string);
				map.put("entity", jsonObject);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/**
	 * POST
	 * @param url
	 * @param params
	 * @return
	 */
	public static Map<String, Object> sendPost(String url,Map<String, String> params){
		Map<String, Object> map = new HashMap<>();
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		HttpPost httpPost = null;
		JSONObject jsonObject = null;
		try {
			httpclient = HttpClients.createDefault();
			httpPost = new HttpPost(url);
			List<BasicNameValuePair> postParams = new ArrayList<>();
			//遍历参数
			for (Map.Entry<String, String> entry : params.entrySet()) {
				postParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			
			httpPost = new HttpPost(url);
			HttpEntity paramEntry = new UrlEncodedFormEntity(postParams);
			httpPost.setEntity(paramEntry);
			
			//执行POST
			response = httpclient.execute(httpPost);
			
			//请求状态״̬
			map.put("status", response.getStatusLine());
			
			//请求头
			map.put("header", response.getHeaders(url));
			
			//实体类JSON处理
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			jsonObject = JSONObject.parseObject(string);
			map.put("entity", jsonObject);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(httpclient != null) {
						try {
							httpclient.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return map;
	}

}
