package com.radical3d.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                 //features = {"./FeatureFiles/AddProductToCart.feature"},
                 features = {"./FeatureFiles/"},
                 glue = "com.radical3d.stepDefinition",
                 tags = "not @Conviven",
                 plugin = {
                    "pretty", "html:reports/myreport.html"
                 })
public class CucumberRunner {
}
