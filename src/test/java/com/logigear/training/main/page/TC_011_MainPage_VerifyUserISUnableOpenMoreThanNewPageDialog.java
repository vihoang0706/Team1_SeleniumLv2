package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.ExtentTestReport;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_011_MainPage_VerifyUserISUnableOpenMoreThanNewPageDialog extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that user is unable open more than 1 \"New Page\" dialog")
    public void DA_MP_TC011() throws IOException {
        logClass.log(Status.INFO, "Step #1. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #2. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        logClass.log(Status.INFO, "Step #3. Try to go to Global Setting -> Add page again");
        dashboardPage.goToAddPage();

        logClass.log(Status.INFO, "Step #4. Observe the current page->User cannot go to Global Setting -> Add page while \"New Page\" dialog appears.\n");
        ExtentTestReport.verifyExpectedAndActualResults(logClass, dashboardPage.isDialogDisplayed(),"Add Page");
    }
}