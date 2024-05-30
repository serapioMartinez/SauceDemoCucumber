package com.radical3d.stepDefinition;

import com.radical3d.factory.BaseClass;
import com.radical3d.pageObject.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class InventorySteps {
    private InventoryPage inventoryPage = new InventoryPage();;

    @Given("system set username cookie {string}")
    public void system_set_username_cookie(String username){
        BaseClass.getWebDriver().get(
                BaseClass.getProperties().getProperty("url")
        );
        BaseClass.getWebDriver().manage().addCookie(new Cookie("session-username",username));
    }
    @Given("user go to the inventory page")
    public void user_go_to_the_inventory_page(){
        BaseClass.getWebDriver().get(
                BaseClass.getProperties().getProperty("inventoryUrl")
        );
    }

    @When("user select the filter by value {string}")
    public void user_select_the_filter_by_value(String visibleTextFilter){
        inventoryPage.defineOrderFilter(visibleTextFilter);
    }

    @Then("user validate first product is the lower priced one")
    public void user_validate_first_product_is_the_lower_priced_one(){
        String expectedPrice = "$7.99";

        String actualPrice = inventoryPage.getFirstProductPrice();

        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Then("user add first_product_to_cart")
    public void user_add_first_product_to_cart(){
        String expectedProductsInCart = "1";

        inventoryPage.addfirstElementToCart();
        String actualProductsInCart = inventoryPage.getTotalProductsInCart();

        Assertions.assertEquals(expectedProductsInCart, actualProductsInCart);

    }

    @Then("user add the {string} product to the cart")
    public void user_add_the_n_product_to_the_cart(String product_ref){
        //Given
        int expectedProductsInCart = Integer.parseInt(inventoryPage.getTotalProductsInCart())+1;

        //When
        WebElement productButton;
        switch(product_ref){
            case "second":
                this.inventoryPage.getSecondProductElements().get(2).click();
                productButton = this.inventoryPage.getSecondProductElements().get(2);
                break;
            case "third":
                this.inventoryPage.getThirdProductElements().get(2).click();
                productButton = this.inventoryPage.getThirdProductElements().get(2);
                break;
            case "fourth":
                this.inventoryPage.getFourthProductElements().get(2).click();
                productButton = this.inventoryPage.getFourthProductElements().get(2);
                break;
            case "fifth":
                this.inventoryPage.getFifthProductElements().get(2).click();
                productButton = this.inventoryPage.getFifthProductElements().get(2);
                break;
            case "sixth":
                this.inventoryPage.getSixthProductElements().get(2).click();
                productButton = this.inventoryPage.getSixthProductElements().get(2);
                break;
            default:
                throw new NoSuchElementException("Element out of existing products or referencing to first product");
        }
        int actualProductsInCart = Integer.parseInt(inventoryPage.getTotalProductsInCart());

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedProductsInCart, actualProductsInCart),
                () -> Assertions.assertEquals("Remove",productButton.getText())
        );
    }

    @Then("user remove first_product_from_cart")
    public void user_remove_first_product_from_cart() throws Exception{
        int expectedproductsInCart = (inventoryPage.getTotalProductsInCart()
                        .isEmpty()?-1:Integer.parseInt(inventoryPage.getTotalProductsInCart())-1);
        if(expectedproductsInCart==-1) throw new Exception("There's no products in the Cart");

        inventoryPage.removeFirstElementFromCart();

        if(expectedproductsInCart==0){
            Assertions.assertAll(
                    () -> Assertions.assertThrows(NoSuchElementException.class,() -> inventoryPage.getTotalProductsInCart()),
                    () -> Assertions.assertEquals("Add to cart", inventoryPage.
                            getFirstProductElements().get(2).getText())
            );

            return;
        }

        int actualProductsInCart = Integer.parseInt(inventoryPage.getTotalProductsInCart())-1;
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedproductsInCart, actualProductsInCart),
                () -> Assertions.assertEquals("Add to cart", inventoryPage.
                                getFirstProductElements().get(2).getText())
        );
    }

    @Then("user click to the cart button to see the cart page")
    public void user_click_to_the_cart_button_to_see_the_cart_page(){
        this.inventoryPage.click_goToShoppingCart();
    }
}
