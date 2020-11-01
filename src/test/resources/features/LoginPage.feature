@Login
Feature:Users should be able to login

  Background:
    Given the user is on the login page
    When the user enters the user information

  Scenario: Login as a user with valid credentials
    Then the user should be able to login
    And Account summary page should	be displayed

  Scenario: Login as a user with invalid credentials
    Then the user should be not able to login
    And  error message "Login and/or password are wrong." should be displayed

  Scenario: Login as a user with invalid credentials
    Then the user should be not able to login
    And  error message "Login and/or password are wrong." should be displayed