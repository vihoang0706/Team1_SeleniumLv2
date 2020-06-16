package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_002_LoginPage_VerifyFailsLoginSpecificRepositoryViaDashboardLoginPageWithIncorrectCredentials extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();

    @Test()
    public void DA_LOGIN_TC002() throws IOException {
        logClass.log(Status.INFO, "Navigate to Dashboard login page" + Constants.AUT);
        navigateToTestSite(Constants.AUT);
        DriverUtils.waitForPageLoaded();
        logClass.log(Status.INFO, "Login with invalid username '" + Constants.INVALID_USERNAME +  " ' and invalid password '" + Constants.INVALID_PASSWORD + "'");
        loginPage.login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
        alert.waitForAlertPresent(); // Wait for Alert present
        logClass.log(Status.INFO, "Verify that Dashboard Error message \"Username or password is invalid\" appears");
        String actualErrorMessage = loginPage.getErrorMessage();
        DriverUtils.verifyExpectedAndActualResults(logClass, actualErrorMessage,Constants.INVALID_USERNAME_OR_PASSWORD_MSG);
    }

    @AfterMethod
    public void PostCondition() {
        logClass.log(Status.INFO, "Close alert");
        alert.acceptAlert();
    }
}
