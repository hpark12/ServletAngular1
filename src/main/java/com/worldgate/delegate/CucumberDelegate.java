package com.worldgate.delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cucumber.api.cli.Main;

public class CucumberDelegate {

	public void runCucumber(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//		Main.main(new String[]{"-g", "trainerTab", "C:/revature/ServletAngular/src/test/resources/trainerTest.feature"});
//		Main.main(new String[]{"-g", "curriculaTab", "C:/revature/ServletAngular/src/test/resources/curriculaTest.feature"});
		Main.main(new String[]{"-g", "loginTab", "C:/revature/ServletAngular/src/test/resources/loginTest.feature"});
	}
}

