package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot04Application {

	/**
	 * 运行这个项目 必须先在本地安装数据库 并且创建数据库 application.properties 配置文件里面设置的
	 * 数据库名称. 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04Application.class, args);
	}

}
