package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.LoginPage;


public class IndexPageTest extends TestBase{
	
	LoginPage loginPage;
	IndexPage indexPage;
	
	
	public IndexPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage=new IndexPage();
	}
	
	
	@Test(priority=1)
	public void indexPageTitleTest(){
		log.info("***************start of indexPageTitleTest******************");
		String actualPageTitle = indexPage.getIndexPageTitle();
		String expectedPageTitle="#1 Free CRM customer relationship management software cloud";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		log.info("***************end of indexPageTitleTest******************");
	}
	
	@Test(priority=2)
	public void clickOnLoginBtnTest(){
		log.info("***************start of clickOnLoginBtnTest******************");
		loginPage=indexPage.clickOnLoginBtn();
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://ui.freecrm.com/";
		Assert.assertEquals(actualUrl, expectedUrl);
		log.info("***************end of clickOnLoginBtnTest******************");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
