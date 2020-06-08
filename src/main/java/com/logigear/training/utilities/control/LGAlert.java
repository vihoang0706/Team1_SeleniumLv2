package com.logigear.training.utilities.control;

import com.logigear.training.common.Constants;
import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LGAlert {

    public  void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Constants.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        Alert alert = DriverManager.getWebDriver().switchTo().alert();
        alert.accept();
    }

    public String getText() {
        Alert alert = DriverManager.getWebDriver().switchTo().alert();
        String text = alert.getText();
        return text;
    }
}
