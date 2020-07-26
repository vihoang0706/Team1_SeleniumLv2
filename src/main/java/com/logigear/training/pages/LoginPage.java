package com.logigear.training.pages;

import com.logigear.training.utilities.controls.LGAlert;
import com.logigear.training.utilities.controls.LGButton;
import com.logigear.training.utilities.controls.LGSelect;
import com.logigear.training.utilities.controls.LGTextBox;
import com.logigear.training.utilities.webdrivers.WebDriverWaitUtils;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    final LGSelect cbbRepository = new LGSelect(By.id("repository"));

    final LGTextBox txtUsername = new LGTextBox(By.id("username"));

    final LGTextBox txtPassword = new LGTextBox(By.id("password"));

    final LGButton btnLogin = new LGButton(By.className("btn-login"));

    final LGAlert alert = new LGAlert();

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

    public void login(String username, String password) {
        WebDriverWaitUtils.waitForControl(txtUsername.getRuntimeElement());
        txtUsername.clearField();
        this.setTxtUsername(username);
        txtPassword.clearField();
        this.setTxtPassword(password);
        this.clickLogin();
        WebDriverWaitUtils.waitForPageLoaded();
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