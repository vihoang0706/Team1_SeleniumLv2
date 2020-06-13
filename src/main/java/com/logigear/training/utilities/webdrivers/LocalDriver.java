package com.logigear.training.utilities.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.Utility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

import static com.logigear.training.common.GlobalVariables.*;

public class LocalDriver extends Utility {
    public RemoteWebDriver webDriver;

    public synchronized RemoteWebDriver initialDriver(String browser, ExtentTest logTest) throws IOException {
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_WIN);
                    this.webDriver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_WIN);
                    webDriver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    log4j.error("Our framework does not support this platform: " + browser);
                    logFail(logTest, "Our framework does not support this platform: " + browser);
                    break;
            }
        } catch (Exception e) {
            log4j.error("initialDriver method - ERROR: " + e);
            logException(logTest, "initialDriver method - ERROR: ", e);
        }

        return webDriver;
    }
}
