package baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Commons.CommonFunc;
import Commons.Data;

public class Page_AddCart {
	Data excel = new Data();
//	xpath
	String xpathAddcart = "(//a[@class='btn btn-default add-to-cart'])[1]";
	String xpathPopupAdd = "//h4[@class='modal-title w-100']";
	String xpathbtnContinue = "//button[@class='btn btn-success close-modal btn-block']";
	String xpathCart = "(//a[@href='/view_cart'])[1]";
	String xpathCartPopup = "(//a[@href='/view_cart'])[2]";
	String xpathHome = "(//a[@href='/'])[2]";
	String xpathQuantity = "//td[@class='cart_quantity']/button";
	String xpathRemove = "//td[@class='cart_delete']/a";
	String xpathMessEmty = "//p[@class='text-center']/b";
	String xpathLogin = "//a[@href='/login']";
	String xpathbtCheckOut = "//a[@class='btn btn-default check_out']";
	String xpathbtnOrder = "//a[@class='btn btn-default check_out']";
	String eleEmail = "//input[@data-qa='login-email']";
	String elePass = "//input[@data-qa='login-password']";
	String btnLogin = "//button[@data-qa='login-button']";
	String xpathNameCard = "//input[@name='name_on_card']";
	String xpathNumberCard = "//input[@name='card_number']";
	String xpathCVC = "//input[@name='cvc']";
	String xpathMM = "//input[@name='expiry_month']";
	String xpathYY = "//input[@name='expiry_year']";
	String xpathConfirmOrder = "//button[@id='submit']";
	String xpathMesscf = "//div[@class='col-sm-9 col-sm-offset-1']/p";
	String URL = "https://automationexercise.com/";
	String Iframe ="//iframe[@id='aswift_5']";
	CommonFunc func = new CommonFunc();
	WebDriver local_driver;
	ExtentTest local_test;
	public  Page_AddCart(WebDriver driver, ExtentTest test) {
		local_driver = driver;
		local_test = test;
	}
	
	public void access_URL() {
		func.open_url(local_driver, local_test, URL);
	}
	public void click_btnCart() {		
		func.element_click_byJS(local_driver, local_test, xpathAddcart);
	}
	
	public void click_btnContinue() {		
		func.element_click_byJS(local_driver, local_test, xpathbtnContinue);
	}
	
	public void compareMessPopup() {
		JavascriptExecutor js = (JavascriptExecutor)local_driver;
		WebElement setText = local_driver.findElement(By.xpath(xpathPopupAdd));
//		String setF = (String) js.executeScript("return arguments[0].value='Hello'", setText);
		String checkF = (String) js.executeScript("return arguments[0].textContent", setText);
		System.out.println(checkF);
		Assert.assertEquals(checkF, "Added!");
		local_test.info("Compare validation");
	}
	
	public void access_inCart() {
		func.element_click(local_driver, local_test, xpathCart);
	}
	
	public void getquanlity() {
		WebElement Quantity = local_driver.findElement(By.xpath(xpathQuantity));
		String SetQuan = Quantity.getText();
		Assert.assertEquals(SetQuan, func.getAttributeValues(local_driver, xpathQuantity, "textContent"));
		local_test.info("Compare Product Quantity");
	}
	
	public void Remove_Product() {
		func.element_click(local_driver, local_test, xpathRemove);
		
	}
	
	public void MessEmptyCart() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement MessinCart = local_driver.findElement(By.xpath(xpathMessEmty));
		String SetMess = MessinCart.getText();
		System.out.println(SetMess);
		Assert.assertEquals(SetMess, MessinCart.getAttribute("textContent"));
		local_test.info("Compare Mess InCart");
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
	
	public void click_btncheckOut() {
		func.element_click(local_driver, local_test, xpathbtCheckOut);
	}
	
	public void click_btnOrder() {
		func.element_click(local_driver, local_test, xpathbtnOrder);
	}
	
	public void input_nameCard(String input_values) {
		func.element_sendkey(local_driver, local_test, xpathNameCard, input_values);
	}
	
	public void input_numberCard(String input_values) {
		func.element_sendkey(local_driver, local_test, xpathNumberCard, input_values);
	}
	
	public void input_cvcCard( String input_values) {
		func.element_sendkey(local_driver, local_test, xpathCVC, input_values);
	}
	
	public void input_MonthCard( String input_values) {
		func.element_sendkey(local_driver, local_test, xpathMM, input_values);
	}
	
	public void input_YearCard(String input_values) {
		func.element_sendkey(local_driver, local_test, xpathYY, input_values);
	}
	
	public void click_cfOrder() {
		func.element_click(local_driver, local_test, xpathConfirmOrder);
	}
	
	public void MessConfirm() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement MesscfOrder = local_driver.findElement(By.xpath(xpathMesscf));
		String SetMesscf = MesscfOrder.getText();
		System.out.println(SetMesscf);
		Assert.assertEquals(SetMesscf, MesscfOrder.getAttribute("textContent"));
		local_test.info("Compare Mess Confirmed Order");
	}
}
