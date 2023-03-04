Feature: OrangeHrm login functionality

  @Smoke
  Scenario: Test the login functionality of OrangeHrm
    Given User opens the "edge" browser and OrangeHrm application using "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters UserName as "Admin" and Password as "admin123"
    And User click on the Login button
    Then User should navigate to home page having url as "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"

  @Regression
  Scenario: Test the login funtionality of Orange Hrm using excel reading
    Given application url is on "LoginDetails" sheet and row number is 1
    And login credentials is on "LoginDetails" sheet and row number is 1
    And user open the browser and application as per shhet details
    When user enter username and password as per the sheet data
    And user click on the login button after entering username and password
    Then user logged in successfully
