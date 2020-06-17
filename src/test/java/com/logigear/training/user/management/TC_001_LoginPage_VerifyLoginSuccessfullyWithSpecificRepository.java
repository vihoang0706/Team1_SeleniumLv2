package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify Login Successfully With Specific Repository")
    public void DA_LOGIN_TC001() throws IOException {

        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        logClass.log(Status.INFO, "Step #2. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #3. Wait for page load");
        DriverUtils.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #4. Verify that Dashboard Main page appears");
        DriverUtils.verifyExpectedAndActualResults(logClass,dashboardPage.getWelcomeAccount(),Constants.VALID_USERNAME);
        DriverUtils.verifyExpectedAndActualResults(logClass,dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY);

        logClass.log(Status.INFO, "Clean up");
        dashboardPage.logout();
    }
}