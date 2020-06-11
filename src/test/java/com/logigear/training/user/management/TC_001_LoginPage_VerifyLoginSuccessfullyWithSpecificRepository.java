package com.logigear.training.user.management;

import com.logigear.training.common.Constants;
import com.logigear.training.test.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {
    @Test
    public void DA_LOGIN_TC001() throws IOException {
        navigateToTestSite(logMethod,Constants.AUT);
        //Login to SampleRepository
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        //Verify that user login to SampleRepository successfully
        Assert.assertEquals(dashboardPage.getWelcomeAccount(), Constants.VALID_USERNAME);
        Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY);
    }
}