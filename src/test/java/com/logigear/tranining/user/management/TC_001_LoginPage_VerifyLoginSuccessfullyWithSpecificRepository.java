package com.logigear.tranining.user.management;

import com.logigear.training.common.Constants;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.DashboardPage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    @Test
    public void TC_001() throws IOException {

        //Login to SampleRepository
        //logStep = logStepInfo(logMethod, "Login to SampleRepository");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        //Verify that user login to SampleRepository successfully
        Assert.assertEquals(dashboardPage.getWelcomeAccount(), Constants.VALID_USERNAME);
        Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY);
    }
}
