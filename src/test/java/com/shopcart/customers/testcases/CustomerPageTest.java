package com.shopcart.customers.testcases;

import java.io.FileNotFoundException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.customers.pages.CustomersPage;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.dashboard.pages.PrestaShopPage;
import com.shopcart.login.LoginPage;
import com.shopcart.util.TestUtil;

public class CustomerPageTest extends TestBase{
	public CustomerPageTest() throws FileNotFoundException {
		super();
	}

	LoginPage loginpage;
	DashboardPage dashboardpage;
	PrestaShopPage prestashoppage;
	CustomersPage customerspage;
	
	String sheetName = "NewCustomer";
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		try {
			loginpage = new LoginPage();
			prestashoppage = new PrestaShopPage();
			customerspage = new CustomersPage();
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
			customerspage.movetoSubMenuCustomer();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void gettitleTest()
	{
		String title = customerspage.getCustomersPageTitle();
		Assert.assertEquals(title, "Manage your Customers • SHOPCART");
		System.out.println(title);
		System.out.println("Successfully checked Customers Page title");
		String label = customerspage.getCustomersPageLabel();
		Assert.assertEquals(label, "Manage your Customers");
		System.out.println(label);
		System.out.println("We are successfully reached on Customers Page");
	}
	
	@Test(priority=2)
	public void clickOnNewCustomerBtnTest()
	{
		customerspage.clickAddNewCustomerButton();
		System.out.println("Successfully clicked on add new customer button");
	}
	
	@DataProvider
	public Object[][] getCustomerTestData() throws InvalidFormatException
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getCustomerTestData")
	public void addNewCustomerTest(String firstname,String lastname,String email,String password)
	{
		customerspage.clickAddNewCustomerButton();
		customerspage.createNewCustomer(firstname, lastname, email, password);
	}
	
	@Test(priority=4)
	public void searchCustomerByFirstnameTest()
	{
		customerspage.searchCustomerByFirstname();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
