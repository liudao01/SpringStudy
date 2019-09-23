package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


/**
 * 这里只是接口   
 * @author liumaolin
 * ibatis   现有的ibatis
 * mybatis mybatis是基于ibatis
 * mybatis plus  是 mybatis 的增强  国人开发的框架
 * 
 *  mapper  是映射.
 */
@Mapper
public interface AccountMapper {

	List<Account> findAll();
	
	

}
