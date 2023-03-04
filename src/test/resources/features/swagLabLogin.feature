Feature: It contains TCs releated to swagLab login funtionality

  #   Background will be executed before each scenario in this feature file but after the '@before' hook.
  Background: This background will be used to execute common pre-requisite step for all the scenarios and scenario
    outline defined in this feature file

    Given user is on swaglab login page
@Smoke @SpecificHook
  Scenario: Test the swagLab login funtionality with different users
    When user enters userName and password
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
    And user click on the login button
    Then user should logged in successfully for valid user


@Regression
  Scenario: Test the SwagLab login functionality with different users using database as map
    When user enters userName and password using datatable data
      | username        | password     |
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
    And user click on the login button
    Then user should logged in successfully for valid user
