package com.shopcart.customers.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class CustomersPage extends TestBase{

	public CustomersPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentCustomer\"]/a")
	WebElement customermenu;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminCustomers\"]/a")
	WebElement customersubmenu;
	
	@FindBy(xpath="//h2[contains(text(),'Manage your Customers')]")
	WebElement customerspagelabel;
	
	@FindBy(className="process-icon-new")
	WebElement addnewcustomer;
	
	
	@FindBy(id="gender_1")
	WebElement socialtitleMr;
	
	@FindBy(id="gender_2")
	WebElement socialtitleMrs;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;

	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="passwd")
	WebElement password;
	
	
	@FindBy(className="process-icon-save")
	WebElement savebutton;
	
	@FindBy(name="customerFilter_firstname")
	WebElement searchcustbyfirstname;
	
	@FindBy(id="submitFilterButtoncustomer")
	WebElement searchbtn;
	
	
	public void movetoSubMenuCustomer()
	{
		Actions action = new Actions(driver);
		action.moveToElement(customermenu).build().perform();
		customersubmenu.click();
	}
	
	public String getCustomersPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getCustomersPageLabel()
	{
		return customerspagelabel.getText();
	}
	
	public void clickAddNewCustomerButton()
	{
		addnewcustomer.click();
	}
	
	public void createNewCustomer(String fname,String lname,String emailid,String pwd)
	{
		
		socialtitleMr.click();
		//socialtitleMrs.click();
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		emailId.sendKeys(emailid);
		password.sendKeys(pwd);
		savebutton.click();
	}
	
	public void searchCustomerByFirstname()
	{
		searchcustbyfirstname.clear();
		searchcustbyfirstname.sendKeys("sam");
		searchbtn.click();
	}
	 

}
