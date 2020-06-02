package com.logigear.tranining.user.management;

import com.logigear.training.common.Common;
import com.logigear.training.common.GlobalVariables;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.DashboardPage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_006_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithPasswordIsCaseSensitive extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void TC_006_VerifyErrorMessageDisplaysWhenLoginWithPasswordIsCaseSensitive() {
        System.out.println("Login with the account has uppercase password");
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);

        System.out.println("VP: Observe the current page. Main page is displayed");
        String actualWelcomeUserName = dashboardPage.getWelcomeAccount();
        Assert.assertEquals(actualWelcomeUserName,GlobalVariables.VALID_USERNAME);

        System.out.println("Logout TA Dashboard");
        dashboardPage.logout();

        System.out.println("Login with the above account but enter lowercase password");
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.LOWERCASE_PASSWORD);

        Common.waitForAlertPresent(); // Wait for Alert present
        System.out.println("VP: Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,GlobalVariables.INVALID_USERNAME_OR_PASSWORD_MSG);
    }
    @AfterClass
    public void PostCondition() {
        System.out.println("Close message");
        Common.acceptAlert();
    }
}