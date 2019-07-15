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

	public List<City> findAll() {
		//JpaRepository 自带findAll
		List<City> findAll = cityRepo.findAll();
		return findAll;
	}

}
