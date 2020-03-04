package com.project.suitex;

import java.lang.reflect.Method;

public class ReflectionAPI 
{

	public static void main(String[] args) 
	{
		String x="demoTest";
		
		//if(x.equals("demoTest"))
		//	demoTest();
		
		ReflectionAPI api=new ReflectionAPI();
		try 
		{
			Method method = api.getClass().getMethod(x);
			method.invoke(api);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			

	}
	
	public static void demoTest()
	{
		System.out.println("iam demo Test....");
	}

}
