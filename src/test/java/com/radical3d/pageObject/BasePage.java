package com.radical3d.pageObject;

import com.radical3d.factory.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage() {
        webDriver = BaseClass.getWebDriver();
        PageFactory.initElements(webDriver, this);
    }
}
