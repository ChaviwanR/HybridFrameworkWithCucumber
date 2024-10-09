package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class Hooks extends CommonMethods {

	@Before
	public void setup() {
		BaseClass.getDriver().get(BaseClass.getProperty("url"));
		BaseClass.getDriver().manage().window().maximize();
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Constants.implicit_wait_time, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		try {
		
			dp.userMenu.click();
			CommonMethods.ClickOnNavigationBar(dp.userMenuOptions, BaseClass.getProperty("userMenuOptions_Logout"));
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}

	}

}
