package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_006_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithPasswordIsCaseSensitive extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();
    public DashboardPage dashboardPage= new DashboardPage();

    @Test
    public void DA_LOGIN_TC006() {
        logClass.log(Status.INFO, "Navigate to Dashboard login page" + Constants.AUT);
        navigateToTestSite(Constants.AUT);
        DriverUtils.waitForPageLoaded();
        System.out.println("Login with the account has uppercase password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        DriverUtils.waitForPageLoaded();
        System.out.println("VP: Observe the current page. Main page is displayed");
        String actualWelcomeUserName = dashboardPage.getWelcomeAccount();
        Assert.assertEquals(actualWelcomeUserName,Constants.VALID_USERNAME);

        System.out.println("Logout TA Dashboard");
        dashboardPage.logout();

        LoginPage lgPage = new LoginPage();
        System.out.println("Login with the above account but enter lowercase password");
        lgPage.login(Constants.VALID_USERNAME, Constants.LOWERCASE_PASSWORD);

        alert.waitForAlertPresent(); // Wait for Alert present
        System.out.println("VP: Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = lgPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,Constants.INVALID_USERNAME_OR_PASSWORD_MSG);
    }
    @AfterMethod
    public void PostCondition() {
        System.out.println("Close message");
        alert.acceptAlert();
    }
}