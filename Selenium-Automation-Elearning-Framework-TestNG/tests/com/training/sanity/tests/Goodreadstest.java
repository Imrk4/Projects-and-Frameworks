package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Goodreadslogin;
import com.training.pom.Searcbooks;
import com.training.pom.Signoutgoodreads;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Goodreadstest {
	
	private static WebDriver driver;
	private static String baseurl;
	private static Goodreadslogin login;
	private static Properties properties;
	private static Signoutgoodreads logout;
	private static ScreenShot screenshot;
	private static Searcbooks Search;
	
	//*************************** B
	@BeforeTest
	public static void BT() throws IOException
	{
		properties = new Properties();
		FileInputStream instream = new FileInputStream("./resources/others.properties");
		properties.load(instream);
		driver= DriverFactory.getDriver(DriverNames.CHROME);
		login = new Goodreadslogin(driver);
		logout = new Signoutgoodreads(driver);
		Search = new Searcbooks(driver);
		baseurl = properties.getProperty("baseURL");
		
		screenshot = new ScreenShot(driver);
		driver.get(baseurl);
		driver.findElement(By.linkText("Sign In")).click();
		 driver.findElement(By.linkText("Sign in with email")).click();
			
	}
	
	@Test(priority = 0)
	public void emaillogin()
	{
		login.enteremail("imharshadmehta1992@gmail.com");
		login.enterpassword("12345678");
		login.clicksigninbtn();
		screenshot.captureScreenShot(baseurl);	
	}
	
	@Test(priority = 1)
	public void Homepage() throws InterruptedException
	{
		login.Homebtn();
		login.mybookslink();
		login.browse();
		//login.giveawayslink();
		//Thread.sleep(3000);
		//login.newreleases();
		//Thread.sleep(3000);
		login.notificationslink();
		Thread.sleep(3000);
		login.mygroupdiscusiions();
		Thread.sleep(3000);
		login.messages();
		Thread.sleep(3000);
		login.freindreq();
		Thread.sleep(3000);
		login.community();		
	}
	
	@Test (priority = 2)
	public void Searchbox() throws InterruptedException
	{
		Search.searchbook("Scams in India");
		Search.searchbutton();
		Search.selectedbook();
		Thread.sleep(5000);
		Search.ToRead();
		Thread.sleep(3000);
		Search.libraries();
		Thread.sleep(3000);
		Search.amazon();
		Thread.sleep(3000);
		Search.ratings();
		Thread.sleep(3000);
	}
	
	@Test (priority = 3 )
	public void signout()
	{
		logout.myprofileclick();
		screenshot.captureScreenShot(baseurl);
		logout.signingout();
	}
	
	
}
