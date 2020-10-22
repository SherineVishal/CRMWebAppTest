package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//button[text()='New']")
	WebElement newBtn;
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public AddNewContactsPage clickOnNewContacts(){
		
		newBtn.click();
		return new AddNewContactsPage();
		
	}	
}
