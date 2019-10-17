package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.Menu;
import com.example.demo.mapper.MenuExample;
import com.example.demo.mapper.MenuMapper;
import com.github.pagehelper.PageHelper;
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
	
	public Menu findById(int id) {
		// TODO Auto-generated method stub
		
		MenuExample example = new MenuExample();
		
		example.createCriteria().andIdEqualTo(id);
//		List<Menu> list  = menuMapper.selectByExample(example);
		
//		return list.size()==1?list.get(0):null;
		
		//使用第二种方式
		Menu menu = menuMapper.selectByPrimaryKey(id);
		return menu;
	}

	
	/**
	 * 分页查询
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Menu> findByPage(Integer pageNumber, Integer pageSize) {
		
		PageHelper.startPage(pageNumber,pageSize);
		//example 实际上就是一堆的复杂条件查询  生成里面已经有MenuExample 
		MenuExample menuExample = new MenuExample();
		//AOP 面向切面编程 分页.  增强了sql 语句
		return menuMapper.selectByExample(menuExample);
	}
	

}
