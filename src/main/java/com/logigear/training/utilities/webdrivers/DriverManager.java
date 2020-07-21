package com.logigear.training.utilities.webdrivers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void initialDriver();

    public void quitWebDriver() {
        if(null!=driver) {
            driver.quit();
            driver=null;
        }
    }

    public WebDriver getDriver() {
        if(null==driver) {
            initialDriver();
        }
        return driver;
    }
}