package com.shopcart.catlog.testcases;

import java.io.FileNotFoundException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.catlog.pages.CategoriesPage;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;

public class CategoriesPageTest extends TestBase{

	public CategoriesPageTest() throws FileNotFoundException {
		super();
	}
	LoginPage loginpage;
	DashboardPage dashboardpage;
	CategoriesPage categoriespage;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		try {
			loginpage = new LoginPage();
			categoriespage = new CategoriesPage();
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
			categoriespage.movetoSubMenuCategories();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void editCategoryTest()
	{
		categoriespage.editCategories();
		
		boolean topradiobtn = categoriespage.radioButtonEnabledorDisabled();
		System.out.println("Radio Button of Tops Enabled = true and Disabled "
				+ "= false: "+topradiobtn);
		
		categoriespage.collapseAllButton();
		
		categoriespage.changeFontInDescriptionFrame();	
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
}
