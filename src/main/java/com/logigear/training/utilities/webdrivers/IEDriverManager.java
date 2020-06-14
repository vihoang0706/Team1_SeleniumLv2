package com.logigear.training.utilities.webdrivers;

import com.logigear.training.common.Constants;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import static com.logigear.training.common.Constants.GECKO_DRIVER_LOCATION;

public class IEDriverManager extends DriverManager{
    @Override
    protected void createWebDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_LOCATION);
        this.driver = new InternetExplorerDriver(options);
    }
}
