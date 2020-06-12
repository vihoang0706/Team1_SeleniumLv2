package com.logigear.training.common;

//import com.api.selenium_services.SeleniumServices;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.logigear.training.utilities.ConfigFileReader;
import com.logigear.training.utilities.Utility;
//import com.perfecto.reportium.client.ReportiumClient;
//import com.logigear.training.utilities.ConfigFileReader;
//import com.utility.DigitalZoomReport;
//import com.logigear.training.utilities.Utility;
//import com.utility.webdrivers.PerfectoDriver;
//import io.restassured.response.Response;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

//import static com.common.GlobalVariables.*;
import static com.logigear.training.common.GlobalVariables.*;
import static com.logigear.training.utilities.Utility.log4jConfiguration;

public class TestBase extends Utility {

    public static boolean isTestSuiteExecutable = false;
    public boolean isTestCaseExecutable = false;

    public static ExtentTest logSuite = null;
    public ExtentTest logClass = null;
    public ExtentTest logMethod = null;
    public ExtentTest logStep = null;
    //public ReportiumClient reportiumClient = null;

    public String testCaseName;
    public String testNameWithStatus;
    public static ArrayList<String> testcaseList = new ArrayList<String>();

    @BeforeSuite()
    public synchronized void beforeSuite() throws IOException {

        // Initiate log4j property system
        log4jConfiguration();
        DOMConfigurator.configure(".\\src\\main\\resources\\suites/log4j.xml");

        log4j.info("beforeSuite method - Start");

        // Initial test report
        try {
            htmlReporter = new ExtentHtmlReporter(reportFilePath);
            htmlReporter.loadXMLConfig(new File(PROJECT_PATH + "\\src\\main\\resources\\suites/reporttheme.xml"));
            report = new ExtentReports();
            report.attachReporter(htmlReporter);
            logSuite = createTestForExtentReport(report, "Initial Setup");
        } catch (Exception e) {
            log4j.error("ERROR while initializing Extend report: " + e.getStackTrace());
            logException(logSuite, "ERROR while initializing Extend report", e);
        }

        // Create report folder
        logInfo(logSuite, "Report folder: " + reportLocation);
        File folder = new File(reportLocation);
        folder.mkdirs();

        // Initial test data
        try {
            String testDataFilePath = TEST_CONFIGURATION;
            configFileReader = new ConfigFileReader(testDataFilePath, logSuite);
            logInfo(logSuite, "Test data: " + testDataFilePath);
        } catch (Exception e) {
            log4j.error("ERROR while reading Test Configuration: " + e.getStackTrace());
            logException(logSuite, "ERROR while reading test Configuration: ", e);
        }

        // Validate toRecipient
        if (System.getProperty("toRecipient") != null) {
            TO_RECIPIENT = System.getProperty("toRecipient");
            IS_SEND_EMAIL = true;
        }

        // Validate testrailUpdate
        try {
            String testPlanID = configFileReader.getDataFromConfigurationFile("TestPlanID");
            if (System.getProperty("testPlanID") != null && !System.getProperty("testPlanID").equals("")) {
                TESTRAIL_UPDATE = true;
                TEST_PLAN_ID = System.getProperty("testPlanID");
            } else if (testPlanID != null && !testPlanID.equals("")) {
                TEST_PLAN_ID = testPlanID;
                TESTRAIL_UPDATE = true;
            }
        } catch (Exception e) {
            log4j.error("Error when getting 'TestPlanID'' parameter: " + e);
            logException(logSuite, "Error when getting 'TestPlanID' parameter: ", e);
        }

        // Validate testingType
        try {
            TESTING_TYPE = System.getProperty("testingType") == null ? configFileReader.getDataFromConfigurationFile("TestingType") : System.getProperty("testingType");
            if (TESTING_TYPE != null && (TESTING_TYPE.equalsIgnoreCase("Full Regression") || TESTING_TYPE.equalsIgnoreCase("Regression") || TESTING_TYPE.equalsIgnoreCase("BVT") || TESTING_TYPE.equalsIgnoreCase("Smoke") || TESTING_TYPE.equalsIgnoreCase("ProdSmoke") || TESTING_TYPE.equalsIgnoreCase("ProdCancelWarranty") || TESTING_TYPE.equalsIgnoreCase("ProdClaimRefund") || TESTING_TYPE.equalsIgnoreCase("SkySmoke") || TESTING_TYPE.equalsIgnoreCase("SkyRegression") || TESTING_TYPE.equalsIgnoreCase("SkyApiSmoke") || TESTING_TYPE.equalsIgnoreCase("SkyApiRegression") || TESTING_TYPE.equalsIgnoreCase("StaticSiteSmoke") || TESTING_TYPE.equalsIgnoreCase("WarriorAdyen")))
                logInfo(logSuite, "Testing Type: " + TESTING_TYPE);
            else
                logFail(logSuite, "Invalid 'testingType' parameter: " + TESTING_TYPE);
        } catch (Exception e) {
            log4j.error("Error when getting 'testingType' parameter: " + e);
            logException(logSuite, "Error when getting 'testingType' parameter: ", e);
        }

        // Validate environment
        try {
            ENVIRONMENT = System.getProperty("environment") == null ? configFileReader.getDataFromConfigurationFile("Environment") : System.getProperty("environment");
            if (ENVIRONMENT == null || ENVIRONMENT == "")
                logFail(logSuite, "Invalid 'environment' parameter: " + ENVIRONMENT);
            else {
                logInfo(logSuite, "Environment: " + ENVIRONMENT);
                SALESFORCE_USERNAME = System.getenv("SALESFORCE_" + ENVIRONMENT.toUpperCase() + "_USERNAME");
                SALESFORCE_PASSWORD = System.getenv("SALESFORCE_" + ENVIRONMENT.toUpperCase() + "_PASSWORD");
                //if (ENVIRONMENT.equalsIgnoreCase("PRODUCTION")) EMAIL_ADDRESS = "automationforui@gmail.com";
            }
        } catch (Exception e) {
            log4j.error("Error when getting 'environment'' parameter: " + e);
            logException(logSuite, "Error when getting 'environment' parameter: ", e);
        }

        // Validate runOn
        try {
            RUN_ON = System.getProperty("runOn") == null ? configFileReader.getDataFromConfigurationFile("RunOn") : System.getProperty("runOn");
            if (RUN_ON != null && (RUN_ON.equalsIgnoreCase("Local") || RUN_ON.equalsIgnoreCase("PerfectoMobile") || RUN_ON.equalsIgnoreCase("Grid") || RUN_ON.equalsIgnoreCase("sel-hub-1.qa") || RUN_ON.equalsIgnoreCase("sel-hub-1.production")))
                logInfo(logSuite, "Run On: " + RUN_ON);
            else
                logFail(logSuite, "Invalid 'runOn' parameter: " + RUN_ON);
        } catch (Exception e) {
            log4j.error("Error when getting 'runOn' parameter: " + e);
            logException(logSuite, "Error when getting 'runOn' parameter", e);
        }

//        //Health check status of selenium hub
//        try {
//            String hubEndPoint = "http://sel-hub-1.qa.squaretrade.com:4444/status";
//            if (RUN_ON.equalsIgnoreCase("Grid") || RUN_ON.equalsIgnoreCase("sel-hub-1.qa") || RUN_ON.equalsIgnoreCase("sel-hub-1.production")) {
//                if (RUN_ON.equalsIgnoreCase("sel-hub-1.production")) hubEndPoint = "http://sel-hub-1.production.squaretrade.com:4444/status";
//
//                Response response = SeleniumServices.gridHealthCheckRequestSpecification(hubEndPoint, logSuite);
//                Boolean gridHealthCheckStatus = (Boolean) response.jsonPath().getMap("value").get("ready");
//                String gridHealthCheckMessage = (String) response.jsonPath().getMap("value").get("message");
//                if (!gridHealthCheckStatus) {
//                    log4j.error(gridHealthCheckMessage);
//                    logFailBeforeSuite(logSuite, gridHealthCheckMessage);
//                } else logInfo(logSuite, gridHealthCheckMessage);
//            }
//        } catch (Exception e) {
//            log4j.error("Error when checking the health status of selenium hub: " + e);
//            logFailBeforeSuite(logSuite, "Error when checking the health status of selenium hub:" + e);
//        }

        // Validate browserName
        try {
            BROWSER = System.getProperty("browserName") == null ? configFileReader.getDataFromConfigurationFile("BrowserName") : System.getProperty("browserName");
            if (BROWSER == null || BROWSER == "") {
                logFail(logSuite, "Invalid 'browserName' parameter: " + BROWSER);
            } else {
                logInfo(logSuite, "Browser name: " + BROWSER);
            }

        } catch (Exception e) {
            log4j.error("Error when getting 'browserName' parameter" + e);
            logException(logSuite, "Error when getting 'browserName' parameter", e);
        }

        if (RUN_ON.equalsIgnoreCase("Local")||RUN_ON.equalsIgnoreCase("Grid") ||RUN_ON.equalsIgnoreCase("sel-hub-1.qa") ||RUN_ON.equalsIgnoreCase("sel-hub-1.production")) {
            //Show OS name
            logInfo(logSuite, "OS name: " + OS_NAME);
        } else {
            // Validate platform
            try {
                PLATFORM = System.getProperty("platform") == null ? configFileReader.getDataFromConfigurationFile("Platform") : System.getProperty("platform");
                logInfo(logSuite, "Platform : " + PLATFORM);
                switch(PLATFORM){
                    case("Windows 10"):
                    case("Windows 8.1"):
                    case("Windows 7"):
                        PLATFORM_NAME = "Windows";
                        PLATFORM_VERSION = PLATFORM.split(" ")[1];
                        break;
                    case("macOS High Sierra"):
                    case("OS X El Capitan"):
                        PLATFORM_NAME = "Mac";
                        PLATFORM_VERSION = PLATFORM;
                        break;
                    case("iOS"):
                        PLATFORM_NAME = "iOS";
                        break;
                    case("Android"):
                        PLATFORM_NAME = "Android";
                        break;
                    default:
                        logFail(logSuite, "Invalid 'platform' parameter: " + PLATFORM);
                }
            } catch (Exception e) {
                log4j.error("Error when getting 'platform' parameter" + e);
                logException(logSuite, "Error when getting 'platform' parameter", e);
            }
        }

        // Get Production Credit Card info from Jenkins
        injectVisaCard();
        injectMasterCard();
        injectAmexCard();
        injectDiscoverCard();

        // Get automation service authentication info from Jenkins
        injectAutomationServiceAPIAuthenticationForAutomationUser();
        injectAutomationServiceAPIAuthenticationForCsAgentUser();

        // Override CONSTANT variables
        if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
            ST_PHONE_WARRANTY_YEARLY = "https://www.squaretrade.com/smartphone-warranty-yearly";
            ST_BASE_URL = "https://www.squaretrade.com";
            ST_EU_URL = "https://www.squaretrade.";
            SPRINT_MOBILE_URL = "https://www.squaretrade.com/web-app/checkout-2.0/smartphone?m_id=subscrip_spri11212016&rp_id=RD-SP1499RN3A&campaign=sprint_mweb_v2_cpg_1&expver=2";

            DB_URL_MERCHANT = "jdbc:postgresql://db-merchant-standby.production.squaretrade.com:5432/merchant?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_WARRANTY = "jdbc:postgresql://db-warranty-standby-bi.production.squaretrade.com:5432/warranty?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_ORDERTRACKING = "jdbc:postgresql://db-ordertracking-standby-bi.production.squaretrade.com:5432/ordertracking?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_MINT = "jdbc:postgresql://db-mint-standby.production.squaretrade.com:5432/mint?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_COMMUNICATION = "jdbc:postgresql://db-communication-standby.production.squaretrade.com:5432/communication?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
        } else {
            ST_PHONE_WARRANTY_YEARLY = "https://www-" + ENVIRONMENT + ".squaretrade.com/smartphone-warranty-yearly";
            ST_BASE_URL = "https://www-" + ENVIRONMENT + ".squaretrade.com";
            BHFL_BASE_URL = ST_BASE_URL + "/bhfl";
            ST_SMARTPHONE_ACTIVATION = ST_BASE_URL + "/smartphone-activation";
            ST_VENDOR_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.com/vendorportal";
            ST_SWEDEN_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.se/register?skip-captcha=true";
            ST_POTUGAL_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.pt/register?skip-captcha=true";
            ST_SPAIN_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.es/register?skip-captcha=true";
            ST_AUSTRIA_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.at/register?skip-captcha=true";
            ST_GERMANY_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.de/register?skip-captcha=true";
            ST_FINLAND_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.fi/register?skip-captcha=true";
            ST_DENMARK_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.dk/register?skip-captcha=true";
            ST_NORWAY_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.no/web-app/registration/launch?skip-captcha=true";
            ST_UK_URL = "https://www-" + ENVIRONMENT + ".squaretrade.co.uk/frontend/registration/#/";
            ST_EU_URL = "https://www-" + ENVIRONMENT + ".squaretrade.";
            SPRINT_MOBILE_URL = "https://www-" + ENVIRONMENT + ".squaretrade.com/web-app/checkout-2.0/smartphone?m_id=subscrip_spri11212016&rp_id=RD-SP1499RN3A&campaign=sprint_mweb_v2_cpg_1&expver=2";
            ST_PREMIUM_SMARTPHONE_WARRANTY = "https://www-" + ENVIRONMENT + ".squaretrade.com/premium-smartphone-warranty";
            ST_HIKARI_URL = "https://www-" + ENVIRONMENT + ".squaretrade.co.jp/frontend/registration/#/";

            DB_URL_MERCHANT = "jdbc:postgresql://db-merchant." + ENVIRONMENT + ".squaretrade.com:5432/merchant?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_MINT = "jdbc:postgresql://db-mint." + ENVIRONMENT + ".squaretrade.com:5432/mint?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_WARRANTY = "jdbc:postgresql://db-warranty." + ENVIRONMENT + ".squaretrade.com:5432/warranty?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_ORDERTRACKING = "jdbc:postgresql://db-ordertracking." + ENVIRONMENT + ".squaretrade.com:5432/ordertracking?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            DB_URL_COMMUNICATION = "jdbc:postgresql://db-communication." + ENVIRONMENT + ".squaretrade.com:5432/communication?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

            TMA_PORTAL_URL = "https://www-" + ENVIRONMENT + ".squaretrade.at/tma";
            TMA_FILE_A_CLAIM_URL = "https://www-" + ENVIRONMENT + ".squaretrade.at/register?skip-captcha=true";

            PART_SHIPMENT_STATUS_URL = "https://www-" + ENVIRONMENT + ".squaretrade.com/web-app/parts-shipment-status/launch/";

            WALMART_HUB_URL = "https://www-" + ENVIRONMENT + ".squaretrade.com/web-app/registration/launch?retailer=WALMART_DOT_COM&retailer=WALMART&warrantyId=";
            WALMART_CLAIMS_URL = "https://www-" + ENVIRONMENT + ".squaretrade.com/walmartclaims?warrantyId=";

            ST_LR_TOOLS_URL = "https://dev:freel00k@www-" + ENVIRONMENT + ".squaretrade.com/web-app/local-repair-tools/launch";
            GENERAL_SFTP_HOST = "sftp." + ENVIRONMENT + ".squaretrade.com";
            GENERAL_SFTP_USERNAME = "devftp";
            GENERAL_SFTP_PASSWORD = "devftp";
        }

