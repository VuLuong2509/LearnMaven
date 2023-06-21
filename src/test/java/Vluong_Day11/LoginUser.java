package Vluong_Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Commons.CommonService;
import baseObjects.Page_Login;

public class LoginUser extends CommonService{	


	
	Page_Login Plogin;

	@BeforeMethod
	public void initdata() {
		Plogin = new Page_Login(driver);
	}
	@Test
	public void TC_003LoginWithWrongFormatEmail(){
		test = extent.createTest("TC_003LoginWithWrongFormatEmail");						
		Plogin.access_URL(test);	
		Plogin.access_login(test);
		Plogin.input_mail(test, "Toi.com");
		Plogin.input_pass(test, "8438126");
		Plogin.click_login(test);
		Plogin.ComparevalidationhWrongFormatEmail(test);

	}
	
	@Test
	public void TC_004LoginWithEmtyEmail(){
		test = extent.createTest("TC_004LoginWithEmtyEmail");		
		Plogin.access_URL(test);	
		Plogin.access_login(test);
		Plogin.input_mail(test, "");
		Plogin.input_pass(test, "8438126");
		Plogin.click_login(test);
		Plogin.ComparevalidationEmtyEmail(test);
	}
	
	@Test
	public void TC_005LoginWithEmtyPass(){
		test = extent.createTest("TC_005LoginWithEmtyPass");
		Plogin.access_URL(test);	
		Plogin.access_login(test);
		Plogin.input_mail(test, "Toi@gmail.com");
		Plogin.input_pass(test, "");
		Plogin.click_login(test);
		Plogin.ComparevalidationEmtyPass(test);
	}
	
	@Test
	public void TC_006LoginWithWrongEmail(){
		test = extent.createTest("TC_006LoginWithWrongEmail");
		Plogin.access_URL(test);	
		Plogin.access_login(test);
		Plogin.input_mail(test, "lqhv@gmail.com");
		Plogin.input_pass(test, "848126");
		Plogin.click_login(test);
		Plogin.ComparevalidationWrongEmail(test);
	}
	
	@Test
	public void TC_007LoginWithWrongPass(){
		test = extent.createTest("TC_007LoginWithWrongPass");
		Plogin.access_URL(test);	
		Plogin.access_login(test);
		Plogin.input_mail(test, "Toi@gmail.com");
		Plogin.input_pass(test, "234234");
		Plogin.click_login(test);
		Plogin.ComparevalidationWrongPass(test);		
	}
	
	@Test
	public void TC_008LoginSuccessfuly(){
		test = extent.createTest("TC_008LoginSuccessfuly");
		Plogin.access_URL(test);	
		Plogin.access_login(test);
		Plogin.input_mail(test, "Toi@gmail.com");
		Plogin.input_pass(test, "8438126");
		Plogin.click_login(test);
		Plogin.CompareMessSuccessfuly(test);
	}
	 
	@Test
	public void TC_009UserCanLogout(){
		test = extent.createTest("TC_009UserCanLogout");		
		Plogin.access_URL(test);
		Plogin.click_logout(test);
		Plogin.access_login(test);
		Plogin.input_mail(test, "Toi@gmail.com");
		Plogin.input_pass(test, "8438126");
		Plogin.click_login(test);
		Plogin.ComparePageLogout(test);		
	}

}
