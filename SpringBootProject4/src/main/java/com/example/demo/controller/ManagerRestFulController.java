package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;

/**
 * 只和用户交换数据json
 *
 * @author liumaolin
 */
@RestController
@RequestMapping("api/v1/manager/permission")
public class ManagerRestFulController {


    @Autowired
    PermissionService permissSrv;

    @RequestMapping("/add")
    public RespStat add(@RequestBody Permission permission) {
        System.out.println("permission = " + permission);
        if (permission.getId() == null) {

            permissSrv.add(permission);
        } else {
			permissSrv.update(permission);
        }
        return RespStat.build(200);
    }

    @RequestMapping("/update")
    public RespStat update(@RequestBody Permission permission) {
        System.out.println("permission = " + permission);
        permissSrv.update(permission);
        return RespStat.build(200);
    }

}
