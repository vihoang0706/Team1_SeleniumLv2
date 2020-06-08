package com.logigear.training.page;

import com.logigear.training.common.CommonMethods;
import com.logigear.training.driverManagement.DriverManager;
import com.logigear.training.utility.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class LoginPage extends Utility{
    public LoginPage() throws IOException {
        switchToWindowHandle();
    }

    private By cbbRepository = By.id("repository");
    //private By txtUsername = By.id("username");
    @FindBy(xpath = "//input[@id = 'username']")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement txtPassword;
    //private By txtPassword = By.id("password");
    private By btnLogin = By.className("btn-login");

    public void setTxtUsername(String username) {
       txtUsername.clear();
       txtUsername.sendKeys(username);

    }

    public void setTxtPassword(String password) {
        //Utility.getDriver().findElement(txtPassword).sendKeys(password);
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void setCbbRepository(String repository){
        Select dropdown = new Select(DriverManager.getWebDriver().findElement(cbbRepository));
        dropdown.selectByVisibleText(repository);
    }

    public void clickLogin() {
        DriverManager.getWebDriver().findElement(btnLogin).click();
    }

    public void login(String username, String password) {
        //Utility.clearField(txtUsername);
        setTxtUsername(username);
        //Utility.clearField(txtPassword);
        setTxtPassword(password);
        clickLogin();
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
