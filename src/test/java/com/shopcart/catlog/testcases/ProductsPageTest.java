package com.shopcart.catlog.testcases;

import java.io.FileNotFoundException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.catlog.pages.ProductsPage;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class ProductsPageTest extends TestBase{

	public ProductsPageTest() throws FileNotFoundException {
		super();
	}
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductsPage productspage;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		try {
			loginpage = new LoginPage();
			productspage = new ProductsPage();
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
			productspage.movetoSubMenuProducts();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void addNewProductTest() throws InterruptedException
	{
		productspage.clickonAddNewProductButton();
		System.out.println("successfully clicked on add new product button");
		
		String headingLabel = productspage.checkANPLabels();
		//System.out.println(headingLabel);
		System.out.println("We are reached on add new product page whose Label Name is :" +headingLabel);	
		
		String subLabel = productspage.checkANPSubLabel();
		//System.out.println(subLabel);
		System.out.println("We are on ANP Page's Information Frame whose Label Name is :" +subLabel);
	
		productspage.writeProductname();
	}
	
	@Test(priority=2, dependsOnMethods = "addNewProductTest")
	public void shortDescriptionTest() throws InterruptedException
	{
		
		productspage.scrollWindowDown();
		productspage.clickonAddNewProductButton();
		driver.switchTo().frame("description_short_1_ifr");
		productspage.writeProductsShortDescription();
	}
	
	@Test(priority=3, dependsOnMethods = "shortDescriptionTest")
	public void descriptionTest() throws InterruptedException
	{
		
		productspage.scrollWindowDown();
		productspage.clickonAddNewProductButton();
		driver.switchTo().frame("description_1_ifr");
		productspage.writeProductsDescription();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
