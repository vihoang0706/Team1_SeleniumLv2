package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;

import static com.logigear.training.common.Constants.WAIT_TIME;

public class BasePage {
    private WebDriver driver;
    private String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(url);
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public void waitForControl(WebElement controlName) {
        try {
            new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        } catch (Exception ex) {
        }
    }

    /**
     * @Action name: waitForPageLoaded()
     * @Example: waitForPageLoaded()
     * @Purpose: wait until page is loaded completed
     */
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
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

    /**
     * @Action: checkControlExist
     * @param elementName
     * @param objectName
     * @throws IOException
     * */
    public void checkControlExist(ExtentTest logTest, WebElement elementName, String objectName) throws IOException {
        try {
            waitForControl(elementName);
            if (!doesControlExist(elementName)) DriverUtils.logFail(logTest, objectName + " does not exist.");
            else DriverUtils.logPass(logTest, objectName + " exists.");
        } catch (Exception e) {

        }
    }

    /**
     * @Action: doesControlExist
     * @param control
     * @throws IOException
     * */
    public static boolean doesControlExist(WebElement control){
        try {
            return control.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Action: refreshPage
     * */
    public void refreshPage() {
        try {
            getDriver().navigate().refresh();
            waitForPageLoaded();
        } catch (Exception e) {
        }
    }

    /**
     * @Action: waitForControlToBeClickable
     * @param controlName
     * */
    public void waitForControlToBeClickable(WebElement controlName) {
        new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.visibilityOf(controlName));
        new WebDriverWait(getDriver(), WAIT_TIME).until(ExpectedConditions.elementToBeClickable(controlName));
    }
}
