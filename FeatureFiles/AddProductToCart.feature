Feature: Add Products from the list to the Cart
#  Background: Login to the page
#    Given user enters the login page
#    When user enter the username "standard_user"
#    And user enter the password "secret_sauce"
#    And  user click the Login Button
#    Then user login succesfully
  @Conviven
  Scenario: user sort products from lower to higger price and add the lower priced product to 
    Given system set username cookie "standard_user"
    And user go to the inventory page
    When user select the filter by value "lohi"
    Then user validate first product is the lower priced one
    And user add first_product_to_cart
#    And user remove first_product_from_cart
    When user click to the cart button to see the cart page
    Then validate cart have 1 items
    And validate 1 item have the name "Sauce Labs Onesie"
    