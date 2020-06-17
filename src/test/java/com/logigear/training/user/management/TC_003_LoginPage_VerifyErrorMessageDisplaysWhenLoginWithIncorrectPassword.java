package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_003_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithIncorrectPassword extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();

    @Test
    public void DA_LOGIN_TC003() {

        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        DriverUtils.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #2. Login with valid username and invalid password");
        loginPage.login(Constants.VALID_USERNAME, Constants.INVALID_PASSWORD);

        // Wait for Alert present
        alert.waitForAlertPresent();

        logClass.log(Status.INFO, "Step #3. Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,Constants.INVALID_USERNAME_OR_PASSWORD_MSG);

    }

    @AfterMethod
    public void PostCondition() {
        System.out.println("Close message");
        alert.acceptAlert();
    }

}