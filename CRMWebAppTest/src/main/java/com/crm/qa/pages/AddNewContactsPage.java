package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AddNewContactsPage extends TestBase {

	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input")
	WebElement company;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveBtn;	
	
	// Initializing the Page Objects:
	public AddNewContactsPage() {
		PageFactory.initElements(driver, this);
	}	
	
	public ContactsInfoPage addNewContact(String fName, String lName, String comp){
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		saveBtn.click();
		return new ContactsInfoPage();
	}
}
	