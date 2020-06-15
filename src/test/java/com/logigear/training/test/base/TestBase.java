package com.logigear.training.test.base;

import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.webdrivers.*;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestBase extends DriverUtils {
    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();
    public DashboardPage dashboardPage = new DashboardPage();
    DriverManager driverManager;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browsername) {
        System.out.println(browsername);

        if(browsername.equalsIgnoreCase("chrome")) {
            System.out.println("You have selected " + browsername);
            driverManager = new ChromeDriverManager();
        } else if(browsername.equalsIgnoreCase("firefox")) {
            System.out.println("You have selected " + browsername);
            driverManager = new FireFoxDriverManager();
        } else if(browsername.equalsIgnoreCase("ie")) {
            System.out.println("You have selected " + browsername);
            driverManager = new IEDriverManager();
        } else {
            System.out.println("You have not selected chrome");
        }
        Constants.DRIVER = driverManager.getWebDriver();
        Constants.DRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeWebDriver() {
        driverManager.quitWebDriver();
    }
}