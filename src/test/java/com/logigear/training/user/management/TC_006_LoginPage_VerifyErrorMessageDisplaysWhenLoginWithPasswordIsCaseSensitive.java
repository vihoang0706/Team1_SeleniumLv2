package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.ExtentTestReport;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_006_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithPasswordIsCaseSensitive extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage= new DashboardPage();

    @Test(description = "Verify that \"Password\" input is case sensitive")
    public void DA_LOGIN_TC006() throws IOException {
        logClass.log(Status.INFO, "Step #1. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        WebDriverWaitUtils.waitForPageLoaded();
        logClass.log(Status.INFO,"Step #2. Observe the current page. Main page is displayed");
        String actualWelcomeUserName = dashboardPage.getWelcomeAccount();
        ExtentTestReport.verifyExpectedAndActualResults(logClass, actualWelcomeUserName,Constants.VALID_USERNAME);

        logClass.log(Status.INFO,"Step #3. Logout TA Dashboard");
        dashboardPage.logout();
        WebDriverWaitUtils.waitForPageLoaded();

        LoginPage lgPage = new LoginPage();
        logClass.log(Status.INFO,"Step #4. Login with the above account but enter lowercase password");
        lgPage.login(Constants.VALID_USERNAME, Constants.LOWERCASE_PASSWORD);

        WebDriverWaitUtils.waitForPageLoaded();
        logClass.log(Status.INFO,"Step #5. Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = lgPage.getErrorMessage();
        ExtentTestReport.verifyExpectedAndActualResults(logClass, actualErrorMessage,Constants.INVALID_USERNAME_OR_PASSWORD_MSG);
    }
}