Feature: Pay Bills Page

  Background:
    Given the user is on the login page
    When the user enters the user information
    Then the user is on the Pay Bills Page

  Scenario: Pay Bills Page title
    Then Pay Bills page title contains "Zero - Pay Bills"

  Scenario: Complete the pay operation
    When the user enters the amount and date
    Then "The payment was successfully submitted." should be displayed

  Scenario: Make a payment without entering the amount
    When the user doesn't enter the amount field
    Then "Please fill out this field." message should be displayed

  Scenario: Make a payment without entering the date
    When the user doesn't enter the date field
    Then "Please fill out this field." message should be displayed

  Scenario: Make a payment with entering the invalid characters in the amount
    When the user enters alphabetical characters in the amount field and valid characters in the date field
    Then "The payment was successfully submitted." should be not displayed


  Scenario: Make a payment with entering the alphabetical characters in the date
    When the user enters valid characters in the amount field and alphabetical characters in the date field
    Then "The payment was successfully submitted." should be not displayed