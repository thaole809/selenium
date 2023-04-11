package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {

	private static String CONFIG_PATH = "./configuration/configs.properties";

	public static String getStringVal(String key) {
		return getValue(CONFIG_PATH, key).toString();
	}

	public static Object getValue(String path, String key) {
		Properties properties = new Properties();
		Object value = null;
		FileInputStream fileInputStream = null;

		try {
			fileInputStream = new FileInputStream(path);

			properties.load(fileInputStream);
			value = properties.getProperty(key);

			if (value == null) {
				throw new Exception();
			}
			return value;
		} catch (Exception ex) {
			System.out.println(" => Error when read key: " + key);
			ex.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static void setValue(String key, String value) {
		Properties properties = new Properties();
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(CONFIG_PATH);

			properties.setProperty(key, value);
			properties.store(fileOutputStream, " => Set new value in properties [" + key + ";" + value + "]");

			System.out.println(" => Set new value in file properties success.");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
