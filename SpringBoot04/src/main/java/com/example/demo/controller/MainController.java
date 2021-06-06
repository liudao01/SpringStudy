package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;

/**
 * 在我们访问 http://主机名：端口号/context-path/Controller的URI/方法的URI
 * http://localhost:8089/boot/user/list
 * http://localhost:8089/boot/list
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
 */
@Controller
public class MainController {

	@Autowired
	CityService cityService;
	
	
	@RequestMapping("/list")
	public String list(Model map) {
		List<City> list = cityService.findAll();
		map.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/add")
	public String add(@ModelAttribute City city,Model map) {
		
		String success = cityService.add(city);
		map.addAttribute("success",city);
		return "add";
	}
	

	
	@RequestMapping("/addPage")
	public String addPage() {
		return "add";
	}
}








