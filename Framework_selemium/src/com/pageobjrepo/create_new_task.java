package com.pageobjrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.genericlib.Browser;

public class create_new_task {
	
	@FindBy(xpath = "//div[@class='customerSelector customerOrProjectSelector selectorWithPlaceholderContainer']/div/div/div[@class='dropdownButton']")
	private WebElement cust_drop_down;
	
	@FindBy(xpath = "//div[text()='Big Bang Company']/preceding-sibling::div[contains(text(),' New Customer ')]")
	private WebElement New_Activcus_value_dropdown;
//@FindBy(xpath="//div[text()='Big Bang Company']/preceding-sibling::div[contains(text(),' ALL ACTIVE CUSTOMERS ')]")
//private WebElement All_Activcus_dropdown;
	
	@FindBy(xpath = "//div[text()='Big Bang Company']")
	private WebElement Big_Bang_comp_value;
	
	@FindBy(xpath = "//div[text()='Galaxy Corporation']")
	private WebElement galaxy_cor_value;
	
	@FindBy(xpath = "//div[text()='Our company']")
	private WebElement our_comp_value;
	
	@FindBy(xpath = "//input[@placeholder='Enter Customer Name']")
	private WebElement New_cus_txtbox;
	
	@FindBy(xpath = "//input[@class='newProject newCustomerProjectField inputFieldWithPlaceholder']")
	private WebElement New_proj_txtbox;
	
	@FindBy(xpath = "//input[@placeholder='Enter Project Name']")
	private WebElement new_proj_name_txtbox;
	
	@FindBy(xpath = "//td[table[tbody[tr[td[@id='descriptionCell0']]]]]/preceding-sibling::td/input")
	private WebElement Entr_task_timetable;
	
	@FindBy(xpath= "//table[@id='ext-comp-1001']/tbody/tr[@id='ext-gen17']//td/em/button")
	private WebElement deadlinefield;
	
	@FindBy (xpath="//a[@id='ext-gen56']")
	private WebElement nxtarrowbtn;
	
	@FindBy (xpath="//div[text()='Create Tasks']")
	private WebElement CreateTaskbtn;
	
	
	WebDriver driver;                         //constr for driver
	public create_new_task(WebDriver driver) {
		this.driver=driver;
	}
	public void click_dropdownicon() {
		cust_drop_down.click();
	}

	public void click_on_new_Act_cus(String Customer, String NewCust, String NewProjname) {
		Browser.driver
				.findElement(By.xpath(
						"//div[text()='Big Bang Company']/preceding-sibling::div[contains(text(),'" + Customer + "')]"))
				.click();
		if (Customer.equals("New Customer")) {
			New_cus_txtbox.sendKeys(NewCust);
			New_proj_txtbox.sendKeys(NewProjname);
		} else if (Customer.equals("ALL ACTIVE CUSTOMERS")) {
			new_proj_name_txtbox.sendKeys(NewProjname);
		} else if (Customer.equals("Big Bang Company")) {
			new_proj_name_txtbox.sendKeys(NewProjname);
		} else if (Customer.equals("Galaxy Corporation")) {
			new_proj_name_txtbox.sendKeys(NewProjname);
		} else if (Customer.equals("Our company")) {
			new_proj_name_txtbox.sendKeys(NewProjname);
		}
	}

	public void EnterTaskTabledetails(String Task) {
		Entr_task_timetable.sendKeys(Task);
	}

	public void setdetailsforTask() {
		deadlinefield.click();
	}

	public void setdetailsfortheTask(String Month,int date) {
    	  String xpathfordate="//tr[td[table[tbody[tr[td[em[button[contains(text(),'" + Month + "')]]]]]]]]/following-sibling::tr/td/table/tbody/tr/td[@class='x-date-active']/a/em/span[text()='"+date+"']";
    	 int n=1;
    	 while(n<12)
    	  try {
    		  Browser.driver.findElement(By.xpath(xpathfordate)).click();
    		  break;
    	  }catch(Exception e) {
    		  nxtarrowbtn.click();
    	  }
    	  }
    public void createTaskaction() {
    	CreateTaskbtn.click();
    }	        
      }
////tr[td[table[tbody[tr[td[em[button[text()='" + Month + "']]]]]]]]/following-sibling::tr/td/table/tbody/tr/td[@class='x-date-active']/a/em/span[text()='"+date+"']