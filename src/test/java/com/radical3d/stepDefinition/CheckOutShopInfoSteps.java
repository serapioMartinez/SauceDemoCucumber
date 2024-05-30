package com.radical3d.stepDefinition;

import com.radical3d.factory.BaseClass;
import com.radical3d.pageObject.CheckOutShopInfoPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckOutShopInfoSteps {

    private CheckOutShopInfoPage infoCheckoutPage = new CheckOutShopInfoPage();

    @Then("validate cart list have {int} products")
    public void calidate_cart_list_have_n_products(int expectedTotalProducts){

        int actualTotalProducts = infoCheckoutPage.getTotalProductsForCheckout();

        Assertions.assertEquals(expectedTotalProducts, actualTotalProducts);
    }
    @Then("validate total price is correct for products total {string}")
    public void validate_total_price_is_correct_for_products_total(String expectedProdTotalPrice){
        //Given
        String expectedTaxTotal = CheckOutShopInfoPage.df.format(Double.parseDouble(expectedProdTotalPrice)*0.08);
        String expectedTotalPrice = CheckOutShopInfoPage.df.format(Double.parseDouble(expectedProdTotalPrice)+Double.parseDouble(expectedTaxTotal));

        //When
        String actualProdTotalPrice = this.infoCheckoutPage.getItemsTotalPrice();
        String actualTaxTotal= this.infoCheckoutPage.getTaxTotalPrice();
        String actualTotalPrice = this.infoCheckoutPage.getTotalPrice();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedProdTotalPrice, actualProdTotalPrice),
                () -> Assertions.assertEquals(expectedTaxTotal, actualTaxTotal),
                () -> Assertions.assertEquals(expectedTotalPrice, actualTotalPrice)
        );

    }

    @Then("user finish chekout")
    public void user_finish_checkout(){
        this.infoCheckoutPage.clickFinishCheckoutButton();
        WebElement checkoutComplete = BaseClass.getWebDriver().findElement(By.cssSelector("span.title"));

        Assertions.assertEquals("Checkout: Complete!", checkoutComplete.getText());
    }
}
