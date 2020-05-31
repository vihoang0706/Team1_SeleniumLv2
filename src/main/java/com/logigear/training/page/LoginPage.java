package com.logigear.training.page;

import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class LoginPage {
    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.className("btn-login");

    public void setTxtUsername(String username) {
        DriverManager.getWebDriver().findElement(txtUsername).sendKeys(username);
    }

    public void setTxtPassword(String password) {
        DriverManager.getWebDriver().findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        DriverManager.getWebDriver().findElement(btnLogin).click();
    }

    public void login(String username, String password) {
        this.setTxtUsername(username);
        this.setTxtPassword(password);
        this.clickLogin();
    }
    public String getErrorMessage() {
        Alert alert = DriverManager.getWebDriver().switchTo().alert();
        String errorMessage = alert.getText();
        return errorMessage;
    }
}
