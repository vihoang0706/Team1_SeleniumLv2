package com.logigear.training.pages;

import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DashboardPage {

    LGLink lnkLogout = new LGLink(By.xpath("//a[.='Logout']"));
    LGLabel lblWelcomeAccount = new LGLabel(By.xpath("//a[@href='#Welcome']"));
    LGLabel lblRepository = new LGLabel(By.xpath("//a[@href='#Repository']/span"));
    private String lblSubMenu = "//a[contains(text(),'%s')]";
    LGLabel lblGlobalSetting = new LGLabel(By.xpath("//li[@class='mn-setting']/a"));
    LGTextBox txtPageName = new LGTextBox(By.id("name"));
    LGButton btnOk = new LGButton(By.id("OK"));
    LGSelect cbbDisplayAfter = new LGSelect(By.xpath("//select[@id='afterpage']/option[contains(text(),'%s')]"));

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
        this.getSubMenu("Add Page").click();
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

    public void selectDisplayAfter(String pageName) {
       cbbDisplayAfter.select(pageName);
    }

    public void checkPositionOfPage(String namePage, String anotherPage) {
        List<WebElement> links = DriverUtils.getDriver().findElements(By.xpath("//div[@id=\"main-menu\"]//li/a[contains(@href, \"/TADashboard\")]"));
        System.out.println(links.size());
        int i=0;
        for(WebElement element:links){
            if(element.getText().equalsIgnoreCase(namePage)) {
                System.out.println("Section "+i+":"+element.getText());
                Assert.assertEquals(links.get(i+1).getText(),anotherPage);
                break;
            }
            i++;
        }
    }

    public String getIdPage() {
        String url = DriverUtils.getDriver().getCurrentUrl();
        String partUrl1[] = url.split("TADashboard/");
        String partUrl2[] = partUrl1[1].split(".page");
        return partUrl2[0];
    }

    public void deletePage(String Page) {

    }
}