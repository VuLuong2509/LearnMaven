package baseObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Commons.CommonFunc;

public class Page_Register {
	//Xpath Element
			String xpathLogin = "//a[@href='/login']";
			String xpathName = "//input[@name='name']"; // Name Element on "New User SignUp!" Table
			String xpathEmail = "//input[@data-qa='signup-email']"; // Email Element on "New User SignUp!" Table
			String xpathBtnSignUp = "//button[@data-qa='signup-button']"; // SignUp Element on "New User SignUp!" Table
			// Element on "ENTER ACCOUNT INFORMATION" page
			String xpathTileInfor = "//input[@id=\"id_gender1\"]"; 
			String xpathNameInfor = "//input[@id=\"name\"]";
			String xpathEmailInfor = "//input[@id=\"email\"]";
			String xpathPassInfor = "//input[@id=\"password\"]";
			String xpathDayInfor = "//select[@id='days']";
			String xpathMonthInfo = "//select[@id='months']";
			String xpathYearInfo = "//select[@id='years']";
			String xpathNewsletInfor = "//input[@id='newsletter']";
			String xpathSpecialInfor = "//input[@id='optin']";
			// ADDRESS INFORMATION
			String xpathFistNinfor = "//input[@id='first_name']";
			String xpathLastNinfor = "//input[@id='last_name']";
			String xpathCompanyInfor = "//input[@id='company']";
			String xpathAddress1Infor = "//input[@id='address1']";
			String xpathAddress2Infor = "//input[@id='address2']";
			String xpathCountryInfor = "//select[@id='country']";
			String xpathStateInfor = "//input[@id='state']";
			String xpathCityInfor = "//input[@id='city']";
			String xpathZipInfor = "//input[@id='zipcode']";
			String xpathphoneNumInfor = "//input[@id='mobile_number']";
			String xpathBtnCreate = "//button[@data-qa='create-account']";
			String xpathMesstitle = "//h2[@class='title text-center']";
			String ExpectMessCreate = "ACCOUNT CREATED!";
			
			String xpathLogout = "//a[@href='/logout']";

			String xpathMess = "//p[@style='color: red;']";
			String expectMess = "Email Address already exist!";
			//URL
			String URL = "https://automationexercise.com/";			
			CommonFunc func = new CommonFunc();
			WebDriver local_driver;
			ExtentTest local_test;
			public Page_Register(WebDriver driver, ExtentTest test) {
				local_driver = driver;
				local_test = test;
			}
			
		
			
			public void access_Page() {
				func.open_url(local_driver,local_test, URL);
			}
			
			public void click_linkLogin() {
				func.element_click(local_driver,local_test, xpathLogin);
			}
			
			public void input_Name(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathName, input_values);
			}
			
			public void input_Email(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathEmail, input_values);
			}
			
			public void click_btnSignUp() {
				func.element_click(local_driver,local_test, xpathBtnSignUp);
			}
			
			public void click_RaTitle() {
				func.element_click(local_driver,local_test, xpathTileInfor);
			}
			
			public void input_Passinfor(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathPassInfor, input_values);
			}
			
			public void select_Inforday(){
				WebElement EleDay = local_driver.findElement(By.xpath(xpathDayInfor));
				Select seDay = new Select(EleDay);
				seDay.selectByVisibleText("25");
				String SelectDay = EleDay.getText();
				WebElement EleMonth = local_driver.findElement(By.xpath(xpathMonthInfo));
				Select seMonth = new Select(EleMonth);
				seMonth.selectByVisibleText("September");
				WebElement EleYear = local_driver.findElement(By.xpath(xpathYearInfo));
				Select seYear = new Select(EleYear);
				seYear.selectByVisibleText("1993");
				
			}
			
			public void click_Newlet() {
				func.element_click(local_driver,local_test, xpathNewsletInfor);
			}
			
			public void click_Special() {
				func.element_click(local_driver,local_test, xpathSpecialInfor);
			}
			
			public void input_FistN(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathFistNinfor, input_values);
			}
			
			public void input_LastN(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathLastNinfor, input_values);
			}
			
			public void input_Company(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathCompanyInfor, input_values);
			}
			
			public void input_Address1(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathAddress1Infor, input_values);
			}
			
			public void input_Address2(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathAddress2Infor, input_values);
			}
			
			public void select_Country() {
				Random Ran2 = new Random();
				Integer ranCountry = Ran2.nextInt(6);
				func.element_select(local_driver, local_test, xpathCountryInfor, ranCountry);
			}
			
			public void input_State(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathStateInfor, input_values);
			}
			
			public void input_City(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathCityInfor, input_values);
			}
			
			public void input_Zip(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathZipInfor, input_values);
			}
			
			public void input_Number(String input_values) {
				func.element_sendkey(local_driver,local_test, xpathphoneNumInfor, input_values);
			}
			
			public void compare_MessExist() {
				WebElement getMEss= local_driver.findElement(By.xpath(xpathMess));
				String AcutalMess = getMEss.getText();
				Assert.assertEquals(AcutalMess, expectMess);
				local_test.info("Enter Compare Mess");
			}
			
			public void click_logout() {
				func.element_click(local_driver,local_test, xpathLogout);				
			}
			
			public void click_BtnCreate() {
				func.element_click_byJS(local_driver,local_test, xpathBtnCreate);		
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public void compare_MessCreate() {
				WebElement eleMess = local_driver.findElement(By.xpath(xpathMesstitle));
				String ActualMess = eleMess.getText();
				Assert.assertEquals(ActualMess, ExpectMessCreate);
			}
}
