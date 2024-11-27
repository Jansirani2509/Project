package com.amazon.browsers;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.baseclass.BaseClass;

public class MultipleBrowsers extends BaseClass {
	@Parameters("browserName")
	@Test
	public void tc1(String browserName) throws Exception {

	switch (browserName) {
		case "chrome":
			chromebrowserLaunch();
			break;
		case "firefox":
			firefoxbrowserLaunch();
			break;
			
		case "edge":
			edgebrowserLaunch();
			break;
			
		default:
			throw new Exception("InvalidBrowser");
			
	}
	
	enterApplnUrl("https://www.amazon.in/");

	}
}
