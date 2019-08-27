package com.shopcart.catlog.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class ProductsPage extends TestBase{

	public ProductsPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="icon-AdminCatalog")
	WebElement catlogmenu;
	
	@FindBy(id="subtab-AdminProducts")
	WebElement productsubmenu;
	
	@FindBy(className="process-icon-new")
	WebElement addnewproductbtn;
	
	@FindBy(className="page-title")
	WebElement addnewpagelabel;
	
	@FindBy(xpath="//*[@id=\"product-informations\"]/h3")
	WebElement addnewpagesublabel;
	
	@FindBy(id="name_1")
	WebElement writeproductname;
	
	@FindBy(xpath="//*[@id=\"tinymce\"]")
	WebElement writeproductshortdescribtion;
	
	@FindBy(xpath="//*[@id=\"tinymce\"]")
	WebElement writeproductdescribtion;
	
	
	
	public void movetoSubMenuProducts()
	{
		Actions action = new Actions(driver);
		action.moveToElement(catlogmenu).build().perform();
		productsubmenu.click();
	}
	
	public void clickonAddNewProductButton()
	{
		addnewproductbtn.click();
	}
	
	public String checkANPLabels()
	{
		return addnewpagelabel.getText();
	}
	
	public String checkANPSubLabel()
	{
		return addnewpagesublabel.getText();
	}

	public void writeProductname()
	{
		writeproductname.sendKeys("Jollify Women's Rayon Crepe Red Top");
	}
	
	public void scrollWindowDown() throws InterruptedException
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
	}
	
	public void writeProductsShortDescription()
	{
		writeproductshortdescribtion.sendKeys("Shop This Must-Have Versatile Top From "
				+ "Jollify.Wear It With A Pair Of Jeans And Sneakers For A Day Out Or "
				+ "With A Tailored Skirt And Nude Heels For The Much Awaited Party Night.");
	}
	
	public void writeProductsDescription()
	{
		writeproductshortdescribtion.sendKeys("Item part number: N-KtiptopRed\r\n" + 
				"ASIN: B071V6WCTR\r\n" + 
				"Date first available at Amazon.in: 25 April 2017\r\n" + 
				"Average Customer Review: 3.6 out of 5 stars   36 customer reviews\r\n" + 
				"Amazon Bestsellers Rank: #51,053 in Clothing & Accessories (See Top 100 in Clothing & Accessories)\r\n" + 
				"#1719 in Women's Tops\r\n" + 
				"Would you like to tell us about a lower price?");
	}
}
