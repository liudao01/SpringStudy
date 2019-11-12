package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Role;

/**
 * RoleMapper继承基类
 */
@Repository
public interface RoleMapper extends MyBatisBaseDao<Role, Integer, RoleExample> {
}