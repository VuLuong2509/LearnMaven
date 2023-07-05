package Vluong_Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Commons.CommonService;
import Commons.ManageObj;
import baseObjects.Page_Login;

public class LoginUser extends CommonService{	


	
	Page_Login Plogin;


	@Test
	public void TC_003LoginWithWrongFormatEmail(){
		test = extent.createTest("TC_003LoginWithWrongFormatEmail");
		Plogin = ManageObj.ManageObj_Plogin_Object(driver, test);
		Plogin.access_URL();	
		Plogin.access_login();
		Plogin.input_mail("Toi.com");
		Plogin.input_pass("8438126");
		Plogin.click_login();
		Plogin.ComparevalidationhWrongFormatEmail();

	}
	
	@Test
	public void TC_004LoginWithEmtyEmail(){
		test = extent.createTest("TC_004LoginWithEmtyEmail");
		Plogin = ManageObj.ManageObj_Plogin_Object(driver, test);
		Plogin.access_URL();	
		Plogin.access_login();
		Plogin.input_mail("");
		Plogin.input_pass("8438126");
		Plogin.click_login();
		Plogin.ComparevalidationEmtyEmail();
	}
	
	@Test
	public void TC_005LoginWithEmtyPass(){
		test = extent.createTest("TC_005LoginWithEmtyPass");
		Plogin = ManageObj.ManageObj_Plogin_Object(driver, test);
		Plogin.access_URL();	
		Plogin.access_login();
		Plogin.input_mail("Toi@gmail.com");
		Plogin.input_pass("");
		Plogin.click_login();
		Plogin.ComparevalidationEmtyPass();
	}
	
	@Test
	public void TC_006LoginWithWrongEmail(){
		test = extent.createTest("TC_006LoginWithWrongEmail");
		Plogin = ManageObj.ManageObj_Plogin_Object(driver, test);
		Plogin.access_URL();	
		Plogin.access_login();
		Plogin.input_mail("lqhv@gmail.com");
		Plogin.input_pass("848126");
		Plogin.click_login();
		Plogin.ComparevalidationWrongEmail();
	}
	
	@Test
	public void TC_007LoginWithWrongPass(){
		test = extent.createTest("TC_007LoginWithWrongPass");
		Plogin = ManageObj.ManageObj_Plogin_Object(driver, test);
		Plogin.access_URL();	
		Plogin.access_login();
		Plogin.input_mail("Toi@gmail.com");
		Plogin.input_pass("234234");
		Plogin.click_login();
		Plogin.ComparevalidationWrongPass();		
	}
	
	@Test
	public void TC_008LoginSuccessfuly(){
		test = extent.createTest("TC_008LoginSuccessfuly");
		Plogin = ManageObj.ManageObj_Plogin_Object(driver, test);
		Plogin.access_URL();	
		Plogin.access_login();
		Plogin.input_mail("Toi@gmail.com");
		Plogin.input_pass("8438126");
		Plogin.click_login();
		Plogin.CompareMessSuccessfuly();
		Plogin.click_logout();
	}
	 
	@Test
	public void TC_009UserCanLogout(){
		test = extent.createTest("TC_009UserCanLogout");
		Plogin = ManageObj.ManageObj_Plogin_Object(driver, test);
		Plogin.access_URL();		
		Plogin.access_login();
		Plogin.input_mail("Toi@gmail.com");
		Plogin.input_pass("8438126");
		Plogin.click_login();
		Plogin.ComparePageLogout();		
	}

}
