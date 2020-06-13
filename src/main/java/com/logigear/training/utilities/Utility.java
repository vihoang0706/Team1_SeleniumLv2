package com.logigear.training.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.*;
import com.logigear.training.utilities.webdrivers.DriverFactory;
import org.apache.commons.io.FileUtils;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.logigear.training.common.GlobalVariables.*;

public class Utility {
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    // Add initialization of drivers
    public static String subWindowHandler = null;
    public static ExtentReports report = null;
    public static ExtentHtmlReporter htmlReporter = null;

    //Initiate variable for log4j
    public static Log log4j;
    public static ConfigFileReader configFileReader = null;

    //Initiate local variables for generating time stamp
    public static String timeStampString = generateTimeStampString("yyyy-MM-dd-HH-mm-ss");

    //Initiate local variables for sending email
    public static String reportLocation = OUTPUT_PATH + "report-" + timeStampString + "/";
    public static String reportFilePath = reportLocation + "report-" + timeStampString + ".html";
    public static String reportCancelWarrantyCSV = null;
    public static String reportRefundClaimCSV = null;

    //Variable for generate random string
    static Calendar now = Calendar.getInstance();

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(RemoteWebDriver webDriver) {
        driver.set(webDriver);
    }

    public static void initializeDriver(ExtentTest logTest) throws IOException {
        try {
            switch (RUN_ON.toLowerCase()) {
                default:
                    Utility.setDriver(DriverFactory.createInstance(BROWSER, logTest));
                    maximizeWindow();
                    break;
            }

            // Check if running on Mobile or Desktop
            Platform platForm = ((RemoteWebDriver) Utility.getDriver()).getCapabilities().getPlatform();
           // IS_MOBILE = (platForm == Platform.ANDROID || platForm == Platform.IOS);

            Utility.getDriver().manage().deleteAllCookies();
            Utility.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Utility.getDriver().manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        } catch (Exception e) {
            TOTAL_FAILED++;
            log4j.error("initializeDriver method - ERROR - " + e);
            logException(logTest, "initializeDriver method - ERROR", e);
        }
    }

    public static void log4jConfiguration() {
        try {
            log4j = LogFactory.getLog(new Object().getClass());
        } catch (Exception e) {
            log4j.error("log4jConfiguration method - ERROR: " + e);
        }
    }

