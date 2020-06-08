package com.logigear.training.common;

public class Constants {
    // AUT
    public static final String AUT = "https://d7ec79cacfa4.ngrok.io/TADashboard/login.jsp#Repository";
    public static final int WAIT_TIME = 5;

    // Path
    public static final String CHROME_DRIVER_LOCATION = ".\\src\\main\\resources\\drivers\\chromedriver.exe";

    // Login
    public static final String VALID_USERNAME = "test";
    public static final String VALID_PASSWORD = "TEST";
    public static final String INVALID_PASSWORD = "abc";
    public static final String INVALID_USERNAME = "abc";
    public static final String SAMPLE_REPOSITORY = "SampleRepository";
    public static final String SAMPLE_REPOSITORY_LV2 = "SampleRepositoryLV2";
    public static final String LOWERCASE_PASSWORD = "test";

    // Messages
    public static final String INVALID_USERNAME_OR_PASSWORD_MSG = "Username or password is invalid";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = PROJECT_PATH + "\\src\\main\\resources\\";
    public static final String OUTPUT_PATH = PROJECT_PATH + "/test-output/testReport.html";

}