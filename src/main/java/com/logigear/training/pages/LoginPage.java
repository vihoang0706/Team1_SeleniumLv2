package com.logigear.training.pages;

import com.logigear.training.common.CommonMethods;
import com.logigear.training.utilities.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private By cbbRepository = By.id("repository");
    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.className("btn-login");

    public void setTxtUsername(String username) {
        Utility.getDriver().findElement(txtUsername).sendKeys(username);
    }

    public void setTxtPassword(String password) {
        Utility.getDriver().findElement(txtPassword).sendKeys(password);
    }

    public void setCbbRepository(String repository){
        Select dropdown = new Select(Utility.getDriver().findElement(cbbRepository));
        dropdown.selectByVisibleText(repository);
    }

    public void clickLogin() {
        Utility.getDriver().findElement(btnLogin).click();
    }

    public void login(String username, String password) {
        //CommonMethods.clearField(txtUsername);
        this.setTxtUsername(username);
        //CommonMethods.clearField(txtPassword);
        this.setTxtPassword(password);
        this.clickLogin();
    }

    public void selectRepository (String repository) {
        this.setCbbRepository(repository);
    }

    public String getErrorMessage() {
        Alert alert = Utility.getDriver().switchTo().alert();
        String errorMessage = alert.getText();
        return errorMessage;
    }

}