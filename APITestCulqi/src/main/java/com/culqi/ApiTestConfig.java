package com.culqi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.culqi.service.CulqiService;
import com.culqi.service.impl.CulqiServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.culqi"})
public class ApiTestConfig {
	
	@Bean
	public CulqiService culqiService() {
		return new CulqiServiceImpl();
	}
}
