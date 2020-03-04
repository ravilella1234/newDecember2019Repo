package com.project.suitex;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.Base.BaseTest;
import com.project.drivercalss.DriverScript;
import com.project.utilities.Constants;
import com.project.utilities.DataUtils;

public class LoginTest extends BaseTest
{
	
	
  @Test(dataProvider = "getdata")
  public void f(Hashtable<String, String> h) 
  {
	  System.out.println("iam loginTest");
	  if(h.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO))
		  throw new SkipException("Run mode is set to No....");
	  
	  
	  ds.executeKeywords(testName, xls, h);
  }
  
  @DataProvider
  public Object[][] getdata() throws Exception
  {
	  System.out.println("iam data provider....");
	  String sheetName="data";
		  
	return DataUtils.getTestData(xls, sheetName, testName);
	  
  }
  
  
}
