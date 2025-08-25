Feature: Sign Up for the Web Demoblaze
  @web @signup @positive
  Scenario: Valid Sign Up
    Given user is on the Demoblaze home page
    When user click Sign Up
    And user enter new username "newautousername" and password "123456"
    And user click Sign up button
    Then user should see notif message "Sign up successful."
