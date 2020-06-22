package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DA_MP_TC011_MainPage_VerifyUserISUnableOpenMoreThanNewPageDialog extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public LGAlert alert = new LGAlert();
    @Test
    public void DA_MP_TC011() throws IOException {
        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        logClass.log(Status.INFO, "Step #2. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        DriverUtils.waitForPageLoaded();
        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        DriverUtils.sleep(5);

        logClass.log(Status.INFO, "Step #4. Try to go to Global Setting -> Add page again");
        boolean doesControlExist = DriverUtils.doesControlExist(dashboardPage.getGlobalSetting());
        System.out.println(doesControlExist);
        Assert.assertEquals(doesControlExist, false);

    }
}