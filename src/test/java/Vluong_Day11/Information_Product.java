package Vluong_Day11;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.debugger.Debugger.ExecuteWasmEvaluatorResponse;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Commons.CommonService;
import Commons.Data;
import baseObjects.Page_Infor;
import baseObjects.Page_Login;

public class Information_Product extends CommonService{
	
	Page_Infor Pinfor;
	@BeforeMethod
	public void initdata() {
		Pinfor = new Page_Infor(driver);
	}	
	@Test
	public void TC_010InforItemWomen() {	
        test = extent.createTest("TC_010InforItemWomen");
		Pinfor.access_URL(test);
		
		//closeAds
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
		//
		
		Pinfor.access_linkProduct(test);
		Pinfor.access_ProductDressWM(test);
		Pinfor.access_ProductD1(test);
		Pinfor.compare_NameProduct(test);
		Pinfor.compare_CateProduct(test);
		Pinfor.compare_PriceProduct(test);
		Pinfor.compare_AvailabilityProduct(test);
		Pinfor.compare_ConditionProduct(test);
		Pinfor.compare_BrandProduct(test);		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
