package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.controls.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AddPageForm extends BasePage {
    final LGTextBox txtPageName = new LGTextBox(getDriver(),By.xpath("//input[@id='name']"));
    final LGSelect ddlParentPage = new LGSelect(By.xpath("//select[@id='parent']"));
    final LGSelect ddlNumberColumn = new LGSelect(By.xpath("//select[@id='columnnumber']"));
    final LGSelect ddlDisplayAfter = new LGSelect(By.xpath("//select [@id='afterpage']"));
    final LGButton btnOK = new LGButton(By.xpath("//input[@id='OK']"));
    final LGButton btnCancel = new LGButton(By.xpath("//input[@id='Cancel']"));
    final LGCheckbox chbIsPublic = new LGCheckbox(By.id("ispublic"));
    @FindBy(xpath = "//input[@id='ispublic']")
    public WebElement chkPublic;

    public AddPageForm(WebDriver driver) {
        super(driver);
    }

    public void checkAddPageModalDisplay(ExtentTest logTest) throws IOException {
        try {
            checkControlExist(logTest, chkPublic, "Public checkbox shows");
            checkControlExist(logTest,btnOK.getRuntimeElement(), "Button OK shows");
        } catch (Exception e) {
        }
    }

    public void enterNewPageInfo(String pagename, String parentOption, String columnOption, String displayAfterOption, Boolean publicOption) throws IOException {
        try {
            waitForPageLoaded();
            if (pagename != null) {
                waitForControl(chkPublic);
                txtPageName.clearField();
                txtPageName.enter(pagename);
            }

            if (parentOption != null) {
                ddlParentPage.select(parentOption);
            }

            if (columnOption != null) {
                ddlNumberColumn.select(columnOption);
            }

            if (displayAfterOption != null) {
                ddlDisplayAfter.select(displayAfterOption);
            }
            if (publicOption.equals("true")) {
                chkPublic.isSelected();
            }
        } catch (Exception e) {
        }
    }

    public void checkOnIsPublicCheckbox() {
        chbIsPublic.check();
    }

    public void clickButton(String buttonName){
        buttonName = buttonName.toLowerCase();
        if (buttonName.equals("ok")) {
            waitForControlToBeClickable(btnOK.getRuntimeElement());
            btnOK.click();
        } else if (buttonName.equals("cancel")){
            waitForControlToBeClickable(btnCancel.getRuntimeElement());
            btnCancel.click();
        }
    }
}

