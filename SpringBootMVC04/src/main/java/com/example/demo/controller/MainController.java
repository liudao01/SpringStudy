package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.Account;
import com.example.demo.mapper.Menu;
import com.example.demo.service.AccountService;
import com.example.demo.service.MenuService;


/**
 * 在我们访问 http://主机名：端口号/context-path/Controller的URI/方法的URI
 * http://localhost:80/boot/user/list
 * 
 * @author Administrator
 * @Controller 加入Spring容器管理,单例
 */

/**
 * 注解 含义
 * 
 * @Component 最普通的组件，可以被注入到spring容器进行管理
 * @Repository 作用于持久层
 * @Service 作用于业务逻辑层
 * @Controller 作用于表现层（spring-mvc的注解）
 * @author liumaolin
 *
 *         访问地址: http://localhost:8080/account/
 * 
 *         访问地址设置 server.servlet.context-path=/account
 */
@Controller
public class MainController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	MenuService menuService;

	
	@RequestMapping("/list")
	@ResponseBody
	public Object list() {
		List<Account> accountObject =  accountService.findAll();
		
		List<Menu> menus  = menuService.findAll();
		
		return menus;
	}
	
	
	
	
	
	@RequestMapping("/add")
	@ResponseBody
	public Object add() {
		accountService.add();
		return "ok";
	}
	
	@RequestMapping("/addMenu")
	@ResponseBody
	public Object addMenu() {
		menuService.add();
		return "ok";
	}
	
	
	
	
	

}
