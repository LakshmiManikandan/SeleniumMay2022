package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferFunds {
	
	@FindBy (id ="tf_fromAccountId")
	private WebElement fromAcc;
	
	@FindBy (id ="tf_toAccountId")
	private WebElement toAcc;
	
	@FindBy (id="tf_amount")
	private WebElement amount;
	
	@FindBy (id ="tf_description")
	private WebElement description;
	
	@FindBy (id ="btn_submit")
	private WebElement continueBtn;
	
	public TransferFunds(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void doFundTransfer(String amt, String desc) {
		Select fromAccDD = new Select(fromAcc);
		fromAccDD.selectByIndex(2);
		Select toAccDD = new Select(toAcc);
		toAccDD.selectByIndex(3);
		amount.sendKeys(amt);
		description.sendKeys(desc);
		continueBtn.click();
	}
}
