package com.chenbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务管理
@EnableTransactionManagement
public class SecurityRegisterLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityRegisterLoginApplication.class, args);
	}

}
