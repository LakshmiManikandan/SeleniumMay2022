package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy (id="user_login")
	private WebElement userName;
	
	@FindBy (id ="user_password")
	private WebElement pass;
	
	@FindBy (name ="submit")
	private WebElement signIn;

	
	@FindBy (css = "#login_form > div.alert.alert-error")
	private WebElement errMsg;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void applicationLogin(String loginName, String loginPassword) {
		userName.sendKeys(loginName);
		pass.sendKeys(loginPassword);
		signIn.click();  	
	}
	public String getErrMsg() {
		String expectedErrMsg = errMsg.getText();
		return expectedErrMsg;
	}
}

