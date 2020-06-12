//package com.logigear.tranining.user.management;
//
//import com.logigear.training.common.Constants;
//import com.logigear.training.common.TestBase;
//import com.logigear.training.pages.DashboardPage;
//import com.logigear.training.pages.LoginPage;
//import com.logigear.training.utilities.Utility;
//import com.logigear.training.utilities.webdrivers.DriverFactory;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//import static com.logigear.training.common.Constants.BROWSER;
//
//public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {
//    LoginPage loginPage = new LoginPage();
//    DashboardPage dashboardPage = new DashboardPage();
//
//    @Test(description = "Responsive Checkout Page | Page title and Header")
//    public void TC_001() throws IOException {
//        if (isTestCaseExecutable = true) {
//            try {
//
//                //Login to SampleRepository
//                loginPage = PageFactory.initElements(Utility.getDriver(), LoginPage.class);
//                loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
//
//                //Verify that user login to SampleRepository successfully
//                Assert.assertEquals(dashboardPage.getWelcomeAccount(), Constants.VALID_USERNAME);
//                Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY);
//            } catch (Exception e) {
//            }
//        }
//    }
//}