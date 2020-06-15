package com.logigear.training.utilities.controls;

import com.logigear.training.common.Constants;
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
            this.runtimeElement = Constants.DRIVER.findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void select(String value) {
        Select dropdown = new Select(this.getRuntimeElement());
        dropdown.selectByVisibleText(value);
    }
}
