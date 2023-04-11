package com.automation.pom.pages;

import org.openqa.selenium.WebDriver;

import com.automation.base.PageAction;
import com.automation.utils.PropertiesFileUtils;
import com.automation.utils.WebElementOfPropFile;

public class LoginPage extends PageAction {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String email) throws Exception {
		this.inputEditText(WebElementOfPropFile.findElement(driver, "login_email_edt"), email);
		waitInSeconds();
	}

	public void setPassword(String password) throws Exception {
		this.inputEditText(WebElementOfPropFile.findElement(driver, "login_password_edt"), password);
		waitInSeconds();
	}

	public void clickSignIn() throws Exception {
		this.clickButton(WebElementOfPropFile.findElement(driver, "login_btn"));
		waitInSeconds();
	}

	public void clickSignOut() throws Exception {
		this.clickButton(WebElementOfPropFile.findElement(driver, "logout_btn"));
		waitInSeconds();
	}

	@Override
	public String getURL() {
		return PropertiesFileUtils.getStringVal("login_url");
	}
}
