package com.logigear.training.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import static com.logigear.training.common.Constants.*;

public class DriverUtils {
    public static String subWindowHandler = null;
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        System.out.println(driver.get());
        return driver.get();
    }
    public static void setDriver(RemoteWebDriver webDriver) {
        driver.set(webDriver);
    }

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        String timestampStr = dtf.format(now);
        return timestampStr;
    }

    public static void navigateToTestSite(String url) {
            //logInfo(logTest, "Navigate to site: " + url);
            getDriver().navigate().to(url);
            maximizeWindow();
    }

    public static boolean isElementClickable(WebElement elementName, int waitTime) throws IOException {
        try {

            new WebDriverWait(getDriver(), waitTime).until(ExpectedConditions.visibilityOf(elementName));
            new WebDriverWait(getDriver(), waitTime).until(ExpectedConditions.elementToBeClickable(elementName));

            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public static void checkControlExist(WebElement elementName, String objectName) throws IOException {
        try {
            waitForControl(elementName);
        } catch (Exception e) {

        }
    }

    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (Exception e) {

        }
    }

    public static void waitForControl(WebElement controlName) {
        try {
            new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception ex) {
        }
    }

    public static void waitForControlToBeClickable(WebElement controlName) {
        new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.elementToBeClickable(controlName));
    }

    public static void refreshPage() {
        try {
            getDriver().navigate().refresh();
        } catch (Exception e) {

        }
    }

    public static void scrollIntoView(WebElement controlName) {
        waitForControl(controlName);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", controlName);
    }

    public static boolean doesControlExist(WebElement control){
        try {
            return control.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }
    public static String getStackTrade(StackTraceElement[] stackTradeElements) {
        try {
            String stackTrade = "";
            for (StackTraceElement element : stackTradeElements) {
                stackTrade += element.toString() + "</br>";
                // Get stacktrade from comm.module level only
                if (element.toString().startsWith("com.logigear.tranining.user.management"))
                    break;
            }
            return stackTrade;
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getWindowHandle(WebDriver driver) {
        // get all the window handles after the popup window appears
        Set<String> afterPopup = driver.getWindowHandles();

        Iterator<String> iterator = afterPopup.iterator();
        while (iterator.hasNext())
            subWindowHandler = iterator.next();

        return subWindowHandler;
    }
    public static void switchToWindowHandle() throws IOException {
        try {
            String popupWidowHandle = getWindowHandle(getDriver());
            getDriver().switchTo().window(popupWidowHandle);
            maximizeWindow();
        } catch (Exception e) {
        }
    }
}
