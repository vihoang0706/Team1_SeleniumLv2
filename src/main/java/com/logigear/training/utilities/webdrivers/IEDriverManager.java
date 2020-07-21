package com.logigear.training.utilities.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager {
    @Override
    protected void initialDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        WebDriverManager.iedriver().setup();
        this.driver = new InternetExplorerDriver(options);
    }
}