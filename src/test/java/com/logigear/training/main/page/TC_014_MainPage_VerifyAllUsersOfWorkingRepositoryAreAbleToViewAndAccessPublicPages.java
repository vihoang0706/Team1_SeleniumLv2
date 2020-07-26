package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.model.PageInfo;
import com.logigear.training.pages.AddPageForm;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.ExtentTestReport;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_014_MainPage_VerifyAllUsersOfWorkingRepositoryAreAbleToViewAndAccessPublicPages extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPageForm = new AddPageForm();
    public LGAlert alert = new LGAlert();
    String newPageName = "TdTesting";

    @Test(description = "Verify that 'Public' pages can be visible and accessed by all users of working repository")
    public void DA_MP_TC014() throws IOException {
        logClass.log(Status.INFO, "Step #1. Log in specific repository with valid account");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #2. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        logClass.log(Status.INFO, "Step #4. Enter Page Name field");
        addPageForm.submitPageInformation(new PageInfo() {{
            pageName = newPageName;
            isPublic = false;
        }});

        logClass.log(Status.INFO, "Step #5. Check Public checkbox");
        addPageForm.checkOnIsPublicCheckbox();

        logClass.log(Status.INFO, "Step #6. Click OK button");
        addPageForm.clickButton("ok");
        alert.waitForAlertPresent();
        alert.acceptAlert();

        logClass.log(Status.INFO, "Step #7. Click on Log out link");
        dashboardPage.logout();

        logClass.log(Status.INFO, "Step #8. Log in with another valid account");
        LoginPage lgPage = new LoginPage();
        lgPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        DashboardPage dbPage = new DashboardPage();
        logClass.log(Status.INFO, "Step #9. Check newly added page is visible");
        ExtentTestReport.verifyExpectedAndActualResults(logClass, String.valueOf(dbPage.isDialogDisplayed()), "true");
    }
}
