@Login
Feature:Users should be able to login

  Background:
    Given the user is on the login page

  Scenario: Login as a user with valid credentials
    When the user enters the user information
    Then the user should be able to login
    And Account summary page should	be displayed

  Scenario: Login as a user with invalid credentials
    When the user enters the wrong user information
    Then the user should be not able to login
    And  error message "Login and/or password are wrong." should be displayed

  Scenario: Login as a user with invalid credentials
    When the user enters the blank username or password information
    Then the user should be not able to login
    And  error message "Login and/or password are wrong." should be displayed