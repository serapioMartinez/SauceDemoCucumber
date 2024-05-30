package com.radical3d.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(id = "login-button")
    private WebElement longInButton;

    @FindBy(css = "form .error-message-container")
    private WebElement errorMessage;

    public LoginPage(){
        super();
    }

    public WebElement getUserNameInput() {
        return userNameInput;
    }

    public WebElement getPassInput() {
        return passInput;
    }

    public WebElement getLongInButton() {
        return longInButton;
    }

    public WebElement getErrorMessageDiv(){
        return errorMessage;
    }

    public void sendKeysUserNameInput(String keys){
        this.userNameInput.sendKeys(keys);
    }

    public void sendkeysPassInput(String keys){
        this.passInput.sendKeys(keys);
    }

    public void clickLoginbutton(){
        this.longInButton.click();
    }
}
