package com.logigear.training.page;

import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.By;

public class DashboardPage {
    private By lnkLogout = By.xpath("//a[.='Logout']");
    private By lblWelcomeAccount = By.xpath("//a[@href='#Welcome']");

    public void logout() {
        DriverManager.getWebDriver().findElement(lblWelcomeAccount).click();
        DriverManager.getWebDriver().findElement(lnkLogout).click();
    }

    public String getWelcomeAccount() {
        String username = DriverManager.getWebDriver().findElement(lblWelcomeAccount).getText();
        return username;
    }
}
