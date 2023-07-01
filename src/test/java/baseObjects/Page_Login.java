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
	ExtentTest local_test;
	public Page_Login(WebDriver driver, ExtentTest test) {
		local_driver = driver;
		local_test = test;
	}
	//handel HTML5 Validation by javascript
	//Research from https://vntesters.com/java-webdriver-14-kiem-tra-html5-validation-message/
	public String getHtml5ValidationMessage1(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) local_driver;// declare javascript
		return (String) js.executeScript("return arguments[0].validationMessage;", element);
		}
	// Action
	
	public void access_URL() {
		func.open_url(local_driver, local_test, URL);
	}
	
	public void input_mail(String input_values) {
		func.element_sendkey(local_driver, local_test, eleEmail, input_values);
	}

	public void input_pass(String input_values) {
		func.element_sendkey(local_driver, local_test, elePass, input_values);
	}

	public void access_login() {
		func.element_click(local_driver, local_test, xpathLogin);
	}

	public void click_login() {
		func.element_click(local_driver, local_test, btnLogin);
	}
	
	public void click_logout() {
		func.element_click(local_driver, local_test, xpathLogout);
		
	}
	
	public void ComparevalidationhWrongFormatEmail() {
		String EmailWrongFormat = getHtml5ValidationMessage1(local_driver.findElement(By.xpath(eleEmail)));
		Assert.assertEquals(EmailWrongFormat, "Please include an '@' in the email address. 'Toi.com' is missing an '@'.");
		local_test.info("Compare validation");
	}
	
	public void ComparevalidationEmtyEmail() {
		String EmailEmtyMess = getHtml5ValidationMessage1(local_driver.findElement(By.xpath(eleEmail)));
		Assert.assertEquals(EmailEmtyMess, "Please fill out this field.");
		local_test.info("Compare validation");
	}
	
	public void ComparevalidationEmtyPass() {
		String EmailEmtyPass = getHtml5ValidationMessage1(local_driver.findElement(By.xpath(elePass)));
		Assert.assertEquals(EmailEmtyPass, "Please fill out this field.");
		local_test.info("Compare validation");
	}
	
	public void ComparevalidationWrongEmail() {
		WebElement getMess= local_driver.findElement(By.xpath(xpathlMess));
		String actualMess = getMess.getText();
		Assert.assertEquals(actualMess, Expectalert);
		local_test.info("Compare validation");		
	}
	
	public void ComparevalidationWrongPass() {
		WebElement getMess= local_driver.findElement(By.xpath(xpathlMess));
		String actualMess = getMess.getText();
		Assert.assertEquals(actualMess, Expectalert);
		local_test.info("Compare validation");
	}
	
	public void CompareMessSuccessfuly() {
		WebElement getMess = local_driver.findElement(By.xpath(xpathMess));
		String ActualMess = getMess.getText();
		Assert.assertEquals(ActualMess, ExpectMess);
		local_test.info("Compare validation");
	}
	
	public void ComparePageLogout() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		func.element_click(local_driver, local_test, xpathLogout);
		JavascriptExecutor js = (JavascriptExecutor) local_driver;// declare javascript
		String currentURL = (String) js.executeScript("return window.location.href"); // get current URL
		Assert.assertEquals(currentURL, ExpectURL); // compare URL
		local_test.info("Compare validation Current");
	}
	
	

}
