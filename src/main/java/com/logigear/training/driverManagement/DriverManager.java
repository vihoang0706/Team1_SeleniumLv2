package com.logigear.training.driverManagement;

import com.logigear.training.common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class DriverManager {
    public static WebDriver driver;

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setDriverManager(DriverType type) {
        switch (type) {
            case CHROME:
                ChromeDriverManager();
                break;
            default:
                break;
        }
    }

    public static void ChromeDriverManager() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver(options);
    }
}