package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class AdminPage {
	public AdminPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	@FindBy(xpath="//nav[@aria-label='Topbar Menu']/ul/li")
	public List<WebElement> TopMenuBar;
	
	@FindBy(xpath="//ul[@class=\"oxd-dropdown-menu\"]/li")
	public List<WebElement> subMenuBar;
	
	

}
