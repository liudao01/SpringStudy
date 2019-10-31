package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.github.pagehelper.PageInfo;

/**
 * 用户账号相关操作
 * 
 * @author liumaolin
 *
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login() {
		return "account/login";
	}

	/**
	 * 校验账户 数据校验
	 * 
	 * @return
	 */
	@RequestMapping("/validataAccount")
	@ResponseBody
	public String validataAccount(String loginName, String password, HttpServletRequest request) {
		System.out.print("loginname=" + loginName);

		System.out.print("password=" + password);
		// 1 直接返回是否登录成功的结果
		// 2. 返回Account 对象 若对象是空的 在controller 里做业务逻辑处理

		Account account = accountService.findByLoginAndPassword(loginName, password);

		if (account == null) {
			return "登录失败";
		} else {
			// 登录成功
			// 让service 返回对象 如果登录成功把用户对象 写到session里
			// 在不同controller 或者前端页面上都能使用当前Account对象
			request.getSession().setAttribute("account", account);
			;
			return "success";
		}

	}

	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request) {

		request.getSession().removeAttribute("account");
		return "index";
	}

	/**
	 * 用户列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize, Model model) {
		
		PageInfo<Account> page = accountService.findByPage(pageNum,pageSize);
		
		model.addAttribute("page",page);
		return "/account/list";
	}
	

	/**
	 * 用户列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public RespStat deleteById( int id) {
		//标记是否删除成功   status  
		RespStat respStat = accountService.deleteById(id);
		return respStat;
	}
}












