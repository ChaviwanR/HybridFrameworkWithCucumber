package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(BaseClass.getDriver()	, this);
	}
	
	@FindBy(name="username")
	public WebElement usernameTextBox;
	
	@FindBy(name="password")
	public WebElement passwordTextBox;
	
	@FindBy(xpath="//button")
	public WebElement button;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	public WebElement errorMessage;
	
	
	public void login(String username, String password) {
		CommonMethods.sendText(usernameTextBox, username);
		CommonMethods.sendText(passwordTextBox, password);
	}

}
