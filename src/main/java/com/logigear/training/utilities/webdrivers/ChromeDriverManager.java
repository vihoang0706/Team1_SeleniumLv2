package com.logigear.training.utilities.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
    @Override
    protected void initialDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().arch32().version("83.0.4103.14").setup();
        this.driver = new ChromeDriver(chromeOptions);
    }
}