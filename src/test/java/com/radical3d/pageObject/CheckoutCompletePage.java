package com.radical3d.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{

    @FindBy(css = "#checkout_complete_container h2.complete-header")
    private WebElement checkoutFinalStatus;

    @FindBy(css = "#checkout_complete_container button#back-to-products")
    private WebElement backHomeButton;

    public CheckoutCompletePage(){
        super();
    }

    public String getCheckoutFinalMessage(){
        return this.checkoutFinalStatus.getText();
    }

    public void clickBackHomeButton(){
        this.backHomeButton.click();
    }
}
