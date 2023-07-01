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
import Commons.ManageObj;
import baseObjects.Page_AddCart;
import baseObjects.Page_Login;

public class AddCart extends CommonService{
	Page_AddCart PAdd;
	@Test
	public void TC_011VerifySubscriptioninCartpage() {
		test = extent.createTest("TC_011VerifySubscriptioninCartpage");
		PAdd = ManageObj.ManageObj_PAdd_Object(driver, test);
		PAdd.access_URL();
		PAdd.click_btnCart();
		PAdd.click_btnContinue();
		PAdd.compareMessPopup();
	}
	@Test
	public void TC_012VerifyMoreProductsOfTheSametype() {
		test = extent.createTest("TC_012VerifyMoreProductsOfTheSametype");
		PAdd = ManageObj.ManageObj_PAdd_Object(driver, test);
		PAdd.access_URL();
		PAdd.click_btnCart();
		PAdd.click_btnContinue();
		PAdd.click_btnCart();
		PAdd.compareMessPopup();
	}
	@Test
	public void TC_013VerifyProductsQuantityInCart() {
		test = extent.createTest("TC_013VerifyProductsQuantityInCart");
		PAdd = ManageObj.ManageObj_PAdd_Object(driver, test);
		PAdd.access_URL();
		PAdd.click_btnCart();
		PAdd.click_btnContinue();
		PAdd.click_btnCart();
		PAdd.compareMessPopup();
		PAdd.access_inCart();
		PAdd.getquanlity();
	}
	@Test
	public void TC_014VerifyRemoveProductsInCart() {
		test = extent.createTest("TC_014VerifyRemoveProductsInCart");
		PAdd = ManageObj.ManageObj_PAdd_Object(driver, test);
		PAdd.access_URL();
		PAdd.click_btnCart();
		PAdd.click_btnContinue();
		PAdd.click_btnCart();
		PAdd.compareMessPopup();
		PAdd.access_inCart();
		PAdd.Remove_Product();
		PAdd.MessEmptyCart();
	}
	@Test
	public void TC_015VerifyCheckOutInCart() {
		test = extent.createTest("TC_015VerifyCheckOutInCart");
		PAdd = ManageObj.ManageObj_PAdd_Object(driver, test);
		PAdd.access_URL();
		PAdd.access_login();
		PAdd.input_mail("Toi@gmail.com");
		PAdd.input_pass("8438126");
		PAdd.click_login();
		PAdd.click_btnCart();
		PAdd.click_btnContinue();
		PAdd.access_inCart();
		PAdd.click_btncheckOut();
		PAdd.click_btnOrder();
		PAdd.input_nameCard("AutomaTion");
		PAdd.input_numberCard("1234567687");
		PAdd.input_cvcCard("234");
		PAdd.input_MonthCard("25");
		PAdd.input_YearCard("24");
		PAdd.click_cfOrder();
		PAdd.MessConfirm();
	}
	
	
	
}
