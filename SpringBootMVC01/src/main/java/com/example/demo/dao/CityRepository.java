package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.City;
/**
 *  持久层 做真实操作处理
 * @author liumaolin
 *
 */

public interface CityRepository extends JpaRepository<City,Integer>{
	//JpaRepository 用于简单排序的接口
	
	
}









