package com.CRM.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.base.basetest;
import com.CRM.pages.ContactsPage;
import com.CRM.pages.HomePage;
import com.CRM.pages.LoginPage;
import com.CRM.util.TestUtil;

public class HomePageTest extends basetest{
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	TestUtil testutil;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		testutil=new TestUtil();
		loginpage=new LoginPage();
		contactspage=new ContactsPage();
		homepage=loginpage.login();
	}
	
	@Test
	public void verifyHomePagetitleTest(){
		String title=homepage.verifyHomePagetitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test
	public void verifyUsernamelabelTest(){
		
		testutil.SwitchtoFrame();
		boolean b=homepage.verifyUsernamelabel();
		Assert.assertTrue(b);
	}
	
	@Test
	public void clickonContactlinkTest(){
		testutil.SwitchtoFrame();
		contactspage=homepage.clickOnContactslink();
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
