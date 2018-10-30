package com.culqi.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.culqi.ApiTestCulqiApplicationTests;
import com.culqi.bean.input.RequestBinList;
import com.culqi.bean.input.RequestGenerarToken;
import com.culqi.bean.output.ResponseBinList;
import com.culqi.bean.output.ResponseGenerarToken;
import com.culqi.commons.Constants;
import com.culqi.service.CulqiService;

public class CulqiServiceImpl implements CulqiService{
	
	private Logger logger = LoggerFactory.getLogger(CulqiServiceImpl.class);
	
	public ResponseGenerarToken generarToken(RequestGenerarToken requestGenerarToken) {
		logger.info("[CulqiServiceImpl - generarToken] Inicio");
		RequestBinList requestBinList = new RequestBinList();
		ResponseBinList responseBinList = new ResponseBinList();
		ResponseGenerarToken responseGenearToken = new ResponseGenerarToken();
		try {
			
			if(requestGenerarToken.getExp_month()==null) {
				throw new Exception("El campo exp_mont es nulo");
			}
			
			if(requestGenerarToken.getExp_year()==null) {
				throw new Exception("El campo  exp_yearno puede estar vacio");
			}else if(requestGenerarToken.getExp_year().isEmpty()) {
				throw new Exception("El campo  exp_yearno puede estar vacio");
			}
			
			if(requestGenerarToken.getPan()==null) {
				throw new Exception("El campo pan no puede estar vacio");
			}else if(requestGenerarToken.getPan().length()<12) {
				throw new Exception("Debe ingresar un pan correcto");
			}
			requestBinList.setBin(obtenerBin(requestGenerarToken.getPan()));
			responseBinList = this.getBinListWS(requestBinList);
			responseGenearToken.setBrand(responseBinList.getScheme());
			responseGenearToken.setCreation_dt(this.fechaCreacion());
			responseGenearToken.setToken(this.obtenerParamToken(requestGenerarToken));
			
		}catch (Exception e) {
			logger.error("[ERROR CulqiServiceImpl - generar token]"+e.getMessage());
		}
		logger.info("[CulqiServiceImpl - generarToken] Fin");
		return responseGenearToken;
	}
	
	public ResponseBinList getBinListWS(RequestBinList requestBinList) {
		logger.info("[CulqiServiceImpl - getBinListWS] Inicio");
		ResponseEntity<ResponseBinList> responseBinList= null;
		RestTemplate restTemplate;
		try {
			restTemplate = new RestTemplate();
			responseBinList = restTemplate.getForEntity(Constants.WS_BINLIST.concat(requestBinList.getBin()), ResponseBinList.class);
		}catch (Exception e) {
			logger.error("[ERROR CulqiServiceImpl - getBinListWS]"+e.getMessage());
		}
		logger.info("[CulqiServiceImpl - getBinListWS] Fin");
		return responseBinList.getBody();
	}
	
	public String obtenerBin(String pan) {
		String bin = "";
		try {
			if(!pan.isEmpty()) {
				bin = pan.substring(0, 6);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return bin;
	}
	
	private String obtenerParamToken(RequestGenerarToken requestGenerarToken) {
		String valorToken = "";
		try {
			valorToken = Constants.INI_TOKEN.concat(requestGenerarToken.getPan().concat(Constants.GUION)
					.concat(requestGenerarToken.getExp_year().concat(Constants.GUION)
							.concat(requestGenerarToken.getExp_month().toString())));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return valorToken;
	}
	
	private String fechaCreacion() {
		String diaActual = "";
		try {
			Date fecha = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
			diaActual = sdf.format(fecha);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return diaActual;
	}
}
