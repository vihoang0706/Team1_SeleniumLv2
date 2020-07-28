package com.logigear.training.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.logigear.training.common.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.SkipException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentTestReport {
    //Initiate local variables for generating time stamp
    public static String timeStampString = generateTimeStampString("yyyy-MM-dd-HH-mm-ss");

    //Report
    public static String reportLocation = Constants.OUTPUT_PATH + "report-" + timeStampString + "/";
    public static String reportFilePath = reportLocation + "report-" + timeStampString + ".html";
    public static ExtentReports report = null;
    public static ExtentHtmlReporter htmlReporter = null;
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

    /**
     * @Action: captureScreenshot
     * @param detail
     * @param screenshotName
     * @param logTest
     * @throws IOException
     */

    public static void captureScreenshot(String detail, String screenshotName, ExtentTest logTest) throws IOException {
        try {
            DriverUtils.sleep(2);

            // Get screenshot name
            screenshotName = screenshotName + generateTimeStampString("yyyy-MM-dd-HH-mm-ss") + ".png";

            // Capture screenshot (If driver == null, it means there is no window opens => Don't capture screenshot)
            TakesScreenshot ts = (TakesScreenshot) DriverUtils.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = reportLocation + screenshotName;
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            // Add current URL to report
            if (DriverUtils.getDriver() != null)
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
            logTest.info(e.getMessage());
        }
    }
}
