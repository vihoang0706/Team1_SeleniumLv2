package com.logigear.training.utilities.webdrivers;

import com.logigear.training.common.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.logigear.training.common.Constants.CHROME_DRIVER_LOCATION;
import static com.logigear.training.common.Constants.GECKO_DRIVER_LOCATION;

public class DriverManagerFactory {
    public RemoteWebDriver webDriver;
    public synchronized RemoteWebDriver createInstance(String browsername) {
        if(browsername.equalsIgnoreCase("chrome")) {
            System.out.println("You have selected " + browsername);
            ChromeOptions options = new ChromeOptions();
            // set your browser-specific options here
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
            this.webDriver = new ChromeDriver(options);
        } else if(browsername.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_LOCATION);
            this.webDriver = new FirefoxDriver(options);
        } else if(browsername.equalsIgnoreCase("ie")) {
            System.out.println("You have selected " + browsername);
            InternetExplorerOptions options = new InternetExplorerOptions();
            System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_LOCATION);
            this.webDriver = new InternetExplorerDriver(options);
        } else {
            System.out.println("You have not selected chrome");
        }
        return webDriver;
    }
}
