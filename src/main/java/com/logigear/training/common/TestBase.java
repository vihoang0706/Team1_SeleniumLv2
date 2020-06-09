package com.logigear.training.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.logigear.training.utility.ConfigFileReader;
import com.logigear.training.utility.Utility;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.logigear.training.common.Constants.*;


public class TestBase extends Utility {


    public static boolean isTestSuiteExecutable = false;
    public boolean isTestCaseExecutable = false;

    public static ExtentTest logSuite = null;
    public ExtentTest logClass = null;
    public ExtentTest logMethod = null;
    public ExtentTest logStep = null;

    public String testCaseName;
    public String testNameWithStatus;

    @BeforeSuite()
    public synchronized void beforeSuite() throws IOException {

        // Initial test report
        try {
            htmlReporter = new ExtentHtmlReporter(reportFilePath);
            htmlReporter.loadXMLConfig(new File(PROJECT_PATH + "\\src\\main\\resources\\suites/config.xml"));
            report = new ExtentReports();
            report.attachReporter(htmlReporter);
            logSuite = createTestForExtentReport(report, "Initial Setup");
        } catch (Exception e) {

        }

        // Create report folder
        logInfo(logSuite, "Report folder: " + reportLocation);
        File folder = new File(reportLocation);
        folder.mkdirs();

        // Initial test data
        try {
            String testDataFilePath = TEST_CONFIGURATION;
            configFileReader = new ConfigFileReader(testDataFilePath, logSuite);
            logInfo(logSuite, "Test data: " + testDataFilePath);
        } catch (Exception e) {
        }

        // Validate runOn
        try {
            RUN_ON = System.getProperty("runOn") == null ? configFileReader.getDataFromConfigurationFile("RunOn") : System.getProperty("runOn");
            if (RUN_ON != null && (RUN_ON.equalsIgnoreCase("Local") || RUN_ON.equalsIgnoreCase("Grid")))
                logInfo(logSuite, "Run On: " + RUN_ON);
            else
                logFail(logSuite, "Invalid 'runOn' parameter: " + RUN_ON);
        } catch (Exception e) {
        }

        // Validate browserName
        try {
            BROWSER = System.getProperty("browserName") == null ? configFileReader.getDataFromConfigurationFile("BrowserName") : System.getProperty("browserName");
            if (BROWSER == null || BROWSER == "") {
                logFail(logSuite, "Invalid 'browserName' parameter: " + BROWSER);
            } else {
                logInfo(logSuite, "Browser name: " + BROWSER);
            }

        } catch (Exception e) {
        }

        if (RUN_ON.equalsIgnoreCase("Local") || RUN_ON.equalsIgnoreCase("Grid") || RUN_ON.equalsIgnoreCase("sel-hub-1.qa") || RUN_ON.equalsIgnoreCase("sel-hub-1.production")) {
            //Show OS name
            logInfo(logSuite, "OS name: " + OS_NAME);
        } else {
            // Validate platform
            try {
                PLATFORM = System.getProperty("platform") == null ? configFileReader.getDataFromConfigurationFile("Platform") : System.getProperty("platform");
                logInfo(logSuite, "Platform : " + PLATFORM);
                switch (PLATFORM) {
                    case ("Windows 10"):
                    case ("Windows 8.1"):
                    case ("Windows 7"):
                        PLATFORM_NAME = "Windows";
                        PLATFORM_VERSION = PLATFORM.split(" ")[1];
                        break;
                    default:
                        logFail(logSuite, "Invalid 'platform' parameter: " + PLATFORM);
                }
            } catch (Exception e) {

            }
        }

        report.setSystemInfo("Browser", BROWSER);
        isTestSuiteExecutable = true;
    }

    @BeforeClass
    public synchronized void beforeClass() throws IOException {

        // Get test case class name
        testCaseName = this.getClass().getSimpleName();

        // Check if TC is executable or not
        if (isTestSuiteExecutable) {
            isTestCaseExecutable = true;
        }

    }

    @BeforeMethod
    public synchronized void beforeMethod(Object[] data) throws IOException {
        logStep = null;
        TOTAL_EXECUTED++;

        if (data != null && data.length > 0) {
            // Get test data for test case
            Hashtable<String, String> dataTest = (Hashtable<String, String>) data[0];

            //Initialize logClass
            logClass = createTestForExtentReport(report, testNameWithStatus);

            // Initial logMethod
            logMethod = createNodeForExtentReport(logClass, dataTest.get("TestDataPurpose"));

            // Assign test category
            logMethod.assignCategory(dataTest.get("TestingType"));

            // Start web driver
            initializeDriver(logMethod);

        } else {
            logClass = createTestForExtentReport(report, testCaseName);
        }
    }

    @AfterMethod
    public synchronized void afterMethod() throws IOException {

        // Quit
        quit(logMethod);
        logMethod = null;

    }

    @AfterClass()
    public synchronized void afterClass() throws IOException {

        List statusHierarchy = Arrays.asList(
                Status.FATAL,
                Status.FAIL,
                Status.ERROR,
                Status.WARNING,
                Status.PASS,
                Status.SKIP,
                Status.DEBUG,
                Status.INFO
        );

        report.config().statusConfigurator().setStatusHierarchy(statusHierarchy);

        // Save test result to HTML file after each test class
        report.flush();

        // Update result to TestRails
        String testInfo = "\n Report link: " + Utility.getReportLink();


        logClass = null;

    }

    @AfterSuite()
    public synchronized void afterSuite() {

    }
}