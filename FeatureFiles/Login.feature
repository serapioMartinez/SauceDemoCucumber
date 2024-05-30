Feature: Login page feature
  Background:
    Given user enters the login page

  Scenario: Succesfull login to the shopping page
#    Given user enters the login page
    When user enter the username "standard_user"
    And user enter the password "secret_sauce"
    And  user click the Login Button
    Then user login succesfully

  @Conviven
  Scenario: Blocked user login
#    Given user enters the login page
    When user enter the username "locked_out_user"
    And user enter the password "secret_sauce"
    And  user click the Login Button
    Then user sees an error message for locked user