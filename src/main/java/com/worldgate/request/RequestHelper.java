package com.worldgate.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.worldgate.delegate.CucumberDelegate;

public class RequestHelper {
	
	private static CucumberDelegate cucumber = new CucumberDelegate();
	public static String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*Get request*/
		String requestHandled = request.getRequestURI().substring(request.getContextPath().length()+1);
		while(requestHandled.indexOf("/")>0) {
			requestHandled = requestHandled.substring(0, requestHandled.indexOf("/"));
		}
		
		//Changing between controllers
		switch(requestHandled) {
		case "runCucumber.do": 
			cucumber.runCucumber(request, response);
			break;
		default: 
			break;
		}
		return "404.html";
	}
}
