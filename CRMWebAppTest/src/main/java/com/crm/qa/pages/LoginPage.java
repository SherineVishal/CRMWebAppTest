package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//div[text()='Login']")
		WebElement loginBtn;
		
				
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
			
		public HomePage login(String usrname, String pwd){
			username.sendKeys(usrname);
			password.sendKeys(pwd);
			loginBtn.click();
			return new HomePage();
		}

}
