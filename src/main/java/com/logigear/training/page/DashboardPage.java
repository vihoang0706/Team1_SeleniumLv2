package com.logigear.training.page;

import com.logigear.training.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {
    private By lnkLogout = By.xpath("//a[.='Logout']");
    private By lblWelcomeAccount = By.xpath("//a[@href='#Welcome']");
    private final By lblRepository = By.xpath("//a[@href='#Repository']/span");
    private final String lblSubMenu = "//a[contains(text(),'%s')]";


    protected WebElement getLblRepository() {
        return Utility.getDriver().findElement(lblRepository);
    }

    protected WebElement getSubMenu(String tabName) {
        return Utility.getDriver().findElement(By.xpath(String.format(lblSubMenu, tabName)));
    }

    public String getRepository() {
        return this.getLblRepository().getText();
    }

    public void logout() {
        Utility.getDriver().findElement(lblWelcomeAccount).click();
        Utility.getDriver().findElement(lnkLogout).click();
    }

    public String getWelcomeAccount() {
        String username = Utility.getDriver().findElement(lblWelcomeAccount).getText();
        return username;
    }

    public void switchRepository(String repo){
        this.getSubMenu("Repository").click();
        Utility.getDriver().findElement(By.partialLinkText(repo)).click();


    }
}
