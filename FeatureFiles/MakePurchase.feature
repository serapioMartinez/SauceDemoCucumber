Feature: Make purchase

  Background: Login and access to the inventory page
    Given system set username cookie "standard_user"
    Then user go to the inventory page
  @Conviven
  Scenario: Order by higger to lower price and Add two products to cart and proceed to ckeckout
    Given user select the filter by value "hilo"
    And user add first_product_to_cart
    And user add the "third" product to the cart
    When user click to the cart button to see the cart page
    And validate cart have 2 items
    And user delete 1 product from the cart
    Then user procced to checkout
    And user fill in the personal information form data
      | Fields     | Values         |
      | first_name | Test name      |
      | last_name  | Test last name |
      | zip_code   | 00000          |
    And click continue chekcout button
    And validate cart list have 1 products
    And validate total price is correct for products total "15.99"
    And user finish chekout
    And validate checkout succesfull message
    And user back to inventory page

