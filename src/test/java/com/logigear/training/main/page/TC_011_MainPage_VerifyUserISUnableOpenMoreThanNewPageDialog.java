//package com.logigear.training.main.page;
//
//import com.aventstack.extentreports.Status;
//import com.logigear.training.common.Constants;
//import com.logigear.training.pages.DashboardPage;
//import com.logigear.training.pages.LoginPage;
//import com.logigear.training.test.base.TestBase;
//import com.logigear.training.utilities.DriverUtils;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class TC_011_MainPage_VerifyUserISUnableOpenMoreThanNewPageDialog extends TestBase {
//    public LoginPage loginPage = new LoginPage(this.driver);
//    public DashboardPage dashboardPage = new DashboardPage(this.driver);
//
//    @Test
//    public void DA_MP_TC011() throws IOException {
//
//        //Main Steps
//        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
//        navigateToTestSite(Constants.AUT);
//
//        logClass.log(Status.INFO, "Step #2. Login with valid username and password");
//        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
//
//        loginPage.waitForPageLoaded();
//        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
//        dashboardPage.goToAddPage();
//
//        DriverUtils.sleep(5);
//        logClass.log(Status.INFO, "Step #4. Try to go to Global Setting -> Add page again");
//        dashboardPage.goToAddPage();
//
//        logClass.log(Status.INFO, "Step #5. Observe the current page->User cannot go to Global Setting -> Add page while \"New Page\" dialog appears.\n");
//        DriverUtils.verifyExpectedAndActualResults(logClass, dashboardPage.isDialogDisplayed(),"Add Page");
//    }
//}