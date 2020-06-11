package com.logigear.training.utilities;

import com.logigear.training.utilities.webdrivers.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import sun.rmi.runtime.Log;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
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
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    //Initiate local variables for generating time stamp
    public static String timeStampString = generateTimeStampString("yyyy-MM-dd-HH-mm-ss");

    //Initiate local variables for sending email
    public static String reportLocation = OUTPUT_PATH + "report-" + timeStampString + "/";
    public static String reportFilePath = reportLocation + "report-" + timeStampString + ".html";
    public static Log log4j;
    public static String subWindowHandler = null;
    public static ExtentReports report = null;
    public static ExtentHtmlReporter htmlReporter = null;
    public static ConfigFileReader configFileReader = null;

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(RemoteWebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void initializeDriver(ExtentTest logTest) throws IOException {
        try {
            switch (RUN_ON.toLowerCase()) {
                case "grid":
                    //Utility.setDriver(DriverFactory.createInstanceGrid(BROWSER, logTest));
                    maximizeWindow();
                    break;
                default:
                    DriverUtils.setDriver(DriverFactory.createInstance(BROWSER, logTest));
                    maximizeWindow();
                    break;
            }
        }  catch (Exception e) {

    }
    }

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        String timestampStr = dtf.format(now);
        return timestampStr;
    }

    public static ExtentTest logStepInfo(ExtentTest logTest, String description) throws IOException {
        return logTest.createNode(description);
    }

    public static ExtentTest createNodeForExtentReport(ExtentTest parentTest, String description) {
        return parentTest.createNode(description);
    }

    public ExtentTest createTestForExtentReport(ExtentReports report, String description) {
        return report.createTest(description);
    }

    public static void logInfo(ExtentTest logTest, String description) {
        logTest.info(description);
    }

    public static void logPass(ExtentTest logTest, String description) {
        logTest.pass(MarkupHelper.createLabel(description, ExtentColor.GREEN));
    }

    public static void logFail(ExtentTest logTest, String description) throws IOException {
        try {
            // Report test fails and capture screenshot
            captureScreenshot("FAILED screenshot: ", "fail-", logTest);

            // Update result on TestRails
            String testInfo = "\n\n Report link: " + DriverUtils.getReportLink();

            throw new SkipException(description);
        } catch (SkipException ex) {
            logTest.fail(MarkupHelper.createLabel(description + "</br>" + getStackTrade(ex.getStackTrace()), ExtentColor.RED));
            Assert.fail(description);
        }
    }

    public static void navigateToTestSite(ExtentTest logTest, String url) throws IOException {
        try {
            //logInfo(logTest, "Navigate to site: " + url);
            DriverUtils.getDriver().navigate().to(url);
            maximizeWindow();
        } catch (Exception e) {

        }
    }

    public static boolean isElementClickable(WebElement elementName, int waitTime, ExtentTest logStep) throws IOException {
        try {

            new WebDriverWait(DriverUtils.getDriver(), waitTime).until(ExpectedConditions.visibilityOf(elementName));
            new WebDriverWait(DriverUtils.getDriver(), waitTime).until(ExpectedConditions.elementToBeClickable(elementName));

            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public static void verifyExpectedAndActualResults(ExtentTest logTest, String expected, String actual) throws IOException {
        try {
            if (actual.trim().equalsIgnoreCase(expected)) {
                logPass(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {

        }
    }

    public static void checkControlExist(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            waitForControl(elementName);
            if (!doesControlExist(elementName)) logFail(logTest, objectName + " does not exist.");
            else logPass(logTest, objectName + " exists.");
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
            new WebDriverWait(DriverUtils.getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception ex) {
        }
    }

    public static void waitForControlToBeClickable(WebElement controlName) {
        new WebDriverWait(DriverUtils.getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        new WebDriverWait(DriverUtils.getDriver(), WAIT_TIME).until(ExpectedConditions.elementToBeClickable(controlName));
    }

    public static void refreshPage() {
        try {
            DriverUtils.getDriver().navigate().refresh();
        } catch (Exception e) {

        }
    }

    public static void scrollIntoView(WebElement controlName) {
        waitForControl(controlName);
        JavascriptExecutor executor = (JavascriptExecutor) DriverUtils.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", controlName);
    }

    public static boolean doesControlExist(WebElement control){
        try {
            return control.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public static void maximizeWindow() throws IOException {
        try {
            DriverUtils.getDriver().manage().window().maximize();
        } catch (Exception e) {

        }
    }

    public static void quit(ExtentTest logTest) throws IOException {
        try {
            DriverUtils.getDriver().quit();
            logInfo(logTest, "Closed browser and released device");
        } catch (Exception e) {

        }
    }

    public static void captureScreenshot(String detail, String screenshotName, ExtentTest logTest) throws IOException {
        try {
            sleep(2);

            // Get screenshot name
            screenshotName = screenshotName + generateTimeStampString("yyyy-MM-dd-HH-mm-ss") + ".png";

            // Capture screenshot (If driver == null, it means there is no window opens => Don't capture screenshot)
            TakesScreenshot ts = (TakesScreenshot) DriverUtils.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = reportLocation + screenshotName;
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            // Add current URL to report
            if (getDriver() != null)
                logTest.info("Page URL: " + DriverUtils.getDriver().getCurrentUrl());

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

//    public static void log4jConfiguration() {
//        try {
//            log4j = LogFactory.getLog(new Object().getClass());
//        } catch (Exception e) {
//            log4j.error("log4jConfiguration method - ERROR: " + e);
//        }
//    }

    public static void clearField(By by) {
        DriverUtils.getDriver().findElement(by).clear();
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
            String popupWidowHandle = getWindowHandle(DriverUtils.getDriver());
            DriverUtils.getDriver().switchTo().window(popupWidowHandle);
            maximizeWindow();
        } catch (Exception e) {
            //log4j.error("switchToWindowHandle method - ERROR - " + e);
        }
    }
}
