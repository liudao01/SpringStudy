package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleExample;
import com.example.demo.mapper.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public PageInfo<Role> findByPage(int pageNum, int pageSize) {
//		System.out.println("roleMapper findByPage");
        PageHelper.startPage(pageNum, pageSize);
        RoleExample roleExample = new RoleExample();
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return new PageInfo<>(roles);
    }


    public Role findById(Integer id) {
//        RoleExample roleExample = new RoleExample();
//        Role role = roleMapper.selectByPrimaryKey(id);
        return roleMapper.findById(id);
    }

    public void addPermission(int id, int[] permissions) {
        System.out.println("id = " + id);
//        for (int p : permissions) {
//            System.out.println("permission[" + id + "] = " + permissions);
//            roleMapper.addPermission(id, p);
//        }

		roleMapper.addPermissions(id, permissions);
    }
}
