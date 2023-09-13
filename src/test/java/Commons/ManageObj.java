package Commons;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;


import baseObjects.Page_AddCart;
import baseObjects.Page_Infor;
import baseObjects.Page_Login;
import baseObjects.Page_Register;


public class ManageObj {
	public static Page_Login Plogin;
	public static Page_Register Pregis;
	public static Page_Infor Pinfor;
	public static Page_AddCart PAdd;

	
	public static Page_Login ManageObj_Plogin_Object(WebDriver driver, ExtentTest test) {
		if (Plogin==null) {
			Plogin = new Page_Login(driver, test);
		}else {
			if(Plogin.getLocal_test()!=test) {
				Plogin.setLocal_test(test);
			}
		}
		
		return Plogin;
	}
	
	public static Page_Register ManageObj_Pregis_Object(WebDriver driver, ExtentTest test) {
		if (Pregis==null) {
			Pregis = new Page_Register(driver, test);
		}else {
			if(Pregis.getLocal_test()!= test) {
				Pregis.setLocal_test(test);
			}
		}
		return Pregis;
	}
	
	public static Page_Infor ManageObj_Pinfor_Object(WebDriver driver, ExtentTest test) {
		if (Pinfor==null) {
			Pinfor = new Page_Infor(driver, test);
		}else {
			if(Pinfor.getLocal_test()!=test) {
				Pinfor.setLocal_test(test);
			}
		}
		return Pinfor;
	}
	
	public static Page_AddCart ManageObj_PAdd_Object(WebDriver driver, ExtentTest test) {
		if (PAdd==null) {
			PAdd = new Page_AddCart(driver, test);
		}else {
			if(PAdd.getLocal_test()!=test) {
				PAdd.setLocal_test(test);
			}
		}
		return PAdd;
	}
	
}
