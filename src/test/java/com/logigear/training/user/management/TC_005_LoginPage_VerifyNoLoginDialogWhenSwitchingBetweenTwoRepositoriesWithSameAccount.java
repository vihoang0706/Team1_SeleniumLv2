package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005_LoginPage_VerifyNoLoginDialogWhenSwitchingBetweenTwoRepositoriesWithSameAccount extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    String repo = "SampleRepositoryLV2";

    @Test(description = "Verify that there is no Login dialog when switching between 2 repositories with the same account")
    public void DA_LOGIN_TC005() {
        logClass.log(Status.INFO, "Step #2. Login with valid account for the first repository");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #3. Choose another repository in Repository list");
        dashboardPage.switchRepository(repo);

        logClass.log(Status.INFO, "Step #4. Observe the current page: There is no Login Repository dialog");
        logClass.log(Status.INFO, "Step #5. Observe the current page: The Repository menu displays name of switched repository");
        Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY_LV2);
    }
}
