package com.CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.base.basetest;

public class LoginPage extends basetest{
	
	//Page Factory-OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement btnlogin;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmlogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifypagetitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCRMlogo(){
		return crmlogo.isDisplayed();
	}
	
	public HomePage login() throws InterruptedException{
		username.sendKeys(properties.getProperty("username"));
		password.sendKeys(properties.getProperty("password"));
		Thread.sleep(5000);
		btnlogin.click();
		return new HomePage();
	}
	
}
