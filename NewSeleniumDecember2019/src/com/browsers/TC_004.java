package com.browsers;

import org.apache.log4j.Logger;

public class TC_004 extends BaseTest
{

	private static final Logger log=Logger.getLogger(TC_004.class.getName());
	
	public static void main(String[] args) throws Exception
	{
		init();
		log.info("Initializing the Properties Files....");
		
		launch("chromebrowser");
		log.info("Opened the browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :-" + eprop.getProperty("amazonurl"));
			
		selectOption("amazonsearchdropbox_id","amazondropvalue");
		log.info("Seleted the option :- "+ or.getProperty("amazondropvalue") + " by using the locator :- " + or.getProperty("amazonsearchdropbox_id") );
		
		typeValue("amazonsearchdropbox_name","amazontext");
		log.info("Entered the text :- " + or.getProperty("amazontext") + " By using the locator :- " +  or.getProperty("amazonsearchdropbox_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on button by using the locator  :-" + or.getProperty("amazonsearchbutton_xpath"));
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();

	}

	
}
