package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class ContactsInfoPage extends TestBase{
	
public WebElement getUIHeader(String firstName,String lastName){
		
		String UIHeader=firstName + " " + 	lastName;
		return driver.findElement(By.xpath("//div[text()='"+ UIHeader +"']"));
	}

}
