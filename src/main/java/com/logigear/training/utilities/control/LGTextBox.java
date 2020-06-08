package com.logigear.training.utilities.control;

import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LGTextBox {
    WebElement runtimeElement;
    By locator;

    public LGTextBox(By locator) {
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = DriverManager.getWebDriver().findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void enter(String content) {
        this.getRuntimeElement().sendKeys(content);
    }

    public void clearField() {
        this.getRuntimeElement().clear();
    }
}
