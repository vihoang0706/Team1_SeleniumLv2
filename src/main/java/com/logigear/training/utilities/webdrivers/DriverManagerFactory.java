package com.logigear.training.utilities.webdrivers;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String type) {
        DriverManager driverManager;
        if ("CHROME".equals(type)) {
            driverManager = new ChromeDriverManager();
        } else if ("FIREFOX".equals(type)) {
            driverManager = new FireFoxDriverManager();
        } else {
            driverManager = new IEDriverManager();
        }
        return driverManager;
    }
}
