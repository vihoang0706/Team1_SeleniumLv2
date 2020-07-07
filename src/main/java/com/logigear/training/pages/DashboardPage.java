package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.controls.LGLabel;
import com.logigear.training.utilities.controls.LGLink;
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
    public LGLabel lblGlobalSetting = new LGLabel(By.xpath("//li[@class='mn-setting']/a"));
    LGLabel lblTitle = new LGLabel(By.xpath("//h2[.='New Page']"));
    LGAlert alert = new LGAlert();

    protected WebElement getSubMenu(String tabName) {
        return DriverUtils.getDriver().findElement(By.xpath(String.format(lblSubMenu, tabName)));
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

    public void goToAddPage() {
        try {
            lblGlobalSetting.click();
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

    public boolean isPositionOfThisPageNextAnotherPage(String namePage, String anotherPage) {
        List<WebElement> links = DriverUtils.getDriver().findElements(By.xpath("//div[@id=\"main-menu\"]//li/a[contains(@href, \"/TADashboard\")]"));
        System.out.println(links.size());
        boolean check = false;
        for (int i=0; i<links.size();i++) {
            if (links.get(i).getText().equalsIgnoreCase(namePage)) {
                int nextPage = i+1;
                if (links.get(nextPage).getText().equalsIgnoreCase(anotherPage)) {
                    System.out.println("Section " + i + ":" + links.get(i+1).getText());
                    check = true;
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
        getPage(pageId).click();

    }

    public void deletePage(String pageId) {
        clickOnPage(pageId);
        lblGlobalSetting.click();
        DriverUtils.waitForControl(this.getSubMenu("Delete"));
        this.getSubMenu("Delete").click();
        alert.waitForAlertPresent();
        alert.acceptAlert();
    }

    public void deleteChildPage(String parentPage, String childPage) {
        clickOnPage(parentPage);
        clickOnPage(childPage);
        lblGlobalSetting.click();
        waitForControl(this.getSubMenu("Delete"));
        this.getSubMenu("Delete").click();
        alert.waitForAlertPresent();
        alert.acceptAlert();
    }

    protected WebElement getPage(String pageId) {
        String lnkPage = "a[href='/TADashboard/"+pageId+".page']";
        return getDriver().findElement(By.cssSelector(String.format(lnkPage, pageId)));
    }

    public boolean isPageDisplayed(String pageName) {
        boolean result = false;
        if (getPageName(pageName).isDisplayed()) {
            result = true;
        }
        return result;
    }

    public boolean isChildPageDisplayed(String parentPage, String childPage) {
        boolean result = false;
        hoverOnElement(getPage(parentPage));
        if (getPage(childPage).isDisplayed()) {
            result = true;
        }
        return result;
    }
}