package com.logigear.training.common;

import static com.logigear.training.utilities.Utility.generateTimeStampString;


public class GlobalVariables {

    public static Process p;
    public static String TEST_NAME;

    public static String AUT = "https://d7ec79cacfa4.ngrok.io/TADashboard/login.jsp";

    // Default wait time
    public static final int WAIT_TIME = 10;

    //Run parameters
//    public static String TESTING_TYPE = "regression";
//    public static String ENVIRONMENT = "stage2";
    public static String RUN_ON = "Local";
//    public static String PLATFORM = "";
//    public static String PLATFORM_NAME = "";
//    public static String PLATFORM_VERSION = "";
//    public static String MANUFACTURER = "";
//    public static String MODEL = "";
    public static String BROWSER = "Chrome";
//    public static String BROWSER_VERSION = "latest";
//    public static String RESOLUTION = "1280x1024";
//    public static String LOCATION = "NA-US-BOS";
//    public static String RUN_MODE = "Y";
    public static String THREAD_COUNT = "1";
    public static int NUMBER_OF_REPORT = 30;

    //Report data
    public static int TOTAL_TESTCASES = 0;
    public static int TOTAL_EXECUTED = 0;
    public static int TOTAL_PASSED = 0;
    public static int TOTAL_FAILED = 0;
    public static int TOTAL_SKIPPED = 0;
    public static boolean REPORT_STATUS = true;
//    public static int WARRANTIES_FOUND = 0;
//    public static int WARRANTIES_EXCLUDED = 0;
//    public static int WARRANTIES_CANCELLED = 0;
//    public static int CLAIMS_FOUND = 0;
//    public static int CLAIMS_REFUNDED = 0;
    public static int TOTAL_PASSED_WITH_RETRY = 0;
    public static String RETRY_FAILED_TESTS = "";

    //Project path
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = PROJECT_PATH + "\\src\\main\\resources\\";
    public static final String OUTPUT_PATH = RESOURCES_PATH + "output/";
    public static final String FILE_UPLOAD_PATH = PROJECT_PATH + "/resources/files_upload/";

    //OS name
    public static final String OS_NAME = System.getProperty("os.name").toLowerCase();

    //The excel file that including all test cases and data test on whole project
//    public static final String TEST_CONFIGURATION_AND_TEST_DATA_EXCEL_PATH = RESOURCES_PATH + "data/" + "TestConfigurationAndTestData.xlsx";
//    public static final String CONFIGURATION_SHEET = "Configuration";
//    public static final String TEST_CASE_SHEET = "TestCases";
//    public static final String TEST_DATA_SHEET = "TestData";
//    public static final String CANCEL_WARRANTY_EXCLUSION_LIST = RESOURCES_PATH + "data/" + "cancel_warranty_exclusion_list.txt";
//    public static final String TEST_DATA_JSON = PROJECT_PATH + "/src/test/java/";
    public static final String TEST_CONFIGURATION = RESOURCES_PATH + "configuration/Configuration.properties";

    //Automation GMAIL variables
//    public static final String GMAIL_USERNAME = System.getenv("GMAIL_USERNAME");
//    public static final String GMAIL_PASSWORD = System.getenv("GMAIL_PASSWORD");
//    public static final String ALL_MAIL_FOLDER = "[Gmail]/All Mail";
//
//    //Report email data
//    public static final String FROM_RECIPIENT = "donotreply@squaretrade.com";
//    public static String TO_RECIPIENT = "qa-automation@squaretrade.com";

    //SHOW/HIDE skip test case in report
    public static final boolean SHOW_SKIP = false;

