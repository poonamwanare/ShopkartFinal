package com.shopcart.catlog.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class ManufacturersPage extends TestBase{

	public ManufacturersPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="icon-AdminCatalog")
	WebElement catlogmenu;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminManufacturers\"]/a")
	WebElement manufacturerssubmenu;
	
	@FindBy(xpath="//*[@id=\"form-manufacturer\"]/div/div[2]/table/tbody/tr/td[7]/div/div/a")
	WebElement viewbtn;
	
	@FindBy(xpath="//a[contains(text(),'Blouse')]")
	WebElement blouselink;
	
	@FindBy(xpath="//*[@id=\"page-header-desc-product-preview\"]/i")
	WebElement previewbtn;
	
	public void movetoSubMenuManufacturers()
	{
		Actions action = new Actions(driver);
		action.moveToElement(catlogmenu).build().perform();
		manufacturerssubmenu.click();
	}
	
	public void viewFashionManufacturer()
	{
		viewbtn.click();
	}
	
	public void blouseLink()
	{
		blouselink.click();
	}
	
	public PreviewPage previewButton() throws FileNotFoundException
	{
		previewbtn.click();
	
			return new PreviewPage();
		
		
	}

}
