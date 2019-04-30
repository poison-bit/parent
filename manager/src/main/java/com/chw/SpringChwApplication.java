package com.chw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//MapperScan,替换在每个mapper上添加@mapper注解
@MapperScan("com.chw.dao.mapper")
//@SpringBootApplication自带的ComponentScan扫描不到service下，所以需要手动配置
@ComponentScan(basePackages={"com.chw"})
/*@ComponentScan(basePackages={"org.quartz"})*/
//当前项目是把SpringBoot放在所有项目都有的公用目录(com.chw)之下,所以不需要配置@ComponentScan
public class SpringChwApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringChwApplication.class);
	}
}