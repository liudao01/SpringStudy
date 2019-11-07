package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 用户权限处理
 * 
 * @author liumaolin
 *
 */
@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {//registerUser

	// 不需要登录的url
	private final String[] IGNORE_URL = { "/index", "/css/", "/js/", "/account/login","/account/registerUser",
			"/account/register","/account/validataAccount" ,"/images"};

	// 登录页 首页 不需要过权限管理系统
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse respons = (HttpServletResponse) resp;

		String uri = request.getRequestURI();
//		System.out.println("------dofilter------------" + uri);
		//判断当前访问的uri是不是在ignore里面  当前访问的uri 是否在ignore
		boolean pass = canPassIgnore(uri);
//		System.out.println("pass = "+pass);
		if (pass) {
			//在里面的话放行
			chain.doFilter(request, respons);
			return;
		} 
			//是否已登录 从session 里面找account
		Object account = request.getSession().getAttribute("account");
//		System.out.println("session  account = "+account);
		if(account == null) {
			//没登录 跳转登录页面
			respons.sendRedirect("/account/login");
			return;
		}

		//继续向下走
		chain.doFilter(req, resp);

		// 1. 从session 里面找account
		// 1.1. 找到放行
		// 1.2. 找不到 没登录
		// 1.3. 当前访问的uri 是否在ignore
		// 1.3.1 不在ignore 跳转登录页面
		// 1.3.2 在的话放行

		// 1. 判断当前访问的Uri 是不是不需要登录的uri 在不在忽略的列表里


	}

	
	private boolean canPassIgnore(String uri) {

		// uri 包含 斜杠

		// 判断访问uri 起始部分 是否包含 ignire 里面的配置
		// 目的让下级目录资源也能访问
		for (String val : IGNORE_URL) {
//			System.out.println("uri = "+uri);
//			System.out.println("val = "+val);
			if (uri.startsWith(val)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 加载filter 启动之前需要的资源
		System.out.println("启动之前需要的资源==========FilterConfig init =======");
		Filter.super.init(filterConfig);
	}

}
