package com.shopcart.dashboard.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopcart.base.TestBase;

public class DashboardPage extends TestBase{
	
	public DashboardPage() throws FileNotFoundException {
		super();
		PageFactory.initElements(driver, this);	}

	@FindBy(className = "page-title")
	WebElement dashboardpagelabel;
	
	@FindBy(xpath="//*[@id=\"page-header-desc-configuration-switch_demo\"]")
	WebElement demomodebtnon;
	
	@FindBy(id = "datepicker-from-info")
	WebElement clickdateselectbtn;
	
	@FindBy(xpath="//*[@id=\"datepicker\"]/div/div/div/div[1]/div/div/div[3]/table/thead/tr/th[1]")
	WebElement prebtn;
	
	@FindBy(xpath="//button[@class='btn btn-default pull-right' and @type='submit']")
	WebElement clickapplybtn;
	
	@FindBy(xpath="//a[@class='btn btn-info' and @style='white-space: unset;']")
	WebElement connecttoprestamarketplace;
	
	@FindBy(xpath="//*[@id=\"modal_addons_connect\"]/div/div/div[1]/h4/a")
	WebElement clickprestashopaddons;
	
	
	
	public String getDashboardPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getDashboardPageLabel()
	{
		return dashboardpagelabel.getText();
	}
	
	public void clickDemomodeBtn()
	{
		demomodebtnon.click();
	}
	
	public void clickDateSelectButton()
	{
		clickdateselectbtn.click();
	}
	
	public void doubleClickOnFromYearMonth()
	{
		// double click on from date
		Actions action1 = new Actions(driver);
		WebElement year_month1 = driver.findElement(By.cssSelector("#datepicker > div > div > div > div:nth-child(1) > div > div > div.daterangepicker-days > table > thead > tr:nth-child(1) > th.month-switch"));
		action1.doubleClick(year_month1).build().perform();
	}
	
	public void doubleClickOnToYearMonth()
	{
		// double click on To date
		Actions action2 = new Actions(driver);
		WebElement year_month2 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/div/div/div/div[2]/div/div/div[1]/table/thead/tr[1]/th[2]"));
		action2.doubleClick(year_month2).build().perform();
	}
	
	public void clickOnPreviousArrow()
	{
		prebtn.click();
	}
	
	public void selectFromYear()
	{
		String fromyear = "2010";
				
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[1]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[2]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[3]
		
		String beforexpath = "//*[@id=\"datepicker\"]/div/div/div/div[1]/div/div/div[3]/table/tbody/tr/td/span[";
		String afterxpath = "]";
				
			//	boolean flag=false;
				for(int num=1; num<=12; num++)
				{
						String fromyearval =driver.findElement(By.xpath(beforexpath + num + afterxpath)).getText();
						System.out.println(fromyearval);
						if(fromyearval.equals(fromyear))
						{
							driver.findElement(By.xpath(beforexpath + num + afterxpath)).click();
							//flag=true;
							//break;
						}	
						//if(flag) {break;}
				}
				

	}
	
	public void selectToYear()
	{
		String toyear = "2011";
		
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[3]/table/tbody/tr/td/span[1]
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[3]/table/tbody/tr/td/span[2]
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[3]/table/tbody/tr/td/span[3]
		
		String beforexpath = "//*[@id=\"datepicker\"]/div/div/div/div[2]/div/div/div[3]/table/tbody/tr/td/span[";
		String afterxpath = "]";
	
	//	boolean flag=false;
		for(int num=1; num<=12; num++)
		{
				String toyearval =driver.findElement(By.xpath(beforexpath + num + afterxpath)).getText();
				System.out.println(toyearval);
				if(toyearval.equals(toyear))
				{
					driver.findElement(By.xpath(beforexpath + num + afterxpath)).click();
					//flag=true;
					//break;
				}	
				//if(flag) {break;}
		}
	}

