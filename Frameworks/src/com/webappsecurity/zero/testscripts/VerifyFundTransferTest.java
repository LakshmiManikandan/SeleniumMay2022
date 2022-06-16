package com.webappsecurity.zero.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.Home;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFunds;
import com.webappsecurity.zero.pages.TransferFundsConfirmation;
import com.webappsecurity.zero.pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base	 {


	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);			
		Home hp = new Home(driver);		
		TransferFunds  tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
		 
		String[][] data = GenericMethods.getData("C:\\Users\\senthilkumar\\Desktop\\QA training videos\\Selenium\\Docs\\TestData.xlsx","Sheet1");
		
		for(int i=1;i<data.length;i++) {
		lp.applicationLogin(data[i][0],data[i][1]);
		driver.navigate().back();
		hp.clickTransferFunds();
		tf.doFundTransfer(data[i][2], data[i][3]);		
		tfv.clickSubmit();		
		String actualText=tfc.verifyTextMsg();
		String expectedText = data[i][4];
		Assert.assertEquals(actualText, expectedText);		
		tfc.logoutFromApplication();
		}
	
	}
	
} 
