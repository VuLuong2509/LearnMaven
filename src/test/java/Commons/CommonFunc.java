package Commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

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
		test.info( ele_sendkey.getAttribute("value" + "Enter: "));
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
	
	public void element_select(WebDriver driver, ExtentTest test, String xpath, Integer values) {
		WebElement select = driver.findElement(By.xpath(xpath));
		Select Select_ele = new Select(select);
		Select_ele.selectByIndex(values);
	}
	
//	public void Wait_element(WebDriver driver, String xpath) {
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				  .withTimeout(Duration.ofSeconds (30)) // thoi gian cho toi da ( implicit + explicit wait deu co)
//				  .pollingEvery(Duration.ofSeconds(1 )) //15 // config tan suat check ele
//				  .ignoring(NoSuchElementException.class); // ke exception no such
//		
//		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
//	         // customized condition for fluent wait
//	         public WebElement apply(WebDriver driver) {
//	            if (driver.findElement(By.xpath(xpath))!=null) 
//	            	return driver.findElement(By.xpath(xpath));
//				return null;
//	         }
//	      });
//	}


}
