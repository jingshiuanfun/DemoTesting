package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo",
		"com.example.demo.controller",
		"com.example.demo.service",
		"com.example.demo.service.implement"
		
})
@EntityScan("com.example.demo.pojo")
@EnableJpaRepositories("com.example.demo.reoisitory")
public class TestApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
