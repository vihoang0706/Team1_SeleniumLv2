package com.logigear.training.utilities.control;

import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LGButton {
    WebElement runtimeElement;
    By locator;

    public LGButton(By locator) {
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = DriverManager.getWebDriver().findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void click() {
        this.getRuntimeElement().click();
    }

    public void clickElementAtPoint() {
        Actions action = new Actions(DriverManager.getWebDriver());
        action.moveByOffset(1144,612).perform();
        action.click();
    }
}
