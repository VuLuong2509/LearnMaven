package baseObjects;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import Commons.CommonFunc;
import Commons.CommonService;
import Commons.Data;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.PressesKey;

public class App_Appium {
	//xpath 
	String ele_Access = "//*[@content-desc='Text']";
	String ele_app = "//android.widget.TextView[@content-desc=\"App\"]";
	
	CommonFunc func = new CommonFunc();
	AndroidDriver local_driver;
	ExtentTest local_test;
	
	public  App_Appium(AndroidDriver mddriver, ExtentTest test) {
		local_driver = mddriver;
		local_test = test;
	}
	
	public ExtentTest getLocal_test() {
		return local_test;
	}

	public void setLocal_test(ExtentTest local_test) {
		this.local_test = local_test;
	}
	
	public void clickbtnAccess() {
		func.element_click(local_driver, local_test, ele_Access);
		System.out.println("Click btnAccess");
	}
	
	public void clickbtnApp() {
		func.element_click(local_driver, local_test, ele_app);
		System.out.println("Click btnApp");
	}
	public void Backbtn() {
		local_driver.navigate().back();
	}

}
