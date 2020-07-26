package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.model.PageInfo;
import com.logigear.training.utilities.DriverUtils;
import com.logigear.training.utilities.controls.*;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AddPageForm extends BasePage {
    final LGTextBox txtPageName = new LGTextBox(By.xpath("//input[@id='name']"));

    final LGSelect ddlParentPage = new LGSelect(By.xpath("//select[@id='parent']"));

    final LGSelect ddlNumberColumn = new LGSelect(By.xpath("//select[@id='columnnumber']"));

    final LGSelect ddlDisplayAfter = new LGSelect(By.xpath("//select [@id='afterpage']"));

    final LGButton btnOK = new LGButton(By.xpath("//input[@id='OK']"));

    final LGButton btnCancel = new LGButton(By.xpath("//input[@id='Cancel']"));

    final LGCheckbox chbIsPublic = new LGCheckbox(By.id("ispublic"));

    @FindBy(xpath = "//input[@id='ispublic']")
    public WebElement chkPublic;

    public void checkAddPageModalDisplay(ExtentTest logTest) throws IOException {
        try {
            checkControlExist(logTest, chkPublic, "Public checkbox shows");
            checkControlExist(logTest,btnOK.getRuntimeElement(), "Button OK shows");
        } catch (Exception e) {
        }
    }

    public void enterNewPageInfo(PageInfo newPage) throws IOException {
        try {
            WebDriverWaitUtils.waitForPageLoaded();
            if (newPage.pageName != null) {
                WebDriverWaitUtils.waitForControl(chkPublic);
                txtPageName.clearField();
                txtPageName.enter(newPage.pageName);
            }

            if (newPage.parentPage != null) {
                ddlParentPage.select(newPage.parentPage);
            }

            if (newPage.columnNumber != null) {
                ddlNumberColumn.select(newPage.columnNumber);
            }

            if (newPage.position != null) {
                ddlDisplayAfter.select(newPage.position);
            }
            if (newPage.isPublic==true) {
                chkPublic.isSelected();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void submitPageInformation(PageInfo newPage) throws IOException {
        this.enterNewPageInfo(newPage);
        this.clickButton("ok");
    }


    public void checkOnIsPublicCheckbox() {
        chbIsPublic.check();
    }

    public void clickButton(String buttonName){
        buttonName = buttonName.toLowerCase();
        if (buttonName.equals("ok")) {
            WebDriverWaitUtils.waitForControlToBeClickable(btnOK.getRuntimeElement());
            btnOK.click();
        } else if (buttonName.equals("cancel")){
            WebDriverWaitUtils.waitForControlToBeClickable(btnCancel.getRuntimeElement());
            btnCancel.click();
        }

    }
}

