package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.TCResult;

public class Verify {

	public static void printMethodInfo(String... params) {
		System.out.print("\n" + Thread.currentThread().getStackTrace()[2].getMethodName() + " - Params: ");
		for (String item : params) {
			System.out.print(" - " + item);
		}
	}

	public static TCResult validateElm_Exist(WebDriver driver, String confFileValue) {
		printMethodInfo(confFileValue);
		try {
			WebElementOfPropFile.findElement(driver, confFileValue);
		} catch (Exception ex) {
			return TCResult.initFailed("Not able to find out Element");
		}
		return TCResult.initPassed();
	}

	public static TCResult validateElm_ContainsValue(WebDriver driver, String confFileValue, String value) {
		printMethodInfo(confFileValue);
		try {
			WebElement element = WebElementOfPropFile.findElement(driver, confFileValue);
			if (element.getAttribute("value").equalsIgnoreCase(value)) {
				return TCResult.initPassed();
			}
		} catch (Exception ex) {
			return TCResult.initFailed("Not able to find out Element");
		}
		return TCResult.initFailed("This value is not found");
	}
}
