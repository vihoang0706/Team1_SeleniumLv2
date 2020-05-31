package com.logigear.training.page;

import com.logigear.training.common.GlobalVariables;
import org.openqa.selenium.By;
import com.logigear.training.driverManagement.DriverManager;

public class LoginPage extends BasePage{
    private final By _cbbRepository = By.id("repository");
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.className("btn-login");

    public void setCbbRepository(String repository){
        DriverManager.getWebDriver().findElement(_cbbRepository).sendKeys(repository);
    }

    public void setTxtUsername(String username) {
        DriverManager.getWebDriver().findElement(_txtUsername).sendKeys(username);
    }

    public void setTxtPassword(String password) {
        DriverManager.getWebDriver().findElement(_txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        DriverManager.getWebDriver().findElement(_btnLogin).click();
    }

    public void login(String repository, String username, String password) {
        this.setCbbRepository(repository);
        this.setTxtUsername(username);
        this.setTxtPassword(password);
        this.clickLogin();
    }
}
