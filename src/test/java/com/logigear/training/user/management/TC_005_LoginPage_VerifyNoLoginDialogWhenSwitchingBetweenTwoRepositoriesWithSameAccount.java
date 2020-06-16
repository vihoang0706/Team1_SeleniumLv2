package com.logigear.training.user.management;

import com.aventstack.extentreports.Status;
import com.logigear.training.common.Constants;
import com.logigear.training.pages.DashboardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.base.TestBase;
import com.logigear.training.utilities.DriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005_LoginPage_VerifyNoLoginDialogWhenSwitchingBetweenTwoRepositoriesWithSameAccount extends TestBase {
    public LoginPage loginPage = new LoginPage();
    public DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void DA_LOGIN_TC005() {
        logClass.log(Status.INFO, "Navigate to Dashboard login page" + Constants.AUT);
        navigateToTestSite(Constants.AUT);
        DriverUtils.waitForPageLoaded();
        //Variables
        String repo = "SampleRepositoryLV2";

        //Main Steps
        System.out.println("Login with valid account for the first repository");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

        DriverUtils.waitForPageLoaded();
        System.out.println("Choose another repository in Repository list");
        dashboardPage.switchRepository(repo);

        System.out.println("Observe the current page: There is no Login Repository dialog");
        System.out.println("Observe the current page: The Repository menu displays name of switched repository");
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        Assert.assertEquals(dashboardPage.getRepository(), Constants.SAMPLE_REPOSITORY_LV2);
    }
}
