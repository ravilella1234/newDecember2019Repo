package com.project.Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.project.drivercalss.DriverScript;
import com.project.keywords.AppKeyword;
import com.project.utilities.ExcelAPI;

public class BaseTest 
{
	public String projectpath=System.getProperty("user.dir");
	public FileInputStream fis;
	public Properties mainProp;
	public Properties envProp;
	public ExcelAPI xls;
	public String testName;
	public DriverScript ds;
	
	
	
	@BeforeTest
	public void init() throws Exception
	{
		System.out.println("iam beforeTest from BaseTest");
		
		String[] pack = this.getClass().getPackage().getName().split("\\.");
		String suiteName = pack[pack.length-1];
		System.out.println(suiteName);
		
		testName = this.getClass().getSimpleName();
		System.out.println(testName);
		
		fis=new FileInputStream(projectpath+"//src//test//resources//environment.properties");
		mainProp=new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis=new FileInputStream(projectpath+"//src//test//resources//"+e+".properties");
		envProp=new Properties();
		envProp.load(fis);
		String val = envProp.getProperty("zohourl");
		System.out.println(val);
		
		// Excel Inilize
		xls=new ExcelAPI(envProp.getProperty(suiteName+"_xls"));
		
		//init DS
		ds=new DriverScript();
		ds.setEnvProp(envProp);
		ds.setMainProp(mainProp);
	}
	
	
	@BeforeMethod
	public void initMethod()
	{
		System.out.println("iam beforeMethod from BaseTest");
	}
	
	@AfterMethod
	public void quit()
	{
		if(ds!=null)
			ds.quit();
	}

}
