package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searcbooks {
	private WebDriver driver;
	
	public Searcbooks(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//*[@aria-label='Search books']")
	private WebElement searchbooks;
	
	@FindBy(xpath = "//*[@aria-label='Search']")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//*[@class='bookTitle']")
	private WebElement selectedbook;
	
	@FindBy(xpath = "//body/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]/span[1]")
	private WebElement ToRead;
	
	@FindBy(xpath = "//*[@class='buttonBar']")
	private WebElement libraries;
	
	@FindBy(xpath = "//*[@id='buyButton']")
	private WebElement amazon;
	
	@FindBy(xpath = "//*[@title='really liked it']")
	private WebElement ratings;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	public void searchbook (String Searchbooks)
	{
		this.searchbooks.clear();
		this.searchbooks.sendKeys(Searchbooks);
	}
	
	public void searchbutton()
	{
		//this.searchbutton.clear();
		this.searchbutton.click();
	}
	
	public void selectedbook()
	{
		this.selectedbook.click();
	}
	public void  ToRead()
	{
		this.ToRead.clear();
		this.ToRead.click();
	}
	
	public void libraries()
	{
		this.libraries.clear();
		this.libraries.click();
	}
	
	public void amazon()
	{
		this.amazon.clear();
		this.amazon.click();
	}
	
	public void ratings()
	{
		this.ratings.clear();
		this.ratings.click();
	}
	

}
