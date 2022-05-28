package com.testngtestscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genericlib.Browser;
import com.genericlib.Excellibrary;
import com.genericlib.commonlibrary;
import com.pageobjrepo.Enter_Time_Track;
import com.pageobjrepo.create_new_task;
import com.pageobjrepo.login;

public class createTaskTest {
	WebDriver driver;
Excellibrary elib;
commonlibrary clib;
login loginpage;
Enter_Time_Track timetrackpage;
create_new_task newtaskpage;
@BeforeClass
public void bfrcls() {
	elib=new Excellibrary();
	clib=new commonlibrary();
	driver=Browser.getBrowser();
	//login loginpage=new login(driver);
	loginpage =PageFactory.initElements(driver, login.class); //one way to initialize obj
	timetrackpage=PageFactory.initElements(driver, Enter_Time_Track.class);
	newtaskpage=PageFactory.initElements(driver, create_new_task.class);
}
@BeforeMethod
public void bfrmthd() {
	
	loginpage.loginto_app();
}
@Test
public void creatNewTaskTest() throws EncryptedDocumentException, IOException {

	clib.waitforpageload(3);
timetrackpage.getTasktoaddsheet();
//clib.normal_wait(3);
timetrackpage.click_on_new_button();
//clib.normal_wait(3);
newtaskpage.click_dropdownicon();
String cusName=elib.ReadExceldata("Sheet1", 1, 1);
System.out.println(cusName);
String newcus=elib.ReadExceldata("Sheet1", 1, 2);
System.out.println(newcus);
String newProject=elib.ReadExceldata("Sheet1", 1, 3);
System.out.println(newProject);
newtaskpage.click_on_new_Act_cus(cusName, newcus, newProject);

String Taskname=elib.ReadExceldata("Sheet1", 1, 6);
//clib.normal_wait(3);
newtaskpage.EnterTaskTabledetails(Taskname);
String month=elib.ReadExceldata("Sheet1", 1,4 );
int date=elib.ReadNumericExceldata("Sheet1", 1,5 );
newtaskpage.setdetailsforTask();
//clib.normal_wait(3);
newtaskpage.setdetailsfortheTask(month, date);
}

@AfterMethod
public void aftrmtd() {
	clib.waitforpageload(3);
	timetrackpage.click_on_logout_button();
}
@AfterClass
public void afrclas() {

	driver.quit();
}
}

