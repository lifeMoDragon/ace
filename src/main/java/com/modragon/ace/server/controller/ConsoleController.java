package com.modragon.ace.server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.modragon.ace.server.console.service.ConsoleService;

@Controller
@RequestMapping("/china/console")
public class ConsoleController {
	@Autowired
	private ConsoleService consoleService;
	
	/**
	 * 控制台菜单获取
	 * @return
	 */
	@RequestMapping(value ="/menu",method = RequestMethod.GET)
	public String getConsoleMenu() {
		List<Map<String, String>> menuList = consoleService.qryConsoleMenu();
		return "aceChinaTemplate/index";
	}
}
