package com.shopcart.base;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	
	
	
	public TestBase() throws FileNotFoundException
	{
		try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("E:\\ShopCart-master\\ShopCartAdmin123\\src\\main\\java\\com\\shopcart\\config\\config.properties");
				prop.load(ip);
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() throws FileNotFoundException
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://sellib/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
		public void takeScreenshotAtEndOfTest(String testMethodName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		FileUtils.copyFile(scrFile, new File("C:\\Users\\SHYAM\\git\\ShopCartGitRepo\\"
				+ "ShopCartAdmin123\\Screenshots\\"+testMethodName+
				"_"+".jpg"));
	}
		
}
