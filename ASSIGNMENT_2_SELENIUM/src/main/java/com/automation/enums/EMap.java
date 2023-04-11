package com.automation.enums;

public class EMap {

	public static ETypeLocator getTypeOfLocator(String type) {
		for (ETypeLocator item : ETypeLocator.values()) {
			if (item.type().contains(type.toLowerCase())) {
				return item;
			}
		}
		return ETypeLocator.XPATH;
	}
	
	public static ETypeTestResult getTypeOfTestResult(String res) {
		for (ETypeTestResult item : ETypeTestResult.values()) {
			if (item.res().equalsIgnoreCase(res)) {
				return item;
			}
		}
		return ETypeTestResult.PASSED;
	}

	public static ETypeWebDriver getTypeOfWebDriver(String type) {
		for (ETypeWebDriver item : ETypeWebDriver.values()) {
			if (item.type().contains(type.toLowerCase())) {
				return item;
			}
		}
		return ETypeWebDriver.CHROME;
	}
}
