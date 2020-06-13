package com.logigear.training.common;

public class GlobalVariables {

    public static String AUT = "https://d7ec79cacfa4.ngrok.io/TADashboard/login.jsp";

    // Default wait time
    public static final int WAIT_TIME = 10;

    //Run parameters
    public static String TESTING_TYPE = "regression";
    public static String RUN_ON = "Local";
    public static String BROWSER = "Chrome";
    public static String THREAD_COUNT = "1";
    public static int NUMBER_OF_REPORT = 30;

    //Report data
    public static int TOTAL_TESTCASES = 0;
    public static int TOTAL_EXECUTED = 0;
    public static int TOTAL_PASSED = 0;
    public static int TOTAL_FAILED = 0;
    public static int TOTAL_SKIPPED = 0;
    public static boolean REPORT_STATUS = true;
    public static int TOTAL_PASSED_WITH_RETRY = 0;
    public static String RETRY_FAILED_TESTS = "";

    //Project path
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = PROJECT_PATH + "\\src\\main\\resources\\";
    public static final String OUTPUT_PATH = RESOURCES_PATH + "output/";
    public static final String FILE_UPLOAD_PATH = PROJECT_PATH + "/resources/files_upload/";

    //OS name
    public static final String OS_NAME = System.getProperty("os.name").toLowerCase();


    public static final String TEST_DATA_JSON = PROJECT_PATH + "/src/test/java/";
    public static final String TEST_CONFIGURATION = RESOURCES_PATH + "configuration/Configuration.properties";


    //SHOW/HIDE skip test case in report
    public static final boolean SHOW_SKIP = false;

    //Driver variables
    public static final String CHROME_DRIVER_WIN = ".\\src\\main\\resources\\drivers\\chromedriver_v83.exe";
    public static final String GECKO_DRIVER_WIN = ".\\src\\main\\resources\\drivers\\geckodriver.exe";

}

