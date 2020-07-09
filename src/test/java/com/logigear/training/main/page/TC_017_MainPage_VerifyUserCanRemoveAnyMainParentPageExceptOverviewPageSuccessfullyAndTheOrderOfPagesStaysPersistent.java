package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.AddPageForm;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.logigear.training.common.Constants.WAIT_TIME;

public class TC_017_MainPage_VerifyUserCanRemoveAnyMainParentPageExceptOverviewPageSuccessfullyAndTheOrderOfPagesStaysPersistent extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();
    public AddPageForm addPageForm = new AddPageForm();

    @Test(description = "Verify that user can remove any main parent page except \"Overview\" page successfully and the order of pages stays persistent as long as there is not children page under it")
    public void DA_MP_TC017() throws IOException {

        //Variables
        String parentPage = "hangTC017";
        String childrenPage = "childTC017";

        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        waitForPageLoaded();

        logClass.log(Status.INFO, "Step #2. Login with valid username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        //Wait for page loads completely
        loginPage.sleep(5);
        loginPage.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add New Parent page");
        dashboardPage = PageFactory.initElements(getDriver(), DashboardPage.class);
        dashboardPage.goToAddPage();

        //Wait for page loads completely
        dashboardPage.waitForPageLoaded();

        addPageForm = PageFactory.initElements(getDriver(), AddPageForm.class);
        addPageForm.checkAddPageModalDisplay(logMethod);
        addPageForm.enterNewPageInfo(parentPage, null, null, null, false);
        addPageForm.clickButton("OK");
        addPageForm.sleep(WAIT_TIME);

        logClass.log(Status.INFO, "Step #4. Add new children page of newly added page");
        DashboardPage dbPage = new DashboardPage();
        dbPage.goBackToPreviousPage(logMethod);
        dbPage.goToAddPage();
        dbPage.waitForPageLoaded();

        addPageForm = PageFactory.initElements(getDriver(), AddPageForm.class);
        addPageForm.checkAddPageModalDisplay(logMethod);
        addPageForm.enterNewPageInfo(childrenPage, parentPage, null, null, false);
        addPageForm.clickButton("OK");
        addPageForm.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #5. Click on Parent page -> Click Delete link");
        DashboardPage dbPage1 = new DashboardPage();
        String idPage = dbPage.getIdPage();
        dbPage1.deletePage(idPage);

        logClass.log(Status.INFO, "VP: Confirm message \"Are you sure you want to remove this page?\" appears");







    }
}
