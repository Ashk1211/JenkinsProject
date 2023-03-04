package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Vtiger.PagesAssignments.VtigerLoginPages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class VtigerLogin extends SeleniumUtility {

//  git practice
	WebDriver driver;
	VtigerLoginPages vtLogin;

	@Given("User open the {string} browser and Vtiger application using {string}")
	public void user_open_the_browser_and_vtiger_application_using(String browser, String appUrl) {
		driver = setUp(browser, appUrl);
		vtLogin = PageFactory.initElements(driver, VtigerLoginPages.class);
	}

	@When("User enters userName as {string} and password as {string}")
	public void user_enters_user_name_as_and_password_as(String userName, String pwd) {
		vtLogin.enteruserNameAndPwd(userName, pwd);
	}

	@When("User click on the Login Button")
	public void user_click_on_the_login_button() {
		vtLogin.clickOnLoginBtn();
	}

	@Then("User will be navigate to home page")
	public void user_will_be_navigate_to_home_page() {
		Assert.assertTrue(vtLogin.vrifyUserIsOnHomePage("Dashboard"));
		tearDown();
	}

}
