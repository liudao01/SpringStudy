package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Permission;

/**
 * PermissionMapper继承基类
 */
@Repository
public interface PermissionMapper extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
}