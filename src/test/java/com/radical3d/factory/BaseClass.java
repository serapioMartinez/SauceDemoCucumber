package com.radical3d.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static Properties props;

    public static void initializeWebDriver() throws IOException{
        initializeProperties();
            switch (props.getProperty("browser")){
                case "chrome":
                    webDriver.set(new ChromeDriver());
                    break;
                case "edge":
                    webDriver.set(new EdgeDriver());
                    break;
                case "firefox":
                    webDriver.set(new FirefoxDriver());
                    break;
                default:
                    webDriver.set(new ChromeDriver());
                    break;
            }


    }

    public static void initializeProperties() throws IOException {
        InputStream myStream = new FileInputStream("./src/test/resources/data.properties");
        props = new Properties();
        props.load(myStream);
    }

    public static Properties getProperties(){
        return props;
    }

    public static WebDriver getWebDriver(){
        return webDriver.get();
    }

}
