package com.logigear.training.utilities.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.common.Constants;
import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

import static com.logigear.training.common.Constants.CHROME_DRIVER_LOCATION;
import static com.logigear.training.common.Constants.GECKO_DRIVER_LOCATION;

public class LocalDriver extends DriverUtils {
    public RemoteWebDriver webDriver;
    public synchronized RemoteWebDriver initialDriver(String browser, ExtentTest logTest) throws IOException {
        try {
            // Set chrome driver path
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
                    this.webDriver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION);
                    this.webDriver = new FirefoxDriver(firefoxOptions);
                    break;
                case "ie":
                    InternetExplorerOptions options = new InternetExplorerOptions();
                    System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_LOCATION);
                    this.webDriver = new InternetExplorerDriver(options);
                default:
                    //log4j.error("Our framework does not support this platform: " + browser);
//                    logFail(logTest, "Our framework does not support this platform: " + browser);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return webDriver;
    }
}
