package com.logigear.training.page;

import com.logigear.training.common.Common;
import com.logigear.training.driverManagement.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private By cbbRepository = By.id("repository");
    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.className("btn-login");

    public void setTxtUsername(String username) {
        DriverManager.getWebDriver().findElement(txtUsername).sendKeys(username);
    }

    public void setTxtPassword(String password) {
        DriverManager.getWebDriver().findElement(txtPassword).sendKeys(password);
    }

    public void setCbbRepository(String repository){
        Select dropdown = new Select(DriverManager.getWebDriver().findElement(cbbRepository));
        dropdown.selectByVisibleText(repository);
    }

    public void clickLogin() {
        DriverManager.getWebDriver().findElement(btnLogin).click();
    }

    public void login(String username, String password) {
        Common.clearField(txtUsername);
        this.setTxtUsername(username);
        Common.clearField(txtPassword);
        this.setTxtPassword(password);
        this.clickLogin();
    }

    public void selectRepository (String repository) {
        this.setCbbRepository(repository);
    }

    public String getErrorMessage() {
        Alert alert = DriverManager.getWebDriver().switchTo().alert();
        String errorMessage = alert.getText();
        return errorMessage;
    }

}
