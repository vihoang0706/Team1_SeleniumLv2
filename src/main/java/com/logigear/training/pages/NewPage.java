package com.logigear.training.pages;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.controls.LGButton;
import com.logigear.training.utilities.controls.LGLink;
import com.logigear.training.utilities.controls.LGSelect;
import com.logigear.training.utilities.controls.LGTextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static com.logigear.training.utilities.DriverUtils.waitForPageLoaded;

public class NewPage {

    LGTextBox txtPageName = new LGTextBox(By.xpath("//input[@id='name']"));
    LGSelect ddlParentPage = new LGSelect(By.xpath("//select[@id='parent']"));
    LGSelect ddlNumberColumn = new LGSelect(By.xpath("//select[@id='columnnumber']"));
    LGSelect ddlDisplayAfter = new LGSelect(By.xpath("//select [@id='afterpage']"));
    LGButton btnOK = new LGButton(By.xpath("//input[@id='OK']"));
    LGButton btnCancel = new LGButton(By.xpath("//input[@id='Cancel']"));
    @FindBy(xpath = "//input[@id='ispublic']")
    public WebElement chkPublic;

    public void enterNewPageInfo(String pagename, String parentOption, String columnOption, String displayAfterOption, Boolean publicOption) throws IOException {
        try {
            waitForPageLoaded();
            if (pagename != null) {
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



    public void clickButton(String buttonName){

        buttonName = buttonName.toLowerCase();
        switch (buttonName) {
            case "ok":
                btnOK.click();

            case "cancel":
                btnCancel.click();
        }

    }


}
