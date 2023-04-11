package com.automation.enums;

public enum ETypeWebDriver {

	CHROME("webdriver.chrome.driver", "./drive/chromedriver"),
	FIREFOX("webdriver.gecko.driver", "./dirve/geckodriver"),
	IE("webdriver.ie.driver", "./drive/internetexplorerdriver");

	private final String type;
	private final String path;

	ETypeWebDriver(String type, String path) {
		this.type = type;
		this.path = path;
	}

	public String type() {
		return this.type;
	}

	public String path() {
		return this.path;
	}
}
