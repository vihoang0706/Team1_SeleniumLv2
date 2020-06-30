package com.logigear.training.main.page;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.pages.NewPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.logigear.training.common.Constants.WAIT_TIME;


public class TC_012_MainPage_VerifyUserIsAbleToAddAdditionalPagesBesidesOverviewPageSuccessfully extends TestBase {

    public LoginPage loginPage = new LoginPage();
    public LGAlert alert = new LGAlert();
    public DashboardPage dashboardPage = new DashboardPage();
    public NewPage newPage = new NewPage();

    @Test(description = "Verify that user is able to add additional pages besides \"Overview\" page successfully")
    public void DA_MP_TC012() throws IOException {

        String pageName = "hangTest2";

        //Main Steps
        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
        navigateToTestSite(Constants.AUT);

        DriverUtils.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #2. Login with empty username and password");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        loginPage.sleep(WAIT_TIME);

        //-Wait for page loads completely
        loginPage.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
        dashboardPage = PageFactory.initElements(DriverUtils.getDriver(), DashboardPage.class);
        dashboardPage.goToAddPage();

        //Wait for page loads completely
        dashboardPage.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #4. Enter Page Name field ");
        newPage = PageFactory.initElements(DriverUtils.getDriver(), NewPage.class);
        newPage.checkAddPageModalDisplay(logMethod);
        newPage.enterNewPageInfo(pageName, null, null, null, false);

        logClass.log(Status.INFO, "Step #5. Click OK button");
        newPage.clickButton("OK");

        newPage.waitForPageLoaded();

        logClass.log(Status.INFO, "Step #6. Check \"Test\" page is displayed besides \"Overview\" page");


    }
}
