package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.model.PageInfo;
import com.logigear.training.pages.AddPageForm;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.ExtentTestReport;
import com.logigear.training.utilities.RandomString;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_013_MainPage_VerifyTheNewlyMainParentPageIsPositionedAtLocationSpecific extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPage = new AddPageForm();
    String newPageName1 = RandomString.randomData("TdTesting");
    String newPageName2 = RandomString.randomData("TdTesting");

    @Test(description = "Verify that the newly added main parent page is positioned at the location specified as set with \"Displayed After\" field of \"New Page\" form on the main page bar/\"Parent Page\" dropped down menu")
    public void DA_LOGIN_TC013() throws IOException {
        logClass.log(Status.INFO, "Step #1. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        WebDriverWaitUtils.waitForPageLoaded();
        logClass.log(Status.INFO, "Step #2. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        logClass.log(Status.INFO, "Step #3. Add first page");
        addPage.submitPageInformation(new PageInfo() {{
            pageName = newPageName1;
        }});

        String idPage1 = dashboardPage.getIdPage();
        System.out.println(idPage1);

        logClass.log(Status.INFO, "Step #6. Go to Global Setting -> Add page");
        AddPageForm addPageForm = new AddPageForm();
        DashboardPage dbPage = new DashboardPage();
        dbPage.goToAddPage();

        logClass.log(Status.INFO, "Step #7. Add second page with specific display after");
        addPageForm.submitPageInformation(new PageInfo() {{
            pageName = newPageName2;
            position = newPageName1;
        }});
        String idPage2 = dbPage.getIdPage();
        System.out.println(idPage2);
        logClass.log(Status.INFO, "Step #8.  Check \"Another Test\" page is positioned besides the \"Test\" page");
        boolean isPositionOfThisPageNextAnotherPage = dbPage.isPositionOfThisPageNextAnotherPage(newPageName1,newPageName2);
        System.out.println(isPositionOfThisPageNextAnotherPage);
        ExtentTestReport.verifyExpectedAndActualResults(logClass,String.valueOf(isPositionOfThisPageNextAnotherPage),"true");

        // Post condition
        DashboardPage dbPage1 = new DashboardPage();
        dbPage1.deletePage(idPage1);

        DashboardPage dbPage2 = new DashboardPage();
        dbPage2.deletePage(idPage2);
    }
}
