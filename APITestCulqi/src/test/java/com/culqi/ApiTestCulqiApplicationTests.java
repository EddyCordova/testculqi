package com.culqi;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.culqi.bean.input.RequestGenerarToken;
import com.culqi.bean.output.ResponseGenerarToken;
import com.culqi.controller.CulqiController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTestCulqiApplicationTests {

	private Logger logger = LoggerFactory.getLogger(ApiTestCulqiApplicationTests.class);
	
	@Autowired
	private CulqiController culqiController;
	
	@Test
	public void contextLoads() {
		RequestGenerarToken req = new RequestGenerarToken();
		req.setPan("4444333322221111");
		req.setExp_year("2020");
		req.setExp_month(10);
		
		ResponseGenerarToken response = culqiController.generarToken(req);
		assertNotNull(response);
		assertNotNull(response.getBrand());
		assertNotNull(response.getCreation_dt());
		assertNotNull(response.getToken());
		logger.info("Test - Brand:"+ response.getBrand());
		logger.info("Test - Creation:"+ response.getCreation_dt());
		logger.info("Test - Token:"+ response.getToken());
		
		
		
	}

}
