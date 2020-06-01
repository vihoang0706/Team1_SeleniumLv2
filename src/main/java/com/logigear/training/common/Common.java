package com.logigear.training.common;

import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
    public static void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), GlobalVariables.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void acceptAlert() {
        Alert alert = DriverManager.getWebDriver().switchTo().alert();
        alert.accept();
    }
}
