//package com.logigear.training.main.page;
//
//import com.aventstack.extentreports.Status;
//import com.logigear.training.common.Constants;
//import com.logigear.training.pages.AddPageForm;
//import com.logigear.training.pages.DashboardPage;
//import com.logigear.training.pages.LoginPage;
//import com.logigear.training.test.base.TestBase;
//import com.logigear.training.utilities.controls.LGAlert;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//
//public class TC_012_MainPage_VerifyThatUserIsAbleToAddAdditionalPagesBesidesOverviewPage extends TestBase {
//
//    public LoginPage loginPage = new LoginPage();
//    public DashboardPage dashboardPage = new DashboardPage();
//    public AddPageForm addPageForm = new AddPageForm();
//
//    @Test(description = "Verify that user is able to add additional pages besides \"Overview\" page successfully")
//    public void DA_MP_TC012() throws IOException {
//
//        String pageName = "hangTest";
//
//        //Main Steps
//        logClass.log(Status.INFO, "Step #1. Navigate to Dashboard login page");
//        navigateToTestSite(Constants.AUT);
//
//        waitForPageLoaded();
//
//        logClass.log(Status.INFO, "Step #2. Login with empty username and password");
//        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
//        loginPage.sleep(5);
//
//        //Wait for page loads completely
//        loginPage.waitForPageLoaded();
//
//        logClass.log(Status.INFO, "Step #3. Go to Global Setting -> Add page");
//        dashboardPage = PageFactory.initElements(getDriver(), DashboardPage.class);
//        dashboardPage.goToAddPage();
//
//        //Wait for page loads completely
//        dashboardPage.waitForPageLoaded();
//
//        logClass.log(Status.INFO, "Step #4. Enter Page Name field ");
//        addPageForm = PageFactory.initElements(getDriver(), AddPageForm.class);
//        addPageForm.checkAddPageModalDisplay(logMethod);
//        addPageForm.enterNewPageInfo(pageName, null, null, null, false);
//
//        logClass.log(Status.INFO, "Step #5. Click OK button");
//        addPageForm.clickButton("OK");
//        addPageForm.waitForPageLoaded();
//
//        DashboardPage dbPage = new DashboardPage();
//        String idPage = dbPage.getIdPage();
//        System.out.println(idPage);
//        logClass.log(Status.INFO, "Step #6. Check \"Test\" page is displayed besides \"Overview\" page");
//
//        boolean isPositionOfThisPageNextAnotherPage = dbPage.isPositionOfThisPageNextAnotherPage(pageName,"Overview");
//        System.out.println(isPositionOfThisPageNextAnotherPage);
//        dbPage.verifyExpectedAndActualResults(logClass,String.valueOf(isPositionOfThisPageNextAnotherPage),"true");
//
//        // Post condition
//        DashboardPage dashboardPage = new DashboardPage();
//        dashboardPage.deletePage(idPage);
//    }
//}
//
