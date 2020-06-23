package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGLabel;
import com.logigear.training.utilities.controls.LGLink;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DashboardPage {
    public ExtentTest logTest;
    LGLink lnkLogout = new LGLink(By.xpath("//a[.='Logout']"));
    LGLabel lblWelcomeAccount = new LGLabel(By.xpath("//a[@href='#Welcome']"));
    LGLabel lblRepository = new LGLabel(By.xpath("//a[@href='#Repository']/span"));
    private String lblSubMenu = "//a[contains(text(),'%s')]";
    public By lblGlobalSetting = By.xpath("//li[@class='mn-setting']/a");
    LGLabel lblTitle = new LGLabel(By.xpath("//h2[.='New Page']"));

    protected WebElement getSubMenu(String tabName) {
        return DriverUtils.getDriver().findElement(By.xpath(String.format(lblSubMenu,tabName)));
    }

    public WebElement getGlobalSetting() {
        return DriverUtils.getDriver().findElement(lblGlobalSetting);
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
        try {
            DriverUtils.getDriver().findElement(lblGlobalSetting).click();
            this.getSubMenu("Add Page").click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element is not interacted");
        }
    }

    public String isDialogDisplayed() {
        String actualTitle = lblTitle.getText();
        return actualTitle;
    }

}