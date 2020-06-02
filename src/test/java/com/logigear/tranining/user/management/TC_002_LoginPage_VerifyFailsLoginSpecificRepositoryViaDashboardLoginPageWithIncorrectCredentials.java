package com.logigear.tranining.user.management;

import com.logigear.training.common.Common;
import com.logigear.training.common.GlobalVariables;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_002_LoginPage_VerifyFailsLoginSpecificRepositoryViaDashboardLoginPageWithIncorrectCredentials extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC_002_LoginPage_VerifyFailsLoginSpecificRepositoryViaDashboardLoginPageWithIncorrectCredentials() {
        System.out.println("Login with invalid username and invalid password");
        loginPage.login(GlobalVariables.INVALID_USERNAME, GlobalVariables.INVALID_PASSWORD);
        Common.waitForAlertPresent(); // Wait for Alert present
        System.out.println("Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,GlobalVariables.INVALID_USERNAME_OR_PASSWORD_MSG);
    }

    @AfterClass
    public void PostCondition() {
        System.out.println("Close message");
        Common.acceptAlert();
        closeWebDriver();
    }
}
