package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 之前是，直接在Mapper类上面添加注解@Mapper，这种方式要求每一个mapper类都需要添加此注解，麻烦。通过使用@MapperScan可以指定要扫描的Mapper类的包的路径,比如:
 * @SpringBootApplication
 * @MapperScan("com.lz.water.monitor.mapper")
 * @author liumaolin
 *
 */

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

}
