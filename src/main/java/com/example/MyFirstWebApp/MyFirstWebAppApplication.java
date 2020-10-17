package com.example.MyFirstWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.MyFirstWebApp")
public class MyFirstWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstWebAppApplication.class, args);
	}

}
