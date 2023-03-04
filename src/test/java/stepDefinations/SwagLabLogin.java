package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Swaglab.Pages.SwagLabHomePage;
import com.Swaglab.Pages.SwagLabLoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.SeleniumUtility;

public class SwagLabLogin extends SeleniumUtility {

	WebDriver driver;
	SwagLabLoginPage swgLogin;
	SwagLabHomePage swgHome;
	String filePath = "./src/main/resources/SwagLabData.properties";

	@Given("user is on swaglab login page")
	public void user_is_on_swag_alb_login_page() throws IOException {
		driver = setUp(getPropertyFileData(filePath, "browser"), getPropertyFileData(filePath, "appUrl"));
		swgLogin = new SwagLabLoginPage(driver);
		swgHome = PageFactory.initElements(driver, SwagLabHomePage.class);

	}

	@When("user enters userName and password")
	public void user_enters_user_name_and_password(DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		List<List<String>> userData = dataTable.asLists(String.class);
		System.out.println(userData);

		List<String> firstUser = userData.get(0);
		System.out.println(firstUser);

		List<String> secondUser = userData.get(1);
		System.out.println(secondUser);

		swgLogin.userEnterUsernameAndPwd(firstUser.get(0), firstUser.get(1));
	}

	@When("user enters userName and password using datatable data")
	public void user_enters_user_name_and_password_using_datatable_data(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//

		List<Map<String, String>> userData = dataTable.asMaps();
		System.out.println(userData);

		String firstUserName = userData.get(0).get("username");
		String firstUserPassword = userData.get(0).get("password");
		System.out.println(firstUserName + " " + firstUserPassword);

		String secondUserName = userData.get(1).get("username");
		String secondUserPassword = userData.get(1).get("password");
		System.out.println(secondUserName + " " + secondUserPassword);
		swgLogin.userEnterUsernameAndPwd(firstUserName, firstUserPassword);
	}

	@When("user click on the login button")
	public void user_click_on_the_the_login_button() {
		swgLogin.userClickOnLoginBtn();
	}

	@Then("user should logged in successfully for valid user")
	public void user_should_login_successfully_for_valid_user() {
		swgHome.verifyUserIsOnLoginPage();
		tearDown();

	}
}
