package com.radical3d.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = "button#continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(css = "button#checkout")
    private WebElement checkoutButton;

    @FindAll(@FindBy(css = ".cart_list .cart_item"))
    private List<WebElement> cartItems;

    public CartPage(){
        super();
    }

    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public List<WebElement> getCartItems() {
        return cartItems;
    }

    public String getCartItemName(int index){
        if(this.cartItems.isEmpty()) return null;
        return this.cartItems.get(index-1).findElement(By.tagName("a")).getText();
    }

    public void clickCheckoutButton(){
        this.checkoutButton.click();
    }

    public void clickContinueShopButton(){
        this.continueShoppingButton.click();
    }
    public void removeItemFromCartList(int index){
        WebElement removeItemButton = this.getCartItems().get(index-1).findElement(By.tagName("button"));
        //JavascriptExecutor jsExecutor = (JavascriptExecutor)this.webDriver;
        //jsExecutor.executeScript("arguments[0].click();", removeItemButton);
        //System.out.println(removeItemButton.getText());
        removeItemButton.click();
        webDriver.navigate().refresh();
        System.out.println(this.getCartItems().size());
    }
}
