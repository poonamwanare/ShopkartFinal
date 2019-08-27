package com.shopcart.customers.testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.customers.pages.AddressesPage;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class AddressesPageTest extends TestBase{

	public AddressesPageTest() throws Exception {
		super();
	}

	LoginPage loginpage;
	AddressesPage addressespage;
	DashboardPage dashboardpage;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		try {
			loginpage = new LoginPage();
			addressespage = new AddressesPage();
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
			addressespage.movetoSubMenuAddresses();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void getaddresspagetitleTest()
	{
		String title = addressespage.getAddressesPageTitle();
		Assert.assertEquals(title, "Addresses • SHOPCART");
		System.out.println(title);
		System.out.println("Successfully checked Addressess Page title");
		String label = addressespage.getAddressesPageLabel();
		Assert.assertEquals(label, "Addresses");
		System.out.println(label);
		System.out.println("We are successfully reached on Addresses Page");
	}
	@Test(priority=2)
	public void editAdressTest()
	{
		addressespage.editAddress();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
