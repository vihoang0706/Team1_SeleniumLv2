package com.logigear.training.utilities;

import com.relevantcodes.extentreports.ExtentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader extends DriverUtils {
    private Properties prop = null;

    //Constructor for ConfigFileReader class
    public ConfigFileReader(String path, ExtentTest logTestForTestBase) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
        }
    }

    public ConfigFileReader(String path) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            //log4j.error("ConfigFileReader method - ERROR - " + e);
        }
    }

    public String getDataFromConfigurationFile(String configParameter) {
        String configValue = null;
        try {
            configValue = prop.getProperty(configParameter).trim();

        } catch (Exception e) {
            //log4j.error("getDataFromConfigurationFile method - ERROR - " + e);
        }
        return configValue;
    }
}

