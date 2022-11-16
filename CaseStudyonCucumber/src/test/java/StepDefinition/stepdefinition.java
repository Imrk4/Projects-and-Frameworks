package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class stepdefinition {
	WebDriver driver;
	
	@Given("open Browser")
	public void open_browser() 
	{
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.get("https://demo.guru99.com/test/newtours/index.php");
	// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	}
	@When("^enter valid username (.*)$")
	public void enter_valid_username(String name) 
	{
	    //name="username" //*[@name='username'] (//table/tbody/tr/td)[8] //*[@type='text'] //*[@name='userName']
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(name);
	}
	@When("^enter valid password (.*)$")
	public void enter_valid_password(String pwd) 
	{
		//name="password" //*[@type='password'] //*[@name='password']
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pwd);
	    
	}
	@When("click on LoginButton")
	public void click_on_login_button() 
	{
	 //name="login" //*[@name='submit' & @value='Submit']
		driver.findElement(By.xpath("//*[@name='submit' and @value='Submit']")).click();		
	}
	@Then("show {string}")
	public void show(String actmsg) 
	{
	    ////body/blockquote/b //table/tbody/tr/td/h3
		String exp= driver.findElement(By.xpath("//table/tbody/tr/td/h3")).getText();
		String act=actmsg;
		Assert.assertEquals(exp,act);
	}



	
//	@Given("open Browser")
//	public void open_browser() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	@When("^enter invalid username (.*)$")
	public void enter_invalid_username(String name2) 
	{
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys(name2);
	}
	@When("^enter invalid password (.*)$")
	public void enter_invalid_password(String pwd2) 
	{
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(pwd2);
	}
	@When("click on loginbutton")
	public void click_on_loginbutton() 
	{
		driver.findElement(By.xpath("//*[@name='submit' and @value='Submit']")).click();
	}
	
	@Then("show msg {string}")
	public void show_msg(String error) 
	{
	    String expmsg=driver.findElement(By.xpath("//span")).getText();
	    String actmsg=error;
	    Assert.assertEquals(expmsg,actmsg);
	}

	
	@Given("close Browser")
	public void close_browser() 
	{
	    driver.quit();
	}





}
