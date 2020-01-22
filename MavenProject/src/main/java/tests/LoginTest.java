package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pageobject.*;
import utils.*;

public class LoginTest {

	public WebDriver driver;
	public Login login;
	public CreateIssue createIssue;
	public Utils utils;
	
		
	@Test
	public void should_BeAbbleToLogIn_With_ValidUserAndPassData() {
		login.loginMethod(utils.getUserName(), utils.getUserPassword());
		Assert.assertTrue(login.getProjects().isDisplayed());
		login.logOut();
	
	}	
		
	@Test
	public void should_Not_logIN_When_UserIDInvalid() throws InterruptedException {
		 login.loginMethod("asddafgdfgdfg", utils.getUserPassword());
		 Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");
		
	}

	
	@Test
	public void should_Not_logIN_When_UserPasswordInvalid() throws InterruptedException {
		login.loginMethod(utils.getUserName(), "sdfasfagadfg");
		Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");

	}
//__________________________________________Bad PASSWORDS__________________________________
	
	@Test
	public void should_Not_logIN_When_UserPasswordIsEmpty() throws InterruptedException {		
	XLSXreader reader = new XLSXreader("test-data\\bad_passwords.xlsx");
		for(int i = 0; i <reader.size(); i++){
			login.loginMethod(reader.getItem("Password", i), reader.getItem("Password", i));
			  Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");

	}
	
	@Test
	public void should_Not_logIN_When_UserPasswordWithIllegalSimbols() throws InterruptedException {
		login.loginMethod(utils.getUserName(), "!@#$%^&**");
		Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");

	}
	
	@Test
	public void should_Not_logIN_When_UserPasswordWithScripting() throws InterruptedException {
		login.loginMethod(utils.getUserName(), "<script>alert(hi!)</script>");
		Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");

	}
	
	@Test
	public void should_Not_logIN_When_UserPasswordWithcrossScripting() throws InterruptedException {
		login.loginMethod(utils.getUserName(), "<b>dfgsdgsbgsgfd</b>");
		Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");

	}
	
	@Test
	public void should_Not_logIN_When_UserPasswordWithLink() throws InterruptedException {
		login.loginMethod(utils.getUserName(), "https://www.delfi.lt/");
		Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");

	}
	
	@Test
	public void should_Not_logIN_When_UserPasswordWithToManySigns() throws InterruptedException {
		login.loginMethod(utils.getUserName(), "frbrebetynteynetyntntmtumyumyumyumyrumyummyuyumymrrtebynetyntenetytentujyukyukykkykuik");
		Assert.assertEquals(login.getErrorMessage().getText(), "Incorrect value: Invalid login or password.");

	}
	
//	@Test(expectedExceptions = ArithmeticException.class)


	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		utils = new Utils();
//	  LOG IN ELEMENTS STARTS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		driver.get(utils.getUrl());
//		System.out.println(utils.getUrl());
		login = new Login(driver);
	
//		login.loginMethod(utils.getUserName(), utils.getUserPassword());
	
//		  LOG IN ELEMENTS ENDS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	}

	@AfterClass(groups ={"smoke" })
	public void afterClass() {
//	  driver.quit();
	}

}
