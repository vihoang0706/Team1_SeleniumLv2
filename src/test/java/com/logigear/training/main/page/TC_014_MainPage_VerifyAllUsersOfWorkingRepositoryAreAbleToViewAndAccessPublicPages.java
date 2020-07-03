package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.AddPageForm;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_014_MainPage_VerifyAllUsersOfWorkingRepositoryAreAbleToViewAndAccessPublicPages extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPageForm = new AddPageForm();
    public LGAlert alert = new LGAlert();
    String pageName = "TdTesting";

    @Test(description = "Verify that 'Public' pages can be visible and accessed by all users of working repository")
    public void DA_MP_TC014() throws IOException {
        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        logClass.log(Status.INFO, "Step #2. Log in specific repository with valid account");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        loginPage.sleep(2);
        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        dashboardPage.sleep(2);
        logClass.log(Status.INFO, "Step #4. Enter Page Name field");
        addPageForm.enterNewPageInfo(pageName, null, null, null, false);

        logClass.log(Status.INFO, "Step #5. Check Public checkbox");
        addPageForm.checkOnIsPublicCheckbox();

        logClass.log(Status.INFO, "Step #6. Click OK button");
        addPageForm.clickButton("ok");
        alert.waitForAlertPresent();
        alert.acceptAlert();

        logClass.log(Status.INFO, "Step #7. Click on Log out link");
        dashboardPage.logout();

        dashboardPage.sleep(2);
        logClass.log(Status.INFO, "Step #8. Log in with another valid account");
        LoginPage lgPage = new LoginPage();
        lgPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        lgPage.sleep(2);
        DashboardPage dbPage = new DashboardPage();
        logClass.log(Status.INFO, "Step #8. Check newly added page is visible");
        dbPage.verifyExpectedAndActualResults(logClass, String.valueOf(dbPage.isDialogDisplayed()), "true");
    }
}
