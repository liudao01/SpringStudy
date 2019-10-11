package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.Menu;
import com.example.demo.mapper.MenuExample;
import com.example.demo.mapper.MenuMapper;
@Service
public class MenuService {
	
	@Autowired
	MenuMapper menuMapper;

	public List<Menu> findAll() {
		
		//example 实际上就是一堆的复杂条件查询  生成里面已经有MenuExample 
		MenuExample menuExample = new MenuExample();
		
		//menuExample 如果没有条件就是查询所有
		//menuExample.createCriteria().andNameEqualTo("name1");
		
		/** 什么条件都不加 是下面的sql 语句
		 * ==>  Preparing: select * from account 
==> Parameters: 
<==      Total: 4
==>  Preparing: select id, `name`, roles, `index` from menu 
==> Parameters: 
<==      Total: 0
		 */
		
		//这是查找全部的语句
		return menuMapper.selectByExample(menuExample);
//		return null;
		
		
		
	}

	public void add() {
		Menu menu = new Menu();
//		menu.setId(0);
		menu.setName("首页");
		menu.setRoles("all");
		menu.setIndex("0");
		menuMapper.insert(menu);
	}
	
	public void findById(int id) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.setName("首页");
		menu.setRoles("all");
		menu.setIndex("0");
		menuMapper.insert(menu);
		
	}
	

}
