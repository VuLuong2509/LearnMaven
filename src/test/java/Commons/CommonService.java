package Commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

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

public class CommonService {
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test = null;

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
		
		return driver;				
	}

	public String screenShot(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
		
		
		
		if(result.getStatus()==1) {
			test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());
		} else if (result.getStatus()==2) {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());
		} else {
			test.info(MediaEntityBuilder.createScreenCaptureFromPath(screenShot(driver)).build());
		}
		
		
		extent.flush();
	}
	@AfterTest
	public void AfterRun() {
		driver.quit();
	}
	
	

}
