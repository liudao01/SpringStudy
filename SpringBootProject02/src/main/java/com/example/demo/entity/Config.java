package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 系统配置相关
 * @author liumaolin
 *
 */
@Component
public class Config {
	//配置文件里面的key
	@Value(value = "${confit.systemName}")
	private String systemName;

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	

}
