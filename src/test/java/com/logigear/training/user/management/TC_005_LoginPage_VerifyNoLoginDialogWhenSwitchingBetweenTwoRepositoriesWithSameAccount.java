package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005_LoginPage_VerifyNoLoginDialogWhenSwitchingBetweenTwoRepositoriesWithSameAccount extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that there is no Login dialog when switching between 2 repositories with the same account")
    public void DA_LOGIN_TC005() {

        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);
        DriverUtils.waitForPageLoaded();

        //Variables
        String repo = "SampleRepositoryLV2";

        logClass.log(Status.INFO, "Step #2. Login with valid account for the first repository");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        DriverUtils.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #3. Choose another repository in Repository list");
        dashboardPage.switchRepository(repo);

        logClass.log(Status.INFO, "Step #4. Observe the current page: There is no Login Repository dialog");
        logClass.log(Status.INFO, "Step #5. Observe the current page: The Repository menu displays name of switched repository");
        DriverUtils.sleep(5);
        Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY_LV2);
    }
}
