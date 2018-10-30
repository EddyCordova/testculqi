package com.culqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.culqi"})
public class ApiTestCulqiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestCulqiApplication.class, args);
	}
}
