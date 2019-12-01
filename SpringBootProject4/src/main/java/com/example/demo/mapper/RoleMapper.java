package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * RoleMapper继承基类
 */
@Repository
public interface RoleMapper extends MyBatisBaseDao<Role, Integer, RoleExample> {
    //    void addPermission(int id, int[] permissions);
    void addPermissions(int id, int[] permissions);

//    void addPermission(int id, int permission);
}