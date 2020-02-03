package com.POM;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.CarrierIT.BaseTest;

public class POM_001 extends BaseTest
{
	LoginPage page;
	
  
  @BeforeTest
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	  init();
	  launch(bType);
	  navigateUrl("automationurl");
  }
  
  @Test
  public void login() 
  {
	  page=new LoginPage(driver);
	  page.customerLogin();
	  
	  String expectedError="Authentication failed";
	  Assert.assertEquals(page.getLoginError(), expectedError);
  }

  @AfterTest
  public void endProcess() 
  {
	  
  }

}
