package com.logigear.training.pages;

import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DashboardPage {

    LGLink lnkLogout = new LGLink(By.xpath("//a[.='Logout']"));
    LGLabel lblWelcomeAccount = new LGLabel(By.xpath("//a[@href='#Welcome']"));
    LGLabel lblRepository = new LGLabel(By.xpath("//a[@href='#Repository']/span"));
    private String lblSubMenu = "//a[contains(text(),'%s')]";
    LGLabel lblGlobalSetting = new LGLabel(By.xpath("//li[@class='mn-setting']/a"));
    LGAlert alert = new LGAlert();
    protected WebElement getSubMenu(String tabName) {
        return DriverUtils.getDriver().findElement(By.xpath(String.format(lblSubMenu,tabName)));
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
        DriverUtils.waitForControl(this.getSubMenu("Add Page"));
        this.getSubMenu("Add Page").click();
    }

    public void goToAction(String action, String pageId) {
        switch (action) {
            case "Edit":
                clickOnPage(pageId);
                lblGlobalSetting.click();
                this.getSubMenu("Edit").click();
                break;
            case "Delete":
               deletePage(pageId);
                break;
        }
    }

    public boolean isPositionOfThisPageNextAnotherPage(String namePage, String anotherPage) {
        List<WebElement> links = DriverUtils.getDriver().findElements(By.xpath("//div[@id=\"main-menu\"]//li/a[contains(@href, \"/TADashboard\")]"));
        System.out.println(links.size());
        boolean check = true;
        for (int i=0; i<links.size();i++) {
            if (links.get(i).getText().equalsIgnoreCase(namePage)) {
                int nextPage = i+1;
                if (links.get(nextPage).getText().equalsIgnoreCase(anotherPage)) {
                    System.out.println("Section " + i + ":" + links.get(i+1).getText());
                    check = true;
                } else {
                    check = false;
                }
            }
        } return check;
    }

    public String getIdPage() {
        String url = DriverUtils.getDriver().getCurrentUrl();
        String partUrl1[] = url.split("TADashboard/");
        String partUrl2[] = partUrl1[1].split(".page");
        System.out.println(partUrl2[0]);
        return partUrl2[0];
    }

    public void clickOnPage(String pageId) {
        String lnkDynamicPage = "//a[@href='/TADashboard/"+pageId+".page']";
        System.out.println(lnkDynamicPage);
        DriverUtils.getDriver().findElement(By.xpath(lnkDynamicPage)).click();

    }

    public void deletePage(String pageId) {
        clickOnPage(pageId);
        lblGlobalSetting.click();
        DriverUtils.waitForControl(this.getSubMenu("Delete"));
        this.getSubMenu("Delete").click();
        alert.waitForAlertPresent();
        alert.acceptAlert();
    }
}