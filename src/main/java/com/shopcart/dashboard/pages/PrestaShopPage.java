package com.shopcart.dashboard.pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shopcart.base.TestBase;

public class PrestaShopPage extends TestBase{

	public PrestaShopPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"onesignal-popover-allow-button\"]")
	WebElement clickonpopupbtn;
	
	@FindBy(className=".//*[@id='cookie']/p[2]/a[2]")
	WebElement clickokbtn;
	
	
	public void clickOnPopupButton() throws InterruptedException
	{	
		//WebDriverWait wait = new WebDriverWait (driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"onesignal-popover-allow-button\\\"]"))).click();
		clickonpopupbtn.click();
	}
	
	public void clickOkButton()
	{
		//clickokbtn.click();
	}
	

}
