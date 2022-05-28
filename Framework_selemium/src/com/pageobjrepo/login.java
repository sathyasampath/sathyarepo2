package com.pageobjrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericlib.Browser;
import com.genericlib.Project_constants;
//finding ele using findby then storing in webele var
public class login {
	
@FindBy(xpath="//div[@class='atProductName']")  //to specifi obj location
private WebElement titlleofloginpage;
@FindBy (xpath="//div[@class='atLogoImg']")
private WebElement logoimg;
@FindBy (xpath="//td[text()='Please identify yourself']")
private WebElement headoflogin;
@FindBy (id="username")
private WebElement untextbox;
@FindBy(name="pwd")
private WebElement pswdtextbox;
@FindBy (id="keepLoggedInLabel")
private WebElement keepmelogdintext;
@FindBy (id="keepLoggedInCheckBox")
private WebElement keepmelogdincheckbox;
@FindBy (id="loginButton")
private WebElement loginbtn;
@FindBy (id="loginRecoveryLinkContainer")
private WebElement forgotpswdlink;
//creating functions and performing actions on webelements



WebDriver driver;                      //initia driver here
public login(WebDriver driver) { //creating construc to initia nonstat var
this.driver=driver;	
//PageFactory.initElements(driver,this);
}
public void loginto_app() {                        
	driver.get(Project_constants.url); 
	untextbox.sendKeys(Project_constants.username);
	pswdtextbox.sendKeys(Project_constants.password);
	loginbtn.click();
	
}

}

