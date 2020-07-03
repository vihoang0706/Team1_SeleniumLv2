package com.logigear.training.utilities.controls;

import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LGCheckbox {
    WebElement runtimeElement;
    By locator;

    public LGCheckbox(By locator) {
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = DriverUtils.getDriver().findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void check() {
        if (!this.getRuntimeElement().isSelected()) {
            this.getRuntimeElement().click();
        }
    }

    public  void uncheck() {
        if (this.getRuntimeElement().isSelected()) {
            this.getRuntimeElement().click();
        }
    }
}
