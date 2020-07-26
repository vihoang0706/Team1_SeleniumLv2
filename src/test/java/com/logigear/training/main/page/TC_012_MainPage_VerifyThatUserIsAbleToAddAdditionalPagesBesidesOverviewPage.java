package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.model.PageInfo;
import com.logigear.training.pages.AddPageForm;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.ExtentTestReport;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_012_MainPage_VerifyThatUserIsAbleToAddAdditionalPagesBesidesOverviewPage extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPageForm = new AddPageForm();
    String newPageName = "hangTest";

    @Test(description = "Verify that user is able to add additional pages besides \"Overview\" page successfully")
    public void DA_MP_TC012() throws IOException {
        logClass.log(Status.INFO, "Step #1. Login with empty username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        logClass.log(Status.INFO, "Step #2. Go to Global Setting -> Add page");
        dashboardPage.goToAddPage();

        logClass.log(Status.INFO, "Step #3. Enter Page Name field ");
        addPageForm.checkAddPageModalDisplay(logMethod);
        addPageForm.submitPageInformation(new PageInfo() {{
            pageName = newPageName;
        }});

        DashboardPage dbPage = new DashboardPage();
        String idPage = dbPage.getIdPage();
        System.out.println(idPage);
        logClass.log(Status.INFO, "Step #4. Check \"Test\" page is displayed besides \"Overview\" page");

        boolean isPositionOfThisPageNextAnotherPage = dbPage.isPositionOfThisPageNextAnotherPage(newPageName,"Overview");
        System.out.println(isPositionOfThisPageNextAnotherPage);
        ExtentTestReport.verifyExpectedAndActualResults(logClass,String.valueOf(isPositionOfThisPageNextAnotherPage),"true");

        // Post condition
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.deletePage(idPage);
    }
}

