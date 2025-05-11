package com.zlh.hello_spring_boot_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author 70635
 */
@SpringBootApplication
@ConfigurationPropertiesScan("com.zlh.hello.property")
public class HelloSpringBootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootStarterApplication.class, args);
	}
}
