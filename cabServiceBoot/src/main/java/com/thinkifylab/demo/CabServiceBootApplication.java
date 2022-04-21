package com.thinkifylab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.thinkifylab.demo","com.thinkifylab.demo.entity"})
public class CabServiceBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabServiceBootApplication.class, args);
	}

}
