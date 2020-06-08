package com.logigear.training.utility.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utility.Utility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

import static com.logigear.training.common.Constants.*;

public class LocalDriver extends Utility {
    public RemoteWebDriver webDriver;

    public synchronized RemoteWebDriver initialDriver(String browser, ExtentTest logTest) throws IOException {
        try {
            // Set chrome driver path
             if (OS_NAME.contains("windows")) {
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
                System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION);
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    webDriver = new ChromeDriver();
                    break;
                case "firefox":
                    webDriver = new FirefoxDriver();
                    break;
                case "safari":
                    webDriver = new SafariDriver();
                    break;
                default:
                    //log4j.error("Our framework does not support this platform: " + browser);
                    logFail(logTest, "Our framework does not support this platform: " + browser);
                    break;
            }
        } catch (Exception e) {

        }

        return webDriver;
    }
}


