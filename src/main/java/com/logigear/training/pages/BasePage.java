package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.ExtentTestReport;
import org.openqa.selenium.By;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class BasePage {
    /**
     * @Action: isElementClickable
     * @param elementName
     * @throws IOException
     * */

    public static boolean isElementClickable(By elementName, int waitTime) throws IOException {
        try {
            new WebDriverWait(DriverUtils.getDriver(), waitTime).until(ExpectedConditions.invisibilityOfElementLocated(elementName));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void checkControlExist(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            WebDriverWaitUtils.waitForControl(elementName);
            if (!doesControlExist(elementName)) ExtentTestReport.logFail(logTest, objectName + " does not exist.");
            else ExtentTestReport.logPass(logTest, objectName + " exists.");
        } catch (Exception e) {

        }
    }

    public static boolean doesControlExist(WebElement control){
        try {
            return control.isSelected();

        } catch (Exception e) {
            return false;
        }
    }

    public static void refreshPage() {
        try {
            DriverUtils.getDriver().navigate().refresh();
            WebDriverWaitUtils.waitForPageLoaded();
        } catch (Exception e) {
        }
    }
}
