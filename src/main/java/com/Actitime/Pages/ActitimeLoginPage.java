package com.Actitime.Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class ActitimeLoginPage extends SeleniumUtility {

	public ActitimeLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(name = "pwd")
	private WebElement pwdField;

	@FindBy(id = "loginButton")
	private WebElement loginBtn;

	public void enterUsernameAndPwd(String userName, String pwd) {
		typeInput(userNameField, userName);
		typeInput(pwdField, pwd);
	}

	public void clickOnLoginBtn() {
		clickOnElement(loginBtn);
	}

	public boolean verifyUserIsOnHomePage(String expectedTitle) {
		try {
			getCurrentPageTitle(expectedTitle);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
