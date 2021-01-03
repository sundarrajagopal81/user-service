package com.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		System.out.println("*** User Service App *** 01/03/2021");
		SpringApplication.run(UserApplication.class, args);
	}

}
