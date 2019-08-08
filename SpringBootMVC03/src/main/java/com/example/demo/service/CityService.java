package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CityRepository;
import com.example.demo.domain.City;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepo;

	/**
	 * 找全部
	 * @return
	 */
	public List<City> findAll() {
		//JpaRepository 自带findAll
		List<City> findAll = cityRepo.findAll();
		return findAll;
	}
	
	
	/**
	 * 根据id 找到某一个
	 * @param id
	 * @return
	 */
	public City findOne(Integer id) {
		return cityRepo.getOne(id);
	}
	
	

}
