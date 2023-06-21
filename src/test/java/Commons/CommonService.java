package Commons;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class CommonService {
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static CommonFunc Func = new CommonFunc();
	@BeforeTest
	@Parameters({"browser"})
	public WebDriver Rundriver(String browser) {
		
		extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("./Report/AutoReport_" +browser+".html");
        extent.attachReporter(spark);
		
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
			option.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();		
		return driver;				
	}
	
	@AfterMethod
	public void saveAttachment() {
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(Func.screenShot(driver)).build());
		extent.flush();
	}
	@AfterTest
	public void AfterRun() {
		driver.quit();
	}
	
	

}
