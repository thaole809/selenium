package com.automation.pom.pages;

import org.openqa.selenium.WebDriver;

import com.automation.base.PageAction;
import com.automation.utils.PropertiesFileUtils;
import com.automation.utils.WebElementOfPropFile;

public class TopMenu extends PageAction {

	public TopMenu(WebDriver driver) {
		super(driver);
	}

	public void clickLogin() throws Exception {
		this.clickButton(WebElementOfPropFile.findElement(driver, "signup_ico"));
		waitInSeconds();
	}

	public void clickLogout() throws Exception {
		this.clickButton(WebElementOfPropFile.findElement(driver, "signout_ico"));
		waitInSeconds();
	}

	@Override
	public String getURL() {
		return PropertiesFileUtils.getStringVal("base_url");
	}
	
}
