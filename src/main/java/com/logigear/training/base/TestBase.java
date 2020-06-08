package com.logigear.training.base;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.common.Constants;
import com.logigear.training.driverManagement.DriverManager;
import com.logigear.training.driverManagement.DriverType;
import com.logigear.training.utilities.Utility;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase extends Utility {

    public ExtentTest logClass = null;
    public ExtentTest logMethod = null;
    public ExtentTest logStep = null;

    @BeforeTest
    public void setup() {
        DriverManager.setDriverManager(DriverType.CHROME);
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DriverManager.getWebDriver().navigate().to(Constants.AUT);
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @AfterTest
    public void closeWebDriver() {
        DriverManager.quitWebDriver();
    }
}