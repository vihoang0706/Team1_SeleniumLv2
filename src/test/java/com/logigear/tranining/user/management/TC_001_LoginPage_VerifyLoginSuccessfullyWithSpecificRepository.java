package com.logigear.tranining.user.management;

import com.logigear.training.common.GlobalVariables;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.HomePage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {
    @Test
    public void TC_001() {
        LoginPage loginPage = new LoginPage();

        //Login to SampleRepository
        loginPage.login(GlobalVariables.SAMPLE_REPOSITORY,GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);

        //Verify that user login to SampleRepository successfully
        HomePage homepage = new HomePage();
        Assert.assertEquals(homepage.getWelcomeAccount(), GlobalVariables.VALID_USERNAME);
        Assert.assertEquals(homepage.getRepository(), GlobalVariables.SAMPLE_REPOSITORY_LV2);
    }
}
