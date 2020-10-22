package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class IndexPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(xpath="//span[text()='Log In']")
		WebElement loginBtn;
		
		//Initializing the Page Objects:
		public IndexPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String getIndexPageTitle(){
			return driver.getTitle();
		}
		
		public LoginPage clickOnLoginBtn(){
			loginBtn.click();
			return new LoginPage();
		}

}
