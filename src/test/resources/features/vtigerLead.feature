Feature: Test the create lead and delete the created lead functionality

  Background: 
    Given User is on Vtiger login page
    And user login using valid credential
    And user navigate to the lead page

  @Smoke @Regression
  Scenario Outline: Create new lead with name as "<firstname>"
    When user click on the add lead button
    And user enters firstname as "<firstname>" and last name as "<lastname>" and click on the save button
    Then verify lead is created with "<firstname>"

    Examples: 
      | firstname | lastname |
      | Smith     | Lee      |
      | Jack      | Mike     |

  @Smoke @Regression
  Scenario: Delete all the created leads
    When user click on the select all leads checkbox
    And user clik on the delete button
    Then delete confirmation pop up will appear
    When user clik on yes to confirm the deletion
    Then vrify that all the leads are deleted
