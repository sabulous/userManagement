package com.sabulous.userManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserManagementApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(UserManagementApplication.class, args);
	}

}
