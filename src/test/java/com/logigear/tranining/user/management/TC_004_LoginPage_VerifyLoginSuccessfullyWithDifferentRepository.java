package com.logigear.tranining.user.management;

import com.logigear.training.common.GlobalVariables;
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
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);

        //Logout
        dashboardPage.logout();

        //Select another repository
        loginPage.selectRepository(GlobalVariables.SAMPLE_REPOSITORY_LV2);

        //Login with SampleRepositoryLV2
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);

        //Verify that user login to SampleRepositoryLV2 successfully
        Assert.assertEquals(dashboardPage.getWelcomeAccount(), GlobalVariables.VALID_USERNAME);
        Assert.assertEquals(dashboardPage.getRepository(), GlobalVariables.SAMPLE_REPOSITORY_LV2);
    }
}
