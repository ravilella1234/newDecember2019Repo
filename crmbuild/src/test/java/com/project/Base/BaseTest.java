package com.project.Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.project.utilities.ExcelAPI;

public class BaseTest 
{
	public String projectpath=System.getProperty("user.dir");
	public FileInputStream fis;
	public Properties mainProp;
	public Properties envProp;
	public ExcelAPI xls;
	
	
	@BeforeTest
	public void init() throws Exception
	{
		System.out.println("iam beforeTest from BaseTest");
		
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
		
		xls=new ExcelAPI(envProp.getProperty("suitex_xls"));
		
	}

}
