package com.OrangeHrm.Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class OrangeHrmLoginPage extends SeleniumUtility {

	@FindBy(name = "username")
	private WebElement userNameField;

	@FindBy(name = "password")
	private WebElement pwdField;

	@FindBy(css = "button[type = 'submit']")
	private WebElement loginBtn;

	public void enterUsernameAndPwd(String userName, String pwd) {
		typeInput(userNameField, userName);
		typeInput(pwdField, pwd);
	}

	public void clickOnLoginBtn() {
		clickOnElement(loginBtn);
	}

	public boolean verifyUserIsOnHomePage(String expectedHomePageUrl) {
		try {
			getCurrentPageUrl(expectedHomePageUrl);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
