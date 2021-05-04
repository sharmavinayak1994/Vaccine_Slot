package com.vinayak.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.vinayak.demo.*"})
@SpringBootApplication
public class VinayakSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinayakSpringApplication.class, args);
	}

}
