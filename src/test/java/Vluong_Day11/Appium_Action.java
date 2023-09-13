package Vluong_Day11;

import org.testng.annotations.Test;



import Commons.CommonService;

import baseObjects.App_Appium;

public class Appium_Action extends CommonService{
	App_Appium app;
	
	@Test
	public void DemoApp() {
		test = extent.createTest("DemoApp");
		app = new App_Appium(mddriver, test);
		app.clickbtnAccess();
		app.Backbtn();
		app.clickbtnApp();
	}
 
}
