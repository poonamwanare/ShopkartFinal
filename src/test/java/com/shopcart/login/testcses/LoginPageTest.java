package com.shopcart.login.testcses;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;
import com.shopcart.util.EventListener;

@Listeners(EventListener.class)
public class LoginPageTest extends TestBase{

	public LoginPageTest() throws FileNotFoundException {
		super();
	}
   LoginPage loginpage;
   DashboardPage dashboardpage;
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException
	{
		initialization();
		try {
			loginpage = new LoginPage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest() throws FileNotFoundException
	{
		dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login Successfully");
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
