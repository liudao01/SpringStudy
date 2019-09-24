package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * 这里只是接口   
 * @author liumaolin
 * ibatis   现有的ibatis
 * mybatis mybatis是基于ibatis
 * mybatis plus  是 mybatis 的增强  国人开发的框架
 * 
 *  mapper  是映射.
 */
//@Mapper
//把这里mapper注解注释掉 那么 需要在applaction里面扫码这个类
public interface AccountMapper {

	@Select("select * from account")
	List<Account> findAll();
	
	
	void add(Account account);

}
