package com.shopcart.catlog.pages;

import java.io.FileNotFoundException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopcart.base.TestBase;

public class PreviewPage extends TestBase{

	public PreviewPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addtocartbtn;
	
	public void handlingNewTab() throws InterruptedException
	{
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
				
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		System.out.println("The title of the main window : "+driver.getTitle());
	}
	
	public void selectSizeofBlouse()
	{
		Select mediumsize = new Select(driver.findElement(By.xpath("//*[@id=\"attributes\"]/fieldset[1]")));
		mediumsize.selectByVisibleText("M");
	}
	
	public void addTOCartButton()
	{
		addtocartbtn.click();
	}
	

}
