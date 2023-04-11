package com.automation.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.DriverIntance;
import com.automation.base.TCResult;
import com.automation.enums.ETypeWebDriver;
import com.automation.pom.pages.DataGenProvider;
import com.automation.pom.pages.TopMenu;
import com.automation.pom.pages.LoginPage;
import com.automation.utils.PropertiesFileUtils;
import com.automation.utils.Verify;

public class TC_LoginTest extends DriverIntance {

	@Override
	protected ETypeWebDriver getConf() {
		return ETypeWebDriver.CHROME;
	}

	@Override
	protected boolean isMaxWindowSize() {
		return false;
	}

	@Override
	protected int getSecondsInPageLoad() {
		return 30;
	}

	@Override
	protected int getSecondsInQuit() {
		return 0;
	}

	@Test(dataProvider = "Excel", dataProviderClass = DataGenProvider.class)
	public void TC001_LoginFirstAccount(String email, String password) throws Exception {
		printParams(getMethodName(), email, password);
		TopMenu topMenu = PageFactory.initElements(driver, TopMenu.class);
		SoftAssert softAssert = new SoftAssert();

		// mở URL: https://automationexercise.com/products
		driver.get(PropertiesFileUtils.getStringVal("base_url"));

		// đảm bảo người dùng chưa đăng nhập tài khoản
		TCResult result = Verify.validateElm_Exist(driver, "logged_in_as_url");
		softAssert.assertFalse(result.isPassed(), result.message());

		// đăng nhập
		topMenu.clickLogin();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		loginPage.clickSignIn();

		// đảm bảo đăng nhập thành công
		result = Verify.validateElm_Exist(driver, "logged_in_as_url");
		softAssert.assertTrue(result.isPassed(), result.message());

		// đăng xuất
		topMenu.clickLogout();
		
		softAssert.assertAll();
	}
}
