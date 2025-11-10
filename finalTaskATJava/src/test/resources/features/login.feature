Feature: Login Tests saucedemo

  Scenario: Failed login without any credentials
    Given the user is on the login page
    When the user fills username and password fields with random values
    And clears the username and password fields
    And clicks the Login button
    Then the error message should contain "Username is required"

  Scenario: Failed login with username but no password
    Given the user is on the login page
    When the user fills username and password fields with random values
    And clears the password field
    And clicks the Login button
    Then the error message should contain "Password is required"

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user fills username and password fields with valid credentials
    And clicks the Login button
    Then the user should see the logo text "Swag Labs" on the home page