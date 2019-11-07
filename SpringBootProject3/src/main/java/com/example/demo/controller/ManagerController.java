package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.PermissionService;
import com.example.demo.service.RoleService;
import com.github.pagehelper.PageInfo;

/**
 * 用户账号相关操作
 * 
 * @author liumaolin
 *
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	AccountService accountService;

	@Autowired
	PermissionService peermissionService;
	
	@Autowired
	RoleService roleService;
	
	
	/**
	 * 账号列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("accountList")
	public String accountList(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, Model model) {

		PageInfo<Account> page = accountService.findByPage(pageNum, pageSize);

		model.addAttribute("page", page);
		return "manager/accountList";
	}

	@RequestMapping("permissionList")
	public String permissionList(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, Model model) {

		//PageInfo<Account> page = peermissionService.findByPage(pageNum, pageSize);
		PageInfo<Account> page = accountService.findByPage(pageNum, pageSize);

		model.addAttribute("page", page);
		return "manager/permissionList";
	}

	@RequestMapping("roleList")
	public String roleList(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "5") int pageSize, Model model) {

		//PageInfo<Account> page = roleService.findByPage(pageNum, pageSize);
		PageInfo<Account> page = accountService.findByPage(pageNum, pageSize);
		model.addAttribute("page", page);
		return "manager/accountList";
	}

}
