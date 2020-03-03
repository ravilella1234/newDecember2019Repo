package com.project.keywords;

import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericKeyword 
{

	public Properties mainProp;
	public Properties envProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	
	public WebDriver driver;
	
	
	
	public void setMainProp(Properties mainProp) {
		this.mainProp = mainProp;
	}

	public void setEnvProp(Properties envProp) {
		this.envProp = envProp;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	public void openBrowser()
	{
		String browser=data.get(dataKey);
		System.out.println("Opening Browser...." +browser);
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\drive\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\drive\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigate to website...." + envProp.getProperty(objectKey));
		driver.get(envProp.getProperty(objectKey));
	}
	
	public void clickElement()
	{
		System.out.println("Click on Element...." + mainProp.getProperty(objectKey));
		//driver.findElement(By.xpath(mainProp.getProperty(objectKey))).click();
		getObject(objectKey).click();
	}
	
	public void type()
	{
		System.out.println("Type the text..." + mainProp.getProperty(objectKey) + "Data -----" + data.get(dataKey));
		//driver.findElement(By.xpath(mainProp.getProperty(objectKey))).sendKeys(data.get(dataKey));
		getObject(objectKey).sendKeys(data.get(dataKey));
	}
	
	//central function to extract objects
	public WebElement getObject(String objectKey)
	{
		WebElement e=null;
		
		if(objectKey.endsWith("_id")) {
			e=driver.findElement(By.id(mainProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_name")) {
			e=driver.findElement(By.name(mainProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_xpath")) {
			e=driver.findElement(By.xpath(mainProp.getProperty(objectKey)));
		}else if(objectKey.endsWith("_css")) {
			e=driver.findElement(By.xpath(mainProp.getProperty(objectKey)));
		}
		return e;
	}
	
	public void quit()
	{
		if(driver!=null)
			driver.quit();
	}
	
}
