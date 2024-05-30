package com.radical3d.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.util.List;

public class CheckOutShopInfoPage extends BasePage{

    public static final DecimalFormat df= new DecimalFormat("0.00");

    @FindAll(@FindBy(css = ".cart_list .cart_item"))
    private List<WebElement> productList;

    @FindBy(css = ".summary_info .summary_subtotal_label")
    private WebElement itemsTotal;

    @FindBy(css = ".summary_info .summary_tax_label")
    private WebElement tax;

    @FindBy(css = ".summary_info .summary_total_label")
    private WebElement totalPrice;

    @FindBy(css = "button#cancel")
    private WebElement cancelCheckoutButton;

    @FindBy(css = "button#finish")
    private WebElement finishCheckOutButton;

    public CheckOutShopInfoPage(){
        super();
    }

    public static double getNum_from_priceLabel(String priceLabel){
        String[] stringSplitted = priceLabel.split("\\$",2);
        return Double.parseDouble(stringSplitted[1]);
    }

    public int getTotalProductsForCheckout(){
        return this.productList.size();
    }

    public String getItemsTotalPrice(){
        System.out.println(this.itemsTotal.getText());
        return df.format(getNum_from_priceLabel(
                this.itemsTotal.getText()
        ));
    }

    public String getTaxTotalPrice(){
        return df.format(getNum_from_priceLabel(
                this.tax.getText()
        ));
    }

    public String getTotalPrice(){
        return df.format(getNum_from_priceLabel(
                this.totalPrice.getText()
        ));
    }

    public void clickCancelCheckout(){
        this.cancelCheckoutButton.click();
    }

    public void clickFinishCheckoutButton(){
        this.finishCheckOutButton.click();
    }
}
