package com.logigear.training.utilities.controls;

import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LGSelect {
    WebElement runtimeElement;
    By locator;

    public LGSelect(By locator) {
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = DriverUtils.getDriver().findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void select(String value) {
        Select dropdown = new Select(this.getRuntimeElement());
        dropdown.selectByVisibleText(value);
    }
}
