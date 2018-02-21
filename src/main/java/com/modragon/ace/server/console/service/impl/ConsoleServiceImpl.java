package com.modragon.ace.server.console.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.modragon.ace.server.console.dao.impl.ConsoleDao;
import com.modragon.ace.server.console.service.ConsoleService;

@Service
public class ConsoleServiceImpl implements ConsoleService {
	@Resource
	private ConsoleDao consoleDao;
	
	public List<Map<String, String>> qryConsoleMenu(){
		List<Map<String, String>> menuList = new ArrayList<>();
		System.out.println(consoleDao.jdbcExample());
		return menuList;
	}
}
