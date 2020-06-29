package com.logigear.training.utilities.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class GridDriver extends DriverUtils {
    public RemoteWebDriver webDriver;

    public synchronized RemoteWebDriver initialDriver(String browser, ExtentTest logTest) throws IOException {
            String ipAddress = "XXX.XXX.XXX.XX";
            /* Firefox */
            webDriver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
            /* Chrome */
            webDriver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
            /* IE */
            webDriver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);

            /* Code Snippet */
            try {
                if (context.getCurrentXmlTest().getParameter("browser").equals("firefox")) {
                    DesiredCapabilities capability = DesiredCapabilities.firefox();
                    webDriver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
                    webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                } else if (context.getCurrentXmlTest().getParameter("browser").equals("chrome")){
                    DesiredCapabilities capability = DesiredCapabilities.chrome();
                    webDriver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
                    webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                } else if (context.getCurrentXmlTest().getParameter("browser").equals("IE")) {
                    DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                    webDriver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
                    webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                }  else {
                    System.out.println("Not able to set Driver object");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return webDriver;
    }
}