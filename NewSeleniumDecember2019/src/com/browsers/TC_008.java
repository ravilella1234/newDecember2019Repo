package com.browsers;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class TC_008 extends BaseTest
{

	public static void main(String[] args) throws Exception {
		init();
		test=r.startTest("TC_007");
		test.log(LogStatus.INFO, "Initializing the Properties Files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :-" + eprop.getProperty("amazonurl"));
		
		String actualLink =driver.findElement(By.linkText("AmazonBasics")).getAttribute("innerHTML"); 
		String expectedLink="AmazonBasic"; 
		
		System.out.println("actualLink : " + actualLink);
		System.out.println("expectedLink :" + expectedLink);
		
		//  **************  Assert Class  ************************
		//Assert.assertEquals(actualLink, expectedLink);
		//Assert.assertTrue(actualLink.contains(expectedLink), "Both links are not equal...");
		
		//driver.findElement(By.linkText("AmazonBasics")).click();
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
		
	//  **************  SoftAssert Class  ************************
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualLink, expectedLink);
		
		s.assertTrue(false, "err1");
		
		s.assertTrue(false, "err2");
		
		s.assertTrue(true, "err3");
		
		s.assertTrue(false, "err4");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony");
		
		s.assertAll();

	}

}
