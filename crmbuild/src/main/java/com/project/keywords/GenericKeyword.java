package com.project.keywords;

import java.util.Hashtable;
import java.util.Properties;

public class GenericKeyword 
{

	public Properties mainProp;
	public Properties envProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	
	
	
	
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
		System.out.println("Opening Browser...." +data.get(dataKey));
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigate to website...." + envProp.getProperty(objectKey));
	}
	
	public void clickElement()
	{
		System.out.println("Click on Element...." + mainProp.getProperty(objectKey));
	}
	
	public void type()
	{
		System.out.println("Type the text..." + mainProp.getProperty(objectKey) + "Data -----" + data.get(dataKey));
	}
	
}
