Feature: Account Activity page


  Scenario: Account	Activity page title
    Given the user is on the login page
    When the user enters the user information
    Then the user is on the Account Activity Page
    And Account Activity page title contains "Zero - Account Activity"


  Scenario: Account	Activity page default account option
    Given the user is on the login page
    When the user enters the user information
    Then the user is on the Account Activity Page
    And In the Account drop	down default option should be "Savings"


  Scenario: Account drop down have following options
    Given the user is on the login page
    When the user enters the user information
    Then the user is on the Account Activity Page
    And In the Account dropdown should be following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions column	names
    Given the user is on the login page
    When the user enters the user information
    Then the user is on the Account Activity Page
    And Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
