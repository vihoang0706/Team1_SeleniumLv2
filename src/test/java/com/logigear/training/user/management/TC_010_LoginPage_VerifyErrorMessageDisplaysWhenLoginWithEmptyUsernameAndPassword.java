//package com.logigear.training.user.management;
//
//import com.aventstack.extentreports.Status;
//import com.logigear.training.common.Constants;
//import com.logigear.training.pages.DashboardPage;
//import com.logigear.training.pages.LoginPage;
//import com.logigear.training.test.base.TestBase;
//import com.logigear.training.utilities.DriverUtils;
//import com.logigear.training.utilities.controls.LGAlert;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class TC_010_LoginPage_VerifyErrorMessageDisplaysWhenLoginWithEmptyUsernameAndPassword extends TestBase {
//
//    public LoginPage loginPage = new LoginPage();
//    public LGAlert alert = new LGAlert();
//
//    @Test(description = "Verify that the page works correctly for the case when no input entered to Password and Username field")
//    public void DA_LOGIN_TC010()  throws IOException {
//
//        //Main Steps
//        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
//        navigateToTestSite(Constants.AUT);
//
//        DriverUtils.waitForPageLoaded();
//
//        logClass.log(Status.INFO, "Step #2. Login with empty username and password");
//        loginPage.login("", "");
//
//        // Wait for Alert present
//        alert.waitForAlertPresent();
//
//        logClass.log(Status.INFO, "Step #3. Verify that Dashboard Error message \"Please enter username!\" appears");
//        loginPage.verifyExpectedAndActualResults(logClass,loginPage.getErrorMessage(),Constants.EMPTY_USERNAME_AND_PASSWORD_MSG);
//
//        logClass.log(Status.INFO, "Clean up");
//        alert.acceptAlert();
//    }
//}
