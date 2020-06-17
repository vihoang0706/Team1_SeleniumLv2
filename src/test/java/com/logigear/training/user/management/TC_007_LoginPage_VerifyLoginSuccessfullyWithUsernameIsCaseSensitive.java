package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_007_LoginPage_VerifyLoginSuccessfullyWithUsernameIsCaseSensitive extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage= new DashboardPage();

    @Test
    public void DA_LOGIN_TC007() {

        //Main steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page" + Constants.AUT);
        navigateToTestSite(Constants.AUT);

        logClass.log(Status.INFO, "Step #2. Login with the account has uppercase username" + Constants.UPPERCASE_USERNAME);
        loginPage.login(Constants.UPPERCASE_USERNAME, Constants.VALID_PASSWORD);

        DriverUtils.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #3. VP: Observe the current page. Main page is displayed");
        Assert.assertEquals(dashboardPage.getWelcomeAccount(),Constants.VALID_USERNAME);

        logClass.log(Status.INFO, "Step #4. Logout TA Dashboard");
        dashboardPage.logout();

        logClass.log(Status.INFO, "Step #5. Login with the account has lowercase username" + Constants.VALID_USERNAME);
        LoginPage lgPage = new LoginPage();
        lgPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        DriverUtils.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #6. VP: Observe the current page. Main page is displayed");
        DashboardPage dbPage = new DashboardPage();
        Assert.assertEquals(dbPage.getWelcomeAccount(),Constants.VALID_USERNAME);
    }

}
