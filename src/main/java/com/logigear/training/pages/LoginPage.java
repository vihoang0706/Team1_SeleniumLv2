package com.logigear.training.pages;

import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.controls.LGButton;
import com.logigear.training.utilities.controls.LGSelect;
import com.logigear.training.utilities.controls.LGTextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    final LGSelect cbbRepository = new LGSelect(By.id("repository"));
    final LGTextBox txtUsername = new LGTextBox(getDriver(),By.id("username"));
    final LGTextBox txtPassword = new LGTextBox(getDriver(), By.id("password"));
    final LGButton btnLogin = new LGButton(By.className("btn-login"));
    final LGAlert alert = new LGAlert();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setTxtUsername(String username) {
        txtUsername.enter(username);
    }

    public void setTxtPassword(String password) {
        txtPassword.enter(password);
    }

    public void setCbbRepository(String repository){
        cbbRepository.select(repository);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public LoginPage login(String username, String password) {
//        txtUsername.clearField();
        this.setTxtUsername(username);
//        txtPassword.clearField();
        this.setTxtPassword(password);
        this.clickLogin();
        return new LoginPage(super.getDriver());
    }

    public void selectRepository (String repository) {
        this.setCbbRepository(repository);
    }

    public String getErrorMessage() {
        alert.waitForAlertPresent(); // Wait for Alert present
        String errorMessage = alert.getText();
        return errorMessage;
    }
}