package com.logigear.tranining.user.management;

import com.logigear.training.common.GlobalVariables;
import com.logigear.training.common.TestBase;
import com.logigear.training.page.HomePage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001_LoginPage_VerifyLoginSuccessfullyWithSpecificRepository extends TestBase {
    LoginPage loginPage = new LoginPage();
    HomePage homepage = new HomePage();
    @Test
    public void TC_001() {

        //Login to SampleRepository
        loginPage.login(GlobalVariables.VALID_USERNAME, GlobalVariables.VALID_PASSWORD);

        //Verify that user login to SampleRepository successfully
        Assert.assertEquals(homepage.getWelcomeAccount(), GlobalVariables.VALID_USERNAME);
        Assert.assertEquals(homepage.getRepository(), GlobalVariables.SAMPLE_REPOSITORY);
    }
}
