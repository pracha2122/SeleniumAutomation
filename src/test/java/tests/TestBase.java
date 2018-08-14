package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utility.ConfigFileReader;



public class TestBase {
	public static WebDriver driver = null;
	ConfigFileReader configFileReader;
	 @BeforeMethod
	public void initialization(){
		 configFileReader = new ConfigFileReader();
	//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\geckodriver.exe");
	System.setProperty("webdriver.gecko.driver",configFileReader.getFFDriverPath());
	 driver = new FirefoxDriver();	      
	    
	     driver.get(configFileReader.getApplicationUrl());	   
	     driver.manage().window().maximize();	    
	     driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	 @AfterMethod
	  public void tearDownTest() {
		 TestBase.driver.quit();
	  }

}
