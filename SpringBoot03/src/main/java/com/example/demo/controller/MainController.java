package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在我们访问 http://主机名：端口号/context-path/Controller的URI/方法的URI
 * http://localhost:80/boot/list
 * 
 * @author Administrator
 * @Controller 加入Spring容器管理,单例
 */
@Controller
public class MainController {

	@RequestMapping("/list")
	public String list(ModelMap map) {
		System.out.println("list");
		return "list";
	}
}
