package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify Login Successfully With Specific Repository")
    public void DA_LOGIN_TC001() throws IOException {
        logClass.log(Status.INFO, "Navigate to Dashboard login page" + Constants.AUT);
        navigateToTestSite(Constants.AUT);
        logClass.log(Status.INFO, "Enter valid username '" + Constants.VALID_USERNAME +  " ' and password '" + Constants.VALID_PASSWORD + "'");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        logClass.log(Status.INFO, "Wait for page load");
        DriverUtils.waitForPageLoaded();
        logClass.log(Status.INFO, "Verify that Dashboard Main page appears");
        DriverUtils.verifyExpectedAndActualResults(logClass,dashboardPage.getWelcomeAccount(),Constants.VALID_USERNAME);
        DriverUtils.verifyExpectedAndActualResults(logClass,dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY);
    }

    @AfterMethod
    public void PostCondition() {
        dashboardPage.logout();
    }
}