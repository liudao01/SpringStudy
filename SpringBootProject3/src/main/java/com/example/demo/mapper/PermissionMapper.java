package com.example.demo.mapper;

import com.example.demo.entity.Permission;

import org.springframework.stereotype.Repository;

/**
 * PermissionMapper继承基类
 */
@Repository
public interface PermissionMapper extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
}