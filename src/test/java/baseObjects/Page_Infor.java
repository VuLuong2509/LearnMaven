package baseObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Commons.CommonFunc;
import Commons.Data;

public class Page_Infor {
	//Xpath
			String xpathLinkProduct = "//a[@href='#Women']";
			String xpathDressWM = "//a[@href='/category_products/1']";
			String xpathProD1 = "//a[@href='/product_details/3']";
			String URL = "https://automationexercise.com/";
			String xpathNameProduct = "(//h2)[3]";
			String xpathCateProduct = "(//p)[3]";
			String xpathPriceProduct = "(//span)[12]/span";
			String xpathAvailabilityProduct = "//div[@class='product-information']/p[2]";
			String xpathConditionProduct = "//div[@class='product-information']/p[3]";
			String xpathBrandProduct = "//div[@class='product-information']/p[4]";
			
			Data excel = new Data();
			
			CommonFunc func = new CommonFunc();
			WebDriver local_driver;
			ExtentTest local_test;
			public Page_Infor(WebDriver driver, ExtentTest test) {
				local_driver = driver;
				local_test = test;
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			public ExtentTest getLocal_test() {
				return local_test;
			}



			public void setLocal_test(ExtentTest local_test) {
				this.local_test = local_test;
			}



			public void access_URL() {
				func.open_url(local_driver, local_test, URL);
				
			}
			
			public void access_linkProduct() {
				func.element_click(local_driver, local_test, xpathLinkProduct);		
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			public void access_ProductDressWM() {
				func.element_click(local_driver, local_test, xpathDressWM);
			}
			
			public void access_ProductD1() {
				func.element_click(local_driver, local_test, xpathProD1);
			}
			
			public void compare_NameProduct() {
				String readdata = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 1);
				System.out.println("data is " + readdata);
				WebElement VrfNameProduct =  local_driver.findElement(By.xpath(xpathNameProduct));
				String Name = VrfNameProduct.getText();
				Assert.assertEquals(Name, readdata);
				System.out.println("Verify Name Product");
				local_test.info("Product Name: " + Name);
			}
			
			public void compare_CateProduct() {
				String readdata1 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 2);
				System.out.println("data is " + readdata1);
				WebElement VrfCateProduct = local_driver.findElement(By.xpath(xpathCateProduct));
				String Cata = VrfCateProduct.getText();
				Assert.assertEquals(Cata, readdata1);
				System.out.println("Verify Category Product");
				local_test.info("Cate Product: " + Cata);
			}
			
			public void compare_PriceProduct() {
				String readdata2 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 3);
				System.out.println("data is " + readdata2);
				WebElement VrfPriceProdct = local_driver.findElement(By.xpath(xpathPriceProduct));
				String Price = VrfPriceProdct.getText();
				Assert.assertEquals(Price, readdata2);
				System.out.println("Verify Price Product");
				local_test.info("Price product: " + Price);
			}
			
			public void compare_AvailabilityProduct() {
				String readdata3 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 4);
				System.out.println("data is " + readdata3);
				WebElement VrfAvailabilityProduct = local_driver.findElement(By.xpath(xpathAvailabilityProduct));
				String Availability = VrfAvailabilityProduct.getText();
				Assert.assertEquals(Availability, readdata3);
				System.out.println("Verify Availability Product");
				local_test.info("Availability product: " + Availability);
			}
			
			public void compare_ConditionProduct() {
				String readdata4 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 5);
				System.out.println("data is " + readdata4);
				WebElement VrfConditionProduct = local_driver.findElement(By.xpath(xpathConditionProduct));
				String Condition = VrfConditionProduct.getText();
				Assert.assertEquals(Condition, readdata4);
				System.out.println("Verify Condition Product");
				local_test.info("Condition product: " + Condition);
			}
			
			public void compare_BrandProduct() {
				String readdata5 = excel.DataExcel("./Resources/Data.xlsx", "Sheet1", 5, 6);
				System.out.println("data is " + readdata5);
				WebElement VrfBrandProduct = local_driver.findElement(By.xpath(xpathBrandProduct));
				String Brand = VrfBrandProduct.getText();
				Assert.assertEquals(Brand, readdata5);
				System.out.println("Verify Brand Product");
				local_test.info("Brand product: " + Brand);
			}
			
			

}
