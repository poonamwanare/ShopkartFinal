package com.shopcart.catlog.testcases;

import java.io.FileNotFoundException;
import java.util.Set;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.catlog.pages.ManufacturersPage;
import com.shopcart.catlog.pages.PreviewPage;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.login.LoginPage;
import com.shopcart.util.EventListener;

@Listeners(EventListener.class)
public class ManufacturersPageTest extends TestBase{

	public ManufacturersPageTest() throws FileNotFoundException {
		super();
	}
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ManufacturersPage manufacturerspage;
	PreviewPage previewpage;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		try {
			loginpage = new LoginPage();
			manufacturerspage = new ManufacturersPage();
			previewpage = new PreviewPage();
			dashboardpage = loginpage.Username(prop.getProperty("username"), prop.getProperty("password"));
			manufacturerspage.movetoSubMenuManufacturers();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void viewManifacturerTest() throws FileNotFoundException, InterruptedException
	{
		manufacturerspage.viewFashionManufacturer();
		System.out.println("Clicked on View Button");
		manufacturerspage.blouseLink();
		System.out.println("Clicked on Blouse Link");
		previewpage = manufacturerspage.previewButton();
		System.out.println("Clicked on Preview Button");

		//previewpage.handlingNewTab();
		//System.out.println("Switched to new window");
		
		String parent = driver.getWindowHandle();
		System.out.println("The title of the main window : "+driver.getTitle());
		Set<String> windowIds = driver.getWindowHandles();
		int count = windowIds.size();
		System.out.println("Total windows: "+count);
		
		for(String child:windowIds)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				
				System.out.println("The title of the NEW window : "+driver.getTitle());
				Thread.sleep(2000);
				previewpage.selectSizeofBlouse(); System.out.println("Selected Size");
				Thread.sleep(2000);
				previewpage.addTOCartButton(); System.out.println("Product added to cart");
				
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		System.out.println("The title of the main window : "+driver.getTitle());
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
