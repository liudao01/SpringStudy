package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CityDao;
import com.example.demo.domain.City;

@Service
public class CityService {

	@Autowired
	CityDao cityDao;

	public List<City> findAll() {
		return cityDao.findAll();
	}

	public String add(Integer id, String name) {
		City city = new City();
		city.setId(id);
		city.setName(name);
		try {
			cityDao.save(city);

			return "保存成功";
		} catch (Exception e) {
			// TODO: handle exception
			return "保存失败";
		}
	}

	public String add(City city) {

		try {
			cityDao.save(city);
			return "保存成功";
		} catch (Exception e) {
			// TODO: handle exception
			return "保存失败";
		}
	}
}
