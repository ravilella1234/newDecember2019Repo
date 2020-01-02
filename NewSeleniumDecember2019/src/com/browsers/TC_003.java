package com.browsers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		//WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		//loc.sendKeys("sony");
		//Thread.sleep(3000);
		//loc.clear();
		//Thread.sleep(3000);
		
		//driver.findElement(By.name("field-keywords")).sendKeys("philips");
		
		//driver.findElement(By.className("nav-input")).clear();
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		
		//driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("samsung");
		
		//driver.findElement(By.linkText("AmazonBasics")).click();
		
		//driver.findElement(By.partialLinkText("AmazonBasic")).click();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				String val = links.get(i).getText();
				System.out.println(val);
			}
			
		}
		
	}

}
