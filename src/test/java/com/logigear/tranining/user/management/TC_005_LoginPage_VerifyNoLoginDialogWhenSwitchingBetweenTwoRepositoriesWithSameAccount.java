package com.logigear.tranining.user.management;

import com.logigear.training.common.Constants;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.DashboardPage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TC_005_LoginPage_VerifyNoLoginDialogWhenSwitchingBetweenTwoRepositoriesWithSameAccount extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void TC_005() {

        //Variables
        String repo = "SampleRepositoryLV2";

        //Main Steps
        System.out.println("Login with valid account for the first repository");
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);

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
