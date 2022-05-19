package com.hybridFramework.loginPage;

import com.hybridFramework.PageObject.HomePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

/**
 * 
 * @author Vivek Saraf
 */
public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test(priority = 1)
	public void testLoginToApplication() throws Exception{
		log.info(LoginTest.class.getName()+" started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(config.getUserName(), config.getPassword());
		loginPage.maximizeWindow();
		boolean status = loginPage.verifySuccessLoginMsg();
		if(status){
		   log.info("login is sucessful");
		}
		else{
			Assert.assertTrue(false, "login is not sucessful");
		}
	}

	@Test (priority = 2)
	public void addNew() throws Exception {
		log.info(LoginTest.class.getName()+" started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(config.getUserName(), config.getPassword());
		loginPage.assertHomePage();
		loginPage.maximizeWindow();
		HomePage homePage = new HomePage(driver);

		homePage.clickReqruitmentMenu();
		homePage.clickAddButton();
		homePage.enterFirstName();
		homePage.enterLastName();
		homePage.enterEmail();
		homePage.enterContactNumber();
		homePage.selectJobVacancy();
		homePage.enterResumeToProfile();
		homePage.scrollDown();
		homePage.enterKeyWords();
		homePage.enterComments();
		homePage.enterDate();
		homePage.saveProfileBtn();
		homePage.successfulAddProfile();
	}

	@Test(priority = 3)
	public void searchProfile() throws InterruptedException {
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(config.getUserName(), config.getPassword());
		loginPage.maximizeWindow();

		HomePage homePage = new HomePage(driver);
		homePage.clickReqruitmentMenu();
		homePage.searchAddedProfileByKeyword();
		homePage.selectHiringManager();
		homePage.searchButton();
		homePage.clickDownloadLink();
		//homePage.selectDownloadFile();


	}

}
