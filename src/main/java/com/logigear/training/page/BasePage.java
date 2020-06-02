package com.logigear.training.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.logigear.training.driverManagement.DriverManager;

public class BasePage {
    private final By _lblWelcomeAccount = By.xpath("//a[@href='#Welcome']");
    private final By _lblRepository = By.xpath("//a[@href='#Repository']/span");
    private final String _lblSubMenu = "//a[contains(text(),'%s')]";

    protected WebElement getLblWelcomeAccount() {
        return DriverManager.getWebDriver().findElement(_lblWelcomeAccount);
    }

    public String getWelcomeAccount() {
        return this.getLblWelcomeAccount().getText();
    }

    protected WebElement getLblRepository() {
        return DriverManager.getWebDriver().findElement(_lblRepository);
    }

    public String getRepository() {
        return this.getLblRepository().getText();
    }

    protected WebElement getSubMenu(String tabName) {
        return DriverManager.getWebDriver().findElement(By.xpath(String.format(_lblSubMenu, tabName)));
    }

    public HomePage logout() {
        this.getLblWelcomeAccount().click();
        this.getSubMenu("Logout").click();
        return new HomePage();
    }
}