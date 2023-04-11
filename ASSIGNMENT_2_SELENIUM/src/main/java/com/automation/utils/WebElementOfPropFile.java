package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.enums.EMap;
import com.automation.enums.ETypeLocator;

public class WebElementOfPropFile {
	public ETypeLocator type;
	public String value;

	public WebElementOfPropFile(ETypeLocator loc, String value) {
		this.type = loc;
		this.value = value;
	}

	public static WebElement findElement(WebDriver driver, String key) throws Exception {
		WebElementOfPropFile elmWithLoc = WebElementOfPropFile.getLocator(key);
		return getElement(driver, elmWithLoc.type, elmWithLoc.value);
	}

	public static WebElement getElement(WebDriver driver, ETypeLocator type, String value) throws Exception {
		WebElement webElement = null;
		try {
			switch (type) {
			case XPATH:
				webElement = driver.findElement(By.xpath(value));
				break;
			case ID:
				webElement = driver.findElement(By.id(value));
				break;
			case NAME:
				webElement = driver.findElement(By.name(value));
				break;
			default:
				break;
			}
		} catch (Exception ex) {
			throw ex;
		}
		return webElement;
	}

	private static WebElementOfPropFile getLocator(String key) throws Exception {
		String elm[] = PropertiesFileUtils.getStringVal(key).split(";");
		if (elm.length < 2) {
			System.out.println(" => Wrong value for property");
			throw new Exception();
		}
		return new WebElementOfPropFile(EMap.getTypeOfLocator(elm[0]), elm[1]);
	}
}
