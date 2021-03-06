package com.project.drivercalss;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.project.keywords.AppKeyword;
import com.project.utilities.Constants;
import com.project.utilities.ExcelAPI;

public class DriverScript 
{
	public Properties mainProp;
	public Properties envProp;
	public AppKeyword app;

	
	public Properties getMainProp() {
		return mainProp;
	}

	public void setMainProp(Properties mainProp) {
		this.mainProp = mainProp;
	}

	public Properties getEnvProp() {
		return envProp;
	}


	public void setEnvProp(Properties envProp) {
		this.envProp = envProp;
	}

	public void quit()
	{
		if(app!=null)
		app.quit();
	}



	public void executeKeywords(String testName,ExcelAPI xls,Hashtable<String, String> h)
	{
		System.out.println("iam driverscript");
		int rows = xls.getRowCount("keywords");
		System.out.println("Rows : " + rows);
		app=new AppKeyword();
		app.setEnvProp(envProp);
		app.setMainProp(mainProp);
		
		//send the  data
		app.setData(h);
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, "TCID", rNum);
			if(tcid.equals(testName))
			{
				String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.KEYWORD_COL, rNum);
				String objectKey = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.OBJECT_COL, rNum);
				String dataKey = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.DATA_COL, rNum);
				String data = h.get(dataKey);
				//System.out.println(tcid + "----" + keyword + "----" + mainProp.getProperty(objectKey) + "----" +data);
				app.setDataKey(dataKey);
				app.setObjectKey(objectKey);
				
				
				/*
				 * if(keyword.equals("openBrowser")) app.openBrowser(); else
				 * if(keyword.equals("navigateUrl")) app.navigateUrl(); else
				 * if(keyword.equals("clickElement")) app.clickElement(); else
				 * if(keyword.equals("type")) app.type(); else
				 * if(keyword.equals("validateLogin")) app.validateLogin(); else
				 * if(keyword.equals("validateTitle")) app.validateTitle();
				 */
				
				Method method;
				try 
				{
					method=app.getClass().getMethod(keyword);
					method.invoke(app);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				} 
			}
		}
	}

}
