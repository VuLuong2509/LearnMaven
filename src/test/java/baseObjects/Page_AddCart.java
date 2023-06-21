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
	public  Page_AddCart(WebDriver driver) {
		local_driver = driver; 
	}
	
	public void access_URL(ExtentTest test) {
		func.open_url(local_driver, test, URL);
	}
	public void click_btnCart(ExtentTest test) {		
		func.element_click_byJS(local_driver, test, xpathAddcart);
	}
	
	public void click_btnContinue(ExtentTest test) {		
		func.element_click_byJS(local_driver, test, xpathbtnContinue);
	}
	
	public void compareMessPopup(ExtentTest test) {
		JavascriptExecutor js = (JavascriptExecutor)local_driver;
		WebElement setText = local_driver.findElement(By.xpath(xpathPopupAdd));
//		String setF = (String) js.executeScript("return arguments[0].value='Hello'", setText);
		String checkF = (String) js.executeScript("return arguments[0].textContent", setText);
		System.out.println(checkF);
		Assert.assertEquals(checkF, "Added!");
		test.info("Compare validation");
	}
	
	public void access_inCart(ExtentTest test) {
		func.element_click(local_driver, test, xpathCart);
	}
	
	public void getquanlity(ExtentTest test) {
		WebElement Quantity = local_driver.findElement(By.xpath(xpathQuantity));
		String SetQuan = Quantity.getText();
		Assert.assertEquals(SetQuan, func.getAttributeValues(local_driver, xpathQuantity, "textContent"));
		test.info("Compare Product Quantity");
	}
	
	public void Remove_Product(ExtentTest test) {
		func.element_click(local_driver, test, xpathRemove);
		
	}
	
	public void MessEmptyCart(ExtentTest test) {
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
		test.info("Compare Mess InCart");
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
	
	public void click_btncheckOut(ExtentTest test) {
		func.element_click(local_driver, test, xpathbtCheckOut);
	}
	
	public void click_btnOrder(ExtentTest test) {
		func.element_click(local_driver, test, xpathbtnOrder);
	}
	
	public void input_nameCard(ExtentTest test, String input_values) {
		func.element_sendkey(local_driver, test, xpathNameCard, input_values);
	}
	
	public void input_numberCard(ExtentTest test, String input_values) {
		func.element_sendkey(local_driver, test, xpathNumberCard, input_values);
	}
	
	public void input_cvcCard(ExtentTest test, String input_values) {
		func.element_sendkey(local_driver, test, xpathCVC, input_values);
	}
	
	public void input_MonthCard(ExtentTest test, String input_values) {
		func.element_sendkey(local_driver, test, xpathMM, input_values);
	}
	
	public void input_YearCard(ExtentTest test, String input_values) {
		func.element_sendkey(local_driver, test, xpathYY, input_values);
	}
	
	public void click_cfOrder(ExtentTest test) {
		func.element_click(local_driver, test, xpathConfirmOrder);
	}
	
	public void MessConfirm(ExtentTest test) {
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
		test.info("Compare Mess Confirmed Order");
	}
}
