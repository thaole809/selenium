package com.automation.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class CaptureScreenshot {

	private static String fileName = null;
	private static String SCREENSHOT_PATH = "./screenshots/";

	public static void takeScreenshot(WebDriver driver, String name) {
		try {
			fileName = SCREENSHOT_PATH + name + ".png";
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			File desFile = new File(fileName);
			FileHandler.copy(srcFile, desFile);
		} catch (IOException e) {
			System.out.println("Not able to take screenshot");
		}
		attachScreenshotToReport();
	}

	public static void attachScreenshotToReport() {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		File file = new File(fileName);
		Reporter.log("<br><a title=\"Screenshot\" href=\"" + file.getAbsolutePath() + "\">");
		Reporter.log(
				"<img width='418' height='240' alt='" + file.getName() + " title='title' src='" + file + "'/></br>");
	}
}
