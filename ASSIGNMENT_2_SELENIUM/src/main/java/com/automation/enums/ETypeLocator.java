package com.automation.enums;

public enum ETypeLocator {
	XPATH("xpath"), ID("id"), NAME("name");

	private final String type;

	ETypeLocator(String type) {
		this.type = type;
	}
	
	public String type() {
		return type;
	}
}
