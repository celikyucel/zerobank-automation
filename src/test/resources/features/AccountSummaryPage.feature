Feature: Account Summary Page


  Scenario: Account	summary	page should have title
    Given the user is on the login page
    When the user enters the user information
    Then Account Summary Page title contains "Zero - Account Summary"
    And the user should see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
