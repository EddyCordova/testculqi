package com.culqi.service;

import com.culqi.bean.input.RequestBinList;
import com.culqi.bean.input.RequestGenerarToken;
import com.culqi.bean.output.ResponseBinList;
import com.culqi.bean.output.ResponseGenerarToken;

public interface CulqiService {
	public ResponseGenerarToken generarToken(RequestGenerarToken requestGenerarToken);
	public ResponseBinList getBinListWS(RequestBinList requestBinList);
}
