package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-newsletter']")
	WebElement chkdSubscribe;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setfirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setlastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setemail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void setSubscribe() {
		chkdSubscribe.click();;
	}
	public void setPrivacyPolicy() {
		chkdPolicy.click();
	}
	public void continueBtn() {
		btnContinue.click();
	}
	public String getConfirmationMsg() {
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
