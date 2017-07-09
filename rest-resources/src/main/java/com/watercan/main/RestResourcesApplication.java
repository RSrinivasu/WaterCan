package com.watercan.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.water"})
public class RestResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestResourcesApplication.class, args);
	}
}
