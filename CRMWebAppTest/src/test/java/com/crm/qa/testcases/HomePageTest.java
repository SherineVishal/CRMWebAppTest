package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnLoginBtn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyContactsLinkTest(){
		log.info("***************start of verifyContactsLinkTest******************");
		contactsPage = homePage.clickOnContactsLink();
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://ui.freecrm.com/contacts";
		Assert.assertEquals(actualUrl, expectedUrl);
		log.info("***************end of verifyContactsLinkTest******************");
	}	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
