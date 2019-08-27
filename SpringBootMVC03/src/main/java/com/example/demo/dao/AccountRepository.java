package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.City;
import com.example.demo.entity.Account;
/**
 *  持久层 做真实操作处理
 * @author liumaolin
 *
 */

public interface AccountRepository extends JpaRepository<Account,Integer>{
	//JpaRepository 用于简单排序的接口
	
	
}









