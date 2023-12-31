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

import io.appium.java_client.android.AndroidDriver;

public class CommonFunc {
	
	public void open_url(WebDriver driver, ExtentTest test,String url) {
		test.info("Go to URL" + url);
		driver.get(url);
	}
	
	public void element_click(Object driver, ExtentTest test, String xpath) {
		WebElement btn = null;
		
		if (driver instanceof AndroidDriver) {
			btn = ((AndroidDriver<WebElement>) driver).findElement(By.xpath(xpath));
	
			test.info("Click btn"+xpath);
		} else {
			btn = ((WebDriver)driver).findElement(By.xpath(xpath));
			test.info("click btn:" + btn.getAttribute("textContent"));
		}
		
		btn.click();
	}
	
	public void element_sendkey(WebDriver driver, ExtentTest test, String xpath, String data) {
		WebElement ele_sendkey = driver.findElement(By.xpath(xpath));
		test.info("Enter: " + data + ele_sendkey.getAttribute("textContent"));
		ele_sendkey.sendKeys(data);		
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
	
	public void Wait_element(WebDriver driver, String xpath) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds (30)) // thoi gian cho toi da ( implicit + explicit wait deu co)
				  .pollingEvery(Duration.ofSeconds(1 )) //15 // config tan suat check ele
				  .ignoring(NoSuchElementException.class); // ke exception no such
		
		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
	         // customized condition for fluent wait
	         public WebElement apply(WebDriver driver, String xpath) {
	            if (driver.findElement(By.xpath(xpath))!=null) 
	            	return driver.findElement(By.xpath(xpath));
				return null;
	         }

			public WebElement apply(WebDriver t) {
				// TODO Auto-generated method stub
				return null;
			}
	      });
	}
	
//	public void Wait_ele(WebDriver driver) {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
//	}


}
