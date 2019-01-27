package com.CRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.base.basetest;
import com.CRM.pages.ContactsPage;
import com.CRM.pages.HomePage;
import com.CRM.pages.LoginPage;
import com.CRM.util.TestUtil;

public class ContactPageTest extends basetest {
	LoginPage loginpage;
	TestUtil testutil;
	HomePage homepage;
	ContactsPage contatspage;
	public ContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		testutil=new TestUtil();
		contatspage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login();
		testutil.SwitchtoFrame();
		contatspage=homepage.clickOnContactslink();
	}
	
	@Test
	public void verifyContactspagelabelTest(){
		boolean b=contatspage.verifyContactpagelabel();
		Assert.assertTrue(b);
	}
	
	@Test
	public void selectcontactTest(){
		contatspage.selectcontactName("narmda d");
	}
	
	@Test
	public void selectmultiplecontactsTest(){
		contatspage.selectcontactName("narmda d");
		contatspage.selectcontactName("pratyusha a");
	}
	/*@DataProvider
	public Object[][] getdata(){
		Object data[][]=testutil.getExceldata("Sheet1");
		return data;
	}
	
	@Test(dataProvider="getdata")
	public void validatecreatenewcontactTest(String title,String firstname,String lastname,String company) throws InterruptedException{
		homepage.clickonNewContact();
		contatspage.createnewcontact(title,firstname, lastname,company);
	}*/
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
