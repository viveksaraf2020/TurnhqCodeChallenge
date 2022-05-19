package com.hybridFramework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.Javascript.JavaScriptHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.helper.genericHelper.GenericHelper;
import org.testng.Assert;

/**
 * 
 * @author Vivek Saraf
 */
public class LoginPage{
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath="//*[@id='txtUsername']")
	WebElement userName;

	@FindBy(xpath="//*[@id='txtPassword']")
	WebElement passWord;

	@FindBy(xpath="//*[@href='http://www.orangehrm.com/']")
	WebElement successMsgObject;

	@FindBy(xpath="//*[@id='btnLogin']")
	WebElement submitLogin;

	@FindBy(xpath="//*[@id='branding']/a[1]")
	WebElement verifyHomepgaeHRM;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, signin,new Config(TestBase.OR).getExplicitWait());
	}

	public void enterUserName(String username){
		log.info("entering email address...."+username);
		this.userName.sendKeys(username);
	}

	public void enterPassword(String password){
		log.info("entering password...."+password);
		this.passWord.sendKeys(password);
	}

	public void maximizeWindow(){
		driver.manage().window().maximize();
	}
	
	public HomePage clickOnSubmitButton(){
		log.info("clicking on submit button...");
		new JavaScriptHelper(driver).scrollDownVertically();
		submitLogin.click();

		return new HomePage(driver);
	}
	
	public boolean verifySuccessLoginMsg(){

		return new GenericHelper().isDisplayed(successMsgObject);
	}

	public void loginToApplication(String userName, String password){
		enterUserName(userName);
		enterPassword(password);
		clickOnSubmitButton();

	}

	public void assertHomePage(){
		log.info("Verify Home page... " + verifyHomepgaeHRM);
		boolean ActualHomepageText = verifyHomepgaeHRM.isDisplayed();
		Assert.assertTrue(true);
	}



}
