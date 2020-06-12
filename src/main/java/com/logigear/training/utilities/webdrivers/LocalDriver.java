package com.logigear.training.utilities.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.Utility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

import static com.logigear.training.common.GlobalVariables.*;

/**
 * Created by vinh.ly on 8/30/2018.
 */
public class LocalDriver extends Utility {
    public RemoteWebDriver webDriver;

    public synchronized RemoteWebDriver initialDriver(String browser, ExtentTest logTest) throws IOException {
        try {
//            // Set chrome driver path
//            } else if (OS_NAME.contains("windows")) {
//                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_WIN);
//                System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_WIN);
//            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    webDriver = new ChromeDriver();
                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_WIN);
                    break;
                case "firefox":
                    webDriver = new FirefoxDriver();
                    System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_WIN);
                    break;
//                case "safari":
//                    webDriver = new SafariDriver();
//                    break;
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
