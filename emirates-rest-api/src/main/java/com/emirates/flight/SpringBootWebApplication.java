package com.emirates.flight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author divyang.patel
 * The Class SpringBootWebApplication which runs the Spring boot application
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.emirates.flight")
@EnableSwagger2 // auto generation of API docs
public class SpringBootWebApplication{
	
 	private static final Class<SpringBootWebApplication> applicationClass = SpringBootWebApplication.class;

 	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
}
