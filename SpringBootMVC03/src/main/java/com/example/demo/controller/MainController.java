package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;

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
 * 访问地址: http://localhost:8080/account/
 * 
 * 访问地址设置
 * server.servlet.context-path=/account
 */
@Controller
public class MainController {
	
	@Autowired
	CityService cityService;
	//http://localhost:8080/
	@RequestMapping("/list")
	public String list(Model map) {
		//返回的这个list 是templates 里面的list模板
		return "list";
	}
	
	/**
	 * @GetMapping 区分get post  同样的Url get 走这里
	 * @return
	 */
	@GetMapping("/register")
	public String register() {

		return "register";
	}
	
	/**
	 * post 方法进入这里
	 * @return
	 */
	@PostMapping("/register")
	public String registerP() {

		return "register";
	}
	
	@RequestMapping("/login")
	public String login() {

		return "login";
	}
	
	
	
	
	
	
	
}
