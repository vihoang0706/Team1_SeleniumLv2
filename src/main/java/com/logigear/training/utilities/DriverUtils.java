package com.logigear.training.utilities;

import com.logigear.training.common.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import static com.logigear.training.common.Constants.*;

public class DriverUtils {
    //Initiate local variables for generating time stamp
    public static String timeStampString = generateTimeStampString("yyyy-MM-dd-HH-mm-ss");

    //Initiate local variables for sending email
    public static String reportLocation = OUTPUT_PATH + "report-" + timeStampString + "/";
    public static String reportFilePath = reportLocation + "report-" + timeStampString + ".html";
    public static String subWindowHandler = null;
    public static ExtentReports report = null;
    public static ExtentHtmlReporter htmlReporter = null;
    public static ConfigFileReader configFileReader = null;

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        String timestampStr = dtf.format(now);
        return timestampStr;
    }

    public static void navigateToTestSite(String url) {
            //logInfo(logTest, "Navigate to site: " + url);
            Constants.DRIVER.navigate().to(url);
            maximizeWindow();
    }

    public static boolean isElementClickable(WebElement elementName, int waitTime, ExtentTest logStep) throws IOException {
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

    public static void captureScreenshot(String detail, String screenshotName, ExtentTest logTest) throws IOException {
        try {
            sleep(2);

            // Get screenshot name
            screenshotName = screenshotName + generateTimeStampString("yyyy-MM-dd-HH-mm-ss") + ".png";

            // Capture screenshot (If driver == null, it means there is no window opens => Don't capture screenshot)
            TakesScreenshot ts = (TakesScreenshot) Constants.DRIVER;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = reportLocation + screenshotName;
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            // Add current URL to report
            if (Constants.DRIVER != null)
                logTest.info("Page URL: " + Constants.DRIVER.getCurrentUrl());

            // Add screenshot to report
            String screenshotLink = "<a href=\"" + screenshotName + "\">" + screenshotName + "</a>";
            if (logTest.getStatus() == Status.ERROR)
                logTest.error(detail + screenshotLink).addScreenCaptureFromPath(screenshotName);
            else if (logTest.getStatus() == Status.FAIL)
                logTest.fail(detail + screenshotLink).addScreenCaptureFromPath(screenshotName);
            else
                logTest.pass(detail + screenshotLink).addScreenCaptureFromPath(screenshotName);
        } catch (Exception e) {

        }
    }

    /* Generate report detail section */
    public static String getReportLink() {
        try {
            String buildURL = System.getProperty("buildURL");
            String jobURL = System.getProperty("jobURL");
            if (buildURL != null && jobURL != null) {
                return jobURL + "ws/" + reportFilePath.substring(reportFilePath.indexOf("Team1-SeleLV2"));
            } else {
                return reportFilePath;
            }
        } catch (Exception ex) {

        }
        return "";
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
}
