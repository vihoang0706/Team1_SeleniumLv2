package com.logigear.tranining.user.management;

import com.logigear.training.common.CommonMethods;
import com.logigear.training.common.Constants;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TC_003_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithIncorrectPassword extends TestBase {
    private LoginPage loginPage = null;

    @Test
    public void TC_003_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithIncorrectPassword() {
        System.out.println("Login with valid username and invalid password");
        loginPage.login(Constants.VALID_USERNAME, Constants.INVALID_PASSWORD);

        CommonMethods.waitForAlertPresent(); // Wait for Alert present
        System.out.println("Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, Constants.INVALID_USERNAME_OR_PASSWORD_MSG);
    }

    @AfterClass
    public void PostCondition() {
        System.out.println("Close message");
        CommonMethods.acceptAlert();
    }

}
