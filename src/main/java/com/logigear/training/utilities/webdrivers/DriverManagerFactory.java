package com.logigear.training.utilities.webdrivers;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class DriverManagerFactory {
    public DriverManager createInstance(String browser, ExtentTest logTest) {
        DriverManager driverManager;
        try {
            driverManager = LocalDriver.getDriverManager(logTest,browser);
            return driverManager;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RemoteWebDriver createInstanceGrid(String browser, ExtentTest logTest) {
        GridDriver driver = new GridDriver();
        try {
            return driver.initialDriver(browser, logTest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
