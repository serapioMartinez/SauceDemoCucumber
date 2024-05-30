package com.radical3d.stepDefinition;

import com.radical3d.factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;
    @Before
    public void init() throws IOException {
        System.out.println("init method");
        BaseClass.initializeWebDriver();
        driver = BaseClass.getWebDriver();
    }

    @After
    public void finalice(Scenario scenario) throws InterruptedException{
        driver.quit();
    }
}
