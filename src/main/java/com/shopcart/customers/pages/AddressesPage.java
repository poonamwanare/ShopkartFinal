package com.shopcart.customers.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class AddressesPage extends TestBase{

	public AddressesPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentCustomer\"]/a")
	WebElement customermenu;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminAddresses\"]/a")
	WebElement addressessubmenu;
	
	@FindBy(className="page-title")
	WebElement addressespagelabel;
	
	@FindBy(className="icon-pencil")
	WebElement editaddressbtn;
	
	@FindBy(id="alias")
	WebElement addressaliastextbox;
	
	@FindBy(id="address1")
	WebElement address1textbox;
	
	@FindBy(id="address2")
	WebElement address2textbox;
	
	@FindBy(className="process-icon-save")
	WebElement savebtn;
	

	public void movetoSubMenuAddresses()
	{
		Actions action = new Actions(driver);
		action.moveToElement(customermenu).build().perform();
		addressessubmenu.click();
	}
	
	public String getAddressesPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getAddressesPageLabel()
	{
		return addressespagelabel.getText();
	}
	
	public void editAddress()
	{
		editaddressbtn.click();
		addressaliastextbox.clear();
		addressaliastextbox.sendKeys("washington");
		address1textbox.clear();
		address1textbox.sendKeys("menge nagar");
		address2textbox.clear();
		address2textbox.sendKeys("ring road");
		savebtn.click();
	}
}
