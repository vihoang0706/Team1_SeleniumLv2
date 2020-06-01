package com.logigear.training.common;

import com.logigear.training.driverManagement.DriverManager;
import com.logigear.training.driverManagement.DriverType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    @BeforeTest
    public void setup() {
        DriverManager.setDriverManager(DriverType.CHROME);
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DriverManager.getWebDriver().navigate().to(GlobalVariables.AUT);
        DriverManager.getWebDriver().manage().window().maximize();
    }

    @AfterTest
    public void closeWebDriver() {
        DriverManager.quitWebDriver();
    }
}
