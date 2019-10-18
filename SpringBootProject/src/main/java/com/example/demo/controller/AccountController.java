package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户账号相关操作
 * @author liumaolin
 *
 */
@Controller
@RequestMapping("/account")
public class AccountController {

	@RequestMapping("login")
	public String login() {
		return "account/login";
	}
	
}
