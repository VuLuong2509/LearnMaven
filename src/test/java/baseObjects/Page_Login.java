package baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Commons.CommonFunc;

public class Page_Login {
	// xpath
	String xpathLogin = "//a[@href='/login']";
	String eleEmail = "//input[@data-qa='login-email']";
	String elePass = "//input[@data-qa='login-password']";
	String btnLogin = "//button[@data-qa='login-button']";
	String URL = "https://automationexercise.com/";
	String xpathlMess = "//p[@style='color: red;']";
	String Expectalert = "Your email or password is incorrect!";	
	String ExpectMess = "Logged in as toivaot";
	String xpathMess= "(//ul[@class='nav navbar-nav'])/li[10]/a";	
	String xpathLogout = "//a[@href='/logout']";
	String ExpectURL = "https://automationexercise.com/login";	
	CommonFunc func = new CommonFunc();
	WebDriver local_driver;
	public Page_Login(WebDriver driver) {
		local_driver = driver; 
	}
	//handel HTML5 Validation by javascript
	//Research from https://vntesters.com/java-webdriver-14-kiem-tra-html5-validation-message/
	public String getHtml5ValidationMessage1(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) local_driver;// declare javascript
		return (String) js.executeScript("return arguments[0].validationMessage;", element);
		}
	// Action
	
	public void access_URL(ExtentTest test) {
		func.open_url(local_driver, test, URL);
	}
	
	public void input_mail(ExtentTest test, String input_values) {
		func.element_sendkey(local_driver, test, eleEmail, input_values);
	}

	public void input_pass(ExtentTest test, String input_values) {
		func.element_sendkey(local_driver, test, elePass, input_values);
	}

	public void access_login(ExtentTest test) {
		func.element_click(local_driver, test, xpathLogin);
	}

	public void click_login(ExtentTest test) {
		func.element_click(local_driver, test, btnLogin);
	}
	
	public void click_logout(ExtentTest test) {
		func.element_click(local_driver, test, xpathLogout);
		
	}
	
	public void ComparevalidationhWrongFormatEmail(ExtentTest test) {
		String EmailWrongFormat = getHtml5ValidationMessage1(local_driver.findElement(By.xpath(eleEmail)));
		Assert.assertEquals(EmailWrongFormat, "Please include an '@' in the email address. 'Toi.com' is missing an '@'.");
		test.info("Compare validation");
	}
	
	public void ComparevalidationEmtyEmail(ExtentTest test) {
		String EmailEmtyMess = getHtml5ValidationMessage1(local_driver.findElement(By.xpath(eleEmail)));
		Assert.assertEquals(EmailEmtyMess, "Please fill out this field.");
		test.info("Compare validation");
	}
	
	public void ComparevalidationEmtyPass(ExtentTest test) {
		String EmailEmtyPass = getHtml5ValidationMessage1(local_driver.findElement(By.xpath(elePass)));
		Assert.assertEquals(EmailEmtyPass, "Please fill out this field.");
		test.info("Compare validation");
	}
	
	public void ComparevalidationWrongEmail(ExtentTest test) {
		WebElement getMess= local_driver.findElement(By.xpath(xpathlMess));
		String actualMess = getMess.getText();
		Assert.assertEquals(actualMess, Expectalert);
		test.info("Compare validation");		
	}
	
	public void ComparevalidationWrongPass(ExtentTest test) {
		WebElement getMess= local_driver.findElement(By.xpath(xpathlMess));
		String actualMess = getMess.getText();
		Assert.assertEquals(actualMess, Expectalert);
		test.info("Compare validation");
	}
	
	public void CompareMessSuccessfuly(ExtentTest test) {
		WebElement getMess = local_driver.findElement(By.xpath(xpathMess));
		String ActualMess = getMess.getText();
		Assert.assertEquals(ActualMess, ExpectMess);
		test.info("Compare validation");
	}
	
	public void ComparePageLogout(ExtentTest test) {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		func.element_click(local_driver, test, xpathLogout);
		JavascriptExecutor js = (JavascriptExecutor) local_driver;// declare javascript
		String currentURL = (String) js.executeScript("return window.location.href"); // get current URL
		Assert.assertEquals(currentURL, ExpectURL); // compare URL
		test.info("Compare validation Current");
	}
	
	

}
