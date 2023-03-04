package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitmeTaskCreation {

	@Given("user is on actitime login page for task creation")
	public void user_is_on_actitime_login_page_for_task_creation() {
		System.out.println("User is on actitime login page");
	}

	@Given("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String pwd) {
		System.out.println("User enter username as " + username + "and password as " + pwd);
	}

	@Given("user click on actitime login button")
	public void user_click_on_actitime_login_button() {
		System.out.println("User click on the login button");
	}

	@When("click on task tab")
	public void click_on_task_tab() {
		System.out.println("User click on task tab");
	}

	@When("click on add new task button")
	public void click_on_add_new_task_button() {
		System.out.println("User click on the new task option");
	}

	@When("select new task option")
	public void select_new_task_option() {
		System.out.println("user select new task option");
	}

	@When("select project from project dropdown")
	public void select_project_from_project_dropdown() {
		System.out.println("User select project from project dropdown");
	}

	@When("enter the task name as {string}")
	public void enter_the_task_name_as(String taskName) {

		System.out.println("User enter the task name as " + taskName);
	}

	@When("click on the create task button")
	public void click_on_the_create_task_button() {
		System.out.println("User click on the create task button");
	}

	@Then("user should be able to see created task")
	public void user_should_be_able_to_see_created_task() {
		System.out.println("User is able to see created task");
	}
}
