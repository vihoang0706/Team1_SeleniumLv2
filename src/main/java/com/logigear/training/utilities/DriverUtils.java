package com.logigear.training.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.webdrivers.DriverManagerFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;

public class DriverUtils {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(RemoteWebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void initializeDriver(String browser, ExtentTest logTest) throws IOException {
        try {
            DriverUtils.setDriver(new DriverManagerFactory().createInstance(browser,logTest));
            maximizeWindow();
        }  catch (Exception e) {
            logTest.info(e.getMessage());
        }
    }

    public static void quit(){
        DriverUtils.getDriver().close();
        DriverUtils.getDriver().quit();
    }

    public static void navigateToTestSite(String url) {
            DriverUtils.getDriver().navigate().to(url);
            maximizeWindow();
    }

    /**
     * @Action: sleep
     * wait for a specific time
     * @param timeout
     */
    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (Exception e) {

        }
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }
}
