Feature: Checkout Process
  Background: Login
    Given user is on the Demoblaze home page
    When user clicks Login link
    And user enter username "junhoo" and password "123456"
    And user click Login button
    Then user should see message "Welcome junhoo"
    Then user clicks category "Phones"
    And user select product "Samsung galaxy s6"
    And user clicks "Add to cart"
    Then user should see a message "Product added." and accept it
    When user click Cart link
    Then product "Samsung galaxy s6" should be in the cart

  @web @checkout @positive
  Scenario: Checkout with the product in cart
    And user clicks the Place Order button
    And user fills the form order:
      | Name      | Country | City   | Credit Card      | Month | Year |
      | Jun Hoo   | Japan   | Tokyo  | 1234567890123456 | 10    | 2026 |
    And user clicks the Purchase button
    Then user see message "Thank you for your purchase!"
    And user clicks OK button for confirmation

