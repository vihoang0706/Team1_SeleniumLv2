package com.logigear.training.utilities.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class LocalDriver extends DriverUtils {
    public RemoteWebDriver webDriver;

    public synchronized RemoteWebDriver initialDriver(String browser, ExtentTest logTest) throws IOException {
        try {
            // Set chrome driver path
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    WebDriverManager.chromedriver().arch32().version("83.0.4103.14").setup();
                    this.webDriver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    WebDriverManager.firefoxdriver().setup();
                    this.webDriver = new FirefoxDriver(firefoxOptions);
                    break;
                case "ie":
                    InternetExplorerOptions options = new InternetExplorerOptions();
                    WebDriverManager.iedriver().setup();
                    this.webDriver = new InternetExplorerDriver(options);
                default:
                    logFail(logTest, "Our framework does not support this platform: " + browser);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return webDriver;
    }
}