package com.radical3d.stepDefinition;

import com.radical3d.factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before
    public void init() throws IOException {
        System.out.println("init method");
        BaseClass.initializeWebDriver();
    }

    @After
    public void finalice() throws InterruptedException{
        BaseClass.getWebDriver().quit();
    }
}
