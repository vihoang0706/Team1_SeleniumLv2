package com.logigear.training.main.page.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_013_MainPage_VerifyTheNewlyMainParentPageIsPositionedAtLocationSpecificed extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();

    @Test(description = "Verify that the newly added main parent page is positioned at the location specified as set with \"Displayed After\" field of \"New Page\" form on the main page bar/\"Parent Page\" dropped down menu")
    public void DA_LOGIN_TC013() throws IOException {

        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        logClass.log(Status.INFO, "Step #2. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #3. Wait for page load");
        DriverUtils.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #4. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        DriverUtils.waitForPageLoaded();
        logClass.log(Status.INFO, "Step #5. Add first page");
        dashboardPage.addPage("Page1");
        DriverUtils.sleep(5);
        String idPage1 = dashboardPage.getIdPage();
        System.out.println(idPage1);
        DriverUtils.sleep(5);
        logClass.log(Status.INFO, "Step #6. Go to Global Setting -> Add page");
        DashboardPage dashboardPage1 = new DashboardPage();
        dashboardPage1.goToAddPage();

        DriverUtils.waitForPageLoaded();
        logClass.log(Status.INFO, "Step #7. Add second page with specific display after");
        dashboardPage1.addPage("Page2","Page1");
        DriverUtils.sleep(5);
        String idPage2 = dashboardPage1.getIdPage();
        System.out.println(idPage2);
        logClass.log(Status.INFO, "Step #8.  Check \"Another Test\" page is positioned besides the \"Test\" page");
        DriverUtils.waitForPageLoaded();
        boolean isPositionOfThisPageNextAnotherPage = dashboardPage.isPositionOfThisPageNextAnotherPage("Page1","Page2");
        System.out.println(isPositionOfThisPageNextAnotherPage);
        DriverUtils.verifyExpectedAndActualResults(logClass,String.valueOf(isPositionOfThisPageNextAnotherPage),"true");

        // Post condition
        DashboardPage dashboardPage2 = new DashboardPage();
        dashboardPage2.deletePage(idPage1);

        DriverUtils.sleep(5);

        dashboardPage2.deletePage(idPage1);

    }
}

