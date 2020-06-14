package com.logigear.training.test.base;

import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.webdrivers.DriverManager;
import com.logigear.training.utilities.webdrivers.DriverManagerFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;



public class TestBase extends DriverUtils {
    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();
    public DashboardPage dashboardPage = new DashboardPage();
    DriverManager driverManager;

    public static ExtentTest test;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static ExtentReports report;

    @BeforeSuite
    public void before() {
        extent = new ExtentReports("target\\surefire-reports\\ExtentReport.html", true);

        log4jConfiguration();
        DOMConfigurator.configure("resources/suites/log4j.xml");
    }
    @BeforeClass
    public void setup() {
        driverManager = DriverManagerFactory.getDriverManager(Constants.BROWSER);
        Constants.DRIVER = driverManager.getWebDriver();
        Constants.DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeWebDriver() {
        driverManager.quitWebDriver();
    }

    @AfterSuite
    public void tearDownSuite() {
        // reporter.endReport();
        extent.flush();
        extent.close();
    }
    public void reportLog(String message) {
        test.log(LogStatus.INFO, message);//For extentTest HTML report
        log4j.info("Message: " + message);
        Reporter.log(message);

    }

}