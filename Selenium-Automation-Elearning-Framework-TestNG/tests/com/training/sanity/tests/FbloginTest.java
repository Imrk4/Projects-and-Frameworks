package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Signinfb;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FbloginTest {
	
	private static WebDriver driver;
	private static String baseUrl;
	private static  Signinfb Signinfb;
	private static Properties properties;
	private static ScreenShot Screenshot;
	
	
	@BeforeTest
	public static void Beforetest() throws IOException
	{
		properties =new Properties();
		FileInputStream instream = new FileInputStream("./resources/others.properties");
		properties.load(instream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Signinfb = new Signinfb(driver);
		baseUrl = properties.getProperty("baseURL");
		Screenshot = new ScreenShot(driver);
		driver.get(baseUrl);	
	}
	
	
	@Test
	public void validLoginTest() {
		Signinfb.Enterphone("8951560426");
		Signinfb.Enterpassword("Rr72527264");
		Signinfb.Clickloginbtn(); 
		Screenshot.captureScreenShot("Loginpage");
	}
	
	@Test(dependsOnMethods = "validLoginTest")
	public void logouttest() throws InterruptedException
	{
		Thread.sleep(5000);
		Signinfb.clicklogout();
		
		
	}
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		//driver.quit();
	

}
}
