package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utils.Utils;

public class CreateIssue extends PageObject {
	public Utils utils;
	
	@FindBy(linkText="Add Issue")
	private WebElement clickAddIssueButton;
	
	@FindBy(id="field-issues-issueName")
	private WebElement typeIssueName;
	
	@FindBy(id="field-issues-descriptionText")
	private WebElement typeIssueDescription;
	
	@FindBy(id="field-issues-okSubmit")
	private WebElement clickIssueSubmitButton;
	
	@FindBy(xpath="//*[@id=\"form-issues\"]/div/div[2]/div[5]/p")
	private WebElement getErrormassageBadSeverity;
	
	@FindBy(xpath ="//*[@id=\"form-issues\"]/div/div[1]/p")
	private WebElement getErrormassageBadName;
	
	@FindBy(id="field-issues-value4")
	private WebElement getSeverityNumber;
	
	@FindBy(xpath="//*[@id=\"body\"]/table/tbody/tr[2]/td/div/h2")
	private WebElement createdIssueName;
	
	//	__________________________________________________________
	
	@FindBy(id="field-issues-value1")
	private WebElement assignedTo;
	
	@FindBy(id="field-issues-value2")
	private WebElement createStatus;
	
	@FindBy(id="field-issues-value3")
	private WebElement createReason;
	
	@FindBy(xpath="//*[@id=\"form-issues\"]/div/div[2]/div[2]/p")
	private WebElement assignedToError;
	
	@FindBy(xpath="//*[@id=\"form-issues\"]/div/div[2]/div[3]/p")
	private WebElement statusError;
	
	@FindBy(xpath="//*[@id=\"form-issues\"]/div/div[2]/div[3]/p")
	private WebElement reasonError;
	
		
	
	public CreateIssue(WebDriver driver) {
		super(driver);
	}
		
	
	public WebElement getAddIssueButton() {
		return clickAddIssueButton;
	}
	
	public WebElement issueNameTyping() {
		return typeIssueName;
	}
	
	public WebElement issueDiscriptionTyping() {
		return typeIssueDescription;
	}
	
	public WebElement issueSubmitButtonClick() {
		return clickIssueSubmitButton;
	}
	
	public WebElement getErrormessageSeverityBad() {
		return getErrormassageBadSeverity;
	}
	
	public WebElement getErrorMessageNameIsBad(){
		return getErrormassageBadName;
	}
	
	public WebElement getSeveritySize() {
		return getSeverityNumber;
	}
	
	public WebElement getIssueCreatedFiled() {
		return createdIssueName;
	}
	
	public WebElement getAssignedToField() {
		return assignedTo;
	}
	
	public WebElement getStatusField() {
		return createStatus;
	}
	
	public WebElement getReasonField() {
		return createReason;
	}
	
	public WebElement getAssignedToErrorMsg() {
		return assignedToError;
	}
	
	public WebElement getStatusErrorMsg() {
		return statusError;
	}
	
	public WebElement getReasonErrorMsg() {
		return reasonError;
	}
	
	
	
	public void add(String name, String description, String severity, String Assigned_To, String status, String reason) throws InterruptedException {
		utils = new Utils();
		driver.get(utils.getUrl() +"/client/index.php?folder=5");
		this.getAddIssueButton().click();
		
		boolean hasFin = false;
		while(!hasFin) {
			this.issueNameTyping().clear();
			this.issueNameTyping().sendKeys(name);
			if(this.issueNameTyping().getAttribute("value").equals(name)) {
				hasFin = true;
			}
		}
		
		this.getAssignedToField().clear();
		this.getAssignedToField().sendKeys(Assigned_To);
		this.getStatusField().clear();
		this.getStatusField().sendKeys(status);
		this.getReasonField().clear();
		this.getReasonField().sendKeys(reason);
		this.issueDiscriptionTyping().sendKeys(description);
		this.getSeveritySize().clear();
		this.getSeveritySize().sendKeys(severity);
		this.issueSubmitButtonClick().click();
				
			
	}

}
