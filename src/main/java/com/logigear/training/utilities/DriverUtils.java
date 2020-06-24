package com.logigear.training.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.logigear.training.common.Constants;
import com.logigear.training.utilities.webdrivers.DriverManagerFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.logigear.training.common.Constants.*;

public class DriverUtils {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    //Initiate local variables for generating time stamp
    public static String timeStampString = generateTimeStampString("yyyy-MM-dd-HH-mm-ss");
    //Initiate local variables for sending email
    public static String reportLocation = OUTPUT_PATH + "report-" + timeStampString + "/";
    public static String reportFilePath = reportLocation + "report-" + timeStampString + ".html";
    public static ExtentReports report = null;
    public static ExtentHtmlReporter htmlReporter = null;

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(RemoteWebDriver webDriver) {

        driver.set(webDriver);
    }

    public static void initializeDriver(String browser, ExtentTest logTest) throws IOException {
        try {
            switch (RUN_ON.toLowerCase()) {
                case "grid":
                    //Utility.setDriver(DriverFactory.createInstanceGrid(BROWSER, logTest));
                    maximizeWindow();
                    break;
                default:
                    DriverUtils.setDriver(new DriverManagerFactory().createInstance(browser,logTest));
                    maximizeWindow();
                    break;
            }
        }  catch (Exception e) {

        }
    }

    public static void quit(){
        DriverUtils.getDriver().close();
        DriverUtils.getDriver().quit();
    }

    public static void logInfo(ExtentTest logTest, String description) {
        logTest.info(description);
    }

    public ExtentTest createTestForExtentReport(ExtentReports report, String description) {
        return report.createTest(description);
    }

    public static ExtentTest createNodeForExtentReport(ExtentTest parentTest, String description) {
        return parentTest.createNode(description);
    }

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        String timestampStr = dtf.format(now);
        return timestampStr;
    }

    public static void navigateToTestSite(String url) {
            DriverUtils.getDriver().navigate().to(url);
            maximizeWindow();
    }

    /**
     * wait for a specific time
     * @param timeout
     */
    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (Exception e) {

        }
    }

    /**
     * wait for a specific control in period time
     *
     * @param controlName Example:
     *                    - @FindBy(id='NextButton')
     *                    - WebElement nextButton;
     *
     *
     **/
    public static void waitForControl(WebElement controlName) {
        try {
            new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception ex) {
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

    /**
     * @Action name: waitForPageLoaded()
     * @Example: waitForPageLoaded()
     * @Purpose: wait until page is loaded completed
     */
    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(WAIT_TIME);
            WebDriverWait wait = new WebDriverWait(getDriver(), 60);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    /**
     *
     * @param detail
     * @param screenshotName
     * @param logTest
     * @throws IOException
     */

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

    /**
     * @Action: logPass
     * @Purpose: return report passed log that contain <span> ticket
     * @param logTest
     * @param description
     */
    public static void logPass(ExtentTest logTest, String description) {
        logTest.pass(MarkupHelper.createLabel(description, ExtentColor.GREEN));
    }

    /**
     * @Action name: logFail(arg1, agr2)
     * @Purpose: return report failed log that contain <span> ticket
     * @param logTest
     * @param description
     * @throws IOException
     */
    public static void logFail(ExtentTest logTest, String description) throws IOException {
        try {
            // Report test fails and capture screenshot
            captureScreenshot("FAILED screenshot: ", "fail-", logTest);

            // Update result on TestRails
            String testInfo = "\n\n Report link: " + DriverUtils.getReportLink();
            System.out.println(testInfo);
            throw new SkipException(description);
        } catch (SkipException ex) {
            logTest.fail(MarkupHelper.createLabel(description + "</br>" + getStackTrade(ex.getStackTrace()), ExtentColor.RED));
            Assert.fail(description);
        }
    }

    /**
     * @Action: verifyExpectedAndActualResults
     * @param logTest
     * @param expected
     * @param actual
     * @throws IOException
     */
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
}
