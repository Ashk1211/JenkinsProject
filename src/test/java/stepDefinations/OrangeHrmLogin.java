package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.OrangeHrm.Pages.OrangeHrmLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.ExcelUtility;
import utility.SeleniumUtility;

public class OrangeHrmLogin extends SeleniumUtility {

	WebDriver driver;
	OrangeHrmLoginPage orgLogin;
	String xlPath = "./src/main/resources/ApplicationDataOrg.xlsx";
	String browser, appUrl, userName, pwd, expectedHomePageUrl;

	@Given("User opens the {string} browser and OrangeHrm application using {string}")
	public void user_opens_the_browser_and_orange_hrm_application_using(String browser, String appUrl) {
		driver = setUp(browser, appUrl);
		orgLogin = PageFactory.initElements(driver, OrangeHrmLoginPage.class);
	}

	@When("User enters UserName as {string} and Password as {string}")
	public void user_enters_user_name_as_and_password_as(String userName, String pwd) {
		orgLogin.enterUsernameAndPwd(userName, pwd);
	}

	@When("User click on the Login button")
	public void user_click_on_the_login_button() {
		orgLogin.clickOnLoginBtn();
	}

	@Then("User should navigate to home page having url as {string}")
	public void user_should_navigate_to_home_page_having_url_as(String expectedHomePageUrl) {
		Assert.assertTrue(orgLogin.verifyUserIsOnHomePage(expectedHomePageUrl));
		tearDown();
	}

	@Given("application url is on {string} sheet and row number is {int}")
	public void application_url_is_on_sheet_and_row_number_is(String xlSheet, int rowNum) throws IOException {
		browser = ExcelUtility.getCellData(xlPath, xlSheet, rowNum, 0);
		appUrl = ExcelUtility.getCellData(xlPath, xlSheet, rowNum, 1);
		expectedHomePageUrl = ExcelUtility.getCellData(xlPath, xlSheet, rowNum, 4);
	}

	@Given("login credentials is on {string} sheet and row number is {int}")
	public void login_credentials_is_on_sheet_and_row_number_is(String xlSheet, int rowNum) throws IOException {
		userName = ExcelUtility.getCellData(xlPath, xlSheet, rowNum, 2);
		pwd = ExcelUtility.getCellData(xlPath, xlSheet, rowNum, 3);

	}

	@Given("user open the browser and application as per shhet details")
	public void user_open_the_browser_and_application_as_per_shhet_details() {
		driver = setUp(browser, appUrl);
		orgLogin = PageFactory.initElements(driver, OrangeHrmLoginPage.class);
	}

	@When("user enter username and password as per the sheet data")
	public void user_enter_username_and_password_as_per_the_sheet_data() {
		orgLogin.enterUsernameAndPwd(userName, pwd);
	}

	@When("user click on the login button after entering username and password")
	public void user_click_on_the_login_button_after_entering_username_and_password() {
		orgLogin.clickOnLoginBtn();
	}

	@Then("user logged in successfully")
	public void user_logged_in_successfully() {
		Assert.assertTrue(orgLogin.verifyUserIsOnHomePage(expectedHomePageUrl));
		tearDown();
	}
}
