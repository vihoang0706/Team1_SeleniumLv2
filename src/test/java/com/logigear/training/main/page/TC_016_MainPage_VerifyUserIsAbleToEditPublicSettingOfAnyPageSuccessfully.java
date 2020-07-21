package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.AddPageForm;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_016_MainPage_VerifyUserIsAbleToEditPublicSettingOfAnyPageSuccessfully extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPageForm = new AddPageForm();
    public LGAlert alert = new LGAlert();
    String pageName = "Test";
    String anotherPageName = "Another Test";

    @Test(description = "Verify that user is able to edit the 'Public' setting of any page successfully")
    public void DA_MP_TC016() throws IOException {
    //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        logClass.log(Status.INFO, "Step #2. Log in specific repository with valid account");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        loginPage.sleep(2);

        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        DriverUtils.sleep(2);
        logClass.log(Status.INFO, "Step #4. Enter Page Name field");
        addPageForm.enterNewPageInfo(pageName, null, null, null, false);

        logClass.log(Status.INFO, "Step #5. Click OK button");
        addPageForm.clickButton("ok");
        alert.waitForAlertPresent();
        alert.acceptAlert();
        dashboardPage.sleep(2);
        String pageId = dashboardPage.getIdPage();

        dashboardPage.sleep(5);
        logClass.log(Status.INFO, "Step #6. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        DriverUtils.sleep(2);
        logClass.log(Status.INFO, "Step #7. Enter Another Page Name field");
        addPageForm.enterNewPageInfo(anotherPageName, null, null, null, false);

        logClass.log(Status.INFO, "Step #8. Check Public checkbox");
        addPageForm.checkOnIsPublicCheckbox();

        logClass.log(Status.INFO, "Step #9. Click OK button");
        addPageForm.clickButton("ok");
        alert.waitForAlertPresent();
        alert.acceptAlert();
        dashboardPage.sleep(2);
        String anotherPageId = dashboardPage.getIdPage();

        logClass.log(Status.INFO, "Step #10. Click on 'Test' page");
        dashboardPage.clickOnPage(pageId);

        logClass.log(Status.INFO, "Step #11. Click on 'Edit' link");
        dashboardPage.goToEditPage();

        logClass.log(Status.INFO, "Step #12. Check 'Edit' Page pop up window is displayed");
        dashboardPage.verifyExpectedAndActualResults(logClass, String.valueOf(dashboardPage.isDialogDisplayed()), "true");

        logClass.log(Status.INFO, "Step #13. Check Public checkbox");
        addPageForm.checkOnIsPublicCheckbox();

        logClass.log(Status.INFO, "Step #14. Click OK button");
        addPageForm.clickButton("ok");
        alert.waitForAlertPresent();
        alert.acceptAlert();

        logClass.log(Status.INFO, "Step #15. Click on 'Another Test' page");
        dashboardPage.clickOnPage(anotherPageId);

        logClass.log(Status.INFO, "Step #16. Click on 'Edit' link");
        dashboardPage.goToEditPage();

        logClass.log(Status.INFO, "Step #17. Check 'Edit Page' pop up window is displayed");
        dashboardPage.verifyExpectedAndActualResults(logClass, String.valueOf(dashboardPage.isDialogDisplayed()), "true");

        logClass.log(Status.INFO, "Step #18. Uncheck Public checkbox");
        addPageForm.uncheckIsPublicCheckbox();

        logClass.log(Status.INFO, "Step #19. Click OK button");
        addPageForm.clickButton("ok");
        alert.waitForAlertPresent();
        alert.acceptAlert();

        logClass.log(Status.INFO, "Step #20. Click Log out link");
        dashboardPage.logout();

        logClass.log(Status.INFO, "Step #21. Log in with another valid account");
        LoginPage lgPage = new LoginPage();
        lgPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #22. Check 'Test' Page is visible and can be accessed");
        DashboardPage dbPage = new DashboardPage();
        dbPage.verifyExpectedAndActualResults(logClass, String.valueOf(dbPage.isPageDisplayed(pageName)), "true");

        logClass.log(Status.INFO, "Step #23. Check 'Another Test' page is invisible");
        dbPage.verifyExpectedAndActualResults(logClass, String.valueOf(dbPage.isPageDisplayed(anotherPageName)), "false");
    }
}
