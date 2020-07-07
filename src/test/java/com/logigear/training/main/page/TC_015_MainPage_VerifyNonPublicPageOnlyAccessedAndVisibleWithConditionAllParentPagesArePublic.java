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

public class TC_015_MainPage_VerifyNonPublicPageOnlyAccessedAndVisibleWithConditionAllParentPagesArePublic extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPageForm = new AddPageForm();
    public LGAlert alert = new LGAlert();
    String pageName = randomData("Testing");
    String childPageName = randomData("ChildTesting");

    @Test(description = "Verify that non \"Public\" pages can only be accessed and visible to their creators with condition that all parent pages above it are \"Public\"")
    public void DA_MP_TC015() throws IOException {
        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);
        logClass.log(Status.INFO, "Step #2. Log in specific repository with valid account");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        loginPage.sleep(2);
        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();
        logClass.log(Status.INFO, "Step #4. Enter Page Name field and check public checkout");
        addPageForm.enterNewPageInfo(pageName, null, null, null, true);
        logClass.log(Status.INFO, "Step #5. Click OK button");
        addPageForm.clickButton("ok");

        addPageForm.sleep(5);
        String idPage1 = dashboardPage.getIdPage();
        System.out.println(idPage1);

        logClass.log(Status.INFO, "Step #6. Go to Global Setting -> Add page\n");
        AddPageForm addPage = new AddPageForm();
        DashboardPage dbPage = new DashboardPage();
        dbPage.goToAddPage();

        logClass.log(Status.INFO, "Step #7. Enter Page Name field\n");
        addPage.enterNewPageInfo(childPageName, pageName, null, null, true);
        logClass.log(Status.INFO, "Step #8. Click OK button");
        addPage.clickButton("ok");

        addPage.sleep(5);
        String idPage2 = dashboardPage.getIdPage();
        System.out.println(idPage2);

        logClass.log(Status.INFO, "Step #8. Click on Log out link\n");
        dbPage.logout();

        logClass.log(Status.INFO, "Step #9. Navigate to Dashboard login page ");
        waitForPageLoaded();
        navigateToTestSite(Constants.AUT);
        waitForPageLoaded();

        logClass.log(Status.INFO, "Step #10. Log in with another valid account\n");
        LoginPage lgPage = new LoginPage();
        lgPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        waitForPageLoaded();

        logClass.log(Status.INFO, "Step #11. Check children is invisible");
        DashboardPage db = new DashboardPage();
        boolean isChildPageDisplayed = db.isChildPageDisplayed(idPage1,idPage2);
        System.out.println(isChildPageDisplayed);
        verifyExpectedAndActualResults(logClass,String.valueOf(isChildPageDisplayed),"false");

        // Post-condition
        DashboardPage dboard = new DashboardPage();
        dboard.deleteChildPage(idPage1,idPage2);
        waitForPageLoaded();
        sleep(10);
        DashboardPage dashboardPage1 = new DashboardPage();
        dashboardPage1.deletePage(idPage1);

    }
}
