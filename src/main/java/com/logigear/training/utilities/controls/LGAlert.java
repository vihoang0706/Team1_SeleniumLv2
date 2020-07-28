package com.logigear.training.utilities.controls;

import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class LGAlert {

    public void acceptAlert() {
        WebDriverWaitUtils.waitForAlertPresent();
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

