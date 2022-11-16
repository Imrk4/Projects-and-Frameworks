package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signoutgoodreads {
	private WebDriver driver;
	
	public Signoutgoodreads(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='dropdown dropdown--profileMenu']")
	private WebElement profile;
	
	@FindBy(linkText = "Sign out")
	private WebElement signout;
	
	public void myprofileclick()
	{
		this.profile.click();
	}
	public void signingout()
	{
		this.signout.click();
	}
}
