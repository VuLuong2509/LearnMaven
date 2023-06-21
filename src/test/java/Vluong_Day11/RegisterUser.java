package Vluong_Day11;



import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Commons.CommonService;
import baseObjects.Page_Register;

import org.openqa.selenium.JavascriptExecutor;


public class RegisterUser extends CommonService{
	Page_Register Pregis;
	@BeforeMethod
	public void initdata() {
		Pregis = new Page_Register(driver);
	}
	
	@Test
	public void TC_001RegisterNewUser() {
		test = extent.createTest("TC_001RegisterNewUser");
	
		// Random
		Random Ran = new Random();
		Integer RanInt = Ran.nextInt(1000);			
		// Teststep
		Pregis.access_Page(test);				
		Pregis.click_linkLogin(test);
		Pregis.input_Name(test, "Toivat" + RanInt);				
		Pregis.input_Email(test,  "Toivaot" + RanInt + "@gmail.com");
		Pregis.click_btnSignUp(test);
		Pregis.click_RaTitle(test);
		test.info("Click Title");
		Pregis.input_Passinfor(test, "Abc123456");		
		Pregis.select_Inforday(test);
		Pregis.click_Special(test);
		Pregis.input_FistN(test, "Luong");
		Pregis.input_LastN(test, "Vu");
		Pregis.input_Company(test, "AutoLearn");
		Pregis.input_Address1(test, "1st Wesminter");
		Pregis.input_Address2(test, "2nd Wesminter");
		Pregis.select_Country(test);		
		Pregis.input_State(test, "Something");
		Pregis.input_City(test, "HCM");
		Pregis.input_Zip(test, "70000");
		Pregis.input_Number(test, "090762" + RanInt);

		Pregis.click_BtnCreate(test);
		Pregis.compare_MessCreate();
	}
	
	@Test
	public void TC_002RegisterNewUserWithExistingEmail() {
		test = extent.createTest("TC_002RegisterNewUserWithExistingEmail");
		Pregis.access_Page(test);
		Pregis.click_logout(test);
		Pregis.click_linkLogin(test);
		Pregis.input_Name(test, "Toivat");
		Pregis.input_Email(test,  "Toi@gmail.com");
		Pregis.click_btnSignUp(test);		
		Pregis.compare_MessExist(test);
	}

	


	
	
}
