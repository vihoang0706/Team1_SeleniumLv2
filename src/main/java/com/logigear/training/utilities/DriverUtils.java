package com.logigear.training.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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

    //Report
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

    public static void initializeDriver(String browser,String runOn, ExtentTest logTest) throws IOException {
        try {
            switch (runOn) {
                case "grid":
                    DriverUtils.setDriver(new DriverManagerFactory().createInstanceGrid(browser,logTest));
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
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
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
        } catch (SkipException ex) {
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

    /**
     * @Action: isElementClickable
     * @param elementName
     * @throws IOException
     * */

    public static boolean isElementClickable(By elementName, int waitTime) throws IOException {
        try {
            new WebDriverWait(DriverUtils.getDriver(), waitTime).until(ExpectedConditions.invisibilityOfElementLocated(elementName));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void checkControlExist(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            waitForControl(elementName);
            if (!doesControlExist(elementName)) logFail(logTest, objectName + " does not exist.");
            else logPass(logTest, objectName + " exists.");
        } catch (Exception e) {

        }
    }

    public static boolean doesControlExist(WebElement control){
        try {
            return control.isSelected();

        } catch (Exception e) {
            return false;
        }
    }

    public static void refreshPage() {
        try {
            getDriver().navigate().refresh();
            waitForPageLoaded();
        } catch (Exception e) {
        }
    }

    public static void waitForControlToBeClickable(WebElement controlName) {
        new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.elementToBeClickable(controlName));
    }

}
