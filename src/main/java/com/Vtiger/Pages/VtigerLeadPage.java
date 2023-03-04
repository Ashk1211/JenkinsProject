package com.Vtiger.Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import utility.SeleniumUtility;

public class VtigerLeadPage extends SeleniumUtility {

	@FindBy(id = "Leads_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addLeadBtn;

	@FindBy(xpath = "(//span[text()='None'])[1]")
	private WebElement saturationDropDownForLead;

	@FindBy(xpath = "//ul[@class='select2-results']/li[2]")
	private WebElement selectSaturationForLead;

	@FindBy(id = "Leads_editView_fieldName_firstname")
	private WebElement firstNameField;

	@FindBy(id = "Leads_editView_fieldName_lastname")
	private WebElement lastNameField;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "(//a[@title='Leads'])[2]")
	private WebElement leadHeaderLink;

	@FindAll({ @FindBy(xpath = "//a[text()='Smith']"), @FindBy(xpath = "//a[text()='Jeff']") })
	private WebElement newlyCreatedLeadName;

	@FindBy(xpath = "//a[text()='Smith']")
	private WebElement newlyCreatedLeadName1;

	@FindBy(xpath = "//a[text()='Jack']")
	private WebElement newlyCreatedLeadName2;

	@FindBy(css = ".listViewEntriesMainCheckBox")
	private WebElement selectAllCheckBox;

	@FindBy(xpath = "//button[@title='Delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//div[text()='Are you sure you want to delete the selected Records?']")
	private WebElement deletePopupMsg;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confirmDeleteBtn;

	@FindBy(css = ".emptyRecordsContent")
	private WebElement emptyRecord;

	public void clickOnaddLeadBtn() {
		clickOnElement(addLeadBtn);
	}

	public void createLead(String firstName, String lastName) {
		clickOnElement(saturationDropDownForLead);
		clickOnElement(selectSaturationForLead);
		typeInput(firstNameField, firstName);
		typeInput(lastNameField, lastName);
		clickOnElement(saveBtn);
	}

	public boolean VerifyCreatedLead() {
//		verifyUIElementDisplayed(driver.findElement(By.xpath("//a[text()='" + leadFirstName + "']")));
		clickOnElement(leadHeaderLink);
		try {
			return verifyUIElementIsDisplayed(newlyCreatedLeadName);
		} catch (TimeoutException e) {
			return false;
		}
	}

	public void clickOnSelectAllCheckBox() {
		clickOnElement(selectAllCheckBox);
	}

	public void clickOnDeleteBtn() {
		clickOnElement(deleteBtn);
	}

	public boolean verfiyDeletePopup() {
		try {
			return verifyUIElementIsDisplayed(deletePopupMsg);
		} catch (TimeoutException e) {
			return false;
		}

	}

	public void clickOnYesBtn() {
		clickOnElement(confirmDeleteBtn);
	}

	public boolean verifyLeadIsDeleted() {
		try {
			return (verifyUIElementIsDisplayed(emptyRecord));
		} catch (TimeoutException e) {
			return false;
		}
	}

}
