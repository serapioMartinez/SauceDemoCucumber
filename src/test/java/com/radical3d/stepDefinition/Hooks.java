package com.radical3d.stepDefinition;

import com.radical3d.factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    public void finalice() throws InterruptedException {
        driver.quit();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {

        Iterator<String> tags = scenario.getSourceTagNames().iterator();
        
        while(tags.hasNext()){
            System.out.println(tags.next());
        }
        TakesScreenshot ts = (TakesScreenshot) driver;
        scenario.attach(ts.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());

    }
}
