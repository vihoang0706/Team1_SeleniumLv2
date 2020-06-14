package com.logigear.training.utilities.webdrivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.logigear.training.common.Constants.CHROME_DRIVER_LOCATION;

public class ChromeDriverManager extends DriverManager{
    @Override
    protected void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        // set your browser-specific options here
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        this.driver = new ChromeDriver(options);
    }
}
