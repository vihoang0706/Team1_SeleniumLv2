package com.logigear.training.utilities.controls;

import com.logigear.training.common.Constants;
import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LGLink {
    WebElement runtimeElement;
    By locator;

    public LGLink(By locator) {
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
}
