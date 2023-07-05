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
import Commons.ManageObj;
import baseObjects.Page_Infor;
import baseObjects.Page_Login;

public class Information_Product extends CommonService{
	
	Page_Infor Pinfor;
	
	@Test
	public void TC_010InforItemWomen() {	
        test = extent.createTest("TC_010InforItemWomen");
        Pinfor = ManageObj.ManageObj_Pinfor_Object(driver, test);
		Pinfor.access_URL();
		
//		//closeAds
//		String title = "AdBlock is now installed!";
//		String CntWin = driver.getWindowHandle();
//		Set<String> windows = driver.getWindowHandles();
//		
//		for (String str : windows) {
//			driver.switchTo().window(str); 
//			System.out.println(str);
//			if (driver.getTitle().equalsIgnoreCase(title)) {
//				driver.switchTo().window(str);
//				driver.close();
//			}			
//		}		
//		driver.switchTo().window(CntWin);
		//
		
		Pinfor.access_linkProduct();
		Pinfor.access_ProductDressWM();
		Pinfor.access_ProductD1();
		Pinfor.compare_NameProduct();
		Pinfor.compare_CateProduct();
		Pinfor.compare_PriceProduct();
		Pinfor.compare_AvailabilityProduct();
		Pinfor.compare_ConditionProduct();
		Pinfor.compare_BrandProduct();		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
