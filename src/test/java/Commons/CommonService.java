package Commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CommonService {
//	public static AndroidDriver mddriver = null;
	public static AndroidDriver<WebElement> mddriver = null;
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test = null;
	protected static AppiumDriverLocalService service;
	DesiredCapabilities dc;
	
	
	@BeforeSuite
	public void initReport() {
		extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("./Report/AutoReport.html");
        extent.attachReporter(spark);
	}

	@BeforeTest
	@Parameters({"platform", "browser", "portno", "devicename"})
	public void Rundriver(String platform, String browser, String portno, String devicename) {
		
		if (platform.equalsIgnoreCase("mobile")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "435da4f5");
//			dc.setCapability(MobileCapabilityType.UDID, "435da4f5");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
			dc.setCapability(MobileCapabilityType.UDID, devicename);
			
			dc.setCapability("unicodeKeyboard", "true");
			dc.setCapability("resetKeyboard", "true");
					
			dc.setCapability("noReset", false);
			dc.setCapability("fullReset", true);
			File f = new File(System.getProperty("user.dir") + File.separator + "RS_app" + File.separator + "ApiDemos-debug.apk" );
			dc.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
			dc.setCapability("appPackage", "io.appium.android.apis");
			dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			
			try {
//				mddriver = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub") , dc);
				service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withLogFile(new File(System.getProperty("user.dir")+"/" +portno+ "_log.txt")).usingPort(Integer.parseInt(portno)));
				service.start();
				
				String newURL = service.getUrl().toString();
				System.out.println("NEW URL: "+ newURL);
				mddriver = new AndroidDriver<WebElement>(service.getUrl(),dc);
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (browser.equalsIgnoreCase("Chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addExtensions(new File("./adBlock/extension_5_6_0_0.crx")); 
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, option);
				option.merge(capabilities);			
				option.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(option);
			} else if(browser.equalsIgnoreCase("FireFox")) {
				driver = new FirefoxDriver();
			} else{
				EdgeOptions option = new EdgeOptions();
//				option.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String title = "AdBlock is now installed!";
			String CntWin = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			
			for (String str : windows) {
				driver.switchTo().window(str); 
				System.out.println(str);
				if (driver.getTitle().equalsIgnoreCase(title)) {
					driver.switchTo().window(str);
					driver.close();
				}			
			}
			
			driver.switchTo().window(CntWin);						
		}
			
	}

	
	
	public String screenShot(Object local_driver) {		
		File screenshotFile;
		if (local_driver instanceof AndroidDriver) {
			screenshotFile = ((TakesScreenshot) mddriver).getScreenshotAs(OutputType.FILE);
		} else {
			screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		}
		
//		Random ran = new Random();
//		int ranNumbername = ran.nextInt(); 
		String new_name = "screenshot_" + getTime() + ".png";
		try {
			FileUtils.copyFile(screenshotFile, new File("./Report/"+new_name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new_name;
	}
	public String getTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
	   	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

	    String formattedDate = myDateObj.format(myFormatObj);
	  
		return formattedDate;
	}


	@AfterMethod
	public void saveAttachment(ITestResult result) {
		
		if (driver!=null) {
			if(result.getStatus()==1) {
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());
			} else if (result.getStatus()==2) {
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());
			} else {
				test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());
			}
		}
		
		if (mddriver!=null) {
			if(result.getStatus()==1) {
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(mddriver)).build());
			} else if (result.getStatus()==2) {
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(mddriver)).build());
			} else {
				test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(mddriver)).build());
			}
		}
		
		
		
		
		
		extent.flush();
	}
	
//	@AfterTest
//	public void mini() {
//		if(driver!=null) {
//			driver.manage().window().minimize();
//		}
//	}
	@AfterSuite
	public void AfterRun() {
		if (driver!=null) {
			driver.quit();
		}
		if (mddriver!=null) {
			mddriver.quit();
		}
		
	}
	
	

}
