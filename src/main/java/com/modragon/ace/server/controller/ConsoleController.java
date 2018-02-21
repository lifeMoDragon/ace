package com.modragon.ace.server.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	public void getConsoleMenu(HttpServletResponse response) {
		List<Map<String, String>> menuList = consoleService.qryConsoleMenu();
		
		try {
			PrintWriter printWriter = response.getWriter();
			printWriter.write("aaa");
			printWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 明了注解@ResponseBody ，则会直接将返回值输出到页面。
	 * @return
	 */
	@RequestMapping(value ="/example1",method = RequestMethod.GET)
	@ResponseBody
	public String getConsoleMenu() {
		return "success";
	}
	
	/**
	 * 通过ModelAndView构造方法可以指定返回的页面名称，也可以通过setViewName()方法跳转到指定的页面
	 * @return
	 */
	@RequestMapping("/example2")
	public ModelAndView helloWorld() { 
	    String message = "Hello World, Spring 3.x!";
	    return new ModelAndView("aceChinaTemplate/index", "message", message);
	}
	
	/**
	 * 在jsp页面中可直通过${key1}获得到值, map.put()相当于request.setAttribute方法。
	 * @return
	 */
	@RequestMapping("/example3")
	public Map<String, String> getMap() { 
	    Map<String, String> map = new HashMap<String, String>(); 
	    map.put("key1", "value-1"); 
	    map.put("key2", "value-2"); 
	    return map; 
	}
}
