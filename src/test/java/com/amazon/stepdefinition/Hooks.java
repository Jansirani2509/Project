package com.amazon.stepdefinition;

import com.amazon.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks  extends BaseClass{

	@Before
	public void beforeExecution() {
		System.out.println("Before.............");
		//browserLaunch("CHROME");
		//enterApplnUrl("https://www.amazon.in/");
		//maximizeWindow();
		//implicitWait(20);
		

	}
	
	@After
	public void afterExecution(Scenario scneario) {
	System.out.println("After.............");
	scneario.attach(takeScreenshot(), "Image/png",scneario.getName());
	deleteCookies();
	closeWindow();

	}

}
