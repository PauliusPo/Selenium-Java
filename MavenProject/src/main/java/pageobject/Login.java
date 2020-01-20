package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {
	
	@FindBy(id="field-login-login")
	private WebElement loginField;
	
	@FindBy(id="field-login-password")
	private WebElement passField;
	
	@FindBy(id="field-login-loginSubmit")
	private WebElement loginSubmitButton;
	
	@FindBy(css="#infobar-right > a:nth-child(2)")
	private WebElement logOutButton;
	
	@FindBy(xpath="//*[@id='form-login']/div/div[2]/p")
	private WebElement errorMessage;
	
	
	@FindBy(xpath="//*[@id=\"body\"]/table/tbody/tr/td[1]/div/h2")
	private WebElement projects;
	
	
	
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	public void loginMethod(String userName, String password) {
		this.loginField.clear();
		this.passField.clear();
		this.loginField.sendKeys(userName);
		this.passField.sendKeys(password);
		this.loginSubmitButton.click();
		
	}
	
	public void loginLogOut(String userId, String userPassword) {
		this.loginField.clear();
		this.passField.clear();
		this.loginField.sendKeys(userId);
		this.passField.sendKeys(userPassword);
		this.loginSubmitButton.click();
		this.logOutButton.click();
		
	}
	
	public void logOut() {

		this.logOutButton.click();
		
	}
	
	public WebElement getLoginField() {
		return loginField;
	}
	
	public WebElement getPasswordField() {
		return passField;
	}
	
	public WebElement getLoginButton() {
		return loginSubmitButton;
	}
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	public WebElement logOutButton() {
		return logOutButton;
	}
	public WebElement getProjects() {
		return projects;
	}

	


}
