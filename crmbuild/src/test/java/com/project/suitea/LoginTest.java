package com.project.suitea;

import java.util.HashMap;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.Base.BaseTest;
import com.project.utilities.DataUtils;

public class LoginTest extends BaseTest
{
	
	
  @Test(dataProvider = "getdata")
  public void f(Hashtable<String, String> h) 
  {
	  //System.out.println("iam loginTest");
	  if(h.get("TCID").equals("LoginTest"))
	  System.out.println(h.get("TCID") + "---" + h.get("Description")+ "---" + h.get("Keyword") + "---" + h.get("Object") + "---" + h.get("Data") );
  }
  
  @DataProvider
  public Object[][] getdata()
  {
	  System.out.println("iam data provider....");
	  String sheetName="keywords";
	  String testCaseName="LoginTest";
	  
	return DataUtils.getTestData(xls, sheetName, testCaseName);
	  
  }
  
  
}
