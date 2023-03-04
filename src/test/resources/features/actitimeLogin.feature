Feature: Actitime Login functionality

@Smoke @Regression
  Scenario: Test the login functionality with Admin credentials
    Given Browser is opend and user is on actitime login page
    When User enters the username and password
    And User click on the login button
    Then User will be navigated to home page
