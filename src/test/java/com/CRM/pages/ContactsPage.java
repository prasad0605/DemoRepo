package com.CRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRM.base.basetest;

public class ContactsPage extends basetest{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactspage;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontact;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement title1;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement surname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement client_lookup;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnsubmit;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public boolean verifyContactpagelabel(){
		return contactspage.isDisplayed();
	}
	
	public void selectcontactName(String name){
		//driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//preceding-sibling::input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createnewcontact(String strtitle,String strfirstname,String strlastname,String strcompany){
		newcontact.click();
		Select s=new Select(title1);
		s.selectByVisibleText(strtitle);
		firstname.sendKeys(strfirstname);
		surname.sendKeys(strlastname);
		client_lookup.sendKeys(strcompany);
		btnsubmit.click();
	}
}
