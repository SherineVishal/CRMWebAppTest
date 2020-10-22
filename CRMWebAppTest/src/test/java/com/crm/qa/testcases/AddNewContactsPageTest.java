package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AddNewContactsPage;
import com.crm.qa.pages.ContactsInfoPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class AddNewContactsPageTest extends TestBase{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	AddNewContactsPage addNewContactsPage;
	ContactsInfoPage contactsInfoPage;
	
	String sheetName = "contacts";
	
	   
	public AddNewContactsPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnLoginBtn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		addNewContactsPage = contactsPage.clickOnNewContacts();
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}	
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void createNewContactTest(String firstName, String lastName, String company){
		contactsInfoPage=addNewContactsPage.addNewContact(firstName, lastName, company);
		String actualHeader=contactsInfoPage.getUIHeader(firstName, lastName).getText();
		String expectedHeader=firstName + " " + lastName;
		Assert.assertEquals(actualHeader, expectedHeader);
	}	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
