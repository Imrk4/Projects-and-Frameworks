package selenium1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewTest {
 WebDriver driver;
  @BeforeTest
  public void beforeTest()
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://www.makemytrip.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
  
  @Test
  public void f() throws InterruptedException 
  {
	  Thread.sleep(5000);
	  driver.findElement(By.linkText("Holiday Packages")).click();
	 driver.findElement(By.xpath("//*[@id='fromCity']")).click();
	 driver.findElement(By.xpath("//*[@placeholder='From']")).sendKeys("Bangalore");
	 Thread.sleep(3000);
	WebElement loc= driver.findElement(By.xpath("//*[@placeholder='From']"));
	//loc.sendKeys("Bangalore");
	Actions act=new Actions(driver);
	act.moveToElement(loc).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
	//driver.findElement(By.xpath("//*[@placeholder='From']")).click();
	//driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-2']/div/p/span")).click();
	//driver.findElement(By.xpath("//*[@id='toCity']")).click();
	Thread.sleep(3000);
	//*[@id="toCity"]
	//driver.findElement(By.xpath("//*[@id='toCity']")).sendKeys("Singapore");
	driver.findElement(By.xpath("//*[@placeholder='To']")).sendKeys("Singapore");
//	driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']/div/p")).click();
	//*[@id="react-autowhatever-1-section-0-item-1"]/div/p/span
	//	  Select sel=new Select(dropdown1);
//	  sel.selectByValue("Bangalore"); 
	//*[@id="react-autowhatever-1-section-0-item-0"]/div/p
	//WebElement sel= driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']/div/p"));
	WebElement sel=driver.findElement(By.xpath("//*[@placeholder='To']"));
	Thread.sleep(3000);
	//Actions act=new Actions(driver);
	act.moveToElement(sel).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
	//(Keys.ARROW_DOWN,Keys.RETURN);
	//*[@data-cy='submit' & @type='button']
	driver.findElement(By.xpath("//*[@id='search_button']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@class='skipBtn']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@class='primary-cta']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@class='closePopup']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//*[@class='modify-search_input '])[3]")).click();
	driver.findElement(By.xpath("(//*[@class='DayPicker-Day'])[9]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@class='primaryBtn big fill btn btn-top-nav btn-lg']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//*[@class='slick-arrow slick-next '])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//*[@class='makeFlex hrtlCenter'])[7]")).click();
	Thread.sleep(5000);
	Set<String> alltab=driver.getWindowHandles();
	System.out.println(alltab);
	  Object[] tabs=alltab.toArray();
	  driver.switchTo().window((String) tabs[1]);
	  driver.findElement(By.xpath("//*[@class='skipBtn']")).click();
	WebElement chbtn=driver.findElement(By.xpath("(//*[@id='changeRemoveBtn'])[3]"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,600)");
	
	  //(//*[@id='changeRemoveBtn'])[3]
	//*[@class='skipBtn']
	//*[@class='closePopup']
	//*[@class='primary-cta']
	//(//*[@class='modify-search_input '])[3]
	//(//*[@class='makeFlex hrtlCenter'])[7]
  }
  @AfterTest
  public void afterTest() 
  {
	  
  }

}
