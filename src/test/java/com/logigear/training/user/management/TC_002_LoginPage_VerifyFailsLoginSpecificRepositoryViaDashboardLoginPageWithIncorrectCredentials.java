package com.logigear.training.user.management;

import com.logigear.training.common.Constants;
import com.logigear.training.test.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_002_LoginPage_VerifyFailsLoginSpecificRepositoryViaDashboardLoginPageWithIncorrectCredentials extends TestBase {
    @Test
    public void DA_LOGIN_TC002() {
        navigateToTestSite(Constants.AUT);
        System.out.println("Login with invalid username and invalid password");
        loginPage.login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);

        alert.waitForAlertPresent(); // Wait for Alert present
        System.out.println("Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,Constants.INVALID_USERNAME_OR_PASSWORD_MSG);
    }

    @AfterClass
    public void PostCondition() {
        System.out.println("Close message");
        alert.acceptAlert();
    }
}
