package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.AddPageForm;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_013_MainPage_VerifyTheNewlyMainParentPageIsPositionedAtLocationSpecific extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPage = new AddPageForm();

    @Test(description = "Verify that the newly added main parent page is positioned at the location specified as set with \"Displayed After\" field of \"New Page\" form on the main page bar/\"Parent Page\" dropped down menu")
    public void DA_LOGIN_TC013() throws IOException {

        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        logClass.log(Status.INFO, "Step #2. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #3. Wait for page load");
        loginPage.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #4. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        dashboardPage.waitForPageLoaded();
        logClass.log(Status.INFO, "Step #5. Add first page");
        addPage.enterNewPageInfo("Page1",null,null,null,null);
        addPage.clickButton("ok");

        addPage.sleep(5);
        String idPage1 = dashboardPage.getIdPage();
        System.out.println(idPage1);
        dashboardPage.sleep(5);
        logClass.log(Status.INFO, "Step #6. Go to Global Setting -> Add page");
        AddPageForm addPageForm = new AddPageForm();
        DashboardPage dbPage = new DashboardPage();
        dbPage.goToAddPage();

        DriverUtils.waitForPageLoaded();
        logClass.log(Status.INFO, "Step #7. Add second page with specific display after");
        addPageForm.enterNewPageInfo("Page2",null,null,"Page1",null);
        addPageForm.clickButton("ok");

        addPageForm.sleep(5);
        String idPage2 = dbPage.getIdPage();
        System.out.println(idPage2);
        logClass.log(Status.INFO, "Step #8.  Check \"Another Test\" page is positioned besides the \"Test\" page");
        dbPage.waitForPageLoaded();
        boolean isPositionOfThisPageNextAnotherPage = dbPage.isPositionOfThisPageNextAnotherPage("Page1","Page2");
        System.out.println(isPositionOfThisPageNextAnotherPage);
        dbPage.verifyExpectedAndActualResults(logClass,String.valueOf(isPositionOfThisPageNextAnotherPage),"true");

        // Post condition
        DashboardPage dbPage1 = new DashboardPage();
        dbPage1.deletePage(idPage1);

        dbPage1.sleep(5);
        DashboardPage dbPage2 = new DashboardPage();
        dbPage2.deletePage(idPage2);
    }
}
