package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 *         访问地址: http://localhost:8888/
 *         //配置信息里端口写成8888了
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
		List<Account> accountObject = accountService.findAll();

		List<Menu> menus = menuService.findAll();

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

	//http://localhost:8888/menuQuery?id=8
	@RequestMapping("/menuQuery")
	@ResponseBody
	public Object menuQuery(@RequestParam Integer id) {

		Menu menu = menuService.findById(id);
		return menu;
	}
	
	//复杂的查询 分页查询  用到pagehelper
	//required = false 可以不传
	//http://localhost:8888/page?pageNumber=1&pageSize=1
	
	//SELECT count(0) FROM menu  先发count 计算页数
	@RequestMapping("/page")
	@ResponseBody
	public Object page(@RequestParam (required = false) Integer pageNumber,@RequestParam (required = false)Integer pageSize) {

		List<Menu> list = menuService.findByPage(pageNumber,pageSize);
		return list;
	}
}
