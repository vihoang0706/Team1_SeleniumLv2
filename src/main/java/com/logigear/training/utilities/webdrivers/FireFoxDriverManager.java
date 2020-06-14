package com.logigear.training.utilities.webdrivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static com.logigear.training.common.Constants.GECKO_DRIVER_LOCATION;

public class FireFoxDriverManager extends DriverManager{
    @Override
    protected void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION);
        this.driver = new FirefoxDriver(options);
    }
}
