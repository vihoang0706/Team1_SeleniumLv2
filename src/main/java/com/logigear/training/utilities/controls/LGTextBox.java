package com.logigear.training.utilities.controls;

import com.logigear.training.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LGTextBox extends BasePage {
    WebElement runtimeElement;
    By locator;
    WebDriver driver;

    public LGTextBox(WebDriver driver, By locator) {
        super(driver);
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = driver.findElement(this.locator);
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
