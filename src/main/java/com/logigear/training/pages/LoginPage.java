package com.logigear.training.pages;

import com.logigear.training.utilities.control.LGAlert;
import com.logigear.training.utilities.control.LGButton;
import com.logigear.training.utilities.control.LGSelect;
import com.logigear.training.utilities.control.LGTextBox;
import org.openqa.selenium.By;

public class LoginPage {
    LGSelect cbbRepository = new LGSelect(By.id("repository"));
    LGTextBox txtUsername = new LGTextBox(By.id("username"));
    LGTextBox txtPassword = new LGTextBox(By.id("password"));
    LGButton btnLogin = new LGButton(By.className("btn-login"));
    LGAlert alert = new LGAlert();

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
        txtUsername.clearField();
        this.setTxtUsername(username);
        txtPassword.clearField();
        this.setTxtPassword(password);
        this.clickLogin();
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
