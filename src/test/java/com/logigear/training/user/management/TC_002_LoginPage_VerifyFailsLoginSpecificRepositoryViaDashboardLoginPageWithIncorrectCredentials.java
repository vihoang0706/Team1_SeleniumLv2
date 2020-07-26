package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.ExtentTestReport;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_002_LoginPage_VerifyFailsLoginSpecificRepositoryViaDashboardLoginPageWithIncorrectCredentials extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();

    @Test(description = "Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials")
    public void DA_LOGIN_TC002() throws IOException {
        logClass.log(Status.INFO, "Step #1. Login with invalid username and invalid password");
        loginPage.login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);

        logClass.log(Status.INFO, "Step #2. Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        ExtentTestReport.verifyExpectedAndActualResults(logClass, actualErrorMessage, Constants.INVALID_USERNAME_OR_PASSWORD_MSG);

        logClass.log(Status.INFO, "Clean up");
        alert.acceptAlert();
    }
}
