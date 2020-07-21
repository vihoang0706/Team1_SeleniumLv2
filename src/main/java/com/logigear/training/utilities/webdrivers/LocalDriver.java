package com.logigear.training.utilities.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;

import java.io.IOException;

public class LocalDriver {
    public static DriverManager getDriverManager(ExtentTest logTest, String browser) throws IOException {
        DriverManager driverManager = null;
        switch (browser.toLowerCase()) {
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FireFoxDriverManager();
                break;
            case "ie":
               driverManager = new IEDriverManager();
            default:
                DriverUtils.logFail(logTest, "Our framework does not support this platform: " + browser);
                break;
        }
        return driverManager;
    }
}