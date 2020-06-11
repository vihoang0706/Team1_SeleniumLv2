package com.logigear.training.utilities.controls;

import com.logigear.training.utilities.DriverUtils;
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
            this.runtimeElement = DriverUtils.getDriver().findElement(this.locator);
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
