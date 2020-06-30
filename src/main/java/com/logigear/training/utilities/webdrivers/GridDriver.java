package com.logigear.training.utilities.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.DriverUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

public class GridDriver extends DriverUtils {
    public RemoteWebDriver webDriver = null;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    public synchronized RemoteWebDriver initialDriver(String browser, ExtentTest logTest) throws IOException {
        if(browser.equals("chrome")){
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
            webDriver=new RemoteWebDriver(new URL("http://localhost:4444/grid/console"), capabilities);
        }else{
            capabilities=DesiredCapabilities.internetExplorer();
            capabilities.setBrowserName("iexplore");
            capabilities.setPlatform(Platform.WINDOWS);
        }
        return webDriver;
    }
}