package com.logigear.tranining.user.management;

import com.logigear.training.common.Constants;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.DashboardPage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004_LoginPage_VerifyLoginSuccessfullyWithDifferentRepository extends TestBase {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void TC_001() {

        //Login with SampleRepository
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        //Logout
        dashboardPage.logout();

        //Select another repository
        loginPage.selectRepository(Constants.SAMPLE_REPOSITORY_LV2);

        //Login with SampleRepositoryLV2
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        //Verify that user login to SampleRepositoryLV2 successfully
        Assert.assertEquals(dashboardPage.getWelcomeAccount(), Constants.VALID_USERNAME);
        Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY_LV2);
    }
}