package com.CRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.base.basetest;

public class HomePage extends basetest {
	
	//Page Factory-OR
	@FindBy(xpath="//td[contains(text(),'User: Prasad Neeli')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement takslink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyHomePagetitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUsernamelabel(){
		return usernamelabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactslink(){
		contactslink.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTaskslink(){
		takslink.click();
		return new TasksPage();
	}
	
	public DealsPage clickOnDealslink(){
		dealslink.click();
		return new DealsPage();
	}
	
	public void clickonNewContact(){
		Actions a=new Actions(driver);
		a.moveToElement(contactslink).build().perform();
	}
	
}
