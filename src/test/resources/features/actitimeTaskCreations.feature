Feature: It contains Tcs related to Actitime task creation functionality

  @Regression
  Scenario Outline: create new task "<Flow>" on "<Server>"
    Given user is on actitime login page for task creation
    And user enters username as "<username>" and password as "<password>"
    And user click on actitime login button
    When click on task tab
    And click on add new task button
    And select new task option
    And select project from project dropdown
    And enter the task name as "<taskName>"
    And click on the create task button
    Then user should be able to see created task

    Examples: 
      | Flow     | Server  | username | password | taskName    |
      | positive | QA      | admin    | manager  | Testing     |
      | negative | Qa      | admin    | Test@123 | Development |
      | positive | staging | trainee  | trainee  | Desining    |
