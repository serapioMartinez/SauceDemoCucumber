package com.radical3d.stepDefinition;

import com.radical3d.factory.BaseClass;
import com.radical3d.pageObject.CheckoutCompletePage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class CheckoutCompleteSteps {

    CheckoutCompletePage checkoutComplete = new CheckoutCompletePage();

    @Then("validate checkout succesfull message")
    public void validate_checkout_succesfull_message(){
        final String succ_message = "Thank you for your order!";

        String actual_message = checkoutComplete.getCheckoutFinalMessage();

        Assertions.assertEquals(succ_message, actual_message);
    }
    @Then("user back to inventory page")
    public void user_back_to_inventory_page(){
        this.checkoutComplete.clickBackHomeButton();
        String expectedUrl = BaseClass.getProperties().get("inventoryUrl").toString();
        String actualUrl = BaseClass.getWebDriver().getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}
