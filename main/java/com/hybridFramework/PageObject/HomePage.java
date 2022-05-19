package com.hybridFramework.PageObject;

import com.github.javafaker.Faker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Vivek Saraf
 */
public class HomePage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WaitHelper waitHelper;
	Faker faker = new Faker();
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement womenMenu;

	@FindBy(xpath="//b[normalize-space()='Recruitment']")
	public WebElement reqruitmentMenu;

	@FindBy(xpath="//*[@id='btnAdd']")
	public WebElement addProfileButton;

	@FindBy(xpath="//*[@id='addCandidate_firstName']")
	public WebElement firstname;

	@FindBy(xpath="//*[@id='addCandidate_lastName']")
	public WebElement lastName;

	@FindBy(xpath="//*[@id='addCandidate_email']")
	public WebElement email;

	@FindBy(xpath="//*[@id='addCandidate_contactNo']")
	public WebElement contactNumber;

	@FindBy(xpath="//*[@id='addCandidate_vacancy']")
	public WebElement jobVacancy;

	@FindBy(xpath="//*[@id='addCandidate_resume']")
	public WebElement enterResume;

	@FindBy(xpath="//*[@id='addCandidate_keyWords']")
	public WebElement enterKeywords;

	@FindBy(xpath="//*[@id='addCandidate_comment']")
	public WebElement enterComments;

	@FindBy(xpath="//*[@id='addCandidate_appliedDate']")
	public WebElement enterDate;

	@FindBy(xpath="//*[@id='btnSave']")
	public WebElement saveProfileButton;

	@FindBy(xpath="//*[@id='successBodyEdit']")
	public WebElement successfullyAddProfile;

	@FindBy(xpath="//*[@id='candidateSearch_candidateName']")
	public WebElement searchProfile;

	@FindBy(xpath="//*[@id='candidateSearch_keywords']")
	public WebElement searchProfileByKeyword;

	@FindBy(xpath="//*[@id='candidateSearch_hiringManager']")
	public WebElement searchHiringManager;

	@FindBy(xpath="//*[@id='btnSrch']")
	public WebElement searchBtn;

	@FindBy(xpath="(//*[@id='resultTable']/tbody/tr/td[7]/a)[1]")
	public WebElement downloadResume;

	@FindBy(xpath="//*[@id='menu_dashboard_index']")
	public WebElement dashBoardMenu;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		TestBase testBase = new TestBase();
		waitHelper.waitForElement(driver, dashBoardMenu,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void mouseOver(String data){
		log.info("doing mouse over on :"+data);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
	}

	public void clickReqruitmentMenu(){
		log.info("Click Reqruitment Menu...."+reqruitmentMenu);
		this.reqruitmentMenu.click();
	}

	public void clickAddButton(){
		log.info("Click Add Button...."+addProfileButton);
		this.addProfileButton.click();
	}

	public void enterFirstName() throws Exception {
		String firstName = faker.name().firstName();
		log.info("Click Add first name...."+firstname);
		firstname.sendKeys(firstName);
		System.out.println(firstname.getAttribute(firstName));
	}

	public void enterLastName() throws Exception {
		String lName = faker.name().lastName();
		log.info("Click Add last name...."+lastName);
		this.lastName.sendKeys(lName);
	}


	public void enterEmail(){
		log.info("Click Add email...."+email);
		this.email.sendKeys("abc@example.com");
	}

	public void enterContactNumber(){
		String cellNumber = faker.phoneNumber().cellPhone();
		log.info("Click Add contact number...."+ contactNumber);
		this.contactNumber.sendKeys(cellNumber);
	}

	public void selectJobVacancy(){
		log.info("Click Add job vacancy...."+ jobVacancy);
		this.jobVacancy.click();
		//this.jobVacancy.findElements()
		Select dropdown = new Select(driver.findElement(By.id("addCandidate_vacancy")));
		dropdown.selectByVisibleText("Software Engineer");
	}

	public void enterResumeToProfile(){
		String resumeLocation = System.getProperty("user.dir")+"/src/main/java/com/hybridFramework/data/Resume.pdf";
		log.info("Add resume...."+ enterResume);
		enterResume.sendKeys(resumeLocation);
	}

	public void enterKeyWords(){
		log.info("Add Keywords...."+ enterKeywords);
		enterKeywords.sendKeys("TurnTest,Test Developer, Full time Courser, Remote");
	}

	public void enterComments(){
		log.info("Add Comments...."+ enterComments);
		enterComments.sendKeys("Hire Strong status after Interview as Very good technical and Team player");
	}

	public void enterDate(){
		log.info("date added....");
		enterDate.clear();
		enterDate.sendKeys("2022-05-14");
	}

	public void scrollDown(){
		log.info("Scroll down....");
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
	}

	public void saveProfileBtn(){
		log.info("Scroll down...." + saveProfileButton);
		if(saveProfileButton.isDisplayed()) {
			saveProfileButton.submit();
		}else {
			System.out.println("Profile is not added");
		}
	}

	public void successfulAddProfile(){
		log.info("Profile Added successfully...."+ successfullyAddProfile);
		successfullyAddProfile.isDisplayed();
	}

	public void searchAddedProfileByKeyword(){
		log.info("Profile Added successfully...."+ searchProfileByKeyword);
		searchProfileByKeyword.clear();
		searchProfileByKeyword.sendKeys("Turn");
	}

	public void searchAddedProfile(){
		log.info("Profile Added successfully...."+ searchProfile);
		searchProfile.clear();
		searchProfile.sendKeys("Turn");
	}

	public void searchButton(){
		log.info("Click search button...."+ searchBtn);
		searchBtn.click();
	}

	public void selectHiringManager(){
		log.info("Search hiring manager...."+ searchHiringManager);
		searchHiringManager.click();
		//this.jobVacancy.findElements()
		Select dropdown = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
		dropdown.selectByVisibleText("Odis Adalwin");
	}

	public void clickDownloadLink(){
		log.info("Click search button...."+ downloadResume);
		downloadResume.click();
	}

	public void selectDownloadFile() throws InterruptedException {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory",System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		ChromeDriver driver = new ChromeDriver(options);

		List<WebElement> list =driver.findElements(By.cssSelector("#resultTable > tbody > tr > td:nth-child(7) > a"));
		WebElement el = list.get(list.size()-1);
		el.click();
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('html > ins').style.display='none'");
		el.click();
		Thread.sleep(15000);

	}


}
