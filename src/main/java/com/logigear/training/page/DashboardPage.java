package com.logigear.training.page;

import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {
    private By lnkLogout = By.xpath("//a[.='Logout']");
    private By lblWelcomeAccount = By.xpath("//a[@href='#Welcome']");
    private final By lblRepository = By.xpath("//a[@href='#Repository']/span");
    private final String lblSubMenu = "//a[contains(text(),'%s')]";


    protected WebElement getLblRepository() {
        return DriverManager.getWebDriver().findElement(lblRepository);
    }

    protected WebElement getSubMenu(String tabName) {
        return DriverManager.getWebDriver().findElement(By.xpath(String.format(lblSubMenu, tabName)));
    }

    public String getRepository() {
        return this.getLblRepository().getText();
    }

    public void logout() {
        DriverManager.getWebDriver().findElement(lblWelcomeAccount).click();
        DriverManager.getWebDriver().findElement(lnkLogout).click();
    }

    public String getWelcomeAccount() {
        String username = DriverManager.getWebDriver().findElement(lblWelcomeAccount).getText();
        return username;
    }

    public void switchRepository(String repo){
        this.getSubMenu("Repository").click();
        DriverManager.getWebDriver().findElement(By.partialLinkText(repo)).click();


    }
}
