package com.shopcart.dashboard.testcases;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopcart.base.TestBase;
import com.shopcart.dashboard.pages.DashboardPage;
import com.shopcart.dashboard.pages.PrestaShopPage;
import com.shopcart.login.LoginPage;

public class PrestShopPageTest extends TestBase{
	public PrestShopPageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
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
	
	@Test
	public void clickOnPopupButtonTest() throws Exception
	{
		dashboardpage.clickOnConnectToPSMarketplaceButton();
		prestashoppage = dashboardpage.clickOnPrestshopAddonLink();
		Thread.sleep(3000);
		prestashoppage.clickOkButton();
		prestashoppage.clickOnPopupButton();
	}

}
