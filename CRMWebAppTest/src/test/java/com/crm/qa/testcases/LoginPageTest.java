package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		indexPage = new IndexPage();	
		loginPage=indexPage.clickOnLoginBtn();
	}
	
	@Test(priority=1)
	public void loginTest(){
		log.info("***************start of loginTest******************");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://ui.freecrm.com/";
		Assert.assertEquals(actualUrl, expectedUrl);
		log.info("***************end of loginTest******************");
	}	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
