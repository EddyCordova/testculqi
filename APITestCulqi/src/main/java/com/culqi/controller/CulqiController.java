package com.culqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.culqi.bean.input.RequestBinList;
import com.culqi.bean.input.RequestGenerarToken;
import com.culqi.bean.output.ResponseGenerarToken;
import com.culqi.commons.Constants;
import com.culqi.service.CulqiService;

@RestController
@RequestMapping("/")
public class CulqiController {
	
	@Autowired
	private CulqiService culqiService;
	
	@RequestMapping(value = "/tokens", method = RequestMethod.POST, produces = Constants.TYPE_UTF)
	public ResponseGenerarToken generarToken(@RequestBody RequestGenerarToken req){
		ResponseGenerarToken responseGenerarToken = new ResponseGenerarToken();
		responseGenerarToken = culqiService.generarToken(req);
		return responseGenerarToken;
	}
}
