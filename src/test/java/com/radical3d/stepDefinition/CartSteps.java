package com.radical3d.stepDefinition;

import com.radical3d.pageObject.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class CartSteps {
    CartPage cartPage = new CartPage();

    @Then("validate cart have {int} items")
    public void cart_have_n_items(int expectedCartItems){
        int actualItemsInCart = cartPage.getCartItems().size();

        Assertions.assertEquals(expectedCartItems, actualItemsInCart);
    }

    @Then("validate {int} item have the name {string}")
    public void validate_i_item_have_the_name(int index, String expectedName){
        String actualName = this.cartPage.getCartItemName(index);

        Assertions.assertEquals(expectedName, actualName);
    }
    @When("user delete {int} product from the cart")
    public void user_delete_i_product_from_the_cart(int index){
        WebElement product = cartPage.getCartItems().get(index-1);
        int expectedProductsInCart = cartPage.getCartItems().size()-1;
        this.cartPage.removeItemFromCartList(index);

        Assertions.assertAll(
                () -> Assertions.assertThrows(StaleElementReferenceException.class, () -> product.isEnabled()),
                () -> Assertions.assertEquals(expectedProductsInCart, cartPage.getCartItems().size())
        );
    }
    @Then("user procced to checkout")
    public void user_procced_to_checkout(){
        this.cartPage.clickCheckoutButton();
    }

    @Then("user click continue shoppping")
    public void user_click_continue_shopping(){
        this.cartPage.clickContinueShopButton();
    }
}
