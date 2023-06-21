package Vluong_Day11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Commons.CommonFunc;
import Commons.CommonService;
import baseObjects.Page_AddCart;
import baseObjects.Page_Login;

public class AddCart extends CommonService{
	Page_AddCart PAdd;
	@BeforeMethod
	public void initdata() {
		PAdd = new Page_AddCart(driver);
	}
	@Test
	public void TC_011VerifySubscriptioninCartpage() {
		test = extent.createTest("TC_011VerifySubscriptioninCartpage");
		PAdd.access_URL(test);
		PAdd.click_btnCart(test);
		PAdd.click_btnContinue(test);
		PAdd.compareMessPopup(test);
	}
	@Test
	public void TC_012VerifyMoreProductsOfTheSametype() {
		test = extent.createTest("TC_012VerifyMoreProductsOfTheSametype");
		PAdd.access_URL(test);
		PAdd.click_btnCart(test);
		PAdd.click_btnContinue(test);
		PAdd.click_btnCart(test);
		PAdd.compareMessPopup(test);
	}
	@Test
	public void TC_013VerifyProductsQuantityInCart() {
		test = extent.createTest("TC_013VerifyProductsQuantityInCart");
		PAdd.access_URL(test);
		PAdd.click_btnCart(test);
		PAdd.click_btnContinue(test);
		PAdd.click_btnCart(test);
		PAdd.compareMessPopup(test);
		PAdd.access_inCart(test);
		PAdd.getquanlity(test);
	}
	@Test
	public void TC_014VerifyRemoveProductsInCart() {
		test = extent.createTest("TC_014VerifyRemoveProductsInCart");
		PAdd.access_URL(test);
		PAdd.click_btnCart(test);
		PAdd.click_btnContinue(test);
		PAdd.click_btnCart(test);
		PAdd.compareMessPopup(test);
		PAdd.access_inCart(test);
		PAdd.Remove_Product(test);
		PAdd.MessEmptyCart(test);
	}
	@Test
	public void TC_015VerifyCheckOutInCart() {
		test = extent.createTest("TC_015VerifyCheckOutInCart");
		PAdd.access_URL(test);
		PAdd.access_login(test);
		PAdd.input_mail(test, "Toi@gmail.com");
		PAdd.input_pass(test, "8438126");
		PAdd.click_login(test);
		PAdd.click_btnCart(test);
		PAdd.click_btnContinue(test);
		PAdd.access_inCart(test);
		PAdd.click_btncheckOut(test);
		PAdd.click_btnOrder(test);
		PAdd.input_nameCard(test, "AutomaTion");
		PAdd.input_numberCard(test, "1234567687");
		PAdd.input_cvcCard(test, "234");
		PAdd.input_MonthCard(test, "25");
		PAdd.input_YearCard(test, "24");
		PAdd.click_cfOrder(test);
		PAdd.MessConfirm(test);
	}
	
	
	
}
