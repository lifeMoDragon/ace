package com.modragon.ace.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class LoginController {
	/**
	 * 中文首页登录
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/china/index",method = RequestMethod.GET)
	public String toChinaIndexPage(ModelMap model) {
		System.out.println("首页登录");
		return "aceChinaTemplate/index";
	}
}