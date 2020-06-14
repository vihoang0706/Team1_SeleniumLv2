package com.logigear.training.test.base;

import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.webdrivers.DriverManager;
import com.logigear.training.utilities.webdrivers.DriverManagerFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestBase extends DriverUtils {
    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();
    public DashboardPage dashboardPage = new DashboardPage();

    DriverManager driverManager;

    @Parameters({ "browser" })
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
}