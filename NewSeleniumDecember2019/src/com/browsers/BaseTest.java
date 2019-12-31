package com.browsers;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class BaseTest
{
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties envprop;
	public static Properties eprop;
	
	
	public static void init() throws Exception
	{
		fis=new FileInputStream(projectPath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectPath+"//environment.properties");
		envprop=new Properties();
		envprop.load(fis);
		String e1 = envprop.getProperty("env");
		System.out.println(e1);
		
		fis=new FileInputStream(projectPath+"//"+e1+".properties");
		eprop=new Properties();
		eprop.load(fis);
		String e2 = eprop.getProperty("amazonurl");
		System.out.println(e2);
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\drive\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3");
			option.addArguments("--disable-notifications");
			
			driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\drive\\geckodriver.exe");
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("ffprofile");
			
			profile.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions option=new FirefoxOptions();
			option.setProfile(profile);
			
			driver=new FirefoxDriver(option);
		}
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(eprop.getProperty(url));
		driver.navigate().to(eprop.getProperty(url));
	}

}