    //TestRail update
//    public static final String TESTRAIL_USER = "22";
//    public static boolean TESTRAIL_UPDATE = false;
//    public static String TEST_PLAN_ID = "";


//    //Turn off send email when running on local
//    public static boolean IS_SEND_EMAIL = false;
//
//    //Environments
//    public static final String PRODUCTION = "production";
//    public static final String STAGE1 = "stage1";
//    public static final String STAGE2 = "stage2";
//    public static final String STAGE3 = "stage3";
//    public static final String STAGE4 = "stage4";
//    public static final String APPSTEAM1 = "appsteam1";
//    public static final String APPSTEAM2 = "appsteam2";
//    public static final String APPSTEAM3 = "appsteam3";
//    public static final String APPSTEAMCLUSTER = "appsteam-cluster";
//    public static final String LOAD2 = "load2";
//    public static final String HOTFIX = "hotfix";
//    public static final String TRAINING = "training";
//    public static final String TRAINING2 = "training2";
//    public static final String TRAINING3 = "training3";
//    public static final String TERRA = "terra1";
////    public static final String OCEANSTEAM1 = "oceansteam1"; //use for OCEAN team
//
    //Driver variables
    public static final String CHROME_DRIVER_WIN = ".\\src\\main\\resources\\drivers\\chromedriver.exe";
    public static final String GECKO_DRIVER_WIN = ".\\src\\main\\resources\\drivers\\geckodriver.exe";

//    //Upload item receipt path variables starts here...!
//    public static final String RECEIPT_PNG_FILE_NAME = "item_receipt.png";
//    public static final String RECEIPT_PDF_FILE_NAME = "item_receipt.pdf";
//    public static final String RECEIPT_JPG_FILE_NAME = "item_receipt.jpg";
//    public static final String RECEIPT_JPEG_FILE_NAME = "item_receipt.jpeg";
//    public static final String RECEIPT_30MBJPG_FILE_NAME = "item_receipt_30MB.jpg";
//    public static final String RECEIPT_10MBPDF_FILE_NAME = "item_receipt_30MB.pdf";
//    public static final String RECEIPT_BROKEN_JPG_FILE_NAME = "item_receipt_broken_image.jpg";
//    public static final String RECEIPT_10MBPDF_FILE_PATH_LOCAL = FILE_UPLOAD_PATH + RECEIPT_10MBPDF_FILE_NAME;
//    public static final String RECEIPT_BROKEN_JPG_FILE_PATH_LOCAL = FILE_UPLOAD_PATH + RECEIPT_BROKEN_JPG_FILE_NAME;
//
//    // Perfecto repository file paths
//    public static final String PERFECTO_WINDOW_UPLOAD_PATH = "C:/temp/";
//    public static final String PERFECTO_MAC_UPLOAD_PATH = "/Users/perfecto/web/Allstate/";
//    public static final String PERFECTO_ANDROID_CAMERA_PATH = "card:/DCIM/Camera/";
//    public static final String PERFECTO_IOS_CAMERA_PATH = "phone:/Media/DCIM/";
//
//    //Perfecto variables
//    public static final String PERFECTO_USERNAME = System.getenv("PERFECTO_USERNAME");
//    public static final String PERFECTO_TOKEN = System.getenv("PERFECTO_TOKEN");
//    public static final String PERFECTO_HOST = "allstate.perfectomobile.com";
//    public static final String PERFECTO_HUB_ADDRESS = "https://allstate.perfectomobile.com/nexperience/perfectomobile/wd/hub";
//    public static final String PERFECTO_CONNECT_MAC = PROJECT_PATH + "/resources/drivers/perfectoconnect";
//    public static final String PERFECTO_CONNECT_WIN = PROJECT_PATH + "/resources/drivers/perfectoconnect.exe";
//    public static String TUNNEL_ID = "";
//
//    // These files are using to upload to Cloud Storage
//    public static final String CSS_UPLOAD_FILE_PATH_TXT = FILE_UPLOAD_PATH + "css_upload_file.txt";
//    public static final String CSS_UPLOAD_FILE_PATH_HTML = FILE_UPLOAD_PATH + "css_upload_email.html";
//
//    // Warranty Event Handler Service API
//    public static String WEH_USERNAME = System.getenv("WEH_USERNAME");
//    public static String WEH_PASSWORD = System.getenv("WEH_PASSWORD");
//
//    // Dev account
//    public static String DEV_USERNAME = System.getenv("DEV_USERNAME");
//    public static String DEV_PASSWORD = System.getenv("DEV_PASSWORD");
//
//    // This files is using for LR tools
//    public static final String UPLOAD_REPAIR_PROFILE_FILE_PATH = FILE_UPLOAD_PATH + "automation_repairprofile.csv";
//    public static final String REPAIR_PROFILE_FILE_NAME = "automation_repairprofile.csv";
//
//    //Database connection urls
//    public static final String JDBC_DRIVER = "org.postgresql.Driver";
//    public static String DB_URL_MERCHANT = "";
//    public static String DB_URL_MINT = "";
//    public static String DB_URL_WARRANTY = "";
//    public static String DW_URL_WARRANTY = "";
//    public static String DB_URL_ORDERTRACKING = "";
//    public static String DB_URL_COMMUNICATION = "";
//    public static String DB_URL = "jdbc:postgresql://db-%s.%s.squaretrade.com:5432/%s?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
//    public static String DB_URL_PRODUCTION = "jdbc:postgresql://db-%s-standby.production.squaretrade.com:5432/%s?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
//    public static String MERCHANT = "merchant";
//    public static String WARRANTY = "warranty";
//    public static String COMMUNICATION = "communication";
//    public static String PURCHASE = "purchase";
//    public static String ORDER_TRACKING = "ordertracking";
//    public static String CLOSEDLOOP = "closedloop";
//
//    //Database accounts
//    public static final String DB_ADMIN_USERNAME = System.getenv("DB_ADMIN_USERNAME");
//    public static final String DB_ADMIN_PASSWORD = System.getenv("DB_ADMIN_PASSWORD");
//    public static final String DB_STAGE_USERNAME = System.getenv("DB_STAGE_USERNAME");
//    public static final String DB_STAGE_PASSWORD = System.getenv("DB_STAGE_PASSWORD");
//    public static final String DB_PROD_USERNAME = System.getenv("DB_PROD_USERNAME");
//    public static final String DB_PROD_PASSWORD = System.getenv("DB_PROD_PASSWORD");
//
//    //Salesforce accounts
//    public static final String SALESFORCE_DEVANDSTAGE_URL = "https://cs3.salesforce.com/home/home.jsp";
//    public static final String SALESFORCE_PROD_URL = "https://squaretrade.my.salesforce.com";
//    public static final String SALESFORCE_LOAD2_URL = "https://test.salesforce.com/";
//    public static final String SALESFORCE_STAGE1_URL = "https://squaretrade--stage1.my.salesforce.com/";
//    public static final String SALESFORCE_STAGE2_URL = "https://squaretrade--stage2.my.salesforce.com/";
//    public static final String SALESFORCE_STAGE3_URL = "https://squaretrade--stage3.my.salesforce.com/";
//    public static final String SALESFORCE_STAGE4_URL = "https://squaretrade--stage4.my.salesforce.com/";
//    public static final String SALESFORCE_DEV_USERNAME = System.getenv("SALESFORCE_DEV_USERNAME");
//    public static final String SALESFORCE_DEV_PASSWORD = System.getenv("SALESFORCE_DEV_PASSWORD");
//    public static final String SALESFORCE_PROD_USERNAME = System.getenv("SF_USERNAME");
//    public static final String SALESFORCE_PROD_PASSWORD = System.getenv("SF_PASSWORD");
//    public static final String SALESFORCE_LOCAL_USERNAME = System.getenv("SALESFORCE_LOCAL_USERNAME");
//    public static final String SALESFORCE_LOCAL_PASSWORD = System.getenv("SALESFORCE_LOCAL_PASSWORD");
//    public static String SALESFORCE_USERNAME = "";
//    public static String SALESFORCE_PASSWORD = "";
//
//    //PROD Credit Cards info
//    public static String VISA_CREDIT_CARD_NUMBER = "";
//    public static String VISA_CREDIT_CARD_EXPIRATION_MONTH = "";
//    public static String VISA_CREDIT_CARD_EXPIRATION_YEAR = "";
//    public static String VISA_CREDIT_CARD_EXPIRATION_DATE = "";
//    public static String VISA_CREDIT_CARD_CVV_NUMBER = "";
//
//    public static String MASTER_CARD_CREDIT_CARD_NUMBER = "";
//    public static String MASTER_CARD_CREDIT_CARD_EXPIRATION_MONTH = "";
//    public static String MASTER_CARD_CREDIT_CARD_EXPIRATION_YEAR = "";
//    public static String MASTER_CARD_CREDIT_CARD_EXPIRATION_DATE = "";
//    public static String MASTER_CARD_CREDIT_CARD_CVV_NUMBER = "";
//
//    public static String AMEX_CREDIT_CARD_NUMBER = "";
//    public static String AMEX_CREDIT_CARD_EXPIRATION_MONTH = "";
//    public static String AMEX_CREDIT_CARD_EXPIRATION_YEAR = "";
//    public static String AMEX_CREDIT_CARD_EXPIRATION_DATE = "";
//    public static String AMEX_CREDIT_CARD_CVV_NUMBER = "";
//
//    public static String DISCOVER_CREDIT_CARD_NUMBER = "";
//    public static String DISCOVER_CREDIT_CARD_EXPIRATION_MONTH = "";
//    public static String DISCOVER_CREDIT_CARD_EXPIRATION_YEAR = "";
//    public static String DISCOVER_CREDIT_CARD_EXPIRATION_DATE = "";
//    public static String DISCOVER_CREDIT_CARD_CVV_NUMBER = "";
//
//    //QA/TEST Credit Card info
//    public static final String CREDIT_CARD_TYPE = "VISA";
//    public static final String CREDIT_CARD_NUMBER = "4111111111111111";
//    public static final String CREDIT_CARD_EXPIRATION_MONTH = "10";
//    public static final String STRING_CREDIT_CARD_EXPIRATION_MONTH = "10 - Oct";
//    public static final String CREDIT_CARD_EXPIRATION_YEAR = "2020";
//    public static final String CREDIT_CARD_EXPIRATION_DATE = "1020";
//    public static final String CREDIT_CARD_CVV_NUMBER = "737";
//    public static final String INVALID_MASTER_CARD_NUMBER = "5555555555554444";
//
//    //QA/TEST JCB Card info
//    public static final String JCB_CARD_TYPE = "JCB";
//    public static final String JCB_CARD_NUMBER = "3528000700000000";
//    public static final String JCB_CARD_EXPIRATION_MONTH = "03";
//    public static final String STRING_JCB_CARD_EXPIRATION_MONTH = "03 - Mar";
//    public static final String JCB_CARD_EXPIRATION_YEAR = "2030";
//    public static final String JCB_CARD_EXPIRATION_DATE = "0330";
//    public static final String JCB_CARD_CVV_NUMBER = "737";
//
//    //QA/TEST Credit Card for monthly phone
//    public static final String CREDIT_CARD_EXPIRATION_MONTH_FOR_MONTHLY_PHONE = "10";
//    public static final String CREDIT_CARD_EXPIRATION_YEAR_FOR_MONTHLY_PHONE = "2020";
//    public static final String CVV_NUMBER_FOR_MONTHLY_PHONE = "737";
//    public static final String CREDIT_CARD_EXPIRATION_DATE_MONTHLY_SMARTPHONE = "10/20";
//
//    //TMA portal
//    public static String TMA_PORTAL_URL = "";
//    public static String TMA_FILE_A_CLAIM_URL = "";
//    public static final String TMA_USER_NAME = System.getenv("TMA_USER_NAME");
//    public static final String TMA_PASSWORD = System.getenv("TMA_PASSWORD");
//    public static final String TMA_PORTAL_TITLE = "UI Automation";
//    public static final String TMA_PORTAL_FIRST_NAME = "Automation";
//    public static final String TMA_PORTAL_LAST_NAME = "UI";
//    public static final String TMA_PORTAL_ADDRESS = "97-99 Rennweg";
//    public static final String TMA_PORTAL_CITY = "WIEN";
//    public static final String TMA_PORTAL_ZIPCODE = "1030";
//    public static final String TMA_PORTAL_PHONE_NUMBER = "4084084008";
//
//    //Authentication info for Partner Portal
//    public static String PARTNER_PORTAL_AUTHORIZATION = System.getenv("PARTNER_PORTAL_AUTHORIZATION_DEV");
//    public static String PARTNER_PORTAL_USERNAME = System.getenv("PARTNER_PORTAL_USERNAME");
//    public static String PARTNER_PORTAL_PASSWORD = System.getenv("PARTNER_PORTAL_PASSWORD_DEV");
//
//    //Authentication info for Product Evaluator
//    public static String PRODUCT_EVALUATOR_AUTHORIZATION = System.getenv("PRODUCT_EVALUATOR_AUTHORIZATION_DEV");
//    public static String PRODUCT_EVALUATOR_USERNAME = System.getenv("PRODUCT_EVALUATOR_USERNAME");
//    public static String PRODUCT_EVALUATOR_PASSWORD = System.getenv("PRODUCT_EVALUATOR_PASSWORD_DEV");
//
//    //Test email variables
//    public static String EMAIL_ADDRESS = "automation@squaretrade.com";
//    public static final String CONFIRM_ACCOUNT_SUBJECT = "Important: Please confirm your email address";
//    public static final String CHOOSE_TV_REPLACEMENT_TEMPLATE = "REPLACEMENT_OFFER_V1_en_US";
//    public static final String CONFIRM_PASSWORD = "123456";
//    public static final String CONFIRM_EU_PASSWORD = "Test" + generateTimeStampString(5);
//    public static final String CONFIRM_EU_RESET_PASSWORD = "TestReset" + generateTimeStampString(5);
//    public static final String PRODUCTION_TRANSFER_EMAIL = "travis@squaretrade.com";
//
//    //Phone type
//    public static final String PHONE_TYPE = "Mobile";
//
//    //Ageback data
//    public static final String AGE_DAYS = "396 days";
//    public static final int AGE_BACK_DAYS = 396;
//
//    //Inventory data
//    public static final int INVENTORY_AVAILABLE = 100;
//    public static final int INVENTORY_UNAVAILABLE = 0;
//
//    //Base SquareTrade links
//    public static String ST_PHONE_WARRANTY_YEARLY = "";

//    public static String ST_VENDOR_PORTAL_URL = "";
//    public static String ST_SWEDEN_PORTAL_URL = "";
//    public static String ST_GERMANY_PORTAL_URL = "";
//    public static String ST_POTUGAL_PORTAL_URL = "";
//    public static String ST_SPAIN_PORTAL_URL = "";
//    public static String ST_EU_URL = "";
//    public static String SPRINT_MOBILE_URL = "";
//    public static String ST_AUSTRIA_PORTAL_URL = "";
//    public static String ST_DENMARK_PORTAL_URL = "";
//    public static String ST_FINLAND_PORTAL_URL = "";
//    public static String ST_NORWAY_PORTAL_URL = "";
//    public static String ST_UK_URL = "";
//    public static String ST_LR_TOOLS_URL = "";
//    public static String BHFL_BASE_URL = "";
//    public static String ST_SMARTPHONE_ACTIVATION = "";
//    public static String ST_PREMIUM_SMARTPHONE_WARRANTY = "";
//    public static String ST_HIKARI_URL = "";
//
//    //Verify POP data
//    public static final String RECEIPT_ISSUER = "Target";
//    public static final String RECEIPT_FORMAT = "Email attachment";
//    public static final String TAX_AMOUNT = "3";
//    public static final String SHIPPING_AMOUNT = "4";
//    public static final String POP_NOTES = "Verify proof of purchase";
//
//    //Warranty checkout info
//    public static String CHECKOUT_COUPON_CODE = "";
//    public static final String CHECKOUT_FIRST_NAME = "Automation";
//    public static final String CHECKOUT_LAST_NAME = "UI";
//    public static final String CHECKOUT_FULL_NAME = "Automation UI";
//    public static final String CHECKOUT_ADDRESS = "360 3rd street";
//    public static final String CHECKOUT_CITY = "Sanfrancisco";
//    public static final String CHECKOUT_STATE = "California";
//    public static final String CHECKOUT_STATE_CODE_CA = "CA";
//    public static final String CHECKOUT_ZIPCODE = "94107";
//    public static final String CHECKOUT_PHONE_NUMBER = "4084084008";
//    public static final String CHECKOUT_REFERRER = "Web ad";
//    public static final String CHECKOUT_PURCHASE_LOCATION = "Costco";
//    public static final String CHECKOUT_CODE_NAME = "ST1CENT";
//    public static final String CITY_ADDRESS_IN_SQIM_EMAIL = "SAN FRANCISCO";
//
//    //TV replacement shipping address
//    public static final String TV_REPLACEMENT_SHIPPING_FIRST_NAME = "Automation";
//    public static final String TV_REPLACEMENT_SHIPPING_LAST_NAME = "UI";
//    public static final String TV_REPLACEMENT_SHIPPING_ADDRESS = "360 3rd street";
//    public static final String TV_REPLACEMENT_SHIPPING_CITY = "Sanfrancisco";
//    public static final String TV_REPLACEMENT_SHIPPING_STATE = "CA";
//    public static final String TV_REPLACEMENT_SHIPPING_ZIPCODE = "94107";
//    public static final String TV_REPLACEMENT_SHIPPING_PHONE_NUMBER = "408-408-4008";
//
//    //TV replacement BBY shipping address
//    public static final String TV_REPLACEMENT_BBY_SHIPPING_FIRST_NAME = "Automation";
//    public static final String TV_REPLACEMENT_BBY_SHIPPING_LAST_NAME = "UI";
//    public static final String TV_REPLACEMENT_BBY_SHIPPING_ADDRESS = "200 MAIN ST";
//    public static final String TV_REPLACEMENT_BBY_SHIPPING_CITY = "KETCHIKAN";
//    public static final String TV_REPLACEMENT_BBY_SHIPPING_STATE = "AK";
//    public static final String TV_REPLACEMENT_BBY_SHIPPING_ZIPCODE = "99901";
//    public static final String TV_REPLACEMENT_BBY_SHIPPING_PHONE_NUMBER = "408-408-4008";
//
//    //Non-US zipcode
//    public static final String UK_SHIPPING_ADDRESS_ZIPCODE = "ST13AB";
//
//    //STAPLES payment method
//    public static final String FACV3_BUYERCENTER_STAPLES_PAYMENT_METHOD = "STAPLES GIFT CARD";
//    //Authentication info for automation service API
//    public static String GRANT_TYPE = "";
//    public static String CLIENT_SECRET = "";
//    public static String CLIENT_ID = "";
//    public static String AUTOMATION_USERNAME = "";
//    public static String AUTOMATION_PASSWORD = "";
//    public static String AUTOMATION_SCOPE = "";
//    public static String CSAGENT_USERNAME = "";
//    public static String CSAGENT_PASSWORD = "";
//    public static String CSAGENT_SCOPE = "";
//
//    //Other info for automation service API
//    public static String DOMAIN_DEFAULT = "app";
//    public static String DOMAIN_MINT = "mint";
//    public static String STATE_DOMAIN_MERCHANT = "MERCHANT";
//    public static String STATE_DOMAIN_WARRANTY = "WARRANTY";
//
//    //IDC variables
//    public static final String NOT_DEFINED = "not defined";
//    public static final String WALMART_INTENT = "/register?retailer=WALMART_DOT_COM&retailer=WALMART";
//    public static final String REGISTER_INTENT = "/register";
//
//    //List of known merchants and unknown merchants
//    public static final String[] KNOWN_AND_UNKNOWN_MERCHANTS = {"Adorama Camera", "Amazon.com", "ABC Warehouse", "B&H Photo Video", "Abt Electronics", "Costco", "42nd Street Photo", "Sam's Club"};
//
//    //Part Shipment Status
//    public static String PART_SHIPMENT_STATUS_URL = "";
//    public static String FEDEX_TRACKING_NUMBER = "706242456901";
//    public static String UPS_TRACKING_NUMBER = "821422254387";
//    public static String DHL_TRACKING_NUMBER = "782238697651";
//
//    //Appointment status
//    public static final String APPOINTMENT_STATUS_REQUESTED = "REQUESTED";
//    public static final String APPOINTMENT_STATUS_CONFIRMED = "CONFIRMED";
//    public static final String APPOINTMENT_STATUS_COMPLETED = "COMPLETED";
//
//    //TV Appointment - KPI Sourcing Address
//    public static final String KPI_SOURCING_ADDRESS1 = "100 Kenai St # 208";
//    public static final String KPI_SOURCING_CITY = "WHITTIER";
//    public static final String KPI_SOURCING_STATE_CODE = "AK";
//    public static final String KPI_SOURCING_ZIP_CODE = "99693";
//
//    //TV Appointment - Address to show appointment list
//    public static final String TV_APPOINTMENT_ADDRESS1 = "12618 LAKE VISTA DR";
//    public static final String TV_APPOINTMENT_CITY = "GIBSONTON";
//    public static final String TV_APPOINTMENT_STATE_CODE = "FL";
//    public static final String TV_APPOINTMENT_ZIP_CODE = "33534";
//
//    //TV Appointment - Address to show No appointments
//    public static final String NO_APPOINTMENT_ADDRESS1 = "10195 SIERRA AVE";
//    public static final String NO_APPOINTMENT_CITY = "FONTANA";
//    public static final String NO_APPOINTMENT_STATE_CODE = "CA";
//    public static final String NO_APPOINTMENT_ZIP_CODE = "92335";
//
//    //Sparkpost Webhook API
//    public static final String SPARKPOST_USERNAME = System.getenv("SPARKPOST_USERNAME");
//    public static String SPARKPOST_PASSWORD = System.getenv("SPARKPOST_PASSWORD");
//
//    //QA account
//    public static final String QA_USERNAME = System.getenv("QA_USERNAME");
//    public static final String QA_PASSWORD = System.getenv("QA_PASSWORD");
//
//    // AWS S3 - EU warranties
//    public static String S3_EU_WARRANTY_ACCESS_KEY = System.getenv("S3_EU_WARRANTY_ACCESS_KEY");
//    public static String S3_EU_WARRANTY_SECRET_ACCESS_KEY = System.getenv("S3_EU_WARRANTY_SECRET_ACCESS_KEY");
//    public static String S3_EU_WARRANTY_REGION = System.getenv("S3_EU_WARRANTY_REGION");
//
//    // Toggle page
//    public static String TOGGLE_APPLICATION_URL_1 = "";
//    public static String TOGGLE_APPLICATION_URL_2 = "";
//
//    //IDC for Walmart
//    public static String WALMART_HUB_URL = "";
//    public static String WALMART_CLAIMS_URL = "";
//
//    //Retailer
//    public static final String SUBSCRIP_FOR_LRN_CLAIM = "subscrip_014704437161";
//
//    //Authentication info for HA services API
//    public static final String HA_GRANT_TYPE = "client_credentials";
//    public static final String HA_CONTENT_TYPE = "application/x-www-form-urlencoded";
//    public static final String HA_G_RECAPTCHA_RESPONSE = System.getenv("HA_G_RECAPTCHA_RESPONSE");
//    public static final String HA_AUTHORIZATION = System.getenv("HA_AUTHORIZATION");
//
//    //Authentication info for Warranty Creation service
//    public static String WARRANTY_CREATION_AUTHORIZATION = System.getenv("WARRANTY_CREATION_AUTHORIZATION_DEV");
//
//    //Purchased warranties by API
//    public static final String SE_ZIP_CODE = "163 91";
//    public static final String SE_CITY = "LUNDA";
//    public static final String SE_ADDRESS = "AB Fagerstagatan 18 B";
//    public static final String DIRECT_MONTHLY_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/direct_monthly_phone_payload.json";
//    public static final String SWEDEN_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/se_phone_warranty_payload.json";
//    public static final String AMAZON_EU_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/amazon_eu_warranty_payload.json";
//    public static final String WALMART_ONLINE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/walmart_online_payload.json";
//    public static final String WALMART_STORE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/walmart_store_payload.json";
//    public static final String SPAIN_UPFRONT_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/es_warranty_payload.json";
//    public static final String SAM_STORE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/sam_store_payload.json";
//    public static final String TELENOR_NORWAY_1_NONSCREEN_MONTHLY_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/telenor_norway1_non_screen_monthly_phone_payload.json";
//    public static final String TELENOR_NORWAY_2_SCREEN_MONTHLY_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/telenor_norway2_screen_monthly_phone_payload.json";
//    public static final String TELENOR_NORWAY_WARRANTY_TOKEN_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/telenor_norway_waranty_token_payload.json";
//    public static final String TELENOR_SUBMIT_CLAIM_SERVISES_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/partner_portal/submit_claim_payload.json";
//    public static final String THREEUK_MONTHLY_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/3uk_monthly_phone_payload.json";
//    public static final String HIKARI_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/hikari_payload.json";
//    public static final String BOSE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/bose_payload.json";
//    public static final String EMC_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/emc_phone_payload.json";
//    public static final String BH_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/bh_warranty_payload.json";
//    public static final String COSTCO_CONCIERGE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/costco_concierge_payload.json";
//    public static final String DENMARK_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/dk_warranty_payload.json";
//    public static final String FINLAND_PHONE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/warranty_creation/fi_phone_warranty_payload.json";
//
//    //Depot API V2
//    public static final String DEPOT_API_V2_ORDER_ACKNOWLEDGEMENT_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/depot_api_v2/order_acknowledgement_payload.json";
//    public static final String DEPOT_API_V2_BOX_OUT_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/depot_api_v2/box_out_payload.json";
//    public static final String DEPOT_API_V2_CORE_RECEIVED_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/depot_api_v2/core_received_payload.json";
//    public static final String DEPOT_API_V2_CORE_AUDITED_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/depot_api_v2/core_audited_payload.json";
//    public static final String DEPOT_API_V2_REPAIR_STATUS_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/depot_api_v2/repair_status_payload.json";
//    public static final String DEPOT_API_V2_ORDER_COMPLETED_SUCCESSFUL_TYPE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/depot_api_v2/order_completed_successful_type_payload.json";
//    public static final String DEPOT_API_V2_ORDER_COMPLETED_BER_TYPE_PAYLOAD_PATH = RESOURCES_PATH + "payload_templates/depot_api_v2/order_completed_ber_type_payload.json";
//
//    //IMEI number
//    public static final String IMEI_NUMBER = "535645483269144";
//
//    //Order Tracking tool
//    public static final String SHIPMENT_PARCEL = "Parcel";
//    public static final String SHIPMENT_FREIGHT_SCHEDULED = "Freight Scheduled";
//    public static final String SHIPMENT_FREIGHT_NOT_SCHEDULED = "Freight Not Scheduled";
//
//    public static final String SYNC_EMAIL_PAYLOAD = RESOURCES_PATH + "payload_templates/sync_email_payload.json";
//    public static final String PASSWORD_SERVICE_PAYLOAD = RESOURCES_PATH + "payload_templates/password_service_payload.json";
//
//    public static final String BULK_CLAIM_PAYLOAD = RESOURCES_PATH + "payload_templates/bulk_claim_payload.json";
//
//    //TV Replacement API
//    public static final String TV_REPLACEMENT_CREATE_OFFER_PAYLOAD = RESOURCES_PATH + "payload_templates/tv_replacement_create_offer_payload.json";
//    public static final String TV_REPLACEMENT_CANCEL_OFFER_PAYLOAD = RESOURCES_PATH + "payload_templates/tv_replacement_cancel_offer_payload.json";
//    public static final String TV_REPLACEMENT_ACCEPT_OFFER_PAYLOAD = RESOURCES_PATH + "payload_templates/tv_replacement_accept_offer_payload.json";
//
//    //TV Appointment API
//    public static final String TV_APPOINTMENT_CREATE_NEW_APPOINTMENT_PAYLOAD = RESOURCES_PATH + "payload_templates/tv_appointment_create_new_appointment_payload.json";
//
//    //TV Order Tracking API
//    public static final String TV_ORDER_TRACKING_UPDATE_ORDER_PAYLOAD = RESOURCES_PATH + "payload_templates/tv_order_tracking_update_order_payload.json";
//    public static final String TV_ORDER_TRACKING_CREATE_TRACKING_INFO_PAYLOAD = RESOURCES_PATH + "payload_templates/tv_order_tracking_create_tracking_info_payload.json";
//    public static final String TV_ORDER_TRACKING_CREATE_ORDER_MANUAL_PAYLOAD = RESOURCES_PATH + "payload_templates/tv_order_tracking_create_order_manual_payload.json";
//
//    // Pop Upload InitiateMediaManager API
//    public static final String Initiate_Media_Manager = RESOURCES_PATH + "payload_templates/initiate_media_Manager.json";
//    public static final String Initiate_Media_Manager_Single_Media = RESOURCES_PATH + "payload_templates/initiate_media_Manager_Single_Media.json";
//    public static final String Initiate_Media_Manager_Two_Media = RESOURCES_PATH + "payload_templates/initiate_media_Manager_Two_Media.json";
//    public static final String retrieve_media_upload_urls = RESOURCES_PATH + "payload_templates/retrieve_media_upload_urls.json";
//    public static final String retrieve_media_upload_status = RESOURCES_PATH + "payload_templates/retrieve_media_upload_status.json";
//    public static final String TRANSFER_WARRANTY_PAYLOAD = RESOURCES_PATH + "payload_templates/transfer_warranty_payload.json";
//    public static final String UPLOAD_MEDIA_TEMPLATE = "MEDIA_MANAGER_INITIATE_V1_en_US";
//
//    //TECHDATA FTP info
//    public static final String SFTP_HOST = "62.225.34.75";
//    public static final int SFTP_PORT = 22;
//    public static final String SFTP_USERNAME = "SquareTradeQ";
//    public static final String SFTP_PASSWORD = "uksjHaAOYPBI";
//    public static final String TECHDATA_DEV_FILE = FILE_UPLOAD_PATH + "Desadv_shortClaimID_Timestamp.xml";
//    public static final String TECHDATA_POD_BOXOUT_FINALDEL_FILE = FILE_UPLOAD_PATH + "POD_STATUS_shortClaimID_Timestamp_BOXOUT_FINALDEL.xml";
//    public static final String TECHDATA_POD_BOXOUT_PICKEDUP_FILE = FILE_UPLOAD_PATH + "POD_STATUS_shortClaimID_Timestamp_BOXOUT_PICKEDUP.xml";
//    public static final String TECHDATA_POD_INBOUND_FINALDEL_FILE = FILE_UPLOAD_PATH + "POD_STATUS_shortClaimID_Timestamp_INBOUND_FINALDEL.xml";
//    public static final String TECHDATA_POD_INBOUND_PICKEDUP_FILE = FILE_UPLOAD_PATH + "POD_STATUS_shortClaimID_Timestamp_INBOUND_PICKEDUP.xml";
//
//    //GENERAL FTP info
//    public static String GENERAL_SFTP_HOST = "";
//    public static final int GENERAL_SFTP_PORT = 22;
//    public static  String GENERAL_SFTP_USERNAME = "";
//    public static  String GENERAL_SFTP_PASSWORD = "";
//
//    //Informatica info
//    public static final String INFORMATICA_USERNAME_STAGE4 = "squaretrade_qa2";
//    public static final String INFORMATICA_PASSWORD_STAGE4 = "Squaretrade3";
//    public static final String INFORMATICA_USERNAME_STAGE_LOAD = "qa-team";
//    public static final String INFORMATICA_PASSWORD_STAGE_LOAD = "Squaretrade1";
//    public static final String INFORMATICA_USERNAME_DEV = "qa-team-dev";
//    public static final String INFORMATICA_PASSWORD_DEV = "Squaretrade1";
//
//    public static final String INFORMATICA_BULK_API_FILE_Raw_LOG_LOAD_JOB_PATH = "/BulkAPI_Raw_Log_Load/tfd_bulk_api_file_raw_log_load";
//    public static final String INFORMATICA_GENERIC_WCS_PAYLOAD_GENERATION_JOB_PATH = "/WIC_Payload_Generation/mct_generic_wcs_payload_generation";
//    public static final String INFORMATICA_UPDATE_ACKNOWLEDGED_JOB_PATH = "/BulkAPI_Update_Response/tfd_update_acknowledged";
//
//    //Media Manager
//    // Appsteam db account
//    public static String CLAIM_FILING_USERNAME_DEV = System.getenv("CLAIM_FILING_USERNAME_DEV");
//    public static String CLAIM_FILING_PASSWORD_DEV = System.getenv("CLAIM_FILING_PASSWORD_DEV");
//    public static String POP_SERVICE_USERNAME_DEV = System.getenv("POP_SERVICE_USERNAME_DEV");
//    public static String POP_SERVICE_PASSWORD_DEV = System.getenv("POP_SERVICE_PASSWORD_DEV");
//    public static String CLAIM_FILING_USERNAME_QA= System.getenv("CLAIM_FILING_USERNAME_QA");
//    public static String CLAIM_FILING_PASSWORD_QA = System.getenv("CLAIM_FILING_PASSWORD_QA");
//    public static String POP_SERVICE_USERNAME_QA = System.getenv("POP_SERVICE_USERNAME_QA");
//    public static String POP_SERVICE_PASSWORD_QA = System.getenv("POP_SERVICE_PASSWORD_QA");
//
//    // ID customer service
//    public static String IDENTITYPROCESSING_USERNAME = System.getenv("IDENTITYPROCESSING_USERNAME");
//    public static String IDENTITYPROCESSING_PASSWORD = System.getenv("IDENTITYPROCESSING_PASSWORD");
//
//    // Warranty-das API
//    public static final String WARRANTY_DAS_CREATE_PERSON_BY_EMAIL_PAYLOAD = RESOURCES_PATH + "payload_templates/warranty_das_create_person_by_email.json";
//
//    // Telenor Login API
//    public static final String TELENOR_PROVISIONAL_TOKEN_PAYLOAD = RESOURCES_PATH + "payload_templates/telenor_provisional_token_payload.json";
//    public static final String TELENOR_UPDATE_PERSON_EMAIL_PAYLOAD = RESOURCES_PATH + "payload_templates/telenor_update_person_email_payload.json";
//
//    // ID customer service
//    public static String ID_CUSTOMER_SERVICE_USERNAME = System.getenv("ID_CUSTOMER_SERVICE_USERNAME");
//    public static String ID_CUSTOMER_SERVICE_STAGE_PASSWORD = System.getenv("ID_CUSTOMER_SERVICE_STAGE_PASSWORD");
//    public static String ID_CUSTOMER_SERVICE_TERRA_PASSWORD = System.getenv("ID_CUSTOMER_SERVICE_TERRA_PASSWORD");
}

