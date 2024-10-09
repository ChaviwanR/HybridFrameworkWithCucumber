package StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethods;

public class loginStepDef extends CommonMethods {
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	   BaseClass.getDriver();
	  Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains("login")); 
	}

	@When("the user enter valid username and valid password")
	public void the_user_enter_valid_username_and_valid_password() {
	    lp.login(BaseClass.getProperty("userName"), BaseClass.getProperty("password"));
	}

	@When("click the login button")
	public void click_the_login_button() {
	    lp.button.click();
	}

	@Then("the user should be loggin successfully")
	public void the_user_should_be_loggin_successfully() {
		 Assert.assertFalse(BaseClass.getDriver().getCurrentUrl().contains("login")); 
	}

	@Then("should be redirected to the dashboard")
	public void should_be_redirected_to_the_dashboard() {
	Assert.assertEquals(dp.dashboardPageText.getText(), "Dashboard");
	}
	
	@When("the user enter invalid username and invalid password")
	public void the_user_enter_invalid_username_and_invalid_password() {
		  lp.login(BaseClass.getProperty("invalid_userName"), BaseClass.getProperty("invalid_password"));
	}

	@Then("the user should be see error message")
	public void the_user_should_be_see_error_message() {
	   Assert.assertEquals(CommonMethods.waitForVisibility(lp.errorMessage).getText(), "Invalid credentials");
	}

	@Then("should not be login")
	public void should_not_be_login() {
	    Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains("login")); 
	}
	
	
}
