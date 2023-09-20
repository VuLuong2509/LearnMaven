package baseObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Commons.CommonFunc;
import Commons.Data;

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
			String xpathbtnContinue = "//a[@data-qa='continue-button']";	
			String xpathLogout = "//a[@href='/logout']";

			String xpathMess = "//p[@style='color: red;']";
			String expectMess = "Email Address already exist!";
			
			Data excel = new Data();
			//URL
			String URL = "https://automationexercise.com/";			
			CommonFunc func = new CommonFunc();
			WebDriver local_driver;
			ExtentTest local_test;
			public Page_Register(WebDriver driver, ExtentTest test) {
				local_driver = driver;
				local_test = test;
			}
			
			
			
			public ExtentTest getLocal_test() {
				return local_test;
			}



			public void setLocal_test(ExtentTest local_test) {
				this.local_test = local_test;
			}

			Random Ran = new Random();
			Integer RanInt = Ran.nextInt(1000);

			public void access_Page() {
				func.open_url(local_driver,local_test, URL);
			}
			
			public void click_linkLogin() {
				func.element_click(local_driver,local_test, xpathLogin);
			}
			
			public void input_Name() {
				String readdataName = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 0);
				func.element_sendkey(local_driver,local_test, xpathName, readdataName + RanInt);
			}
			
			public void input_Email() {
				String readdataEmail = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 1);
				func.element_sendkey(local_driver,local_test, xpathEmail, readdataEmail + RanInt + "@gmail.com");
			}
			
			public void input_EmailExist(String data) {
				func.element_sendkey(local_driver, local_test, xpathEmail, data);
			}
			
			public void click_btnSignUp() {
				func.element_click(local_driver,local_test, xpathBtnSignUp);
			}
			
			public void click_RaTitle() {
				func.element_click(local_driver,local_test, xpathTileInfor);
			}
			
			public void input_Passinfor() {
				String readdataPass = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 2);
				func.element_sendkey(local_driver,local_test, xpathPassInfor, readdataPass);
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
			
			public void input_FistN() {
				String readdataFirstN = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 3);
				func.element_sendkey(local_driver,local_test, xpathFistNinfor, readdataFirstN);
			}
			
			public void input_LastN() {
				String readdataLastN = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 4);
				func.element_sendkey(local_driver,local_test, xpathLastNinfor, readdataLastN);
			}
			
			public void input_Company() {
				String readdataCompany = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 5);
				func.element_sendkey(local_driver,local_test, xpathCompanyInfor, readdataCompany);
			}
			
			public void input_Address1() {
				String readdataAddress1 = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 6);
				func.element_sendkey(local_driver,local_test, xpathAddress1Infor, readdataAddress1);
			}
			
			public void input_Address2() {
				String readdataAddress2 = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 7);
				func.element_sendkey(local_driver,local_test, xpathAddress2Infor, readdataAddress2);
			}
			
			public void select_Country() {
				Random Ran2 = new Random();
				Integer ranCountry = Ran2.nextInt(6);
				func.element_select(local_driver, local_test, xpathCountryInfor, ranCountry);
			}
			
			public void input_State() {
				String readdataState = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 8);
				func.element_sendkey(local_driver,local_test, xpathStateInfor, readdataState);
			}
			
			public void input_City() {
				String readdataCity = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 9);
				func.element_sendkey(local_driver,local_test, xpathCityInfor, readdataCity);
			}
			
			public void input_Zip() {
				String readdataZip = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 10);
				func.element_sendkey(local_driver,local_test, xpathZipInfor, readdataZip);
			}
			
			public void input_Number() {
				String readdataNumber = excel.DataExcel("./Resources/Data.xlsx", "Sheet2", 1, 11);
				func.element_sendkey(local_driver,local_test, xpathphoneNumInfor, readdataNumber + RanInt);
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
			
			public void click_Continue() {
				func.element_click(local_driver, local_test, xpathbtnContinue);
			}
			
			public void compare_MessCreate() {
				WebElement eleMess = local_driver.findElement(By.xpath(xpathMesstitle));
				String ActualMess = eleMess.getText();
				Assert.assertEquals(ActualMess, ExpectMessCreate);
			}
			
			public void Wail_ele_logout() {
				func.Wait_element(local_driver, xpathLogout);
			}
			
			public void Wait_Ele() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
