package com.logigear.training.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.logigear.training.driverManagement.DriverManager;
import com.logigear.training.driverManagement.DriverType;
import com.logigear.training.utility.ConfigFileReader;
import com.logigear.training.utility.Utility;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.logigear.training.common.Constants.*;


public class TestBase extends Utility {

//    public ExtentTest logClass = null;
//    public ExtentTest logMethod = null;
//    public ExtentTest logStep = null;
//
//    @BeforeTest
//    public void setup() {
//        DriverManager.setDriverManager(DriverType.CHROME);
//        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        DriverManager.getWebDriver().navigate().to(Constants.AUT);
//        DriverManager.getWebDriver().manage().window().maximize();
//    }
//
//    @AfterTest
//    public void closeWebDriver() {
//        DriverManager.quitWebDriver();
//    }
//}

    public static boolean isTestSuiteExecutable = false;
    public boolean isTestCaseExecutable = false;

    public static ExtentTest logSuite = null;
    public ExtentTest logClass = null;
    public ExtentTest logMethod = null;
    public ExtentTest logStep = null;
    //public ReportiumClient reportiumClient = null;

    public String testCaseName;
    public String testNameWithStatus;
    public static ArrayList<String> testcaseList = new ArrayList<String>();

    @BeforeSuite()
    public synchronized void beforeSuite() throws IOException {

        // Initiate log4j property system
//        log4jConfiguration();
//        DOMConfigurator.configure("resources/suites/log4j.xml");
//
//        log4j.info("beforeSuite method - Start");

        // Initial test report
        try {
            htmlReporter = new ExtentHtmlReporter(reportFilePath);
            htmlReporter.loadXMLConfig(new File(PROJECT_PATH + "/resources/suites/config.xml"));
            report = new ExtentReports();
            report.attachReporter(htmlReporter);
            logSuite = createTestForExtentReport(report, "Initial Setup");
        } catch (Exception e) {
//            log4j.error("ERROR while initializing Extend report: " + e.getStackTrace());
//            logException(logSuite, "ERROR while initializing Extend report", e);
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
//            log4j.error("ERROR while reading Test Configuration: " + e.getStackTrace());
//            logException(logSuite, "ERROR while reading test Configuration: ", e);
        }


        // Validate testingType


        // Validate runOn
        try {
            RUN_ON = System.getProperty("runOn") == null ? configFileReader.getDataFromConfigurationFile("RunOn") : System.getProperty("runOn");
            if (RUN_ON != null && (RUN_ON.equalsIgnoreCase("Local") || RUN_ON.equalsIgnoreCase("Grid")))
                logInfo(logSuite, "Run On: " + RUN_ON);
            else
                logFail(logSuite, "Invalid 'runOn' parameter: " + RUN_ON);
        } catch (Exception e) {
//            log4j.error("Error when getting 'runOn' parameter: " + e);
//            logException(logSuite, "Error when getting 'runOn' parameter", e);
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
//            log4j.error("Error when getting 'browserName' parameter" + e);
//            logException(logSuite, "Error when getting 'browserName' parameter", e);
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
//        log4j.info("beforeSuite method - End");
    }

    @BeforeClass
    public synchronized void beforeClass() throws IOException {
        //log4j.info("beforeClass method - start");

        // Get test case class name
        testCaseName = this.getClass().getSimpleName();

        // Check if TC is executable or not
        if (isTestSuiteExecutable) {
            isTestCaseExecutable = true;
        }

        //log4j.info("beforeClass method - End");
    }

    @BeforeMethod
    public synchronized void beforeMethod(Object[] data) throws IOException {
        //log4j.info("beforeMethod method - Start");
        logStep = null;
        TOTAL_EXECUTED++;

        if (data != null && data.length > 0) {
            // Get test data for test case
            Hashtable<String, String> dataTest = (Hashtable<String, String>) data[0];


            //Initialize logClass
            logClass = createTestForExtentReport(report, testNameWithStatus);

            // Initial logMethod
            logMethod = createNodeForExtentReport(logClass, dataTest.get("TestDataPurpose"));
            //log4j.info(dataTest.get("No.") + ": " + dataTest.get("TestDataPurpose"));

            // Assign test category
            logMethod.assignCategory(dataTest.get("TestingType"));

            // Start web driver
            initializeDriver(logMethod);

//            //Initialize Digital Zoom report
//            reportiumClient = DigitalZoomReport.initDigitalZoomReport(Utility.getDriver());

            //log4j.info("beforeMethod method - End");
        } else {
            logClass = createTestForExtentReport(report, testCaseName);
//            logSkip(logClass, "This test case has no data to run");
        }
    }

    @AfterMethod
    public synchronized void afterMethod() throws IOException {
        //log4j.info("afterMethod method - Start");


        //Update test execution status to the testcaseList
        testcaseList.add(testNameWithStatus + ": " + logMethod.getStatus());

        // Quit
        quit(logMethod);
        logMethod = null;

       //log4j.info("afterMethod method - End");
    }

    @AfterClass()
    public synchronized void afterClass() throws IOException {
        //log4j.info("afterClass method - Start");

        // Remove skip test case from report
        //if (isTestCaseExecutable == false && SHOW_SKIP == false) report.removeTest(logClass);

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

        //log4j.info("afterClass method - End");
    }

    @AfterSuite()
    public synchronized void afterSuite() throws Exception {
        //log4j.info("afterSuite method - Start");

        //Get the total count of TCs passed and failed
        //getTestCaseExecutionCount(testcaseList);




    }
}