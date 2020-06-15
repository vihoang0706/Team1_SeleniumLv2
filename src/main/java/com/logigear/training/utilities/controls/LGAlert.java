package com.logigear.training.utilities.controls;

import com.logigear.training.common.Constants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LGAlert {
    public  void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(Constants.DRIVER, Constants.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        Alert alert = Constants.DRIVER.switchTo().alert();
        alert.accept();
    }

    public String getText() {
        Alert alert = Constants.DRIVER.switchTo().alert();
        String text = alert.getText();
        return text;
    }
}
