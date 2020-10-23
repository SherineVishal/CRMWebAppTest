package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


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
		
		log.info("***************start of createNewContactTest******************");
		contactsInfoPage=addNewContactsPage.addNewContact(firstName, lastName, company);
		String actualHeader=contactsInfoPage.getUIHeader(firstName, lastName).getText();
		String expectedHeader=firstName + " " + lastName;
		Assert.assertEquals(actualHeader, expectedHeader);
		log.info("***************end of createNewContactTest******************");
	}	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
