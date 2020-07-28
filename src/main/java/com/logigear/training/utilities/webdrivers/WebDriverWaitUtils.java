package com.logigear.training.utilities.webdrivers;

import com.logigear.training.common.Constants;
import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.logigear.training.common.Constants.WAIT_TIME;

public class WebDriverWaitUtils {
    /**
     * @Action name: waitForPageLoaded()
     * @Example: waitForPageLoaded()
     * @Purpose: wait until page is loaded completed
     */
    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 40);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


    /**
     * wait for a specific control in period time
     *
     * @param controlName Example:
     *                    - @FindBy(id='NextButton')
     *                    - WebElement nextButton;
     *
     *
     **/
    public static void waitForControl(WebElement controlName) {
        try {
            new WebDriverWait(DriverUtils.getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception ex) {
        }
    }

    public static void waitForControlToBeClickable(WebElement controlName) {
        new WebDriverWait(DriverUtils.getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        new WebDriverWait(DriverUtils.getDriver(), WAIT_TIME).until(ExpectedConditions.elementToBeClickable(controlName));
    }

    public static void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Constants.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
