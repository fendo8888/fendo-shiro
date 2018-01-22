package com.fendo.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FendoShiroApplication{


	public static void main(String[] args) {
			SpringApplication.run(FendoShiroApplication.class, args);
		}

}
