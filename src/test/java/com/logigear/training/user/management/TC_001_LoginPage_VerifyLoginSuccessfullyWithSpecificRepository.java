package com.logigear.training.user.management;

import com.logigear.training.common.Constants;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.reports.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {
    @Test(priority = 0, description = "Verify Login Successfully With Specific Repository")
    public void DA_LOGIN_TC001(Method method){
        //ExtentReports Description
        ExtentTestManager.startTest(method.getName(), "Verify Login Successfully With Specific Repository");
        navigateToTestSite(Constants.AUT);
        //Login to SampleRepository
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        //Verify that user login to SampleRepository successfully
        Assert.assertEquals(dashboardPage.getWelcomeAccount(), Constants.VALID_USERNAME);
        Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY);
    }

    @AfterTest
    public void PostCondition() {
        dashboardPage.logout();
    }
}