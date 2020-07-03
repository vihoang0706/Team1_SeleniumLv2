package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends DriverUtils {
    public ExtentTest logTest;
    LGLink lnkLogout = new LGLink(By.xpath("//a[.='Logout']"));
    LGLabel lblWelcomeAccount = new LGLabel(By.xpath("//a[@href='#Welcome']"));
    LGLabel lblRepository = new LGLabel(By.xpath("//a[@href='#Repository']/span"));
    private String lblSubMenu = "//a[contains(text(),'%s')]";
    public By lblGlobalSetting = By.xpath("//li[@class='mn-setting']/a");
    LGLabel lblTitle = new LGLabel(By.xpath("//h2[.='New Page']"));
    LGTextBox txtPageName = new LGTextBox(By.id("name"));
    LGButton btnOk = new LGButton(By.id("OK"));


    protected WebElement getSubMenu(String tabName) {
        return DriverUtils.getDriver().findElement(By.xpath(String.format(lblSubMenu, tabName)));
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

    public void switchRepository(String repo) {
        this.getSubMenu("Repository").click();
        DriverUtils.getDriver().findElement(By.partialLinkText(repo)).click();
    }

    public void addPage(String pageName) {
        this.setPageName(pageName);
        this.clickOk();
    }

    public void setPageName(String pageName) {
        txtPageName.enter(pageName);
    }

    public void clickOk() {
        btnOk.click();
    }

    public void goToAddPage() {
        try {
            DriverUtils.getDriver().findElement(lblGlobalSetting).click();
            this.getSubMenu("Add Page").click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element is not interacted");
        }
    }

    protected WebElement getPageName(String pageName) {
        return DriverUtils.getDriver().findElement(By.xpath(String.format(lblSubMenu,pageName)));
    }

    public String isDialogDisplayed() {
        String actualTitle = lblTitle.getText();
        return actualTitle;
    }

    public void openNewAddedPage(String namePage) {
        WebElement pageUL = getDriver().findElement(By.xpath("//div[@id='main-menu']//ul"));
        List<WebElement> pagesList = pageUL.findElements(By.tagName("li"));
        for (WebElement li : pagesList) {
            if (li.getText().equals(namePage)){
                li.click();
            }
        }
    }

//    public Boolean checkNewAddedPageShowsAfterOverview(String addedPage) {
//        WebElement pageUL = getDriver().findElement(By.xpath("//div[@id='main-menu']//ul"));
//        List<WebElement> pagesList = pageUL.findElements(By.tagName("li"));
//        if (getDriver().findElement(By.xpath("//div[@id='main-menu']//ul/li")).getText().equals("Overview")) {
//
//        }
//        for (int i = 1; i <= pagesList.size(); i++) {
//            WebElement pageName = getDriver().findElement(By.xpath("//div[@id='main-menu']//ul/li"));
//            if (pageName.getText().equals(addedPage)) {
//                System.out.println(i);
//            }
//
//
//        }
//
//        return true;
//
//    }
    public boolean isPageDisplayed(String pageName) {
        boolean result = false;
        if (getPageName(pageName).isDisplayed()) {
            result = true;
        }
        return result;
    }
}