package com.logigear.training.test.base;

import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.webdrivers.*;
import org.testng.annotations.*;


public class TestBase extends DriverUtils{
    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();
    public DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browsername) {
        this.setDriver(new DriverManagerFactory().createInstance(browsername));
        maximizeWindow();
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}