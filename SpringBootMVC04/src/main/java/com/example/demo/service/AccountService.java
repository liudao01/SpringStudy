package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.Account;
import com.example.demo.mapper.AccountMapper;

@Service
public class AccountService {

	@Autowired
	AccountMapper accountMapper;
	
	public List<Account> findAll() {
		return accountMapper.findAll();

	}

}
