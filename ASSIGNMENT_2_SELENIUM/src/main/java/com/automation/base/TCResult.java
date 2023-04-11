package com.automation.base;

import org.testng.ITestResult;

public class TCResult {
	private String name;
	private String message;
	private int result;
	private static final String ERROR_FORMAT = "[ERROR - M]";

	public TCResult(String name, String message, int result) {
		this.name = name;
		this.message = message;
		this.result = result;
		printResult(isPassed());
	}

	public TCResult(String message, int result) {
		this.name = "";
		this.message = message;
		this.result = result;
		printResult(isPassed());
	}

	public String name() {
		return name;
	}

	public String message() {
		return message;
	}

	public boolean isPassed() {
		return result == ITestResult.SUCCESS;
	}

	public static TCResult initPassed() {
		return new TCResult("", ITestResult.SUCCESS);
	}

	public static TCResult initFailed(String message) {
		return new TCResult(ERROR_FORMAT.replace("M", message), ITestResult.FAILURE);
	}
	
	private static void printResult(boolean isPassed) {
		System.out.print(isPassed ? " => found" : " => not found");
	}
}
