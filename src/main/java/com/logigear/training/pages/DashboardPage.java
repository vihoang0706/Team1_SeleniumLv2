package com.logigear.training.pages;

import com.logigear.training.driverManagement.DriverManager;
import com.logigear.training.utilities.control.LGLabel;
import com.logigear.training.utilities.control.LGLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    LGLink lnkLogout = new LGLink(By.xpath("//a[.='Logout']"));
    LGLabel lblWelcomeAccount = new LGLabel(By.xpath("//a[@href='#Welcome']"));
    LGLabel lblRepository = new LGLabel(By.xpath("//a[@href='#Repository']/span"));
    LGLabel  lblSubMenu = new LGLabel(By.xpath("//a[contains(text(),'%s')]"));

    protected WebElement getSubMenu(String tabName) {
        return lblSubMenu.formatDynamicLocator(tabName);
    }

    public String getRepository() {
        return lblRepository.getText();
    }

    public void logout() {
        lblWelcomeAccount.click();
        lnkLogout.click();
    }

    public String getWelcomeAccount() {
        String username = lblWelcomeAccount.getText();
        return username;
    }

    public void switchRepository(String repo){
        this.getSubMenu("Repository").click();
        DriverManager.getWebDriver().findElement(By.partialLinkText(repo)).click();
    }
}
