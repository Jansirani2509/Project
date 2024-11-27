package com.amazon.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.amazon.baseclass.BaseClass;
import com.amazon.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	


	@Given("User is on the amazon page")
	public void user_is_on_the_amazon_page() throws FileNotFoundException, IOException {
		browserLaunch(getPropertyFileValue("browser"));
		enterApplnUrl(getPropertyFileValue("url"));
		maximizeWindow();
		implicitWait();
	    
	}
	@When("User login {string},{string}")
	public void user_login(String emailId, String password) {
		pom.getLoginPage().login(emailId, password);
	    
	}
	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String expLoginErrorMsg) {
		String loginErrorMsgText = pom.getLoginPage().getLoginErrorMsgText();
		  boolean contains = loginErrorMsgText.contains(expLoginErrorMsg);
		  Assert.assertTrue("Verify aftet login error Msg", contains);
}




}
