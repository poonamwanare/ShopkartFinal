package com.shopcart.dashboard.testcases;

import java.io.FileNotFoundException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.dashboard.pages.PrestaShopPage;
import com.shopcart.login.LoginPage;

public class DashboardPageTest extends TestBase{

	public DashboardPageTest() throws Exception {
		super();
	}
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	PrestaShopPage prestashoppage;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		try {
			loginpage = new LoginPage();
			dashboardpage = new DashboardPage();
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
			prestashoppage = new PrestaShopPage();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void dashboardPageTitleandLabelTest() throws FileNotFoundException
	{
		String title = dashboardpage.getDashboardPageTitle();
		Assert.assertEquals(title, "SHOPCART > Administration panel (PrestaShop™)");
		System.out.println(title);
		System.out.println("Successfully checked Dashboard Page title");
		String label = dashboardpage.getDashboardPageLabel();
		Assert.assertEquals(label, "Dashboard");
		System.out.println(label);
		System.out.println("We are successfully reached on Dashboard Page");
		dashboardpage.clickDemomodeBtn();
		System.out.println("Demo mode successfully off");
	}
	
	@Test(priority=2)
	public void dateSelectionTest()
	{
		//click on date selection button
		dashboardpage.clickDateSelectButton();
		System.out.println("successfully open date table");
		
		//double click on From date slection tab to select year
		dashboardpage.doubleClickOnFromYearMonth();
		System.out.println("successfully double click on selected element");
		
		//click on prev button to select require year
		//dashboardpage.clickOnPreviousArrow();
		//System.out.println("successfully click on Pre Arrow");
		
		//select from year
		dashboardpage.selectFromYear();
		System.out.println("successfully Select From Year");
		
		//select from month
		dashboardpage.selectFromMonth();
		System.out.println("successfully Select From Month");
		
		//select from date
		dashboardpage.selectFromDate();
		System.out.println("successfully select From date");
		
		//double click on From date slection tab to select year
		dashboardpage.doubleClickOnToYearMonth();
		System.out.println("successfully double click on selected element");
				
		//select to year
		dashboardpage.selectToYear();
		System.out.println("successfully Select To Year");
		
		//select to month
		dashboardpage.selectToMonth();
		System.out.println("successfully Select To Month");
		
		//select to date
		dashboardpage.selectToDate();
		System.out.println("successfully Select To Date");
		
		//Click on Apply Button
		dashboardpage.clickOnApplyButton();
		System.out.println("Successfully Clicked on Apply Button");
		
	}
	
	@Test
	public void connectToPrestashopButton() throws Exception
	{
		dashboardpage.clickOnConnectToPSMarketplaceButton();
		prestashoppage = dashboardpage.clickOnPrestshopAddonLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	

}
