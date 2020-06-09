package com.logigear.training.common;

import com.logigear.training.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
    public static void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(Utility.getDriver(), Constants.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void acceptAlert() {
        Alert alert = Utility.getDriver().switchTo().alert();
        alert.accept();
    }

    public static void clearField(By by) {
        Utility.getDriver().findElement(by).clear();
    }

}
