package com.Vtiger.PagesAssignments;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class VtigerLoginPages extends SeleniumUtility {

	@FindBy(name = "username")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text() = 'Sign in']")
	private WebElement loginBtn;

	public void enteruserNameAndPwd(String userName, String pwd) {
		typeInput(userNameField, userName);
		typeInput(passwordField, pwd);
	}

	public void clickOnLoginBtn() {
		clickOnElement(loginBtn);

	}

	public boolean vrifyUserIsOnHomePage(String expectedTitle) {
		try {
			getCurrentPageTitle(expectedTitle);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}
