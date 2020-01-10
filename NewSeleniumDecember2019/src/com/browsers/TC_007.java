package com.browsers;

import com.relevantcodes.extentreports.LogStatus;

public class TC_007 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=r.startTest("TC_007");
		test.log(LogStatus.INFO, "Initializing the Properties Files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :-" + eprop.getProperty("amazonurl"));
	 
		  String expectedLink="amazonbasic";
		  if(!verifyLink(expectedLink))
			  reportFailure("Both links are not equal...");
		  else
			  reportSuccess("Both links are equal...");
			  
	
		  r.endTest(test);
		  r.flush();

	}

	

	

}
