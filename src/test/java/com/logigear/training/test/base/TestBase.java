package com.logigear.training.test.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.logigear.training.common.Constants;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.ExtentTestReport;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class TestBase extends ExtentTestReport {
    public ExtentTest logMethod = null;
    public static ExtentTest logSuite = null;
    public String testCaseName;
    public ExtentTest logClass = null;
    public WebDriver driver;
    DesiredCapabilities capability = null;
    String nodeURL;

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
        if(runOn=="grid") {
            nodeURL = "http://localhost:4444/wd/hub";
            switch (browserName.toLowerCase()) {
                case "chrome":
                    capability = DesiredCapabilities.chrome();
                    capability.setBrowserName("chrome");
                    capability.setPlatform(Platform.WINDOWS);
                case "firefox":
                    capability = DesiredCapabilities.firefox();
                    capability.setBrowserName("chrome");
                    capability.setPlatform(Platform.WINDOWS);
            }
            driver = new RemoteWebDriver(new URL(nodeURL), capability);
        } else {
            DriverUtils.initializeDriver(browserName, logMethod);
        }
        logClass = createTestForExtentReport(report, testCaseName);
        DriverUtils.navigateToTestSite(Constants.AUT);
        WebDriverWaitUtils.waitForPageLoaded();
    }

    @AfterClass
    public synchronized void afterMethod() throws IOException {
        DriverUtils.getDriver().quit();
    }

    @AfterSuite()
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