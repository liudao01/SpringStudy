package com.example.demo.controller.rest;

import com.example.demo.controller.RespStat;
import com.example.demo.service.RoleService;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色权限 只和用户交换数据json
 *
 * @author liumaolin
 */
@RestController
@RequestMapping("api/v1/manager/role/Permission")
public class RoleManagerRestFulController {

    @Autowired
    RoleService roleService;


    @RequestMapping("/add")
    public RespStat add(@RequestParam int[] permissions, @RequestParam int id) {
        System.out.println("/manager/role/Permission = " + ToStringBuilder.reflectionToString(permissions));
        //sql 语句
        //INSERT INTO role_permission (role_id_p,permission_id_p) VALUES ();
        roleService.addPermission(id, permissions);
        return RespStat.build(200);
    }


}
