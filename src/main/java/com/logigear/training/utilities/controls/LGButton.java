package com.logigear.training.utilities.controls;

import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LGButton {
    WebElement runtimeElement;
    By locator;
    WebDriver driver;

    public LGButton(By locator) {
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = driver.findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void click() {
        this.getRuntimeElement().click();
    }

    public void clickElementAtPoint() {
        Actions action = new Actions(DriverUtils.getDriver());
        action.moveByOffset(1144,612).perform();
        action.click();
    }
}
