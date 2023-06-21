package Commons;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class CommonFunc {
	public String screenShot(WebDriver driver) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public void open_url(WebDriver driver, ExtentTest test,String url) {
		test.info("Go to URL" + url);
		driver.get(url);
	}
	
	public void element_click(WebDriver driver, ExtentTest test, String xpath) {
		WebElement btn = driver.findElement(By.xpath(xpath));
		test.info("click btn:" + btn.getAttribute("textContent"));
		btn.click();
	}
	
	public void element_sendkey(WebDriver driver, ExtentTest test, String xpath, String data) {
		WebElement ele_sendkey = driver.findElement(By.xpath(xpath));
		ele_sendkey.sendKeys(data);
		test.info("Enter Email: "+ ele_sendkey.getAttribute("value"));
	}
	
	public String getAttributeValues(WebDriver driver, String xpath, String attributeName) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		String value = ele.getAttribute(attributeName);
		return value;
	}
	
	public void element_click_byJS(WebDriver driver, ExtentTest test, String xpath) {
		WebElement element_click = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element_click);
		
	}

}
