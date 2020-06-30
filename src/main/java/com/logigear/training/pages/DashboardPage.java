package com.logigear.training.pages;

import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGLabel;
import com.logigear.training.utilities.controls.LGLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends DriverUtils {

    LGLink lnkLogout = new LGLink(By.xpath("//a[.='Logout']"));
    LGLabel lblWelcomeAccount = new LGLabel(By.xpath("//a[@href='#Welcome']"));
    LGLabel lblRepository = new LGLabel(By.xpath("//a[@href='#Repository']/span"));
    LGLink lblSubMenu = new LGLink(By.xpath("//a[contains(text(),'%s')]"));
    LGLink lblGlobalSetting = new LGLink(By.xpath("//li[@class='mn-setting']"));
    private String subMenuLink = "//a[contains(text(),'%s')]";

    private WebElement getSubMenu(String tabName) {
        return DriverUtils.getDriver().findElement(By.xpath((String.format(subMenuLink, tabName))));
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
        DriverUtils.getDriver().findElement(By.partialLinkText(repo)).click();
    }

    public void goToAddPage() {
        lblGlobalSetting.click();
        this.getSubMenu("Add Page").click();
    }
}