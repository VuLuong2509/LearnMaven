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
			public Page_Register(WebDriver driver) {
				local_driver = driver; 
			}
			
			public void access_Page(ExtentTest test) {
				func.open_url(local_driver, test, URL);
			}
			
			public void click_linkLogin(ExtentTest test) {
				func.element_click(local_driver, test, xpathLogin);
			}
			
			public void input_Name(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathName, input_values);
			}
			
			public void input_Email(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathEmail, input_values);
			}
			
			public void click_btnSignUp(ExtentTest test) {
				func.element_click(local_driver, test, xpathBtnSignUp);
			}
			
			public void click_RaTitle(ExtentTest test) {
				func.element_click(local_driver, test, xpathTileInfor);
			}
			
			public void input_Passinfor(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathPassInfor, input_values);
			}
			
			public void select_Inforday(ExtentTest test){
				WebElement EleDay = local_driver.findElement(By.xpath(xpathDayInfor));
				Select seDay = new Select(EleDay);
				seDay.selectByVisibleText("25");
				String SelectDay = EleDay.getText();
				test.info("Select Day" + SelectDay);
				WebElement EleMonth = local_driver.findElement(By.xpath(xpathMonthInfo));
				Select seMonth = new Select(EleMonth);
				seMonth.selectByVisibleText("September");
				WebElement EleYear = local_driver.findElement(By.xpath(xpathYearInfo));
				Select seYear = new Select(EleYear);
				seYear.selectByVisibleText("1993");
			}
			
			public void click_Newlet(ExtentTest test) {
				func.element_click(local_driver, test, xpathNewsletInfor);
			}
			
			public void click_Special(ExtentTest test) {
				func.element_click(local_driver, test, xpathSpecialInfor);
			}
			
			public void input_FistN(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathFistNinfor, input_values);
			}
			
			public void input_LastN(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathLastNinfor, input_values);
			}
			
			public void input_Company(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathCompanyInfor, input_values);
			}
			
			public void input_Address1(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathAddress1Infor, input_values);
			}
			
			public void input_Address2(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathAddress2Infor, input_values);
			}
			
			public void select_Country(ExtentTest test) {
				Random Ran2 = new Random();
				Integer ranCountry = Ran2.nextInt(6);
				WebElement eleCountry = local_driver.findElement(By.xpath(xpathCountryInfor));
				Select seCountry = new Select(eleCountry);
				seCountry.selectByIndex(ranCountry);
			}
			
			public void input_State(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathStateInfor, input_values);
			}
			
			public void input_City(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathCityInfor, input_values);
			}
			
			public void input_Zip(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathZipInfor, input_values);
			}
			
			public void input_Number(ExtentTest test, String input_values) {
				func.element_sendkey(local_driver, test, xpathphoneNumInfor, input_values);
			}
			
			public void compare_MessExist(ExtentTest test) {
				WebElement getMEss= local_driver.findElement(By.xpath(xpathMess));
				String AcutalMess = getMEss.getText();
				Assert.assertEquals(AcutalMess, expectMess);
				test.info("Enter Compare Mess");
			}
			
			public void click_logout(ExtentTest test) {
				func.element_click(local_driver, test, xpathLogout);				
			}
			
			public void click_BtnCreate(ExtentTest test) {
				func.element_click_byJS(local_driver, test, xpathBtnCreate);		
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
