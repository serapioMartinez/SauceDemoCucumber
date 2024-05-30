package com.radical3d.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends BasePage{

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(css = "#shopping_cart_container a.shopping_cart_link")
    private WebElement goToShoppingCartLink;

    @FindBy(css = ".header_label .app_logo")
    private WebElement pageMainTitle;

    @FindBy(css = "select.product_sort_container")
    private WebElement selectFilter;

    @FindAll({
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(1) .inventory_item_label a"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(1) .pricebar .inventory_item_price"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(1) .pricebar button")})
    private List<WebElement> firstProductElements;

    @FindAll({
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(2) .inventory_item_label a"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(2) .pricebar .inventory_item_price"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(2) .pricebar button")})
    private List<WebElement> secondProductElements;

    @FindAll({
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(3) .inventory_item_label a"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(3) .pricebar .inventory_item_price"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(3) .pricebar button")})
    private List<WebElement> thirdProductElements;

    @FindAll({
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(4) .inventory_item_label a"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(4) .pricebar .inventory_item_price"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(4) .pricebar button")})
    private List<WebElement> fourthProductElements;

    @FindAll({
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(5) .inventory_item_label a"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(5) .pricebar .inventory_item_price"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(5) .pricebar button")})
    private List<WebElement> fifthProductElements;

    @FindAll({
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(6) .inventory_item_label a"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(6) .pricebar .inventory_item_price"),
            @FindBy(css = "div.inventory_list .inventory_item:nth-child(6) .pricebar button")})
    private List<WebElement> sixthProductElements;

    public InventoryPage(){
        super();
        //selectFilter = webDriver.findElement(By.cssSelector("select.product_sort_container"));
    }

    public Select getSelectFilter() {
        return new Select(selectFilter);
    }

    public List<WebElement> getFirstProductElements() {
        return firstProductElements;
    }

    public WebElement getShoppingCartBadge() {
        return shoppingCartBadge;
    }

    public WebElement getGoToShoppingCartLink() {
        return goToShoppingCartLink;
    }

    public WebElement getPageMainTitle() {
        return pageMainTitle;
    }

    public List<WebElement> getSecondProductElements() {
        return secondProductElements;
    }

    public List<WebElement> getThirdProductElements() {
        return thirdProductElements;
    }

    public List<WebElement> getFourthProductElements() {
        return fourthProductElements;
    }

    public List<WebElement> getFifthProductElements() {
        return fifthProductElements;
    }

    public List<WebElement> getSixthProductElements() {
        return sixthProductElements;
    }

    public void defineOrderFilter(String visibleText){
        Select filterSelect = new Select(this.selectFilter);
        System.out.println(pageMainTitle.getText());
        filterSelect.selectByValue(visibleText);
    }
    public void addfirstElementToCart(){
        this.firstProductElements.get(2). //index 2 is the button
                click();
        System.out.println(this.firstProductElements.get(1). //index 1 is the price
                getText());
    }

    public void removeFirstElementFromCart(){
        this.firstProductElements.get(2). //index 2 is the button
                click();
    }

    public void addToCartLastElement(){
        this.sixthProductElements.get(2).
                click();
        System.out.println(this.sixthProductElements.get(1).
                getText());
    }

    public String getFirstProductPrice(){
        return firstProductElements.get(1).getText();
    }

    public String getTotalProductsInCart(){
        return shoppingCartBadge.getText();
    }

    public void click_goToShoppingCart(){
        this.goToShoppingCartLink.click();
    }
}
