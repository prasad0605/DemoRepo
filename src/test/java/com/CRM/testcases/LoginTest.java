package com.CRM.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.base.basetest;
import com.CRM.pages.HomePage;
import com.CRM.pages.LoginPage;

public class LoginTest extends basetest{
	LoginPage page;
	HomePage homepage;
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		page=new LoginPage();
	}
	
	@Test
	public void pagetitleTest(){
		String title=page.verifypagetitle();
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test
	public void CRMlogoTest(){
		boolean b=page.verifyCRMlogo();
		Assert.assertTrue(b);
	}
	
	@Test
	public void CRMlogin() throws InterruptedException{
		homepage=page.login();
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
