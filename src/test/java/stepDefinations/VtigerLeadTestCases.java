package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Vtiger.Pages.VtigerHomePage;
import com.Vtiger.Pages.VtigerLeadPage;
import com.Vtiger.Pages.VtigerLoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class VtigerLeadTestCases extends SeleniumUtility {
	WebDriver driver;
	String propFilePath = "./src/main/resources/VtigerLead.properties";
	VtigerLoginPage vtLogin;
	VtigerHomePage vtHome;
	VtigerLeadPage vtLead;

	@Given("User is on Vtiger login page")
	public void user_is_on_vtiger_login_page() throws IOException {
		driver = setUp(getPropertyFileData(propFilePath, "browser"), getPropertyFileData(propFilePath, "appUrl"));
		vtLogin = PageFactory.initElements(driver, VtigerLoginPage.class);
		vtHome = new VtigerHomePage(driver);
		vtLead = PageFactory.initElements(driver, VtigerLeadPage.class);
	}

	@Given("user login using valid credential")
	public void user_login_using_valid_credential() throws IOException {
		vtLogin.vtigerLogin(getPropertyFileData(propFilePath, "username"),
				getPropertyFileData(propFilePath, "password"));
	}

	@Given("user navigate to the lead page")
	public void user_navigate_to_the_lead_page() {
		vtHome.navigateToLeadPage();
	}

	@When("user click on the add lead button")
	public void user_click_on_the_add_lead_button() {
		vtLead.clickOnaddLeadBtn();
	}

	@When("user enters firstname as {string} and last name as {string} and click on the save button")
	public void user_enters_firstname_as_and_last_name_as_and_click_on_the_save_button(String firstname,
			String lastname) {
		vtLead.createLead(firstname, lastname);
	}

	@Then("verify lead is created with {string}")
	public void verify_lead_is_created_with(String firstname) {
		Assert.assertTrue(vtLead.VerifyCreatedLead());
	}

	@When("user click on the select all leads checkbox")
	public void user_click_on_the_select_all_leads_checkbox() {
		vtLead.clickOnSelectAllCheckBox();
	}

	@When("user clik on the delete button")
	public void user_clik_on_the_delete_button() {
		vtLead.clickOnDeleteBtn();
	}

	@Then("delete confirmation pop up will appear")
	public void delete_confirmation_pop_up_will_appear() {
		Assert.assertTrue(vtLead.verfiyDeletePopup());
	}

	@When("user clik on yes to confirm the deletion")
	public void user_clik_on_yes_to_confirm_the_deletion() {
		vtLead.clickOnYesBtn();
	}

	@Then("vrify that all the leads are deleted")
	public void vrify_that_all_the_leads_are_deleted() {
		Assert.assertTrue(vtLead.verifyLeadIsDeleted());
		tearDown();
	}
}
