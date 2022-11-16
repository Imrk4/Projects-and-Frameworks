package hybridAppTesting;

import java.net.MalformedURLException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class GeneralStores extends Capabilities 
{
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void beforetest1() throws MalformedURLException
	{
		driver=capability();
	}
	@Test
	public void testcase1() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Australia\"))").click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Enter name here']")).sendKeys("Rajkumar");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='male']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@text='Let's Shop']")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(3000);
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(3000);
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String shoes1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		shoes1=shoes1.substring(1);
		Double samt1=Double.parseDouble(shoes1);
		System.out.println(samt1);
		String shoes2=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		shoes2=shoes2.substring(1);
		Double samt2=Double.parseDouble(shoes2);
		System.out.println(samt2);
		Double expamt=samt1+samt2;
		String ptotal=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		ptotal=ptotal.substring(1);
		Double actamt=Double.parseDouble(ptotal);
		System.out.println(actamt);
		driver.findElement(By.className("android.widget.CheckBox")).click();
		TouchAction tap=new TouchAction(driver);
		AndroidElement terms=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		tap.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();
		driver.switchTo().alert().dismiss();
		Thread.sleep(4000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		
		Set<String> contextnames=driver.getContextHandles();
		for(String cname:contextnames)
		{
			System.out.println(cname);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Moolya",Keys.ENTER);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.context("NATIVE_APP");
	}
}
