package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.ExtentTestReport;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_003_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithIncorrectPassword extends TestBase {
    public LoginPage loginPage = new LoginPage();

    @Test(description = "Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password")
    public void DA_LOGIN_TC003() throws IOException {
        logClass.log(Status.INFO, "Step #1. Login with valid username and invalid password");
        loginPage.login(Constants.VALID_USERNAME, Constants.INVALID_PASSWORD);

        logClass.log(Status.INFO, "Step #2. Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        ExtentTestReport.verifyExpectedAndActualResults(logClass, actualErrorMessage,Constants.INVALID_USERNAME_OR_PASSWORD_MSG);
    }
}