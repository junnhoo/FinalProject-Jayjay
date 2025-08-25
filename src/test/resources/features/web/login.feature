Feature: Login
  @web @login @positive
  Scenario: Valid login
    Given user is on the Demoblaze home page
    When user clicks Login link
    And user enter username "junhoo" and password "123456"
    And user click Login button
    Then user should see message "Welcome junhoo"

  @web @login @negative
  Scenario: Invalid login
    Given user is on the Demoblaze home page
    When user clicks Login link
    And user enter username "junhooo" and password "123456"
    And user click Login button
    Then user should see error message "User does not exist."




