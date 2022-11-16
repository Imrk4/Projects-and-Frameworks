package hybridAppTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities 
{
	public static AndroidDriver<AndroidElement> capability() throws MalformedURLException 
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Rajkumar");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.androidsample.generalstore");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.androidsample.generalstore.SplashActivity");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"D://Rajkumar Moolya//docs1//docs//chromedriver.exe");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.APPIUM);
		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		return driver;
	}
}
