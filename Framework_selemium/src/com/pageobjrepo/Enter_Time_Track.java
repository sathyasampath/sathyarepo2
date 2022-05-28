package com.pageobjrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Enter_Time_Track {
	
@FindBy(xpath="//button[@class=\"containers-EnterTT-ETTTaskPanel-trigger--ANgIUi1t\"]")
private WebElement add_taskto_sheet;
@FindBy(xpath="//div[text()='Tasks']")      //passing locators
private WebElement Task_link;           //ele storing in parti var
@FindBy(xpath="//div[text()='Reports']")     
private WebElement Report_link;
@FindBy(xpath="//div[text()='Users']")     
private WebElement Users_link;
@FindBy(xpath="//button[@class=\"components-Buttons-button--2ZtATn8v components-Buttons-default--2AuE4tKC containers-EnterTT-ETTTaskPanel-addNew--1XHPprq8\"]")     
private WebElement Addnew_button;
@FindBy (xpath="//a[@class='logout']")
private WebElement logoutbtn;
//a[@id='logoutLink']



WebDriver driver;
public Enter_Time_Track(WebDriver driver) {
	this.driver=driver;
}


public void getTasktoaddsheet() {
	add_taskto_sheet.click();
	}
public void click_on_task() {
	Task_link.click();
}
public void click_on_reports() {
	Report_link.click();
}
public void click_on_users() {
	Users_link.click();
}
public void click_on_new_button() {
Addnew_button.click();
}
public void click_on_logout_button() {
logoutbtn.click();
}
}