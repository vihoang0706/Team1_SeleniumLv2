package com.logigear.training.common;

import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
    public static void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Constants.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void acceptAlert() {
        Alert alert = DriverManager.getWebDriver().switchTo().alert();
        alert.accept();
    }

    public static void clearField(By by) {
        DriverManager.getWebDriver().findElement(by).clear();
    }

}
