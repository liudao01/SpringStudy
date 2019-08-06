package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
 * 访问地址: http://localhost:8080/city/list
 */
@Controller
@RequestMapping("/city")
public class MainController {

	@Autowired
	CityService cityService;

	//http://localhost:8080/city/list
	@RequestMapping("/list")
	public String list(Model map) {
		
		List<City> list = cityService.findAll();
		map.addAttribute("list", list);
		//返回的这个list 是templates 里面的list模板
		return "list";
	}
	
	/**
	 * @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，两个都可以接收参数，
	 * 关键点不同的是@RequestParam 是从request里面拿取值，
	 * 而 @PathVariable 是从一个URI模板里面来填充
	 * @return
	 * 
	 * http://localhost:8080/city/list/1
	 */
	@RequestMapping("/list/{id}")
	public String getOne(@PathVariable("id") Integer id, Model model) {

		City city = cityService.findOne(id);
		model.addAttribute("city", city);
		System.out.println("city "+city.getName());
		//这里用到的view 是jsp 的
		return "list1";
		
	}
	
	
	
	
	
	
	
	
}
