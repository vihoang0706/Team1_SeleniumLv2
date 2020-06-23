package com.logigear.training.utilities.controls;

import com.logigear.training.common.Constants;
import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LGAlert {
    public void waitForAlertPresent() {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Constants.WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        Alert alert = DriverUtils.getDriver().switchTo().alert();
        alert.accept();
    }

    public String getText() {
        Alert alert = DriverUtils.getDriver().switchTo().alert();
        String text = alert.getText();
        return text;
    }

    public boolean isAlertPresent()
    {
        try
        {
            DriverUtils.getDriver().switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }
}

