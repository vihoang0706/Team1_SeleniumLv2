package com.logigear.training.pages;

import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.controls.LGLabel;
import com.logigear.training.utilities.controls.LGLink;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage extends BasePage {
    final LGLink lnkLogout = new LGLink(By.xpath("//a[.='Logout']"));

    final LGLabel lblWelcomeAccount = new LGLabel(By.xpath("//a[@href='#Welcome']"));

    final LGLabel lblRepository = new LGLabel(By.xpath("//a[@href='#Repository']/span"));

    final String lblSubMenu = "//a[contains(text(),'%s')]";

    final LGLabel lblGlobalSetting = new LGLabel(By.xpath("//li[@class='mn-setting']/a"));

    final LGLabel lblTitle = new LGLabel(By.xpath("//h2[.='New Page']"));

    final LGAlert alert = new LGAlert();

    protected WebElement getSubMenu(String tabName) {
        return DriverUtils.getDriver().findElement(By.xpath(String.format(lblSubMenu, tabName)));
    }

    public String getRepository() {
        WebDriverWaitUtils.waitForControl(lblRepository.getRuntimeElement());
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
        WebDriverWaitUtils.waitForControl(lblGlobalSetting.getRuntimeElement());
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
        DriverUtils.sleep(5);
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
        DriverUtils.sleep(5);
        clickOnPage(pageId);
        lblGlobalSetting.click();
        WebDriverWaitUtils.waitForControl(this.getSubMenu("Delete"));
        this.getSubMenu("Delete").click();
        alert.waitForAlertPresent();
        alert.acceptAlert();
    }

    public boolean isPageDisplayed(String pageName) {
        boolean result = false;
        if (getPageName(pageName).isDisplayed()) {
            result = true;
        }
        return result;
    }
}