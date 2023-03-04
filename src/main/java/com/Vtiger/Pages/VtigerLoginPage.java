package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VtigerLoginPage extends SeleniumUtility {

	public VtigerLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement userNameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInBtn;

	public void vtigerLogin(String username, String pwd) {
		typeInput(userNameField, username);
		typeInput(passwordField, pwd);
		clickOnElement(signInBtn);
	}
}
