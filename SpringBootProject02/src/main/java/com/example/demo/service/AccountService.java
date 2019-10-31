package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountExample;
import com.example.demo.mapper.AccountMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AccountService {

	@Autowired
	AccountMapper accMapper;

	public Account findByLoginAndPassword(String loginName, String password) {

		AccountExample example = new AccountExample();
		example.createCriteria().andLoginNameEqualTo(loginName).andPasswordEqualTo(password);
		// 判断查找出来的
		// 1.没有
		// 2. 有一条
		// 3. 好几条
		List<Account> list = accMapper.selectByExample(example);
		return list.size() == 0 ? null : list.get(0);
	}

	public PageInfo<Account> findByPage(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		AccountExample example = new AccountExample();
		List<Account> list = accMapper.selectByExample(example);
		PageInfo page= new PageInfo<>(list,5);//5显示导航有多少页码
		return page; 
	}

}














