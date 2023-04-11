package com.automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.automation.enums.ETypeWebDriver;
import com.automation.utils.CaptureScreenshot;

public abstract class DriverIntance {

	protected WebDriver driver;

	protected abstract ETypeWebDriver getConf();

	protected abstract boolean isMaxWindowSize();

	protected abstract int getSecondsInPageLoad();

	protected abstract int getSecondsInQuit();

	protected void initWindow() {
		if (isMaxWindowSize()) {
			driver.manage().window().maximize();
		}
		if (getSecondsInPageLoad() > 0) {
			driver.manage().timeouts().pageLoadTimeout(getSecondsInPageLoad(), TimeUnit.SECONDS);
		}
	}

	protected String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}
	
	protected void printParams(String methodName, String...params) {
		System.out.println("\n\n" + methodName + " ----------------------------------------");
		for (String item : params) {
			System.out.print(item + " - ");
		}
	}

	@BeforeClass
	public void initDriverInstance() {
		System.setProperty(getConf().type(), getConf().path());
		switch (getConf()) {
		case CHROME:
			this.driver = new ChromeDriver();
			break;
		case FIREFOX:
			this.driver = new FirefoxDriver();
		default:
			break;
		}
		initWindow();
	}

	@AfterClass
	public void closeDriverInstance() throws InterruptedException {
		if (getSecondsInQuit() < 0) {
			return;
		}
		if (getSecondsInQuit() == 0) {
			driver.quit();
			return;
		}
		Thread.sleep(getSecondsInQuit());
		driver.quit();
	}

	@AfterMethod
	public void takeScreenshot(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				return;
			}
			String email = result.getParameters()[0].toString();
			String emailPart = email.substring(0, email.indexOf("@"));
			CaptureScreenshot.takeScreenshot(driver, emailPart);
			System.out.print(" => Take screenshot for case: " + emailPart);
		} catch (Exception e) {
			System.out.println("Exception when taking screenshot: " + e.getMessage());
		}
	}
}
