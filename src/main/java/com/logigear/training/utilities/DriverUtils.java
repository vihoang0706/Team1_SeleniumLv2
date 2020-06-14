package com.logigear.training.utilities;

import com.logigear.training.common.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.logging.Log;

import static com.logigear.training.common.Constants.*;

public class DriverUtils {
    public static String subWindowHandler = null;
    public static Log log4j;

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        String timestampStr = dtf.format(now);
        return timestampStr;
    }

    public static void log4jConfiguration() {
        try {
            log4j = LogFactory.getLog(new Object().getClass());
        } catch (Exception e) {
            log4j.error("log4jConfiguration method - ERROR: " + e);
        }
    }

    public static void navigateToTestSite(String url) {
            //logInfo(logTest, "Navigate to site: " + url);
            Constants.DRIVER.navigate().to(url);
            maximizeWindow();
    }

    public static boolean isElementClickable(WebElement elementName, int waitTime) throws IOException {
        try {

            new WebDriverWait(Constants.DRIVER, waitTime).until(ExpectedConditions.visibilityOf(elementName));
            new WebDriverWait(Constants.DRIVER, waitTime).until(ExpectedConditions.elementToBeClickable(elementName));

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
            new WebDriverWait(Constants.DRIVER, WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception ex) {
        }
    }

    public static void waitForControlToBeClickable(WebElement controlName) {
        new WebDriverWait(Constants.DRIVER, WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        new WebDriverWait(Constants.DRIVER, WAIT_TIME).until(ExpectedConditions.elementToBeClickable(controlName));
    }

    public static void refreshPage() {
        try {
            Constants.DRIVER.navigate().refresh();
        } catch (Exception e) {

        }
    }

    public static void scrollIntoView(WebElement controlName) {
        waitForControl(controlName);
        JavascriptExecutor executor = (JavascriptExecutor) Constants.DRIVER;
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
        Constants.DRIVER.manage().window().maximize();
    }

    public static void quit() throws IOException {
        try {
            Constants.DRIVER.quit();
        } catch (Exception e) {

        }
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
            String popupWidowHandle = getWindowHandle(Constants.DRIVER);
            Constants.DRIVER.switchTo().window(popupWidowHandle);
            maximizeWindow();
        } catch (Exception e) {
        }
    }

    public static ExtentTest logStepInfo(ExtentTest logTest, String description, Object... args) throws IOException {
        return logTest.createNode(description);
    }
}
