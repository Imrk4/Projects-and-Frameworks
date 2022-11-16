package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signinfb {
	private WebDriver driver;
	
	public Signinfb(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(id="email")
	private WebElement phonenumber;
	
	@FindBy(id="pass")
	private WebElement password;
	 
	@FindBy(name="login")
	private WebElement Button;
	
	@FindBy(xpath = "(//*[@class='qzhwtbm6 knvmm38d']/span)[5]") 
	private WebElement Logoutbtn;
			
			
	public void Enterphone(String Phonenumber)
	{
		this.phonenumber.clear();
		this.phonenumber.sendKeys(Phonenumber);
	}
	public void Enterpassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	public void Clickloginbtn() {
		this.Button.click();
	}
	public void clicklogout()
	{
		this.Logoutbtn.click();
	}
}
