package com.modragon.ace.server.console.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.modragon.ace.server.console.service.ConsoleService;

@Service
public class ConsoleServiceImpl implements ConsoleService {
	public List<Map<String, String>> qryConsoleMenu(){
		List<Map<String, String>> menuList = new ArrayList<>();
		return menuList;
	}
}
