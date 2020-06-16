package com.logigear.training.utilities.controls;

import com.logigear.training.common.Constants;
import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LGLabel {
    WebElement runtimeElement;
    By locator;

    public LGLabel(By locator) {
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = DriverUtils.getDriver().findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public String getText() {
        String getText = this.getRuntimeElement().getText();
        return getText;
    }

    public void click() {
        this.getRuntimeElement().click();
    }

    public void waitForElementVisible() {
        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Constants.WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public WebElement formatDynamicLocator(String tabName) {
        return DriverUtils.getDriver().findElement(By.xpath(String.format(tabName, this.locator)));
    }
}
