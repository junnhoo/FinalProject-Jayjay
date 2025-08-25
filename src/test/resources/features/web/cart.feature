Feature: Add item to shopping cart

  Background: Login
    Given user is on the Demoblaze home page
    When user clicks Login link
    And user enter username "junhoo" and password "123456"
    And user click Login button
    Then user should see message "Welcome junhoo"

  @web @cart
  Scenario: Add an item to shopping cart
    Then user clicks category "Phones"
    And user select product "Samsung galaxy s6"
    And user clicks "Add to cart"
    Then user should see a message "Product added." and accept it
    When user click Cart link
    Then product "Samsung galaxy s6" should be in the cart
