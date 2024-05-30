package com.radical3d.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPIFormPage extends BasePage{

    @FindBy(css = "input#first-name")
    private WebElement fisrtNameField;

    @FindBy(css = "input#last-name")
    private WebElement lastNameField;

    @FindBy(css = "input#postal-code")
    private WebElement zipCodeField;

    @FindBy(css = ".checkout_buttons #cancel")
    private WebElement cancelCheckoutButton;

    @FindBy(css = ".checkout_buttons #continue")
    private WebElement continueCheckoutButton;

    public CheckOutPIFormPage(){
        super();
    }

    public WebElement getFisrtNameField() {
        return fisrtNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public WebElement getCancelCheckoutButton() {
        return cancelCheckoutButton;
    }

    public WebElement getContinueCheckoutButton() {
        return continueCheckoutButton;
    }

    public void fillInPIForm(String firstName, String lastName, String zipCode){
        this.fisrtNameField.sendKeys(firstName);
        this.lastNameField.sendKeys(lastName);
        this.zipCodeField.sendKeys(zipCode);
    }

    public void clickCancelChekcout(){
        this.cancelCheckoutButton.click();
    }

    public void clickContinueCheckout(){
        this.continueCheckoutButton.click();
    }
}
