package com.logigear.training.utilities.controls;

import com.logigear.training.common.Constants;
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
            this.runtimeElement = Constants.DRIVER.findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void click() {
        this.getRuntimeElement().click();
    }

    public void clickElementAtPoint() {
        Actions action = new Actions(Constants.DRIVER);
        action.moveByOffset(1144,612).perform();
        action.click();
    }
}
