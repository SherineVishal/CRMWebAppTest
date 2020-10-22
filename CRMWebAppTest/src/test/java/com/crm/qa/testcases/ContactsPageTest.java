package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddNewContactsPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	AddNewContactsPage addNewContactsPage;
		  
	public ContactsPageTest(){
			super();
			
	}	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnLoginBtn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void clickOnNewBtnTest(){
		addNewContactsPage=contactsPage.clickOnNewContacts();
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://ui.freecrm.com/contacts/new";
		Assert.assertEquals(actualUrl, expectedUrl);

	}	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
