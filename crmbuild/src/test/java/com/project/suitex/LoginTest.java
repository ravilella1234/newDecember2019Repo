package com.project.suitex;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.Base.BaseTest;
import com.project.utilities.DataUtils;
import com.project.utilities.ExcelAPI;

public class LoginTest extends BaseTest
{
	
	
  @Test(dataProvider = "getdata")
  public void f(Hashtable<String, String> h) 
  {
	  System.out.println("iam loginTest");
  }
  
  @DataProvider
  public Object[][] getdata() throws Exception
  {
	  System.out.println("iam data provider....");
	  String sheetName="data";
		  
	return DataUtils.getTestData(xls, sheetName, testName);
	  
  }
  
  
}
