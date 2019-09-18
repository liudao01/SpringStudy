package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.City;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

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

	// http://localhost:8080/
	@RequestMapping("/list")
	@ResponseBody
	public Object list(Model map) {
		//查找所有
//		List<Account> findAll = accountService.findAll();
		//自定义hql 查找id为1的数据
		Object account = accountService.findxxx();
		System.out.println("account "+account);
		return account;
		
	}

	/**
	 * @GetMapping 区分get post 同样的Url get 走这里
	 * @return
	 */
	@GetMapping("/register")
	public String register() {
		
		System.out.println("get register");
		return "register";
	}
	
	@RequestMapping("/findbyidbetten")
	@ResponseBody
	public Object findbyidbetten(Model map) {
		List<Account> findAll = accountService.findByIdBetween(1, 6);
		return findAll;
		
	}
	
	/**
	 * post 方法进入这里
	 * 
	 * @return
	 */
	@PostMapping("/register")
	public String registerP(HttpServletRequest request, Account account) {
		String loginNameString = (String)request.getParameter("loginName");
		System.out.println("loginName = "+loginNameString);
		System.out.println("post register");
		System.out.println("account = " + ToStringBuilder.reflectionToString(account));

		RespStat respStat = accountService.save(account);
		request.setAttribute("stat",respStat);
		System.out.println("stat = "+ToStringBuilder.reflectionToString(respStat));
		return "register";
	}

	@RequestMapping("/login")
	public String login() {

		return "login";
	}

}
