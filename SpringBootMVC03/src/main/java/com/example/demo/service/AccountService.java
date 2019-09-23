package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.RespStat;
import com.example.demo.dao.AccountRepository;
import com.example.demo.domain.City;
import com.example.demo.entity.Account;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepo;

	/**
	 * 找全部
	 * @return
	 */
	public List<Account> findAll() {
		//JpaRepository 自带findAll
		List<Account> findAll = accountRepo.findAll();
		System.out.println(ToStringBuilder.reflectionToString(findAll));
		return findAll;
	}
	
	
	/**
	 * 根据id 找到某一个
	 * @param id
	 * @return
	 */
	public Optional<Account> findById(Integer id) {
		//接口自带方法
	
		
		return 	accountRepo.findById(id);
	}
	
	
	/**
	 * 找到id 在min 和max 之间的数据集合
	 * @param min
	 * @param max
	 * @return
	 */
	public List<Account> findByIdBetween(int min,int max) {
		//JpaRepository 自带findAllctionToString(findAll));
		//自定义方法
		return accountRepo.findByIdBetween(min,max);
	}


	/**
	 * 注册 保存用户
	 * @param account
	 * @return
	 */
	public RespStat save(Account account) {
		/**
		 * 返回实体类. id 带回来
		 */
		try {
			
			Account entity = accountRepo.save(account);
			
		} catch (Exception e) {
			return new RespStat(500,"发生错误",e.getMessage());
		}
		return RespStat.build(200);
	}
	
	public Object findxxx() {
//		List<Account> byxxxAccounts = accountRepo.findbyxx();
		List<Account> byxxxAccounts = accountRepo.findbyxx2(2);
		return  byxxxAccounts;
	}

	
	
	

}
