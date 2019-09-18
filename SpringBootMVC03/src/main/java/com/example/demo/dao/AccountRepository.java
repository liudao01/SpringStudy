package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.City;
import com.example.demo.entity.Account;
/**
 *  持久层 做真实操作处理
 * @author liumaolin
 *
 */

public interface AccountRepository extends JpaRepository<Account,Integer>{

	//自定义的方法
	List<Account> findByIdBetween(int min, int max);
	
	
	//或者根据用户名密码找到用哪个户
	
	Account findByLoginNameAndPassword(String loginName,String password);
	
	//自定义HQL HQL是Hibernate Query Language(Hibernate 查询语言)的缩写,提供更加丰富灵活、更为强大的查询能力;HQL更接近SQL语句查询语法。
	//面向表的查询 acc 是Account 的别名
	@Query("select acc from Account acc where acc.id=1")
	List<Account> findbyxx();
	//? 是占位符可以把某个id 传递进来
	@Query("select acc from Account acc where acc.id=?1")
	List<Account> findbyxx2(int id);
	//JpaRepository 用于简单排序的接口
	
	
}









