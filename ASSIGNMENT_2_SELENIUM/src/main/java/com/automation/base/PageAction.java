package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageAction {

	private int WAITING_TIME_IN_SECONDS = 30;
	private int WAITING_TIME_IN_SECONDS_STEP = 20;
	private WebDriverWait wait;
	protected WebDriver driver;

	public PageAction(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, WAITING_TIME_IN_SECONDS);
	}
	
	public abstract String getURL();

	protected void waitInSeconds() throws InterruptedException {
		Thread.sleep(WAITING_TIME_IN_SECONDS_STEP);
	}

	protected void clickButton(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected void inputEditText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}

	protected void selectItemList(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		Select select = new Select(element);
		select.selectByValue(text);
	}
}
