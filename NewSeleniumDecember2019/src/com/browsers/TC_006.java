package com.browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=r.startTest("TC_005");
		test.log(LogStatus.INFO, "Initializing the Properties Files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :-" + eprop.getProperty("amazonurl"));
		

		//String actualLink = driver.findElement(By.linkText("AmazonBasics")).getText();
		/*
		 * String actualLink =
		 * driver.findElement(By.linkText("AmazonBasics")).getAttribute("href"); String
		 * expectedLink="AmazonBasic";
		 * 
		 * System.out.println("actualLink : " + actualLink);
		 * System.out.println("expectedLink :" + expectedLink);
		 * 
		 * //if(actualLink.equals(expectedLink))
		 * //if(actualLink.equalsIgnoreCase(expectedLink))
		 * if(actualLink.contains(expectedLink))
		 * System.out.println("Both links are equal...."); else
		 * System.out.println("Both links are not equal...");
		 */
		
		
		WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		
		loc.sendKeys("sony");
		
		String val = loc.getAttribute("value");
		
		System.out.println("Text is : " + val);
	}

}
