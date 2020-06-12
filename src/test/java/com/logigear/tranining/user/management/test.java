package com.logigear.tranining.user.management;

//import com.common.CommonMethods;
//import com.common.TestBase;
import com.logigear.training.common.TestBase;
//import com.pages.buyer_center.BuyerCenterCheckOutPage;
//import com.pages.buyer_center.BuyerCenterHomePage;
//import com.pages.buyer_center.BuyerCenterProductLandingPage;
//import com.utility.Utility;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

import static com.logigear.training.common.GlobalVariables.*;

public class test extends TestBase {
    //private BuyerCenterHomePage buyerCenterHomePage = null;

    @Test(dataProvider = "getDataForTest", priority = 1, description = "Responsive Checkout Page | Page title and Header")
    public void TC01(Hashtable<String, String> data) throws IOException {
        if (isTestCaseExecutable && isTestDataExecutable(data, logMethod)) {
            try {
                logStep = logStepInfo(logMethod, "Step #1. Go to Checkout page for");
                navigateToTestSite(logMethod, AUT);


            } catch (Exception e) {
                log4j.error(getStackTrade(e.getStackTrace()));
                logException(logMethod, testCaseName, e);
            }
        }
    }
}
