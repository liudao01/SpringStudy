package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Account;
import com.example.demo.entity.Config;
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
	
	@Autowired
	Config config;

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String login(Model model) {
		model.addAttribute("config",config);
		return "account/login";
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	@RequestMapping("register")
	public String register() {
		return "account/register";
	}

	/**
	 * 注册用户
	 * 
	 * @param loginName
	 * @param password
	 * @param nickName
	 * @param age
	 * @param location
	 * @return
	 */
	@RequestMapping("/registerUser")
	@ResponseBody
	public RespStat registerUser(String loginName, String password, String nickName, Integer age, String location) {

		System.out.println("注册用户 loginName " + loginName);
		// 标记是否删除成功 status
		RespStat respStat = accountService.reguster(loginName, password, nickName, age, location);
		return respStat;
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
			return "success";
		}

	}

	/**
	 * 登出
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logOut")
	public String logOut(HttpServletRequest request) {

		request.getSession().removeAttribute("account");
		return "index";
	}

	/**
	 * 用户列表
	 * 
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize,
			Model model) {

		PageInfo<Account> page = accountService.findByPage(pageNum, pageSize);

		model.addAttribute("page", page);
		return "account/list";
	}

	/**
	 * 根据id 删除用户 TODO 需要校验是否当前登录用户 如果是当前登录用户 不能删除
	 * 
	 * @return
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public RespStat deleteById(int id) {
		// 标记是否删除成功 status
		RespStat respStat = accountService.deleteById(id);
		return respStat;
	}

	@RequestMapping("/profile")
	public String profile() {

		try {
			File path = new File(ResourceUtils.getURL("classpath:").getPath());
			File upload = new File(path.getAbsolutePath(), "static/upload/");
			System.out.println(upload.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return "account/profile";
	}

	/**
	 * 文件上传 这是在jar包解开的情况下才可以 如果打成jar包 不能在包里面写文件.
	 * 
	 * 应该做一次资源映射
	 * 
	 * @param filename
	 * @param password
	 * @return
	 */
	@RequestMapping("/fileUploadController")
	@ResponseBody
	public String fileUpload(MultipartFile filename, String password) {
		System.out.println("password:" + password);
		System.out.println("file:" + filename.getOriginalFilename());
		try {

			//原始的位置  映射的   ResourceUtils.getURL("classpath:").getPath()
			System.out.println("ResourceUtils.getURL(\"classpath:\").getPath() = "
					+ ResourceUtils.getURL("classpath:").getPath());
			///Users/liumaolin/Downloads/project_study
			//暂时写死 本地的路径  需要加上 static/upload/ 
			File upload = new File(("/Users/liumaolin/Downloads/project_study"));
//			File path = new File(ResourceUtils.getURL("classpath:").getPath());
//			File upload = new File(path.getAbsolutePath(), "static/upload/");

			System.out.println("upload:" + upload);
			System.out.println("filename.getOriginalFilename() = "+filename.getOriginalFilename());

			filename.transferTo(new File(upload + "/" + filename.getOriginalFilename()));
			System.out.println("ok");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "profile";
	}

}
