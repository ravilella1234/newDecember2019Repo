package com.browsers;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
			
		selectOption("searchDropdownBox","Books");
		
		typeValue("field-keywords","Harry Potter");
		
		clickElement("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();

	}

	
}
