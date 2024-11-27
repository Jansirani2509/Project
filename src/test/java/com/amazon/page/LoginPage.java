package com.amazon.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	public  LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="ap_email")
	 private WebElement txtEmail;
	
	
	@FindBy(id="continue")
	private WebElement btnLogin;
	
	@FindBy(id="ap_password")
	 private WebElement txtPass;
	
	@FindBy(id="signInSubmit")
	 private WebElement btnSignin;
	
	@FindBy(xpath= "//span[@class='a-list-item']")
	private WebElement textLoginErrorMsg;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnSignin() {
		return btnSignin;
	}

	public WebElement getTextLoginErrorMsg() {
		return textLoginErrorMsg;
	}

	public void setTxtEmail(WebElement txtEmail) {
		this.txtEmail = txtEmail;
	}

	public void setBtnLogin(WebElement btnLogin) {
		this.btnLogin = btnLogin;
	}

	public void setTxtPass(WebElement txtPass) {
		this.txtPass = txtPass;
	}

	public void setBtnSignin(WebElement btnSignin) {
		this.btnSignin = btnSignin;
	}

	public void setTextLoginErrorMsg(WebElement textLoginErrorMsg) {
		this.textLoginErrorMsg = textLoginErrorMsg;
	}
	
public void login(String emailId,String password) {
		
		elementSendKeys(txtEmail, emailId);
		elementClick(btnLogin);
		elementSendKeys(txtPass, password);
		elementClick(btnSignin);
}

public String getLoginErrorMsgText() {
	String loginErrorMsg = elementGetText(textLoginErrorMsg);
	System.out.println(loginErrorMsg);
	return loginErrorMsg;
}
}
