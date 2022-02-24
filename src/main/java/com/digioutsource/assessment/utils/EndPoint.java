package com.absa.assessment.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class EndPoint {

	private static Logger log = LogManager.getLogger(EndPoint.class.getName());
	public static final String URL = "https://v6.exchangerate-api.com/v6/1fc80820c72b0163bc9c7536/latest/USD";

	public static String getEndPoint(){
		log.info("Base URI : " + URL);
		return URL;
	}

	public static String getEndPoint(String resource){
		log.info("URI End Point : " + URL + resource);
		return URL + resource;
	}
}
