Feature: Vtiger login funtionality

  Scenario: Test the login funtionality of Vtiger
    Given User open the "chrome" browser and Vtiger application using "https://demo.vtiger.com/vtigercrm/index.php"
    When User enters userName as "admin" and password as "Test@123"
    And User click on the Login Button
    Then User will be navigate to home page