    public static String getStackTrade(StackTraceElement[] stackTradeElements) {
        try {
            String stackTrade = "";
            for (StackTraceElement element : stackTradeElements) {
                stackTrade += element.toString() + "</br>";
                // Get stacktrade from comm.module level only
                if (element.toString().startsWith("com.modules"))
                    break;
            }
            return stackTrade;
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * @param logTest
     * @param expected
     * @param actual
     * @Action name: verifyExpectedAndActualResults
     * @CreatedDate: 03/10/2017
     * @ModifyDate: 04/12/2017
     */
    public static void verifyExpectedAndActualResults(ExtentTest logTest, String expected, String actual) throws IOException {
        try {
            if (actual.trim().equalsIgnoreCase(expected)) {
                logPass(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResults method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResults method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param expected
     * @param actual
     * @Action name: verifyExpectedAndActualResultsBoolean
     * @CreatedDate: 22/03/2019
     */
    public static void verifyExpectedAndActualResultsBoolean(ExtentTest logTest, boolean expected, boolean actual) throws IOException {
        try {

            if (expected == actual) {
                logPass(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            }

        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResultsBoolean method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResultsBoolean method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param expected
     * @param actual
     * @Action name: verifyExpectedAndActualResultsSubString
     * Purpose Sometimes, we need to verify the expected string displays within actual string or not (verify substring)
     * @CreatedDate: 04/25/2017
     * @ModifyDate: 04/25/2017
     */
    public static void verifyExpectedAndActualResultsSubString(ExtentTest logTest, String expected, String actual) throws IOException {
        try {
            if (actual.trim().contains(expected.trim())) {
                logPass(logTest, "Expected Result: Object contains '" + expected + "'" + "<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: Object contains '" + expected + "'" + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResultsSubString method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResultsSubString method - ERROR", e);
        }
    }

    public static void verifyExpectedAndActualResultsSubStringSoftAssert(ExtentTest logTest, String expected, String actual) throws IOException {
        try {
            if (actual.trim().contains(expected.trim())) {
                logPass(logTest, "Expected Result: Object contains '" + expected + "'" + "<br/>Actual Result: " + actual);
            } else {
                logFailSoftAssert(logTest, "Expected Result: Object contains '" + expected + "'" + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResultsSubString method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResultsSubString method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param expected
     * @param actual
     * @Action name: verifyNotExistInSubString
     * Purpose Sometimes, we need to verify the expected string not displays within actual string (verify substring)
     * @CreatedDate: 06/18/2019
     @ModifyDate: 06/18/2019
     */
    public static void verifyNotExistInSubString(ExtentTest logTest, String expected, String actual) throws IOException {
        try {
            Boolean isFalse=actual.trim().contains(expected.trim());
            if(isFalse == false){
                logPass(logTest, "Expected Result: Object not contains '" + expected + "'" + "<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: Object contains '" + expected + "'" + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyNotExistInSubString method - ERROR - " + e);
            logException(logTest, "verifyNotExistInSubString method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param expected
     * @param actual
     * @Action name: verifyExpectedAndActualResults
     * @CreatedDate: 03/10/2017
     * @ModifyDate: 04/12/2017
     */
    public static void verifyExpectedAndActualResults(ExtentTest logTest, double expected, double actual) throws IOException {
        try {
            if (actual == expected) {
                logPass(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResults method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResults method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param elementName
     * @param objectName
     * @param expected    - "true" or "false"
     * @Action name: verifyCheckboxStatus
     * @CreatedDate: 05/17/2017
     * @ModifyDate: 05/17/2017
     */
    public static void verifyCheckboxStatus(ExtentTest logTest, WebElement elementName, String objectName, String expected) throws IOException {
        try {
            if (expected.equalsIgnoreCase("true")) {
                if (elementName.isSelected())
                    logPass(logTest, "Expected Result: " + objectName + " checkbox element displays in 'checked' state <br/>Actual Result: Checkbox element is in checked state");
                else
                    logFail(logTest, "Expected Result: " + objectName + " Checkbox element displays in 'checked' state <br/>Actual Result: Checkbox element is in unchecked state");
            } else {
                if (!elementName.isSelected())
                    logPass(logTest, "Expected Result: " + objectName + " Checkbox element displays in 'unchecked' state <br/>Actual Result: Checkbox element is in unchecked state");
                else
                    logFail(logTest, "Expected Result: " + objectName + " Checkbox element displays in 'unchecked' state <br/>Actual Result: Checkbox element is in checked state");
            }

        } catch (Exception e) {
            log4j.error("verifyCheckboxStatus - ERROR - " + e);
            logException(logTest, "verifyCheckboxStatus method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param elementName
     * @param objectName
     * @Action name: checkControlExist
     * @CreatedDate: 03/21/2017
     * @ModifyDate: 04/12/2017
     */
    public static void checkControlExist(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            waitForControl(elementName);
            if (!doesControlExist(elementName)) logFail(logTest, objectName + " does not exist.");
            else logPass(logTest, objectName + " exists.");
        } catch (Exception e) {
            log4j.error("checkControlExist - ERROR - " + e);
            logException(logTest, "checkControlExist method - ERROR", e);
        }
    }

    public static void checkControlExistSoftAssert(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            waitForControl(elementName);
            if (!doesControlExist(elementName)) logFailSoftAssert(logTest, objectName + " does not exist.");
            else logPass(logTest, objectName + " exists.");
        } catch (Exception e) {
            log4j.error("checkControlExist - ERROR - " + e);
            logException(logTest, "checkControlExist method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param elementName
     * @param objectName
     * @Action name: checkControlNotLinking
     * @CreatedDate: 04/20/2018
     */
    public static void checkControlNotLinking(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            waitForControl(elementName);
            if (doesControlPropertyExist(elementName, "href"))
                logFail(logTest, objectName + " is linking.");
            else
                logPass(logTest, objectName + " is not linking");
        } catch (Exception e) {
            log4j.error("checkControlNotLinking - ERROR - " + e);
            logException(logTest, "checkControlNotLinking method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param elementName
     * @param objectName
     * @Action name: checkControlNotExist
     * @CreatedDate: 04/10/2017
     * @ModifyDate: 04/12/2017
     */
    public static void checkControlNotExist(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            if (doesControlExist(elementName))
                logFail(logTest, objectName + " exist.");
            else
                logPass(logTest, objectName + " does not exists.");
        } catch (Exception e) {
            log4j.error("checkControlNotExist - ERROR - " + e);
            logException(logTest, "checkControlNotExist method - ERROR", e);
        }
    }

    /**
     * Check property of element like textbox, label
     *
     * @param elementName
     * @param elementProperty
     * @param propertyValue
     * @param logTest
     * @throws IOException
     */
    public static void checkControlProperty(WebElement elementName, String elementProperty, String propertyValue, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("checkControlPropertyValue method...Start");

            waitForControl(elementName);
            String actualPropertyValue = elementName.getAttribute(elementProperty);
            verifyExpectedAndActualResults(logTest, propertyValue, actualPropertyValue);

            log4j.info("checkControlPropertyValue method...End");

        } catch (Exception e) {
            log4j.error("checkControlPropertyValue - ERROR - " + e);
            logException(logTest, "checkControlPropertyValue method - ERROR", e);
        }
    }

    /**
     * Check value of element like textbox, label
     *
     * @param elementName
     * @param value
     * @param logTest
     * @throws IOException
     */
    public static void checkControlValue(WebElement elementName, String value, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("checkControlValue method...Start");

            waitForControl(elementName, logTest);
            sleep(2);
            String actualValue = elementName.getAttribute("value");
            if (actualValue == null)
                actualValue = elementName.getText();
            verifyExpectedAndActualResults(logTest, value, actualValue);

            log4j.info("checkControlValue method...End");
        } catch (Exception e) {
            log4j.error("checkControlValue - ERROR - " + e);
            logException(logTest, "checkControlValue method - ERROR", e);
        }
    }

    public static void checkComboboxValue(WebElement elementName, String value, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("checkComboboxValue method...Start");

            waitForControl(elementName);
            String actualValue = new Select(elementName).getFirstSelectedOption().getText();
            verifyExpectedAndActualResults(logTest, value, actualValue);

            log4j.info("checkComboboxValue method...End");
        } catch (Exception e) {
            log4j.error("checkComboboxValue - ERROR - " + e);
            logException(logTest, "checkComboboxValue method - ERROR", e);
        }
    }

    /**
     * @param url - Ex: https://www-stage2.squaretrade.com
     * @Action name: navigateToTestSite(arg1)
     * @Example: navigateToTestSite("https://www-stage2.squaretrade.com")
     * @Purpose: Navigate to a specific url
     * @CreatedBy: quoc.le
     * @On: 11/18/2016
     */
    public static void navigateToTestSite(ExtentTest logTest, String url) throws IOException {
        try {
            logInfo(logTest, "Navigate to site: " + url);
            Utility.getDriver().navigate().to(url);
            maximizeWindow();
            waitForPageLoaded();
        } catch (Exception e) {
            log4j.error("navigateToTestSite method - ERROR - " + e);
            logException(logTest, "navigateToTestSite method - ERROR", e);
        }
    }

    /**
     * @param description - Ex: Step#1: Select smart phones device type on menu bar
     * @Action name: logStepInfo(logMethod,arg1)
     * @Purpose: return log steps that contain <span> ticket
     * @CreatedBy: quoc.le
     * @On: 1/16/2017
     */
    public static void logInfo(ExtentTest logTest, String description) {
        logTest.info(description);
    }

    /**
     * @param logTest
     * @param description
     * @Action name: logFail(arg1, agr2)
     * @Purpose: return report failed log that contain <span> ticket
     * @CreatedBy: quoc.le
     * @On: 1/16/2017
     */
    public static void logFail(ExtentTest logTest, String description) throws IOException {
        try {
            // Report test fails and capture screenshot
            captureScreenshot("FAILED screenshot: ", "fail-", logTest);

            // Update result on TestRails
            String testInfo = "\n\n Report link: " + Utility.getReportLink();
            //if (TESTRAIL_UPDATE) markTestCaseFailInTestRail(description.replace("<br/>", "\n") + testInfo, logTest);
            throw new SkipException(description);
        } catch (SkipException ex) {
            logTest.fail(MarkupHelper.createLabel(description + "</br>" + getStackTrade(ex.getStackTrace()), ExtentColor.RED));
            Assert.fail(description);
        }
    }

    /**
     * @param logSuite
     * @param description
     * @Action name: logFailBeforeSuite(arg1, agr2)
     * @Purpose: return report failed log that contain <span> ticket and stop the execution at before suite
     * @CreatedBy: Rooban
     * @On: 9/27/2019
     */
    public static void logFailBeforeSuite(ExtentTest logSuite, String description) throws IOException {
        try {
            String testInfo = "\n\n Report link: " + Utility.getReportLink();
            //if (TESTRAIL_UPDATE) markTestCaseFailInTestRail(description.replace("<br/>", "\n") + testInfo, logSuite);

            logSuite.fail(MarkupHelper.createLabel(description + "</br>", ExtentColor.RED));
            TOTAL_TESTCASES = TOTAL_SKIPPED + TOTAL_EXECUTED;
            TOTAL_PASSED = TOTAL_EXECUTED - TOTAL_FAILED;
            report.flush();
            System.exit(-1);
        } catch (Exception e) {
            log4j.error("Error when reporting logFail: " + e);
        }
    }

    /**
     * @param logTest
     * @param description
     * @Action name: logPass(arg1, agr2)
     * @Purpose: return report passed log that contain <span> ticket
     * @CreatedBy: quoc.le
     * @On: 1/16/2017
     */
    public static void logPass(ExtentTest logTest, String description) {
        logTest.pass(MarkupHelper.createLabel(description, ExtentColor.GREEN));
    }

    /**
     * @param logTest
     * @param description
     * @param exception
     * @Action name: logException(arg1, agr2)
     * @Purpose: return report error log that contain <span> ticket
     * @CreatedBy: quoc.le
     * @On: 1/16/2017
     */
    public static void logException(ExtentTest logTest, String description, Exception exception) throws IOException {
        try {
            // Report test fails and capture screenshot
            captureScreenshot("ERROR screenshot: ", "error-", logTest);

            String testInfo = "\n\n Report link: " + Utility.getReportLink();

            throw new SkipException(description);
        } catch (SkipException ex) {
            logTest.error(MarkupHelper.createLabel(description + "</br>" + exception.toString() + "</br>" + getStackTrade(exception.getStackTrace()), ExtentColor.ORANGE));
            Assert.fail(description);
        }
    }

    public static void logSkip(ExtentTest logTest, String description) {
        logTest.skip(MarkupHelper.createLabel(description, ExtentColor.GREY));
    }

    public static ExtentTest logStepInfo(ExtentTest logTest, String description, Object... args) throws IOException {
        return logTest.createNode(description);
    }

    public static ExtentTest createNodeForExtentReport(ExtentTest parentTest, String description) {
        return parentTest.createNode(description);
    }

    /**
     * wait for a specific time
     *
     * @param timeout Example: sleep(4) -> wait for 4 seconds
     * @author quoc.le
     */
    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (Exception e) {
            log4j.warn("Exception is sleep method - ERROR: " + e);
        }
    }

    public static void waitForControl(WebElement controlName) {
        try {
            new WebDriverWait(Utility.getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception ex) {
            // TBD
        }
    }

    public static void waitForControlToBeClickable(WebElement controlName) {
        new WebDriverWait(Utility.getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        new WebDriverWait(Utility.getDriver(), WAIT_TIME).until(ExpectedConditions.elementToBeClickable(controlName));
    }

    public static void waitForControlDisAppear(WebElement controlName, ExtentTest logTest) throws IOException {
        try {
            if (doesControlExist(controlName)) {
                int i = 0;
                while (i < WAIT_TIME * 3 && doesControlExist(controlName)) {
                    sleep(2);
                }
            }
        } catch (Exception e) {
            log4j.error("waitForControlDisAppear method - ERROR - " + e);
            logException(logTest, "waitForControlDisAppear method - ERROR", e);
        }
    }

    public static void waitForControl(WebElement controlName, ExtentTest logTest) throws IOException {
        try {
            for (int i = 0; i < WAIT_TIME / 12; i++) {
                if (doesControlExist(controlName)) {
                    break;
                } else sleep(1);
            }
        } catch (Exception e) {
            log4j.error("waitForControl method - ERROR - " + e);
            logException(logTest, "waitForControl method - ERROR", e);
        }
    }

    /**
     * @Action name: waitForPageLoaded()
     * @Example: waitForPageLoaded()
     * @Purpose: wait until page is loaded completed
     * @CreatedBy: quoc.le
     * @On: 11/18/2016
     * @ModifiedBy:
     */
    public static void waitForPageLoaded() {
        Wait<WebDriver> wait = new WebDriverWait(Utility.getDriver(), WAIT_TIME);
        try {
            // Wait for HTML load
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    sleep(1);
                    boolean readyState = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    boolean activeJQuery = ((JavascriptExecutor) driver).executeScript("if (typeof jQuery != 'undefined') { return jQuery.active == 0; } else {  return true; }").equals(true);
                    return readyState && activeJQuery;
                }
            });

            // Wait for Angular load
            wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    sleep(1);
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    Boolean angularIsComplete = (Boolean) (executor.executeScript(
                            "return angular.element(document).injector().get('$http').pendingRequests.length === 0"));
                    return angularIsComplete;
                }
            });
        } catch (Exception e) {
            // TBD
        }
    }

    /**
     * @Action name: refreshPage()
     * @Example: refreshPage()
     * @Purpose: refresh a specific page
     * @CreatedBy: quoc.le
     * @On: 11/21/2016
     * @ModifiedBy:
     */
    public static void refreshPage() {
        try {
            Utility.getDriver().navigate().refresh();
            waitForPageLoaded();
        } catch (Exception e) {
            log4j.error("refreshPage method - ERROR - " + e);
        }
    }

    /**
     * @Action name: force Click by java script
     * @Example: forceClick()
     * @CreatedBy: quoc.le
     * @On: 1/16/2017
     */
    public static void forceClick(WebElement controlName) {
        waitForControl(controlName);
        JavascriptExecutor executor = (JavascriptExecutor) Utility.getDriver();
        executor.executeScript("arguments[0].click();", controlName);
    }

    /**
     * @Action name: scroll into view by java script
     * @Example: scrollIntoView()
     * @CreatedBy: quoc.le
     * @On: 06/30/2017
     */
    public static void scrollIntoView(WebElement controlName) {
        waitForControl(controlName);
        JavascriptExecutor executor = (JavascriptExecutor) Utility.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", controlName);
    }

    /**
     * @return true if control exists/false if control not exists
     * @ActionName: doesControlExist
     * @CreatedDate: 1/6/2017
     * @Author: quoc.le
     */
    public static boolean doesControlExist(WebElement control){
        try {
            return control.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return true if control.property exists/false if control.property not exists
     * @ActionName: doesControlPropertyExist
     * @CreatedDate: 4/20/2018
     * @Author: hieunguyen
     */
    public static boolean doesControlPropertyExist(WebElement control, String property) throws IOException {
        try {
            String value = control.getAttribute(property);
            if (value == null) return false;
            else return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return window handles string
     * @ActionName: getWindowHandle
     * @CreatedDate: 1/4/2017
     * @Author: quoc.le
     */
    public static String getWindowHandle(WebDriver driver) {
        // get all the window handles after the popup window appears
        Set<String> afterPopup = driver.getWindowHandles();

        Iterator<String> iterator = afterPopup.iterator();
        while (iterator.hasNext())
            subWindowHandler = iterator.next();

        return subWindowHandler;
    }

    /**
     * @return void
     * @ActionName: switchToWindowHandle
     * @CreatedDate: 1/4/2017
     * @Author: quoc.le
     */
    public static void switchToWindowHandle() throws IOException {
        try {
            String popupWidowHandle = getWindowHandle(Utility.getDriver());
            Utility.getDriver().switchTo().window(popupWidowHandle);
            maximizeWindow();
        } catch (Exception e) {
            log4j.error("switchToWindowHandle method - ERROR - " + e);
        }
    }

    /**
     * @ActionName: maximizeWindow();
     * return: void
     * @Author: binh.le
     */

    public static void maximizeWindow() throws IOException {
        try {
            if (OS_NAME.contains("mac")||OS_NAME.contains("linux"))
                Utility.getDriver().manage().window().setSize(new Dimension(1440, 900));
            else
                Utility.getDriver().manage().window().maximize();
        } catch (Exception e) {
            log4j.error("maximizeWindow method - ERROR - " + e);
        }
    }

    public static void quit(ExtentTest logTest) throws IOException {
        try {
            Utility.getDriver().quit();
            logInfo(logTest, "Closed browser and released device");
        } catch (Exception e) {
            log4j.error("Unable to close browser/release device: " + e);
        }
    }


    public static boolean isTestDataExecutable(Hashtable<String, String> data, ExtentTest logTest) throws IOException {
        boolean testDataRun = false;
        boolean testingType = false;

        try {
            // if Testing Type = Smoke, execute Smoke test cases
            if ((TESTING_TYPE.equalsIgnoreCase("Smoke") || TESTING_TYPE.equalsIgnoreCase("ProdSmoke")) && data.get("TestingType").equalsIgnoreCase("Smoke")) {
                testingType = true;
            }
            // if Testing Type = BVT, execute BVT + Smoke test cases
            else if (TESTING_TYPE.equalsIgnoreCase("BVT") && (data.get("TestingType").equalsIgnoreCase("BVT") || data.get("TestingType").equalsIgnoreCase("Smoke"))) {
                testingType = true;
            }
            // if Testing Type = Regression, execute BVT + Smoke + Regression + Full Regression test cases
            else if (TESTING_TYPE.equalsIgnoreCase("Regression") && (data.get("TestingType").equalsIgnoreCase("BVT") || data.get("TestingType").equalsIgnoreCase("Smoke") || data.get("TestingType").equalsIgnoreCase("Regression"))) {
                testingType = true;
            }
            // if Testing Type = Full Regression, execute BVT + Smoke + Regression + Full Regression test cases
            else if (TESTING_TYPE.equalsIgnoreCase("Full Regression") && (data.get("TestingType").equalsIgnoreCase("BVT") || data.get("TestingType").equalsIgnoreCase("Smoke") || data.get("TestingType").equalsIgnoreCase("Regression") || data.get("TestingType").equalsIgnoreCase("Full Regression"))) {
                testingType = true;
            }
            else if (TESTING_TYPE.equalsIgnoreCase("ProdCancelWarranty") || TESTING_TYPE.equalsIgnoreCase("ProdClaimRefund") || TESTING_TYPE.equalsIgnoreCase("SkySmoke") || TESTING_TYPE.equalsIgnoreCase("SkyRegression") || TESTING_TYPE.equalsIgnoreCase("SkyApiSmoke") || TESTING_TYPE.equalsIgnoreCase("SkyApiRegression") || TESTING_TYPE.equalsIgnoreCase("StaticSiteSmoke") || TESTING_TYPE.equalsIgnoreCase("WarriorAdyen")) {
                testingType = true;
            }

            if (data.get("RunMode").equalsIgnoreCase("Y") && testingType == true)
                testDataRun = true;
            else {
                if (!data.get("RunMode").equalsIgnoreCase("Y"))
                    logSkip(logTest, "Skipping test as RunMode was set to NO");
                else
                    logSkip(logTest, "Skipping test as TestingType is not appropriated");
            }

        } catch (Exception e) {
            log4j.error("isTestDataExecutable method - ERROR - " + e);
            logException(logTest, "isTestDataExecutable method - ERROR", e);
        }
        return testDataRun;
    }


    // Taking a screenshot
    public static void captureScreenshot(String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) Utility.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = reportLocation + screenshotName + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
        } catch (Exception e) {
            log4j.info("Exception while taking a screenshot." + e.getMessage());
        }
    }

    public static void captureScreenshot(String detail, String screenshotName, ExtentTest logTest) throws IOException {
        try {
            sleep(2);

            // Get screenshot name
            screenshotName = screenshotName + generateTimeStampString("yyyy-MM-dd-HH-mm-ss") + ".png";

            // Capture screenshot (If driver == null, it means there is no window opens => Don't capture screenshot)
            TakesScreenshot ts = (TakesScreenshot) Utility.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = reportLocation + screenshotName;
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            // Add current URL to report
            if (getDriver() != null)
                logTest.info("Page URL: " + Utility.getDriver().getCurrentUrl());

            // Add screenshot to report
            String screenshotLink = "<a href=\"" + screenshotName + "\">" + screenshotName + "</a>";
            if (logTest.getStatus() == Status.ERROR)
                logTest.error(detail + screenshotLink).addScreenCaptureFromPath(screenshotName);
            else if (logTest.getStatus() == Status.FAIL)
                logTest.fail(detail + screenshotLink).addScreenCaptureFromPath(screenshotName);
            else
                logTest.pass(detail + screenshotLink).addScreenCaptureFromPath(screenshotName);
        } catch (Exception e) {
            log4j.info("Exception while taking screenshot: " + e.getMessage());
        }
    }

    /**
     * @param anything
     * @return return new string that contains lowercase letters only
     * @ActionName: lowercaseFilter
     */
    public static String lowercaseFilter(String anything) {
        return anything.toLowerCase()
                .replace("0", "a")
                .replace("1", "b")
                .replace("2", "c")
                .replace("3", "d")
                .replace("4", "d")
                .replace("5", "e")
                .replace("6", "f")
                .replace("7", "g")
                .replace("8", "h")
                .replace("9", "j")
                .replaceAll("[^a-z]", "");
    }

    public static String getTestCaseID() {
        try {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            for (StackTraceElement item : stackTraceElements) {
                if (item.getClassName().startsWith("com.modules"))
                    return item.getFileName().split("_")[0].toLowerCase();
            }
            return "noname";
        } catch (Exception ex) {
            return "noname";
        }
    }


    public static String generateRandomEmail(String email) {
        if (email.contains("@")) {
            String[] parts = email.split("@");
            String part1 = parts[0];
            String part2 = parts[1];
            return part1 + "+" + getTestCaseID().replace("c", "") + generateTimeStampString("MMddHHmmss") + "@" + part2;
//            return part1 + "+" + generateTimeStampString("MMddHHmmss") + "@" + part2;
        } else {
            throw new IllegalArgumentException("The String" + email + " does not contain @");
        }
    }

    /**
     * Generate a random email with specific length
     *
     * @param email
     * @param length
     * @return return new email with specific length
     */
    public static String generateRandomEmailWithLength(String email, int length) {
        String emailTemp = generateRandomEmail(email);
        String[] parts = emailTemp.split("@");
        String part1 = parts[0];
        String part2 = parts[1];
        int lengthTemp = length - emailTemp.length();
        String valueTemp = RandomStringUtils.randomNumeric(lengthTemp);
        return part1 + valueTemp + "@" + part2;
    }

    /**
     * @Action name: goBacktoPreviousPage()
     * @Example: goBacktoPreviousPage()
     * @Purpose: go back to previous page
     * @CreatedBy: quoc.le
     * @On: 03/15/2017
     */
    public static void goBackToPreviousPage(ExtentTest logTest) throws IOException {
        try {
            logInfo(logTest, "Back to previous page");
            Utility.getDriver().navigate().back();
            waitForPageLoaded();
        } catch (Exception e) {
            log4j.error("goBackToPreviousPage method - ERROR - " + e);
            logException(logTest, "goBackToPreviousPage method - ERROR", e);
        }
    }

    public static void countTestCaseRan(Status result) {
        try {
            if (result.equals(Status.PASS))
                TOTAL_PASSED++;
            else if ((result.equals(Status.FAIL)) || result.equals(Status.ERROR) || result.equals(Status.WARNING))
                TOTAL_FAILED++;
        } catch (Exception e) {
            log4j.error("countTestCaseRan method - ERROR - " + e);
        }
    }

    /**
     * @param logTest
     * @param expected boolean
     * @param actual   boolean
     * @Action name: assertTrueFalse
     * Purpose Sometimes, we need to verify the control is displayed, is enable within actual condition or not.
     * @CreatedDate: 05/30/2017
     */
    public static void assertTrueFalse(ExtentTest logTest, boolean expected, boolean actual) throws IOException {
        try {
            if (expected == actual) {
                logPass(logTest, "The result is matched, <br/>Expected Result: " + expected + "<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "The result is matched, <br/>Expected Result: " + expected + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("assertTrueFalse method - ERROR - " + e);
            logException(logTest, "assertTrueFalse method - ERROR", e);
        }
    }

    //Handle error when leaving page unexpected.
    public static void handleAlertbox(String option, ExtentTest logTest) throws IOException, NoAlertPresentException, InterruptedException {
        try {
            log4j.debug("handleAlertbox...start");
            logInfo(logTest, "handleAlertbox method starts");

            // Switching to Alert
            Alert alert = Utility.getDriver().switchTo().alert();

            // Displaying alert message
            sleep(2);

            if (option.equals("accept")) {
                // Accepting alert
                alert.accept();
            } else alert.dismiss();

            Utility.getDriver().switchTo().defaultContent();
            logInfo(logTest, "handleAlertbox method ends");
            log4j.debug("handleAlertbox...end");
        } catch (Exception e) {
            log4j.error("handleAlertbox method - ERROR - " + e);
            logException(logTest, "handleAlertbox method - ERROR - ", e);
        }
    }

    public static void verifyPageURL(String value, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("Start of verifyPageURL method");
            waitForPageLoaded();
            String currentURL = Utility.getDriver().getCurrentUrl();
            verifyExpectedAndActualResultsSubString(logTest, value, currentURL);

            log4j.debug("End of verifyPageURL method");
        } catch (Exception e) {
            log4j.error("verifyPageURL method - ERROR - " + e);
            logException(logTest, "verifyPageURL method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param key
     * @Action name: getItemFromLocalStorage
     * @CreatedDate: 12/11/2017
     * @ModifyDate: 12/11/2017
     * @Owner: Vinh Ly
     */
    public static String getItemFromLocalStorage(String key, ExtentTest logTest) throws IOException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Utility.getDriver();
            return (String) js.executeScript(String.format(
                    "return window.localStorage.getItem('%s');", key));
        } catch (Exception e) {
            log4j.error("getItemFromLocalStorage method - ERROR - " + e);
            logException(logTest, "getItemFromLocalStorage method - ERROR", e);
            return "";
        }
    }

    /**
     * @param logTest
     * @param key
     * @Action name: checkItemInLocalStorage
     * @CreatedDate: 12/11/2017
     * @ModifyDate: 12/11/2017
     * @Owner: Vinh Ly
     */
    public static void checkItemInLocalStorage(String key, String expectedValue, ExtentTest logTest) throws IOException {
        try {
            String actualValue = getItemFromLocalStorage(key, logTest);
            actualValue = actualValue.trim().replaceAll("\"", "");
            if (actualValue.equalsIgnoreCase(expectedValue)) {
                logPass(logTest, "Expected Result: " + expectedValue + "<br/>Actual Result: " + actualValue);
            } else {
                logFail(logTest, "Expected Result: " + expectedValue + "<br/>Actual Result: " + actualValue);
            }
        } catch (Exception e) {
            log4j.error("checkItemInLocalStorage method - ERROR - " + e);
            logException(logTest, "checkItemInLocalStorage method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param key
     * @Action name: isItemPresentInLocalStorage
     * @CreatedDate: 12/11/2017
     * @ModifyDate: 12/11/2017
     * @Owner: Vinh Ly
     */
    public static boolean isItemPresentInLocalStorage(String key, ExtentTest logTest) throws IOException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Utility.getDriver();
            return !(js.executeScript(String.format(
                    "return window.localStorage.getItem('%s');", key)) == null);
        } catch (Exception e) {
            log4j.error("isItemPresentInLocalStorage method - ERROR - " + e);
            logException(logTest, "isItemPresentInLocalStorage method - ERROR", e);
            return false;
        }
    }

    /**
     * @param logTest
     * @param key
     * @Action name: checkItemNotExistInLocalStorage
     * @CreatedDate: 12/11/2017
     * @ModifyDate: 12/11/2017
     * @Owner: Vinh Ly
     */
    public static void checkItemNotExistInLocalStorage(String key, ExtentTest logTest) throws IOException {
        try {
            boolean isExist = isItemPresentInLocalStorage(key, logTest);
            if (isExist == false) {
                logPass(logTest, key + " item does NOT exist in Local Storage");
            } else {
                logFail(logTest, key + " item exists in Local Storage");
            }
        } catch (Exception e) {
            log4j.error("checkItemNotInLocalStorage method - ERROR - " + e);
            logException(logTest, "checkItemNotInLocalStorage method - ERROR", e);
        }
    }

    public static void setItemInLocalStorage(String item, String value, ExtentTest logTest) throws IOException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Utility.getDriver();
            js.executeScript(String.format(
                    "window.localStorage.setItem('%s','%s');", item, value));
        } catch (Exception e){
            log4j.error("setItemInLocalStorage method - ERROR - " + e);
            logException(logTest, "setItemInLocalStorage method - ERROR", e);
        }
    }

    /**
     * @Action generateIMEI
     * @CreatedDate: 2018/03/21
     * @ModifyDate: 2018/03/21
     * @Owner: Vinh Ly
     * Translated from: https://lazyzhu.com/imei-generator/js/imei-generator.js
     */
    public static String generateIMEI() {
        int pos;
        int[] str = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int sum = 0;
        int final_digit;
        int t;
        int len_offset;
        int len = 15;
        String imei = "";

        String[] rbi = new String[]{"01", "10", "30", "33", "35", "44", "45", "49", "50", "51", "52", "53", "54", "86", "91", "98", "99"};
        String[] arr = rbi[(int) Math.floor(Math.random() * rbi.length)].split("");
        str[0] = Integer.parseInt(arr[0]);
        str[1] = Integer.parseInt(arr[1]);
        pos = 2;

        while (pos < len - 1) {
            str[pos++] = (int) (Math.floor(Math.random() * 10) % 10);
        }

        len_offset = (len + 1) % 2;
        for (pos = 0; pos < len - 1; pos++) {
            if ((pos + len_offset) % 2 != 0) {
                t = str[pos] * 2;
                if (t > 9) {
                    t -= 9;
                }
                sum += t;
            } else {
                sum += str[pos];
            }
        }

        final_digit = (10 - (sum % 10)) % 10;
        str[len - 1] = final_digit;

        for (int d : str) {
            imei += String.valueOf(d);
        }

        return imei;
    }

    public static void checkTargetHashMapContaining(HashMap targetHashMap, HashMap subHashMap, ExtentTest logTest) throws IOException {
        try {
            logInfo(logTest, "checkTargetHashMapContaining method ... Start");
            for (Object expKey : subHashMap.keySet()) {
                logInfo(logTest, "Verify value of " + expKey.toString() + " :");
                if (targetHashMap.containsKey(expKey)) {
                    String expValue = subHashMap.get(expKey).toString();
                    String actValue;
                    if (targetHashMap.get(expKey) == null)
                        actValue = "null";
                    else
                        actValue = targetHashMap.get(expKey).toString();
                    verifyExpectedAndActualResults(logTest, expValue, actValue);
                } else {
                    logFail(logTest, "Key " + expKey.toString() + " is not found in target HashMap:" + targetHashMap);
                }
            }
            logInfo(logTest, "checkTargetHashMapContaining method ... End");
        } catch (Exception e) {
            log4j.error("checkTargetHashMapContaining method - ERROR - " + e);
            logException(logTest, "checkTargetHashMapContaining method - ERROR - ", e);
        }
    }

    /**
     * Clear value in textbox using keyboard: ctrl+a > delete
     *
     * @param controlName
     */
    public static void clearTextboxByKey(WebElement controlName, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("clearTextboxByKey method...start");
            int length = controlName.getAttribute("value").length();
            waitForControlToBeClickable(controlName);
            controlName.click();
            sleep(1);
            for (int i = 0; i < length; i++) {
                controlName.sendKeys(Keys.ARROW_RIGHT);
            }
            sleep(2);

            for (int i = 0; i < length; i++) {
                controlName.sendKeys(Keys.BACK_SPACE);
            }
            sleep(3);

            log4j.info("clearTextboxByKey method...end");
        } catch (Exception e) {
            log4j.error("clearTextboxByKey method - ERROR - " + e);
            logException(logTest, "clearTextboxByKey method - ERROR", e);
        }
    }

    /**
     * @param controlName
     * @param objectName
     * @param logTest
     * @throws IOException
     */
    public static void checkControlNotDisplayed(WebElement controlName, String objectName, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("checkControlDisplayed method...start");

            if (controlName.isDisplayed())
                logFail(logTest, objectName + " exist.");
            else
                logPass(logTest, objectName + " does not exists.");

            log4j.info("checkControlDisplayed method...end");
        } catch (Exception e) {
            log4j.error("checkControlDisplayed method - ERROR - " + e);
            logException(logTest, "checkControlDisplayed method - ERROR", e);
        }
    }

    /***
     * Change value of the entry element by executing javascript commands: set value, dispatch 'input' and then 'blur' events
     * Use this method if sendKeys methods does not work
     * @param element
     * @param keysToSend
     * @throws IOException
     */
    public static void sendKeysByJS(WebElement element, String keysToSend) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) Utility.getDriver();
            String script = "function changeValue(ele, value){" +
                    "ele.value=value;" +
                    "ele.dispatchEvent(new Event('input'));" +
                    "ele.dispatchEvent(new Event('blur'));};" +
                    "changeValue(arguments[0],arguments[1]);";

            executor.executeScript(script, element, keysToSend);
        } catch (Exception e) {
            log4j.error("sendKeysByJS method - ERROR - " + e);
        }
    }

    /***
     * Change value of the entry element by Keyboard
     * Use this method if sendKeys methods does not work
     * @param element
     * @param keysToSend
     * @throws IOException
     */
    public static void sendKeysByKeyboard(WebElement element, String keysToSend) {
        try {
            element.click();
            Keyboard board = ((HasInputDevices) Utility.getDriver()).getKeyboard();
            board.sendKeys(keysToSend);
        } catch (Exception e) {
            log4j.error("sendKeysByKeyboard method - ERROR - " + e);
        }
    }

    /**
     * Check new tab open when clicking link
     *
     * @param pageURL
     * @param logTest
     * @throws IOException
     */
    public static void checkNewTabOpen(String pageURL, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("checkNewTabOpen method...start");

            List<String> browserTabs = new ArrayList<String>(Utility.getDriver().getWindowHandles());
            Utility.getDriver().switchTo().window(browserTabs.get(1));
            verifyPageURL(pageURL, logTest);
            Utility.getDriver().close();
            Utility.getDriver().switchTo().window(browserTabs.get(0));

            log4j.info("checkNewTabOpen method...end");
        } catch (Exception e) {
            log4j.error("checkNewTabOpen method - ERROR - " + e);
            logException(logTest, "checkNewTabOpen method - ERROR", e);
        }
    }

    /***
     * Generate a 13-digits random number
     * @throws IOException
     */
    public static long numbGenerator() {
        long min = 1000000000000L; //13 digits inclusive
        long max = 10000000000000L; //14 digits exclusive
        Random random = new Random();
        long number = min + ((long) (random.nextDouble() * (max - min)));
        return number;
    }

    /* Generate report detail section */
    public static String getReportLink() {
        try {
            String buildURL = System.getProperty("buildURL");
            String jobURL = System.getProperty("jobURL");
            if (buildURL != null && jobURL != null) {
                return jobURL + "ws/" + reportFilePath.substring(reportFilePath.indexOf("ST-UIAutomation"));
            } else {
                return reportFilePath;
            }
        } catch (Exception ex) {
            log4j.error("Error while getting report link: " + ex.getMessage());
        }
        return "";
    }

    public static String maskCreditCard(String cardNumber) {
        return cardNumber.replaceAll("[0-9]{12}", "*");
    }

    public static String maskNumber(String numberString) {
        return numberString.replaceAll("[0-9]", "*");
    }

    /**
     * Mask the given email address.
     * E.g. The original email address: automation+1035890319165214@squaretrade.com
     * The email address after being masked: a..4@squaretrade.com
     */
    public String maskEmailAddress(String email){
        String maskedEmail = "";
        String emailUsername = "";
        String regex = ".*\\+[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.find()){
            emailUsername = matcher.group();
            maskedEmail = email.replace(emailUsername.substring(1, emailUsername.length() - 1), "..");
        }

        return maskedEmail;
    }

    //wait for alert present
    public static void waitForAlertPresent() {
        int i = 0;
        while (i++ < 5) {
            try {
                Alert alert = Utility.getDriver().switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                sleep(1);
                continue;
            }
        }
    }

    public static long getCurrentTimeInMiliseconds() {
        return System.currentTimeMillis();
    }

    /**
     * Check expiration time of ccode is 1 day
     * @param logTest
     * @throws IOException
     */
    public static void checkCcodeExpirationTime(ExtentTest logTest) throws IOException {
        try {
            long currentTime = getCurrentTimeInMiliseconds();
            long ccodeExpiryTime = Long.parseLong(getItemFromLocalStorage("ccode-expiry", logTest).trim().replaceAll("\"", ""));
            long second = (ccodeExpiryTime - currentTime) / 1000;

            if (second >= 86300 && second <= 86400)
                logPass(logTest, "Ccode Expiration: " + second + "seconds");
            else
                logFail(logTest, "Ccode Expiration: " + second + "seconds");
        } catch (Exception e) {
            log4j.error("checkCcodeExpirationTime method - ERROR - " + e);
            logException(logTest, "checkCcodeExpirationTime method - ERROR", e);
        }
    }

    /**
     * clear Local Storage
     * @param logTest
     * @throws IOException
     */
    public static void clearLocalStorage(ExtentTest logTest) throws IOException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Utility.getDriver();
            js.executeScript(String.format("window.localStorage.clear();"));
        } catch (Exception e) {
            log4j.error("clearLocalStorage method - ERROR - " + e);
            logException(logTest, "clearLocalStorage method - ERROR", e);
        }
    }

    /**
     * Check options of combobox
     * @param value
     * @param logTest
     * @throws IOException
     */
    public void checkComboboxOption(WebElement element, String value, ExtentTest logTest) throws IOException {
        try {
            log4j.debug("checkComboboxOption method...beginning");

            //Get all expected option
            List<String> expectedOption = Arrays.asList(value.split(";"));

            //Get all actual option
            List<String> actualOption = new ArrayList<>();
            List<WebElement> dropdownOption = new Select(element).getOptions();

            for (WebElement option : dropdownOption) {
                actualOption.add(option.getText());
            }

            logInfo(logTest, "Check all options of combobox");
            if (actualOption.equals(expectedOption))
                logPass(logTest, "Expected Result: " + expectedOption + "<br/>Actual Result: " + actualOption);
            else
                logFail(logTest, "Expected Result: " + expectedOption + "<br/>Actual Result: " + actualOption);

            log4j.info("checkComboboxOption method...end");
        } catch (Exception e) {
            log4j.error("checkComboboxOption method - ERROR - " + e);
            logException(logTest, "checkComboboxOption method - ERROR", e);
        }
    }

    public ExtentTest createTestForExtentReport(ExtentReports report, String description) {
        return report.createTest(description);
    }

    /**
     * Check expiration time of cpn is 1 day
     * @param logTest
     * @throws IOException
     */
    public static void checkCpnExpirationTime(ExtentTest logTest) throws IOException {
        try {
            long currentTime = getCurrentTimeInMiliseconds();
            long ccodeExpiryTime = Long.parseLong(getItemFromLocalStorage("cpn-expiry", logTest).trim().replaceAll("\"", ""));
            long second = (ccodeExpiryTime - currentTime) / 1000;

            if (second >= 86300 && second <= 86400)
                logPass(logTest, "Ccode Expiration: " + second + "seconds");
            else
                logFail(logTest, "Ccode Expiration: " + second + "seconds");
        } catch (Exception e) {
            log4j.error("checkCcodeExpirationTime method - ERROR - " + e);
            logException(logTest, "checkCcodeExpirationTime method - ERROR", e);
        }
    }

    public static void compareTwoList (List <String> expectList, List<String> actualList, ExtentTest logTest) throws IOException {
        try {
            Collections.sort(expectList);
            Collections.sort(actualList);

            if (expectList.equals(actualList))
                logPass(logTest, "Expected Result: " + expectList + "<br/>Actual Result: " + actualList);
            else
                logFail(logTest, "Expected Result: " + expectList + "<br/>Actual Result: " + actualList);

        } catch (Exception e) {
            log4j.error("compareTwoList method - ERROR - " + e);
            logException(logTest, "compareTwoList method - ERROR", e);
        }
    }

    /**
     * @purpose: convert a string in snake case(e.g. this_is_example) to camel case (e. thisIsExample)
     * @return : return string in camel case format
     */
    public String convertSnakeCaseToCamelCase(String name, ExtentTest logTest)throws IOException{
        String newName = null;
        try{
            newName = String.format(name.replaceAll("\\_(.)", "%S"), (Object[]) name.replaceAll("[^_]*_(.)[^_]*", "$1_").split("_"));
        }
        catch (Exception e){
            log4j.error("convertSnakeCaseToCamelCase method - ERROR - " + e);
            logException(logTest, "convertSnakeCaseToCamelCase method - ERROR", e);
        }
        return newName;
    }

    /**
     * @purpose: we have 2 ways to fetch value from database for validation: via API and via query DB
     *           The API response return columns' name in camel case.
     *           The query DB's result return columns' name in snake case.
     *           We don't want to have 2 separated methods to validate the same thing.
     *           This method is to convert columns' name to the same format so that we can use the same validation method regardless of input is API's response or query DB's result
     * @return: if the input Hashmap has keys(columns) name in snake case, convert those column name to camel case, then return new hashmap
     *          if the input Hashmap has keys(columns) name in camel case, no need to convert, return original hashmap
     */
    public HashMap convertTableColumnNameToCamelCase(HashMap table, ExtentTest logTest)throws IOException{

        HashMap<String, String> tableClone = table;
        HashMap<String, String> newTable = new HashMap();
        try{
            //check if table's column name contain snake case or not. If yes, convert it to camel case. If no, return original Hashmap
            Set keys = table.keySet();
            //System.out.println("Column name:" + keys);
            if (keys.toString().contains("_") && !keys.toString().contains("_links")){
                System.out.println("Result is getting from database");
                for (Map.Entry<String, String> entry : tableClone.entrySet()) {
                    String oldColumName = entry.getKey();
                    String value = entry.getValue();
                    String newColumnName = convertSnakeCaseToCamelCase(oldColumName, logTest);
                    newTable.put(newColumnName, value);
                    //System.out.println("New hashmap: "+ newTable);
                }
            }
            else {
                System.out.println("Result is getting from API's response");
                newTable = table;
            }
        }
        catch (Exception e){
            log4j.error("convertTableColumnNameToCamelCase method - ERROR - " + e);
            logException(logTest, "convertTableColumnNameToCamelCase method - ERROR", e);
        }
        return newTable;
    }

    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return randomStr
     * - random string like: 2016-12-23-01-46-16
     * @author: Quoc Le
     * @ActionName: generateTimeStampString
     * @CreatedDate: 12/23/2016
     * This method generates timestamp
     */
    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        String timestampStr = dtf.format(now);
        return timestampStr;
    }

    public static String generateTimeStampString(int length) {
        String timestampStr = null;
        if (length <= 14 && length > 0) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime now = LocalDateTime.now();
            timestampStr = dtf.format(now);
        }
        return right(timestampStr, length);
    }

    public static int getDayOfMonth() {
        return now.get(Calendar.DATE);
    }

    public static int getMonth() {
        return now.get(Calendar.MONTH);
    }

    public static int getyear() {
        return now.get(Calendar.YEAR);
    }

    public static String right(String value, int length) {
        // To get right characters from a string, change the begin index.
        return value.substring(value.length() - length);
    }

    public boolean isThisDateValid(String dateToValidate, String dateFormat) {
        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            //if not valid, it will throw ParseException
            sdf.parse(dateToValidate);

        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public void inputCharactersOneByOne(WebElement controlName, String value)throws IOException{
        controlName.clear();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            controlName.sendKeys(s);
        }
    }

    public boolean isAttributePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

    public static void closeTab(){
        Utility.getDriver().close();
    }

    public void openNewTab() {
        String newTab = "window.open('about:blank','_blank')";
        ((JavascriptExecutor)getDriver()).executeScript(newTab);
    }

    public void switchTab() {
        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }

    /**
     * @param logTest
     * @param actual
     * @Action name: verifyActualisNotNullResults
     * @CreatedDate: 10/08/2019
     */
    public static void verifyActualisNotNullResults(ExtentTest logTest,String actual) throws IOException {
        try {
            if (actual!= null) {
                logPass(logTest, "Expected Result: is not null "+"<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: is null " + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResults method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResults method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param actual
     * @Action name: verifyActualisNullResults
     * @CreatedDate: 05/06/2020
     */
    public static void verifyActualisNullResults(ExtentTest logTest,String actual) throws IOException {
        try {
            if (actual == null) {
                logPass(logTest, "Expected Result: is null "+"<br/>Actual Result: " + actual);
            } else {
                logFail(logTest, "Expected Result: is not null " + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyActualisNullResults method - ERROR - " + e);
            logException(logTest, "verifyActualisNullResults method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param args
     * @ActionName: createCSVFile(logTest, Object... args)
     * @purpose: Create CSV file in the output folder and add the headers
     * @Author: Rooban
     */
    public void createCSVFile(ExtentTest logTest, String... args) throws IOException {
        try {
            log4j.debug("Create a CSV file in output folder...start");

            String buildNumber = System.getenv("BUILD_NUMBER");
            String fileName = null;

            if (args[0].equalsIgnoreCase("Warranty Id")) {
                if (buildNumber != null) {
                    //String buildNumber = buildURL.split("/")[buildURL.split("/").length-1];
                    reportCancelWarrantyCSV = reportLocation + "CancelWarranty-Build-" + buildNumber + ".csv";
                } else {
                    reportCancelWarrantyCSV = reportLocation + "CancelWarranty-report-" + timeStampString + ".csv";
                }
                fileName = reportCancelWarrantyCSV;
            } else {
                if (buildNumber != null) {
                    reportRefundClaimCSV = reportLocation + "RefundClaim-Build-" + buildNumber + ".csv";
                } else {
                    reportRefundClaimCSV = reportLocation + "RefundClaim-report-" + timeStampString + ".csv";
                }
                fileName = reportRefundClaimCSV;
            }
            logInfo(logTest, "Create a CSV file: " + fileName);

            FileWriter csvWriter = new FileWriter(fileName, true);
            for (int i=0; i<=args.length-1; i++) {
                if (i==args.length-1) {
                    csvWriter.append(args[i]);
                    csvWriter.append("\n");
                } else {
                    csvWriter.append(args[i] + ",");
                }
            }
            csvWriter.flush();
            csvWriter.close();

            log4j.info("Create a CSV file in output folder...end");
        } catch (Exception e) {
            log4j.error("Create a CSV file in output folder - ERROR - " + e);
            logException(logTest, "Create a CSV file in output folder - ERROR - ", e);
        }
    }

    /**
     * @param logTest
     * @param hashMap
     * @param args
     * @ActionName: writeDataToCSV(logTest, String csvFileName, HashMap<String, Object> hashMap, String... args)
     * @purpose: Write data into CSV file with append mode
     * @Author: Rooban
     */
    public void writeDataToCSV(ExtentTest logTest, String csvFileName, HashMap<String, Object> hashMap, String... args) throws IOException {
        try {
            log4j.debug("Append the data in CSV file...start");

            FileWriter csvWriter = new FileWriter(csvFileName, true);
            for (int i=0; i<=args.length-1; i++) {
                String data = "";
                if (hashMap.get(args[i])==null) {
                    data = "";
                } else {
                    data = hashMap.get(args[i]).toString();
                }

                if (i==args.length-1) {
                    csvWriter.append(data);
                    csvWriter.append("\n");
                } else {
                    csvWriter.append(data + ",");
                }
            }

            csvWriter.flush();
            csvWriter.close();

            log4j.debug("Append the data in CSV file...end");
        } catch (Exception e) {
            log4j.error("Append the data in CSV file - ERROR - " + e);
            logException(logTest, "Append the data in CSV file - ERROR - ", e);
        }
    }

    public List<HashMap<String,Object>> excludeWarrantyIdFromCancellation(ExtentTest logTest, List<HashMap<String, Object>> warrantyInfoList, ArrayList<String> excludeWarrantyList) throws IOException {
        String index = "";
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        try {
            log4j.debug("Exclude the warranty ids from cancellation list...start");
            if (excludeWarrantyList.size()>0) {
                if (warrantyInfoList.size()>0) {
                    boolean match;
                    for (int i=0; i<warrantyInfoList.size(); i++) {
                        match = false;
                        for (int j=0; j<excludeWarrantyList.size(); j++) {
                            if (warrantyInfoList.get(i).get("id").toString().equalsIgnoreCase(excludeWarrantyList.get(j))) {
                                match = true;
                            }
                        }
                        if (!match) {
                            list.add(warrantyInfoList.get(i));
                        }
                    }
                }
            }
            log4j.info("Exclude the warranty ids from cancellation list...end");
        } catch (Exception e) {
            log4j.error("Exclude the warranty ids from cancellation list - ERROR - " + e);
            logException(logTest, "Exclude the warranty ids from cancellation list - ERROR - ", e);
        }
        return list;
    }

    /**
     * Reading test data from json for a specific test case
     *
     * @param testName
     * @param dataFilePath
     * @param logTest
     * @return Test Data Object in Key Value pair.
     * <p>
     * Operations in Sequence: Get the data from json file
     * Check if the test case is present in the json file
     * Get the test data in json array format
     * Deserialize the json read into an object of Hashtable type
     * Put the data into object array and return to data provider
     * The action name is the same as other action. But it use override method when running.
     */
    public static Object[][] getData(String testName, String dataFilePath, ExtentTest logTest) throws IOException {

        Object[][] data = new Object[0][1];

        //Read json file data using Gson library
        BufferedReader br = new BufferedReader(new FileReader(dataFilePath));
        JsonElement jsonElement = new JsonParser().parse(br);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        //Check for the test name in the json file
        boolean blnTCExist = jsonObject.has(testName);
        if (!blnTCExist) {
            log4j.error(testName + " is not present in the data.json file - " + dataFilePath);
            return data;
        }

        //Get test data for the specific test case
        JsonArray jsonArray = jsonObject.getAsJsonArray(testName);
        data = jsonArrayToObjectArray(jsonArray);
        return data;
    }

    public static Object[][] jsonArrayToObjectArray(JsonArray jsonArray){

        Object[][] data = new Object[0][1];
        int index = 0;
        Gson gson = new Gson();

        if (jsonArray.size()>0) {
            data = new Object[jsonArray.size()][1];
            for (Object obj : jsonArray) {
                Hashtable<String, String> hashTable = new Hashtable<String, String>();
                data[index][0] = gson.fromJson((JsonElement) obj, hashTable.getClass());
                index++;
            }
        }
        return data;
    }

    public static boolean isElementClickable(WebElement elementName, int waitTime, ExtentTest logStep) throws IOException {
        try {
            log4j.debug("isElementClickable method...start");
            new WebDriverWait(Utility.getDriver(), waitTime).until(ExpectedConditions.visibilityOf(elementName));
            new WebDriverWait(Utility.getDriver(), waitTime).until(ExpectedConditions.elementToBeClickable(elementName));
            log4j.info("isElementClickable method... end");
            return true;
        } catch (Exception e) {
            log4j.info("Element is not clickable");
        }
        return false;
    }

    /**
     * @param logTest
     * @param expected
     * @param actual
     * @Action name: verifyExpectedAndActualResults
     * @CreatedDate: 03/10/2017
     * @ModifyDate: 04/12/2017
     */
    public static void verifyExpectedAndActualResultsSoftAssert(ExtentTest logTest, String expected, String actual) throws IOException {
        try {
            if (actual.trim().equalsIgnoreCase(expected)) {
                logPass(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            } else {
                logFailSoftAssert(logTest, "Expected Result: " + expected + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResultsSoftAssert method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResultsSoftAssert method - ERROR", e);
        }
    }

    public static void verifyExpectedAndActualResultsSoftAssert(ExtentTest logTest, Boolean expected, Boolean actual) throws IOException {
        try {
            if (actual.equals(expected)) {
                logPass(logTest, "Element is clickable");
            } else {
                logFailSoftAssert(logTest, "Element is not clickable");
            }
        } catch (Exception e) {
            log4j.error("verifyExpectedAndActualResultsSoftAssert method - ERROR - " + e);
            logException(logTest, "verifyExpectedAndActualResultsSoftAssert method - ERROR", e);
        }
    }

    /**
     * @param logTest
     * @param description
     * @Action name: logFail(arg1, agr2)
     * @Purpose: return report failed log that contain <span> ticket
     * @CreatedBy: quoc.le
     * @On: 1/16/2017
     */
    public static void logFailSoftAssert(ExtentTest logTest, String description) throws IOException {
        try {
            // Report test fails and capture screenshot
            captureScreenshot("FAILED screenshot: ", "fail-", logTest);

            // Update result on TestRails
            String testInfo = "\n\n Report link: " + Utility.getReportLink();
            throw new SkipException(description);
        } catch (SkipException ex) {
            logTest.fail(MarkupHelper.createLabel(description + "</br>" + getStackTrade(ex.getStackTrace()), ExtentColor.RED));
        }
    }

    public static boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                boolean success = deleteDirectory(files[i]);
                if (!success) {
                    return false;
                }
            }
        }
        System.out.println("removing file or directory : " + dir.getName());
        return dir.delete();
    }

    /**
     * Verify the actual string is neither empty nor null
     * @param logTest
     * @param actual
     * @throws IOException
     */
    public static void verifyActualIsNotEmptyResults(ExtentTest logTest,String actual) throws IOException {
        try {
            if (StringUtils.isEmpty(actual)) {
                logFail(logTest, "Expected Result: is not empty " + "<br/>Actual Result: " + actual);
            } else {
                logPass(logTest, "Expected Result: is not empty " + "<br/>Actual Result: " + actual);
            }
        } catch (Exception e) {
            log4j.error("verifyActualIsNotEmptyResults method - ERROR - " + e);
            logException(logTest, "verifyActualIsNotEmptyResults method - ERROR", e);
        }
    }

    /**
     * clickBackArrowBrowser
     * @param logTest
     * @throws IOException
     */
    public void clickBackArrowBrowser(ExtentTest logTest) throws IOException {
        try {
            log4j.debug("Start checking Buyer Center Home page displays");
            getDriver().navigate().back();
            log4j.debug("End checking Buyer Center Checkout Page displays");
        } catch (Exception e) {
            log4j.error("clickBackArrowBrowser method - ERROR - " + e);
            logException(logTest, "clickBackArrowBrowser method - ERROR", e);

        }
    }

    /**
     * @param testCaseList
     * @param testName
     * @Action name: getRetryCount(arg1, agr2)
     * @Purpose: Get retry count if the test case is failed
     * @CreatedBy: Rooban
     * @On: 04/28/2020
     */
    public int getRetryCount(ArrayList<String> testCaseList, String testName) {
        int count = 0;

        for (int i=0; i<testCaseList.size(); i++) {
            if (testCaseList.get(i).contains(testName)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param testCaseList
     * @Action name: getTestCaseExecutionCount(arg1)
     * @Purpose: Get Test execution count and update the global variables
     * @CreatedBy: Rooban
     * @On: 04/28/2020
     */
    public void getTestCaseExecutionCount(ArrayList<String> testCaseList) {

        for (int i=0; i<testCaseList.size(); i++) {
            if (testCaseList.get(i).contains(": pass")) {
                if (testCaseList.get(i).contains(": RETRY")) {
                    TOTAL_PASSED_WITH_RETRY++;
                } else {
                    TOTAL_PASSED++;
                }
            } else if(testCaseList.get(i).contains(": skip")) {
                TOTAL_SKIPPED++;
            } else {
                if (RETRY_FAILED_TESTS.equalsIgnoreCase("Yes")) {
                    if (testCaseList.get(i).contains(": RETRY2")) {
                        TOTAL_FAILED++;
                    }
                } else {
                    TOTAL_FAILED++;
                }
            }
        }

        TOTAL_TESTCASES = TOTAL_PASSED + TOTAL_PASSED_WITH_RETRY + TOTAL_FAILED + TOTAL_SKIPPED;
    }
}
