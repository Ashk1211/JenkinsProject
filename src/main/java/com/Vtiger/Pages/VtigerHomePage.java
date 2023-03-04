package com.Vtiger.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.SeleniumUtility;

public class VtigerHomePage extends SeleniumUtility {
	WebDriver driver;

	public VtigerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "appnavigator")
	private WebElement burgerMenu;

	@FindBy(xpath = "//span[contains (text(),'MARKETING')]")
	private WebElement marketingOptions;

	@FindBy(xpath = "//a[@title='Leads']")
	private WebElement leadOption;

	@FindBy(xpath = "//a[@href='index.php?module=Contacts&view=List&app=MARKETING' and @title='Contacts']")
	private WebElement contactOption;

	@FindBy(css = "company-logo")
	private WebElement companyLogo;

	@FindBy(css = "fa fa-user")
	private WebElement profileBtn;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutBtn;

	public void navigateToLeadPage() {
		clickOnElement(burgerMenu);
//		mouseHover("targetElement", marketingOptions, 0, 0);
		clickOnElement(marketingOptions);
		clickOnElement(leadOption);
	}

	public void navigateToContactPage() {
		clickOnElement(burgerMenu);
//		mouseHover("targetElement", marketingOptions, 0, 0);
		clickOnElement(marketingOptions);
		clickOnElement(contactOption);
	}

	public void signOut() {
		clickOnElement(companyLogo);
		clickOnElement(profileBtn);
		clickOnElement(signOutBtn);
	}
}
