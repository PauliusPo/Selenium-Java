package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.*;
import utils.Utils;

	public class IssueCreatingTest {

	public WebDriver driver;
	public Login login;
	public CreateIssue createIssue;
	public Utils utils;
	

	@Test
	public void Should_CreateIssue_When_Correct_data_Is_Given() throws InterruptedException {		
		createIssue.add("Pauliaus 2020-01-13", "Pirmadienis", "2", "Paulius", "Active", "Fixed");		
		Assert.assertEquals(createIssue.getIssueCreatedFiled().isDisplayed(), true);
	}
	
	
	@Test 
	public void should_NOT_Work_When_AssignedToIsInvalid() throws InterruptedException {
		createIssue.add("Pauliaus 2020-01-13", "Pirmadienis", "2", "sdadfdfbsfgbfsgbnfgnfgn", "Active", "Fixed");
		Assert.assertEquals(createIssue.getAssignedToErrorMsg().getText(), "Incorrect value: No matching item is selected.");	
	}
	
	
	@Test
	public void Should_Not_CreateIssue_When_Issue_Name_Empty_String() throws InterruptedException {
		createIssue.add(" ", "Pirmadienis", "2", "Paulius", "Active", "Fixed");	
		Assert.assertEquals(createIssue.getErrorMessageNameIsBad().getText(), "Incorrect value: Required value is missing.");
		
	}
	
	
	@Test
	public void Should_Not_CreateIssue_When_Issue_Name_Not_Provided() throws InterruptedException {
		createIssue.add("", "Pirmadienis", "2", "Paulius", "Active", "Fixed");	
		Assert.assertEquals(createIssue.getErrorMessageNameIsBad().getText(), "Incorrect value: Required value is missing.");
		
	}
	
	
	@Test
	public void Should_Not_CreateIssue_Then_Issue_Severity_To_Big() throws InterruptedException {
		createIssue.add("Pauliaus", "Pirmadienis", "9", "Paulius", "Active", "Fixed");
		Assert.assertEquals(createIssue.getErrormessageSeverityBad().getText(), "Incorrect value: Number is too big.");
		
	}
	
	
	@Test 
	public void should_NOT_Work_When_Reason_Is_Not_Valid() throws InterruptedException {
		createIssue.add("Pauliaus 2020-01-13", "Pirmadienis", "2", "Paulius", "sgsrhrtyntynyyyynt", "Fixed");
		Assert.assertEquals(createIssue.getReasonErrorMsg().getText(), "Incorrect value: No matching item is selected.");
		
	}
	
	
	@Test 
	public void should_NOT_Work_When_Status_Is_Not_Valid() throws InterruptedException {
		createIssue.add("Pauliaus 2020-01-13", "Pirmadienis", "2", "Paulius", "sgsrhrtyntynyyyynt", "Fixed");
		Assert.assertEquals(createIssue.getStatusErrorMsg().getText(), "Incorrect value: No matching item is selected.");
		
	}

	//@Test(expectedExceptions = ArithmeticException.class)  //<--Ignoring spelling mistakes

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		utils = new Utils();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

//	  LOG IN ELEMENTS STARTS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		driver.get(utils.getUrl());
		login = new Login(driver);
		
		login.loginMethod(utils.getUserName(), utils.getUserPassword());
		createIssue = new CreateIssue(driver);
		

		

//	  LOG IN ELEMENTS ENDS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	}

	@AfterClass
	public void afterClass() {
//	  driver.quit();
	}

}
