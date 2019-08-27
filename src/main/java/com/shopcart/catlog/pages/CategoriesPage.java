package com.shopcart.catlog.pages;

import java.io.FileNotFoundException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class CategoriesPage extends TestBase{

	public CategoriesPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="icon-AdminCatalog")
	WebElement catlogmenu;
	
	@FindBy(xpath="//*[@id=\"subtab-AdminCategories\"]/a")
	WebElement categoriessubmenu;
	
	@FindBy(xpath="//*[@id=\"tr_2_3_0\"]/td[6]/div/div/button")
	WebElement viewdropdwntogglebtn;
	
	@FindBy(className="edit")
	WebElement clickeditbtn;
	
	@FindBy(id="expand-all-categories-tree")
	WebElement expandallbtn;
	
	@FindBy(xpath="//input[@name='id_parent' and @value='6']")
	WebElement topsradiobtn;
	
	@FindBy(id="collapse-all-categories-tree")
	WebElement collapseallbtn;
	
	@FindBy(xpath="//*[@id=\"mce_16\"]")
	WebElement clickonItallic;
	
	@FindBy(id="category_form_submit_btn")
	WebElement savebtn;
	
	
	public void movetoSubMenuCategories()
	{
		Actions action = new Actions(driver);
		action.moveToElement(catlogmenu).build().perform();
		categoriessubmenu.click();
	}
	
	public void editCategories()
	{
		viewdropdwntogglebtn.click();
		clickeditbtn.click();
		expandallbtn.click();
	}
	
	public boolean radioButtonEnabledorDisabled()
	{
		return topsradiobtn.isEnabled();
	}
	
	public void collapseAllButton()
	{
		collapseallbtn.click();
	}

	public void changeFontInDescriptionFrame()
	{
		//Switch mouse to frame
		driver.switchTo().frame("description_1_ifr");
		System.out.println("Switched to frame");
			 
		 WebElement ele = driver.findElement(By.xpath(".//*[@id='tinymce']/p[1]/strong"));
		 Actions dummy = new Actions(driver);
		 dummy.doubleClick(ele).build().perform();
		
		//clickonItallic.click();
		 //switch out off frame
		 driver.switchTo().defaultContent();
		 savebtn.click();
	}
}
