package com.logigear.training.common;

public class Constants {
    // AUT
    public static final String AUT = "https://cc0de9b0c966.ngrok.io/TADashboard/login.jsp";

    //Time
    public static final int WAIT_TIME = 7;

    // Driver Path
    public static final String CHROME_DRIVER_LOCATION = ".\\src\\main\\resources\\drivers\\chromedriver.exe";
    public static final String GECKO_DRIVER_LOCATION = ".\\src\\main\\resources\\drivers\\geckodriver.exe";
    public static final String IE_DRIVER_LOCATION = ".\\src\\main\\resources\\drivers\\IEDriverServer.exe";

    // Login information
    public static final String VALID_USERNAME = "test";
    public static final String VALID_PASSWORD = "TEST";
    public static final String INVALID_PASSWORD = "abc";
    public static final String INVALID_USERNAME = "abc";
    public static final String SAMPLE_REPOSITORY = "SampleRepository";
    public static final String SAMPLE_REPOSITORY_LV2 = "SampleRepositoryLV2";
    public static final String LOWERCASE_PASSWORD = "test";

    // Messages
    public static final String INVALID_USERNAME_OR_PASSWORD_MSG = "Username or password is invalid";
    public static final String EMPTY_USERNAME_AND_PASSWORD_MSG = "Please enter username!";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = PROJECT_PATH + "\\src\\main\\resources\\";
    public static final String OUTPUT_PATH = RESOURCES_PATH + "output/";
    public static final String TEST_CONFIGURATION = RESOURCES_PATH + "configuration/Configuration.properties";

    //Run parameters
    public static String RUN_ON = "Local";
    public static String BROWSER = "CHROME";
    public static String BROWSER_VERSION = "latest";
    public static String RESOLUTION = "1280x1024";
    public static String THREAD_COUNT = "1";
    public static int NUMBER_OF_REPORT = 30;

    //OS name
    public static final String OS_NAME = System.getProperty("os.name").toLowerCase();

    //Report data
    public static int TOTAL_TESTCASES = 0;
    public static int TOTAL_EXECUTED = 0;
    public static int TOTAL_PASSED = 0;
    public static int TOTAL_FAILED = 0;
    public static int TOTAL_SKIPPED = 0;
    public static boolean REPORT_STATUS = true;

}