Feature: Select category
  Background: Login
    Given user is on the Demoblaze home page
    When user clicks Login link
    And user enter username "junhoo" and password "123456"
    And user click Login button
    Then user should see message "Welcome junhoo"

  @web @category @positive
  Scenario: Select Phones category
    Then user clicks category "Phones"
    And user should see product "Samsung galaxy s6"

  @web @category @positive
  Scenario: Select Laptops category
    Then user clicks category "Laptops"
    And user should see product "Sony vaio i5"