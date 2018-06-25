package com.dsx.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
	
	private static final Logger logger = LoggerFactory.getLogger(RouteController.class);
	
	@RequestMapping("/home")
	public String toHome(Map<String,String> map) {
		logger.debug("进入controller...");
		map.put("name", "Tom");
		return "home";
	}

}
