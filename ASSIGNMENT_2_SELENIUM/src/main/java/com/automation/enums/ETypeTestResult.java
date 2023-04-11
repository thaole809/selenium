package com.automation.enums;

public enum ETypeTestResult {
	PASSED ("pass"), FAILED ("failed"), SKIPPED ("skipped");
	
	private final String res;
	
	private ETypeTestResult(String res) {
		this.res = res;
	}
	
	public String res() {
		return res;
	}
}
