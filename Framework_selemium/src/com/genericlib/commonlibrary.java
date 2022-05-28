package com.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//reusable methods will b here
//implementing methods here so tat v can use in our proj
public class commonlibrary {

	public void normal_wait(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void waitforpageload(long duration) {
		Browser.driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	public void waitforelementpresent(long duration, WebElement wb) {
		WebDriverWait wait = new WebDriverWait(Browser.driver, duration);
		wait.until(ExpectedConditions.visibilityOf(wb));

	}

	public boolean verifytext(String Expectedresult, WebElement wb) {
		boolean result = false;
		String Actual_result = wb.getText();
		if (Expectedresult.equals(Actual_result)) {
			result = true;
		}
		return result;
	}

	public void acceptalert() {
		Alert alt = Browser.driver.switchTo().alert();
		alt.accept();
	}

	public void dismissalert() {
		Alert alt = Browser.driver.switchTo().alert();
		alt.dismiss();
	}

	public String getalerttext() {
		Alert alt = Browser.driver.switchTo().alert();
		String text = alt.getText();
		return text;
	}
    public void valuetoalert(String data) {
    	Alert alt = Browser.driver.switchTo().alert();
    	alt.sendKeys(data);
    }
}
