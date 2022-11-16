package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Goodreadslogin {
	private WebDriver driver;
	
	public Goodreadslogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id = "ap_email")
	private WebElement email;
	
	@FindBy(id = "ap_password")
	private WebElement password;
	
	@FindBy(id = "a-autoid-0")
	private WebElement signinbtn;
	
	@FindBy(linkText = "Home")
	private WebElement Homepage;
	
	@FindBy(linkText ="My Books")
	private WebElement mybooks;
	
	@FindBy(partialLinkText ="Browse")
	private WebElement browse;
	
	@FindBy(partialLinkText ="Giveaways")
	private WebElement Giveaways;
	
	//@FindBy(linkText = "New Releases")
	//private WebElement newreleases;
	
	@FindBy(xpath = "//*[@title='Notifications']")
	private WebElement notifications;
	
	@FindBy(xpath = "//*[@title='My group discussions']")
	private WebElement mygroup;
	
	@FindBy(xpath = "//*[@title='Messages']")
	private WebElement messages;
	
	@FindBy(xpath = "//*[@aria-label='Friend Requests']")
	private WebElement frndreq;
	
	@FindBy(partialLinkText ="Community")
	private WebElement community;
	
	public void enteremail(String email)
	{
	this.email.clear();
	this.email.sendKeys(email);
	}
	
	public void enterpassword(String password)
	{
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clicksigninbtn() 
	{
		this.signinbtn.click();
		
	}
	
	public void Homebtn()
	{
		this.Homepage.click();
	}
	
	public void mybookslink()
	{
		this.mybooks.click();
		
	}
	
	public void browse()
	{
		this.browse.click();
	}
	
	public void giveawayslink()
	{
		this.Giveaways.click();
	}
	
//	public void newreleases()
//	{
//		this.newreleases.click();
//	}
	
	public void notificationslink()
	{
		this.notifications.click();
	}
	
	public void mygroupdiscusiions()
	{
		this.mygroup.click();
	}
	
	public void messages()
	{
		this.messages.click();
	}
	
	public void freindreq()
	{
		this.frndreq.click();
	}
	
	public void community()
	{
		this.community.click();
	}
}
