package com.amazon.pageobjectmanager;

import com.amazon.page.LoginPage;

public class PageObjectManager {
	private LoginPage loginPage;
	
	public LoginPage getLoginPage() {
		return (loginPage==null) ? loginPage=new LoginPage() : loginPage ;
	}
}
