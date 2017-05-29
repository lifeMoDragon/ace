package com.modragon.ace.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class LoginController {
	/**
	 * 首页登录
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/index",method = RequestMethod.GET)
	public String toIndexPage(ModelMap model) {
		System.out.println("首页登录");
		return "aceChinaTemplate/index";
	}
}