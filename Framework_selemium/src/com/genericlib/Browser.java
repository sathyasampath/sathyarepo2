package com.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
	public static WebDriver driver;

	public static WebDriver getBrowser() {
		if (Project_constants.browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Project_constants.browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Project_constants.browser.equals("safari")) {
			System.setProperty("webdriver.safari.driver", "");
			driver = new SafariDriver();
		} else if (Project_constants.browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}

		return driver;
	}
}
