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
		// Teststep
		Pregis.access_Page();				
		Pregis.click_linkLogin();
		Pregis.input_Name();				
		Pregis.input_Email();
		Pregis.click_btnSignUp();
		Pregis.click_RaTitle();
		Pregis.input_Passinfor();		
		Pregis.select_Inforday();
		Pregis.click_Special();
		Pregis.input_FistN();
		Pregis.input_LastN();
		Pregis.input_Company();
		Pregis.input_Address1();
		Pregis.input_Address2();
		Pregis.select_Country();		
		Pregis.input_State();
		Pregis.input_City();
		Pregis.input_Zip();
		Pregis.input_Number();
		Pregis.click_BtnCreate();
		Pregis.compare_MessCreate();
		Pregis.click_Continue();
//		Pregis.Wail_ele_logout();
		Pregis.Wait_Ele();
		Pregis.click_logout();
	}
	
	@Test
	public void TC_002RegisterNewUserWithExistingEmail() {
		test = extent.createTest("TC_002RegisterNewUserWithExistingEmail");
		Pregis = ManageObj.ManageObj_Pregis_Object(driver, test);
		Pregis.access_Page();	
		Pregis.click_linkLogin();
		Pregis.input_Name();
		Pregis.input_EmailExist("Toi@gmail.com");
		Pregis.click_btnSignUp();		
		Pregis.compare_MessExist();
	}

	


	
	
}
