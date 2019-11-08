package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Permission;
import com.example.demo.mapper.PermissionExample;
import com.example.demo.mapper.PermissionMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PermissionService {

	@Autowired
	PermissionMapper pMapper;
	
	
	public PageInfo<Permission> findByPage(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum,pageSize);
		
		PermissionExample example = new PermissionExample();
		List<Permission> list = pMapper.selectByExample(example);
		
		return new PageInfo<>(list);
	}


	public Permission findByid(int id) {
		
//		PermissionExample example = new PermissionExample();
		Permission selectByPrimaryKey = pMapper.selectByPrimaryKey(id);
		
		return selectByPrimaryKey;
	}


	/**
	 * 更新用户
	 * @param permission
	 */
	public void update(Permission permission) {
		PermissionExample example = new PermissionExample();
		// TODO Auto-generated method stub
//		pMapper.updateByExample(permission, example );  有外键 不能使用byExample
//		pMapper.updateByPrimaryKey(permission);
		pMapper.updateByPrimaryKeySelective(permission);
	}

}