	public void selectFromMonth()
	{
		String frommonth = "FEB";
		
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr/td/span[1]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr/td/span[2]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr/td/span[3]
		
		String beforexpath = "//*[@id=\"datepicker\"]/div/div/div/div[1]/div/div/div[2]/table/tbody/tr/td/span[";
		String afterxpath = "]";
	
		boolean flag=false;
		for(int num=1; num<=12; num++)
		{
				String frommonthval =driver.findElement(By.xpath(beforexpath + num + afterxpath)).getText();
				System.out.println(frommonthval);
				if(frommonthval.equals(frommonth))
				{
					driver.findElement(By.xpath(beforexpath + num + afterxpath)).click();
					flag=true;
					break;
				}	
				if(flag) {break;}
		}	
	}
	
	public void selectToMonth()
	{
		String tomonth = "AUG";
		
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[2]/table/tbody/tr/td/span[1]
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[2]/table/tbody/tr/td/span[2]
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[2]/table/tbody/tr/td/span[3]
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[2]/table/tbody/tr/td/span[4]
		
		String beforexpath = "//*[@id=\"datepicker\"]/div/div/div/div[2]/div/div/div[2]/table/tbody/tr/td/span[";
		String afterxpath = "]";
	
		boolean flag=false;
		for(int num=1; num<=12; num++)
		{
				String tomonthval =driver.findElement(By.xpath(beforexpath + num + afterxpath)).getText();
				System.out.println(tomonthval);
				if(tomonthval.equals(tomonth))
				{
					driver.findElement(By.xpath(beforexpath + num + afterxpath)).click();
					flag=true;
					break;
				}	
				if(flag) {break;}
		}
	}
	
	public void selectFromDate()
	{
		String fromday = "1";
		
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[1]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[2]
		//*[@id="datepicker"]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr[2]/td[3]
		
		String beforexpath = "//*[@id=\"datepicker\"]/div/div/div/div[1]/div/div/div[1]/table/tbody/tr[";
		String afterxpath = "]/td[";
		
		boolean flag=false;
		for(int rowNum=1; rowNum<=5; rowNum++)
		{
			for(int colNum=1; colNum<=7; colNum++)
			{
				String fromdayval =driver.findElement(By.xpath(beforexpath + rowNum + afterxpath + colNum + "]")).getText();
				System.out.println(fromdayval);
				if(fromdayval.equals(fromday))
				{
					driver.findElement(By.xpath(beforexpath + rowNum + afterxpath + colNum + "]")).click();
					flag=true;
					break;
				}	
			}
			if(flag) {break;}
		}
	}
	
	public void selectToDate()
	{
		String today = "1";
		
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[4]
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[5]
		//*[@id="datepicker"]/div/div/div/div[2]/div/div/div[1]/table/tbody/tr[1]/td[6]
		
		String beforexpath = "//*[@id=\"datepicker\"]/div/div/div/div[2]/div/div/div[1]/table/tbody/tr[";
		String afterxpath = "]/td[";
	
		boolean flag=false;
		for(int rowNum=1; rowNum<=5; rowNum++)
		{
			for(int colNum=1; colNum<=7; colNum++)
			{
				String todayval =driver.findElement(By.xpath(beforexpath + rowNum + afterxpath + colNum + "]")).getText();
				System.out.println(todayval);
				if(todayval.equals(today))
				{
					driver.findElement(By.xpath(beforexpath + rowNum + afterxpath + colNum + "]")).click();
					flag=true;
					break;
				}	
			}
			if(flag) {break;}
		}	
	}
	
	public void clickOnApplyButton()
	{
		clickapplybtn.click();
	}
	
	public void clickOnConnectToPSMarketplaceButton()
	{
		
		connecttoprestamarketplace.click();
	
	}
	
	public PrestaShopPage clickOnPrestshopAddonLink() throws Exception
	{
		clickprestashopaddons.click();
		return new PrestaShopPage();
	
	}
}