        if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION) || ENVIRONMENT.contains("stage")) {
            SPARKPOST_PASSWORD = System.getenv("SPARKPOST_PASSWORD_STAGE");
            WARRANTY_CREATION_AUTHORIZATION = System.getenv("WARRANTY_CREATION_AUTHORIZATION_STAGE");
            PARTNER_PORTAL_AUTHORIZATION = System.getenv("PARTNER_PORTAL_AUTHORIZATION_STAGE");
            PARTNER_PORTAL_PASSWORD = System.getenv("PARTNER_PORTAL_PASSWORD_STAGE");
            PRODUCT_EVALUATOR_AUTHORIZATION = System.getenv("PRODUCT_EVALUATOR_AUTHORIZATION_STAGE");
            PRODUCT_EVALUATOR_PASSWORD = System.getenv("PRODUCT_EVALUATOR_PASSWORD_STAGE");
            TMA_FILE_A_CLAIM_URL = "https://www-" + ENVIRONMENT + ".squaretrade.at/register";
            GENERAL_SFTP_HOST = "sftp-stage.squaretrade.com";
            GENERAL_SFTP_USERNAME = ENVIRONMENT;
            GENERAL_SFTP_PASSWORD = ENVIRONMENT + "ftp";
        }

        TOGGLE_APPLICATION_URL_1 = "https://svc-api-int-1." + ENVIRONMENT + ".squaretrade.com:9130/togglz-console/index";
        TOGGLE_APPLICATION_URL_2 = "https://svc-api-int-2." + ENVIRONMENT + ".squaretrade.com:9130/togglz-console/index";

       // report.setSystemInfo("environment", ENVIRONMENT);
        report.setSystemInfo("Browser", BROWSER);

        // Start Perfecto Connection: support for Mobile and Window fast-web only
        /*if (RUN_ON.equalsIgnoreCase("PerfectoMobile") && !PLATFORM_NAME.equalsIgnoreCase("Mac")) {
            PerfectoDriver perfectoDriver = new PerfectoDriver();
            TUNNEL_ID = perfectoDriver.startPerfectoConnection(PERFECTO_TOKEN);
            USE_PERFECTO_CONNECT = true;
        }*/

        /* This solution is to handle uploading file on Perfecto/Mobile devices (IN PROGRESS)
        // Copy file from local to Perfecto Repository
        if (RUN_ON.equalsIgnoreCase("PerfectoMobile")) {
            PerfectoLabUtils perfectoLabUtils = new PerfectoLabUtils();
            perfectoLabUtils.uploadFileToRepo(PERFECTO_HOST, PERFECTO_TOKEN, RECEIPT_PNG_FILE_PATH_LOCAL, "PUBLIC:" + RECEIPT_PNG_FILE_NAME);
            perfectoLabUtils.uploadFileToRepo(PERFECTO_HOST, PERFECTO_TOKEN, RECEIPT_JPG_FILE_PATH_LOCAL, "PUBLIC:" + RECEIPT_PDF_FILE_NAME);
            perfectoLabUtils.uploadFileToRepo(PERFECTO_HOST, PERFECTO_TOKEN, RECEIPT_JPEG_FILE_PATH_LOCAL, "PUBLIC:" + RECEIPT_JPG_FILE_NAME);
            perfectoLabUtils.uploadFileToRepo(PERFECTO_HOST, PERFECTO_TOKEN, RECEIPT_PDF_FILE_PATH_LOCAL, "PUBLIC:" + RECEIPT_JPEG_FILE_NAME);
        }
        */

        isTestSuiteExecutable = true;
        log4j.info("beforeSuite method - End");
    }

    @BeforeClass
    public synchronized void beforeClass() throws IOException {
        log4j.info("beforeClass method - start");

        // Get test case class name
        testCaseName = this.getClass().getSimpleName();

        // Check if TC is executable or not
        if (isTestSuiteExecutable) {
            isTestCaseExecutable = true;
        }

        log4j.info("beforeClass method - End");
    }

    @BeforeMethod
    public synchronized void beforeMethod(Object[] data) throws IOException {
        log4j.info("beforeMethod method - Start");
        logStep = null;
        TOTAL_EXECUTED++;

        if(data != null && data.length > 0) {
            // Get test data for test case
            Hashtable<String, String> dataTest = (Hashtable<String, String>) data[0];

            //Get Retry count
            if (RETRY_FAILED_TESTS.equalsIgnoreCase("Yes")) {
                int retryCount = getRetryCount(testcaseList, testCaseName + ": " + dataTest.get("No."));
                if (retryCount > 0) {
                    testNameWithStatus = testCaseName + ": " + dataTest.get("No.") + ": RETRY" + retryCount;
                    //logMethod.assignCategory("RETRY");
                } else {
                    testNameWithStatus = testCaseName + ": " + dataTest.get("No.");
                }
            } else {
                testNameWithStatus = testCaseName + ": " + dataTest.get("No.");
            }

            //Initialize logClass
            logClass = createTestForExtentReport(report, testNameWithStatus);

            // Initial logMethod
            logMethod = createNodeForExtentReport(logClass, dataTest.get("TestDataPurpose"));
            log4j.info(dataTest.get("No.") + ": " + dataTest.get("TestDataPurpose"));

            // Assign test category
            logMethod.assignCategory(dataTest.get("TestingType"));

            // Start web driver
            initializeDriver(logMethod);

            //Initialize Digital Zoom report
           // reportiumClient = DigitalZoomReport.initDigitalZoomReport(Utility.getDriver());

            log4j.info("beforeMethod method - End");
        }
        else{
            logClass = createTestForExtentReport(report, testCaseName);
            logSkip(logClass, "This test case has no data to run");
        }
    }

    @AfterMethod
    public synchronized void afterMethod() throws IOException {
        log4j.info("afterMethod method - Start");

        if (RUN_ON.equalsIgnoreCase("PerfectoMobile")) {
            String testStatus = logMethod.getStatus().toString();
           // if (!testStatus.equalsIgnoreCase("pass")) DigitalZoomReport.testStopFailed(testStatus, reportiumClient);
        }

        //Update test execution status to the testcaseList
        testcaseList.add(testNameWithStatus + ": " + logMethod.getStatus());

        // Quit
        quit(logMethod);
        logMethod = null;

        log4j.info("afterMethod method - End");
    }

    @AfterClass()
    public synchronized void afterClass() throws IOException {
        log4j.info("afterClass method - Start");

        // Remove skip test case from report
        if (isTestCaseExecutable == false && SHOW_SKIP == false) report.removeTest(logClass);

        List statusHierarchy = Arrays.asList(
                Status.FATAL,
                Status.FAIL,
                Status.ERROR,
                Status.WARNING,
                Status.PASS,
                Status.SKIP,
                Status.DEBUG,
                Status.INFO
        );

        report.config().statusConfigurator().setStatusHierarchy(statusHierarchy);

        // Save test result to HTML file after each test class
        report.flush();

        // Update result to TestRails
        String testInfo = "\n Report link: " + Utility.getReportLink();
        //if (logClass.getStatus().equals(Status.PASS)) markTestCasePassInTestRail(testInfo, logClass);

        logClass = null;

        log4j.info("afterClass method - End");
    }

    @AfterSuite()
    public synchronized void afterSuite() throws Exception {
        log4j.info("afterSuite method - Start");

        // Stop Perfecto Connection
//        if (USE_PERFECTO_CONNECT) {
//            PerfectoDriver perfectoDriver = new PerfectoDriver();
//            perfectoDriver.stopPerfectoConnection();
//        }

        //Get the total count of TCs passed and failed
        getTestCaseExecutionCount(testcaseList);

        // Send test result on email
//        if (IS_SEND_EMAIL) {
//            REPORT_STATUS = (TOTAL_PASSED + TOTAL_PASSED_WITH_RETRY == TOTAL_EXECUTED);
//            if (TESTING_TYPE.equalsIgnoreCase("ProdCancelWarranty") || TESTING_TYPE.equalsIgnoreCase("ProdClaimRefund")) {
//                emailActions.sendEmailReportCancelWarrantyRefundClaim(TESTING_TYPE, reportFilePath, logSuite);
//            } else {
//                emailActions.sendEmailReport(ENVIRONMENT, TESTING_TYPE, reportFilePath, REPORT_STATUS, logSuite);
//            }
//            logInfo(logSuite, "Test result email was sent");
//        }

        //This code block is used to keep limited number of reports
        if (!RUN_ON.equalsIgnoreCase("Local")) {
            String currentDirectory = System.getProperty("user.dir");
            File dir = new File(currentDirectory + "/resources/output");
            File[] files = dir.listFiles();
            Arrays.sort(files, Comparator.comparingLong(File::lastModified));
            for (int i = 0; i < files.length - NUMBER_OF_REPORT; i++) {
                deleteDirectory(files[i]);
            }
        }

        log4j.info("afterSuite method - End");
    }

    @DataProvider
    public Object[][] getDataForTest() throws IOException {
        String DataFilePath = TEST_DATA_JSON + this.getClass().getPackage().getName().replace(".","/") + "/data.json";
        Object[][] data =  getData(testCaseName, DataFilePath, logClass);
        if (data.length==0) {
            logClass = createTestForExtentReport(report, testCaseName);
            logClass.fail(testCaseName + " is not present in the data.json file");
            TOTAL_FAILED++;
        }
        return data;
    }
}
