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
import Commons.ManageObj;
import baseObjects.Page_Register;

import org.openqa.selenium.JavascriptExecutor;


public class RegisterUser extends CommonService{
	Page_Register Pregis;

	
	@Test
	public void TC_001RegisterNewUser() {
		test = extent.createTest("TC_001RegisterNewUser");
		Pregis = ManageObj.ManageObj_Pregis_Object(driver, test);
		// Random
		Random Ran = new Random();
		Integer RanInt = Ran.nextInt(1000);			
		// Teststep
		Pregis.access_Page();				
		Pregis.click_linkLogin();
		Pregis.input_Name("Toivat" + RanInt);				
		Pregis.input_Email("Toivaot" + RanInt + "@gmail.com");
		Pregis.click_btnSignUp();
		Pregis.click_RaTitle();
		test.info("Click Title");
		Pregis.input_Passinfor("Abc123456");		
		Pregis.select_Inforday();
		Pregis.click_Special();
		Pregis.input_FistN("Luong");
		Pregis.input_LastN("Vu");
		Pregis.input_Company("AutoLearn");
		Pregis.input_Address1("1st Wesminter");
		Pregis.input_Address2("2nd Wesminter");
		Pregis.select_Country();		
		Pregis.input_State("Something");
		Pregis.input_City("HCM");
		Pregis.input_Zip("70000");
		Pregis.input_Number("090762" + RanInt);

		Pregis.click_BtnCreate();
		Pregis.compare_MessCreate();
	}
	
	@Test
	public void TC_002RegisterNewUserWithExistingEmail() {
		test = extent.createTest("TC_002RegisterNewUserWithExistingEmail");
		Pregis = ManageObj.ManageObj_Pregis_Object(driver, test);
		Pregis.access_Page();
		Pregis.click_logout();
		Pregis.click_linkLogin();
		Pregis.input_Name("Toivat");
		Pregis.input_Email("Toi@gmail.com");
		Pregis.click_btnSignUp();		
		Pregis.compare_MessExist();
	}

	


	
	
}
