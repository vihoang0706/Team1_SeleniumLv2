package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_LoginPage_VerifyLoginSuccessfullyWithDifferentRepository extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public LGAlert alert = new LGAlert();

    @Test(description = "Verify that user is able to log in different repositories successfully after logging out current repository")
    public void DA_LOGIN_TC004() {
        logClass.log(Status.INFO, "Step #1. Login with SampleRepository");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #2. Logout");
        dashboardPage.logout();

        LoginPage lgPage = new LoginPage();
        logClass.log(Status.INFO, "Step #3. Select another repository");
        lgPage.selectRepository(Constants.SAMPLE_REPOSITORY_LV2);

        logClass.log(Status.INFO, "Step #4. Login with SampleRepositoryLV2");
        lgPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        DashboardPage dbPage = new DashboardPage();
        logClass.log(Status.INFO, "Step #5. Verify that user login to SampleRepositoryLV2 successfully");
        Assert.assertEquals(dbPage.getWelcomeAccount(), Constants.VALID_USERNAME);
        Assert.assertEquals(dbPage.getRepository(), Constants.SAMPLE_REPOSITORY_LV2);

        dbPage.logout();
    }
}