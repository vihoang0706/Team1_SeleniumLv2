package com.logigear.training.test.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.logigear.training.common.Constants;
import com.logigear.training.utilities.DriverUtils;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class TestBase extends DriverUtils{
    public ExtentTest logMethod = null;
    public static ExtentTest logSuite = null;
    public String testCaseName;
    public ExtentTest logClass = null;
    public String testNameWithStatus;

    @BeforeSuite()
    public synchronized void beforeSuite() throws IOException {

        // Initial test report
        try {
            htmlReporter = new ExtentHtmlReporter(reportFilePath);
            htmlReporter.loadXMLConfig(new File(Constants.PROJECT_PATH + "\\src\\main\\resources\\suites/reporttheme.xml"));
            report = new ExtentReports();
            report.attachReporter(htmlReporter);
            logSuite = createTestForExtentReport(report, "Initial Setup");
        } catch (Exception e) {

        }

        // Create report folder
        logInfo(logSuite, "Report folder: " + reportLocation);
        File folder = new File(reportLocation);
        folder.mkdirs();
    }

    @BeforeClass
    public synchronized void beforeClass() throws IOException {
        // Get test case class name
        testCaseName = this.getClass().getSimpleName();
    }

    @BeforeMethod
    @Parameters({"browser","runOn"})
    public synchronized void beforeMethod(String browserName,String runOn) throws IOException{
        report.setSystemInfo("Browser", browserName);
        initializeDriver(browserName,runOn, logMethod);
        logClass = createTestForExtentReport(report, testCaseName);
    }

    @AfterMethod
    public synchronized void afterMethod() throws IOException {
        quit();
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

        report.flush();
        logClass = null;

    }
}