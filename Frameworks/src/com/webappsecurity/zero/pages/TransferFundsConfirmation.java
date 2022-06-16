package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {
	
	@FindBy (css ="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement textMsg;
	
	@FindBy (css = "#settingsBox > ul > li:nth-child(3) > a")
	private WebElement username;
	
	@FindBy (id = "logout_link")
	private WebElement logout;
	
	@FindBy (id = "signin_button")
	private WebElement signInBtn;
	
	
	public TransferFundsConfirmation(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	public String verifyTextMsg() {
	String expectedMsg =	textMsg.getText();
	return expectedMsg;
	
		
	}
	public void logoutFromApplication() {
		username.click();
		logout.click();
		signInBtn.click();
			
	}

}
