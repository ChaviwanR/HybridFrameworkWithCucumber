package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class DashboardPage {
	
	public DashboardPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath="//ul[@class='oxd-main-menu']/li")
	public List<WebElement> leftMenu;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	public WebElement dashboardPageText;
	
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	public WebElement userMenu;
	
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']/li")
	public List<WebElement>  userMenuOptions;

}
