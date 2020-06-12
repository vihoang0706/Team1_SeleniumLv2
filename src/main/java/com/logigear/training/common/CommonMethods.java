package com.logigear.training.common;


//import com.api.automation_services.AutomationServices;
//import com.api.automation_services.ValidationAPIServices;
//import com.api.email_services.EmailSendingServices;
//import com.api.warranty_creation_services.InformaticaServices;
//import com.aventstack.extentreports.ExtentTest;
import com.logigear.training.utilities.Utility;
//import com.pages.EU_site.RegisterPage;
//import com.pages.appointments_parts_status_page.StatusPage;
//import com.pages.buyer_center.*;
//import com.pages.faca.*;
//import com.pages.facv3.*;
//import com.pages.idc.*;
//import com.pages.salesforce.*;
//import com.pages.third_party.GMail.EMailDetailPage;
//import com.pages.tma_portal.portal.TMAPortalCustomerAndPaymentDetailsPage;
//import com.pages.tma_portal.portal.TMAPortalDeviceInformationPage;
//import com.pages.tma_portal.portal.TMAPortalLoginPage;
//import com.pages.tma_portal.portal.TMAPortalThankYouPage;
//import com.pages.buyer_center.BuyerCenterSmartphoneActivationPage;
//import com.utility.ReadingFromDB;
//import com.utility.Utility;
//import com.utility.database.Database;
//import com.utility.database.DatabaseValidation;
//import com.utility.database.QueryDatabase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//
//import javax.mail.Message;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.*;

import static com.logigear.training.utilities.Utility.*;

//import static com.common.GlobalVariables.*;
//import static org.springframework.util.StreamUtils.BUFFER_SIZE;

public class CommonMethods extends Utility {

    /*----- Initiate GMailHomePage classes start here -----*/
    //EMailDetailPage gmailEmailDetailPage = null;

    //BuyerCenterHomePage buyerCenterHomePage = null;
//    BuyerCenterProductLandingPage buyerCenterProductLandingPage = null;
//    BuyerCenterCheckOutPage checkoutPage = null;
//    BuyerCenterThankYouPage thankYouPage = null;
//    BuyerCenterLoginAndSetupPage buyerCenterLoginAndSetupPage = null;
//    BuyerCenterAllPlansPage buyerCenterAllPlansPage = null;
//    BuyerCenterCheckOutPage buyerCenterCheckOutPage = null;
//    BuyerCenterMyWarrantiesListPage buyerCenterMyWarrantiesListPage = null;
//    BuyerCenterPlanDetailsPage buyerCenterPlanDetailsPage = null;
//    BuyerCenterSmartphoneActivationPage buyerCenterSmartphoneActivationPage = null;
//
//    IDCCreateNewPasswordPage idcCreateNewPasswordPage = null;
//    IDC2ChoosePlansPage idc2ChoosePlansPage = null;
//    IDC2Step1Page idc2Step1Page = null;
//    IDC2Step2Page idc2Step2Page = null;
//    IDC2SetupAccountEmailPage idc2SetupAccountEmailPage = null;
//    private Message emailMessage;
//    BuyerCenterCreatePasswordPage buyerCenterCreatePasswordPage = null;
//
//    SalesforceLoginPage salesforceLoginPage = null;
//    SalesforceHomePage salesforceHomePage = null;
//    SalesforceWarrantyDetailPage salesforceWarrantyDetailPage = null;
//    SalesforceClaimDetailPage salesforceClaimDetailPage = null;
//    SalesforceProofOfPurchaseVerificationPage proofOfPurchaseVerification = null;
//    SalesforceUpdateWarrantyPage salesforceUpdateWarrantyPage = null;
//    SalesforceSpecialistTriagePage salesforceSpecialistTriagePage = null;
//    SalesforceConfirmationPage confirmationPage = null;
//    SalesforceUpdateClaimPage salesforceUpdateClaimPage = null;
//    SalesforceDenyClaimPage salesforceDenyClaimPage = null;
//    SalesforceSuccessDenialPage salesforceSuccessDenialPage = null;
//    SalesforceFileClaimPage salesforceFileClaimPage = null;
//    SalesforceConfirmPersonAndItemInformationPage salesforceConfirmPersonAndItemInformationPage = null;
//    SalesforceClaimFiledPage salesforceClaimFiledPage = null;
//    SalesforceSubmitClaimForProcessingPage salesforceSubmitClaimForProcessingPage = null;
//    SalesforceApproveClaimPage salesforceApproveClaimPage = null;
//    SalesforceProofOfPurchaseVerificationPage salesforceProofOfPurchaseVerificationPage = null;
//    SalesforceMarkResolutionCompletePage salesforceMarkResolutionCompletePage = null;
//    SalesforceRecordDepotConfirmationPage salesforceRecordDepotConfirmationPage = null;
//    SalesforceRecordAuditResultsPage salesforceRecordAuditResultsPage = null;
//    SalesforceConfirmSignedAffidavitPage salesforceConfirmSignedAffidavitPage = null;
//    SalesforceRecordShippingStatusPage salesforceRecordShippingStatusPage = null;
//    SalesforceGenerateCouponCodePage salesforceGenerateCouponCodePage = null;
//    SalesforceInvalidateProofOfPurchasePage salesforceInvalidateProofOfPurchasePage = null;
//    SalesforceTicketDetailPage salesforceTicketDetailPage = null;
//    SalesforceCancelWarrantyPage salesforceCancelWarrantyPage = null;
//    SalesforceClaimApprovalPage salesforceClaimApprovalPage = null;
//    SalesforceResendWarrantyContractPage salesforceResendWarrantyContractPage = null;
//
//    FACASubmitPage0Page facaSubmitPage0Page = null;
//    FACAUpdateProductInformationPage facaUpdateProductInformationPage = null;
//    FACAUpdateShippingAddressPage facaUpdateShippingAddressPage = null;
//    FACASubmitPage1Page facaSubmitPage1Page = null;
//    FACAResolutionPage facaResolutionPage = null;
//    FACADeductiblePage facaDeductiblePage = null;
//
//    FACV3IdentifyMyDevicePage facv3IdentifyMyDevicePage = null;
//    FACV3ProblemCodesPage facv3ProblemCodesPage = null;
//    FACV3ProblemQuestionPage facv3ProblemQuestionPage = null;
//    FACV3IMEIPage facv3IMEIPage = null;
//    FACV3ConfirmAddressPage facv3ConfirmAddressPage = null;
//    FACV3SelectShippingAddressPage facv3SelectShippingAddressPage = null;
//    FACV3AdvancedExchangeConfirmationPage facv3AEConfirmationPage = null;
//    FACv3DeductiblePage facv3DeductiblePage = null;
//    FACV3PaymentMethodSelectionPage facv3PaymentMethodSelectionPage = null;
//    FACV3ResolutionForPhonePage facv3ResolutionForPhonePage = null;
//    FACV3AdvancedExchangeTermsAcknowledgedPage facv3AETermsAcknowledgedPage = null;
//    FACV3LocalRepairShopLocationPage facv3LRShopLocationPage = null;
//    FACV3ConfirmModelPage facv3ConfirmModelPage = null;
//    FACV3ThankYouPage facv3ThankYouPage = null;
//    FACV3PlanCoveragePage facv3PlanCoveragePage = null;
//
//    TMAPortalLoginPage tmaPortalLoginPage = null;
//    TMAPortalDeviceInformationPage tmaPortalDeviceInformationPage = null;
//    TMAPortalCustomerAndPaymentDetailsPage tmaPortalCustomerAndPaymentDetailsPage = null;
//    TMAPortalThankYouPage tmaPortalThankYouPage = null;
//
//    RegisterPage registerPage = null;
//    StatusPage statusPage = null;
//
//    ReadingFromDB readingFromDB = new ReadingFromDB();
//    QueryDatabase queryDatabase = new QueryDatabase();
//    Database database = new Database();
//    ValidationAPIServices validationAPIServices = new ValidationAPIServices();
//    AutomationServices automationServices = new AutomationServices();
//    private DatabaseValidation databaseValidation = new DatabaseValidation();
//    EmailSendingServices emailSendingServices = new EmailSendingServices();
//    InformaticaServices informaticaServices = new InformaticaServices();

    /*----- Initiate GMailHomePage classes end here -----*/

//    public static void updatePartIDOnSalesforce(Hashtable<String, String> data, String warrantyID, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("updatePartIDOnSalesforce...start");
//            SalesforceHomePage salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(warrantyID, logTest);
//
//            logInfo(logTest, "Update part ID");
//            SalesforceWarrantyDetailPage salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnUpdatePartIDActionLink(logTest);
//
//            SalesforceUpdatePartIDPage salesforceUpdatePartIDPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdatePartIDPage.class);
//            salesforceUpdatePartIDPage.updatePartID(data.get("Carrier"), data.get("Manufacturer"), data.get("Model"), data.get("Color"), data.get("Memory"), logTest);
//        } catch (Exception e) {
//            log4j.error("updatePartIDOnSalesforce method - ERROR - " + e);
//            logException(logTest, "updatePartIDOnSalesforce method - ERROR", e);
//        }
//    }
//
//    public static void downloadFile(ExtentTest logTest, String fileURL, String fileName, String extension) throws IOException {
//        try {
//            logInfo(logTest, "Download file from Cloud Storage: " + fileURL);
//            URL url = new URL(fileURL);
//            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//            int responseCode = httpConn.getResponseCode();
//
//            // always check HTTP response code first
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                String disposition = httpConn.getHeaderField("Content-Disposition");
//                String contentType = httpConn.getContentType();
//                int contentLength = httpConn.getContentLength();
//
//                logInfo(logTest, "Content-Type = " + contentType);
//                logInfo(logTest, "Content-Disposition = " + disposition);
//                logInfo(logTest, "Content-Length = " + contentLength);
//
//                // Create file
//                InputStream inputStream = httpConn.getInputStream();
//                File newFile = new File(reportLocation + "" + fileName + "" + extension);
//                newFile.createNewFile();
//
//                // opens an output stream to save into file
//                FileOutputStream outputStream = new FileOutputStream(newFile.getPath());
//
//                int bytesRead = -1;
//                byte[] buffer = new byte[BUFFER_SIZE];
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//
//                outputStream.close();
//                inputStream.close();
//                httpConn.disconnect();
//
//                if (newFile.length() > 0)
//                    logPass(logTest, "File is downloaded successfully: " + newFile.getPath());
//                else
//                    logFail(logTest, "File is empty: " + newFile.getPath());
//            } else {
//                logFail(logTest, "No file to download. Server replied HTTP code: " + responseCode);
//            }
//        } catch (Exception e) {
//            log4j.error("downloadFile method - ERROR: " + e);
//            logException(logTest, "downloadFile method - ERROR: ", e);
//        }
//    }
//
//    public static void openLRTools(ExtentTest logTest) throws IOException {
//        try {
//            navigateToTestSite(logTest, ST_LR_TOOLS_URL);
//        } catch (Exception e) {
//            log4j.error("dopen LR tool - ERROR: " + e);
//            logException(logTest, "open LR tool - ERROR: ", e);
//        }
//    }
//
//    /*----------- Common Methods start here -----------*/
//    public HashMap getEmailInfo(String templateID, String from, String templateSubject, ExtentTest logTest) throws IOException {
//        try {
//            HashMap<String, String> emailInfo = new HashMap<>();
//
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                emailInfo.put("from", from);
//                emailInfo.put("subject", templateSubject);
//                return emailInfo;
//            } else {
//                HashMap templateInfo = emailSendingServices.getTemplateMetaData(logTest, templateID);
//
//                // Remove parameters in email subject
//                StringBuilder sb = new StringBuilder(templateInfo.get("emailSubject").toString());
//                int index = sb.indexOf("${");
//                if (index != -1)
//                    sb.delete(index, sb.length());
//                templateSubject = sb.toString().trim();
//
//                emailInfo.put("from", templateInfo.get("emailFrom").toString());
//                emailInfo.put("subject", "[" + ENVIRONMENT + "][" + templateInfo.get("id") + "]" + "[" + templateInfo.get("buildRef") + "] " + templateSubject);
//
//                return emailInfo;
//            }
//        } catch (Exception e) {
//            log4j.error("getEmailInfo method - ERROR - " + e);
//            logException(logTest, "getEmailInfo method - ERROR", e);
//        }
//
//        return null;
//    }
//
//    /**
//     * @param to
//     * @param subject
//     * @param logTest
//     * @ActionName: confirmEmailAndFinishSetUpPlan(arg1, arg2, arg3)
//     * @CreatedDate: 2/23/2017
//     * @Author: quoc.le
//     */
//    public void confirmEmailAndFinishSetUpPlan(String to, String subject, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Confirm the email and finish set up of the plan...starts");
//
//            logInfo(logTest, "Wait for Setup Account emil sent to user");
//            Message message = emailActions.verifyEmailExist(null, to, subject, false, logTest);
//
//            logInfo(logTest, "Click on 'Complete Set Up' button");
//            gmailEmailDetailPage = PageFactory.initElements(Utility.getDriver(), EMailDetailPage.class);
//            gmailEmailDetailPage.clickCompleteSetupButton(message, logTest);
//
//            log4j.info("Confirm the email and finish set up of the plan...ends");
//        } catch (Exception e) {
//            log4j.error("confirmEmailAndFinishSetUpPlan - ERROR - " + e);
//            logException(logTest, "confirmEmailAndFinishSetUpPlan - ERROR ", e);
//        }
//    }
//
//    /**
//     * @param to
//     * @param templateEmail
//     * @param logTest
//     * @ActionName: chooseTVReplacement(arg1, arg2, arg3)
//     * @CreatedDate: 4/27/2017
//     * @Author: quoc.le
//     */
//    public void chooseTVReplacement(String to, String templateEmail, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Choose TV Replacement...starts");
//
//            logInfo(logTest, "Wait for Choose TV Replacement email sent to user");
//            HashMap emailInfo = getEmailInfo(templateEmail, "", "", logTest);
//            Message message = emailActions.verifyEmailExist(emailInfo.get("from").toString(), to, emailInfo.get("subject").toString(), false, logTest);
//
//            logInfo(logTest, "Click on 'Click here' link in email");
//            gmailEmailDetailPage = PageFactory.initElements(Utility.getDriver(), EMailDetailPage.class);
//            gmailEmailDetailPage.clickLinkChooseTVReplacement(message, logTest);
//
//            log4j.info("Choose TV Replacement...ends");
//        } catch (Exception e) {
//            log4j.error("chooseTVReplacement method - ERROR - " + e);
//            logException(logTest, "chooseTVReplacement method - ERROR ", e);
//        }
//    }
//
//    /**
//     * @param to
//     * @param templateEmail
//     * @param logTest
//     * @ActionName: chooseTVReplacement(arg1, arg2, arg3)
//     * @CreatedDate: 4/27/2017
//     * @Author: quoc.le
//     */
//    public void uploadMedia(String to, String templateEmail, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Upload Media...starts");
//
//            logInfo(logTest, "Wait for Upload Media email sent to user");
//            HashMap emailInfo = getEmailInfo(templateEmail, "", "", logTest);
//            Message message = emailActions.verifyEmailExist(emailInfo.get("from").toString(), to, emailInfo.get("subject").toString(), false, logTest);
//
//            logInfo(logTest, "Click on 'Upload Media' link in email");
//            gmailEmailDetailPage = PageFactory.initElements(Utility.getDriver(), EMailDetailPage.class);
//            gmailEmailDetailPage.clickLinkUploadMedia(message, logTest);
//
//            log4j.info("Upload Media...ends");
//        } catch (Exception e) {
//            log4j.error("uploadMedia method - ERROR - " + e);
//            logException(logTest, "uploadMedia method - ERROR ", e);
//        }
//    }
//
//    /**
//     * @ActionName: gotoWarrantyCheckoutPage
//     * @CreatedDate: 2017/12/11
//     * @Author: vinh.ly
//     */
//    public void gotoWarrantyCheckoutPage(Hashtable<String, String> data, ExtentTest logTest) throws IOException {
//        try {
//            String deviceType = data.get("DeviceType").toLowerCase();
//
//            log4j.debug("Go to warranty checkout page...starting");
//            buyerCenterHomePage = PageFactory.initElements(Utility.getDriver(), BuyerCenterHomePage.class);
//            navigateToTestSite(logTest, ST_BASE_URL);
//
//            //Set the optimizelyOptOut value into cookie
//            ((JavascriptExecutor) Utility.getDriver()).executeScript("document.cookie=\"optimizelyOptOut=true\"");
//
//            logInfo(logTest, "Select device type on menu bar");
//            buyerCenterHomePage.clickDeviceTypeTab(deviceType, logTest);
//
//            //If the device is other than smartphone, laptop, ipad, applicance and TV, do one more step to select the specific device type from combobox "Select Item"
//            if (!(deviceType.equals("smartphones") || deviceType.equals("iphones") || deviceType.equals("familyplans") || deviceType.equals("monthly smartphone") || deviceType.equals("laptops") || deviceType.equals("ipads") || deviceType.equals("appliances") || deviceType.equals("televisions") || deviceType.equals("premium smartphone") || deviceType.equals("monthly smartphone family") || deviceType.equals("premium smartphone family"))) {
//                buyerCenterAllPlansPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterAllPlansPage.class);
//                buyerCenterAllPlansPage.selectDeviceByName(deviceType, logTest);
//                waitForControl(buyerCenterAllPlansPage.button_BuyProtection);
//            }
//
//            logInfo(logTest, "Select a price and deductible(if any) and plan specified years for warranty");
//            //Handle for upfront and monthly smartphone
//            if (deviceType.equals("smartphones") || deviceType.equals("iphones") || deviceType.equals("familyplans") || deviceType.equals("monthly smartphone") || deviceType.equals("premium smartphone") || deviceType.equals("monthly smartphone family") || deviceType.equals("premium smartphone family")) {
//                buyerCenterProductLandingPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterProductLandingPage.class);
//                if (deviceType.equals("smartphones") || deviceType.equals("iphones")) {
//                    buyerCenterProductLandingPage.selectNewPlan(deviceType, 1, data.get("Plan"), logTest);
//
//                } else if (deviceType.equals("familyplans")) {
//                    buyerCenterProductLandingPage.selectNewPlan(deviceType, 2, data.get("Plan"), logTest);
//                } else {
//                    if (deviceType.equals("monthly smartphone") || deviceType.equals("premium smartphone")) {
//                        if (data.get("Number Of Plan") != null) {
//                            int numberOfPlan = Integer.valueOf(data.get("Number Of Plan"));
//                            buyerCenterProductLandingPage.selectNewPlan(deviceType, numberOfPlan, null, logTest);
//                        }
//                    } else
//                        buyerCenterProductLandingPage.selectNewPlan(deviceType, 0, null, logTest);
//
//                    buyerCenterProductLandingPage.clickBuyProtectionMonthlyPlanButton(logTest);
//
//                    if (deviceType.equals("monthly smartphone"))
//                        buyerCenterProductLandingPage.handleSmartphoneUpsellPopup("nothank", logTest);
//
//                    if (deviceType.equals("monthly smartphone family"))
//                        buyerCenterProductLandingPage.handleSmartphoneFamilyUpsellPopup("nothank", logTest);
//                }
//
//                //Handle the product landing page for categories other than phones (categories listed above)
//            } else {
//                buyerCenterProductLandingPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterProductLandingPage.class);
//
//                // if device is ipad, there is no price to select, just choose iPad model
//                if (deviceType.equals("ipads")) {
//                    if (data.get("model") != null)
//                        buyerCenterProductLandingPage.selectIpadModel(data.get("model"), logTest);
//                } else {
//                    // Select the price of other devices
//                    if (data.get("Device price") != null)
//                        buyerCenterProductLandingPage.selectPrice(data.get("Device price"), logTest);
//
//                }
//
//                //For Electronics only, Select ADH warranty and there is no deductible selector
//                if (deviceType.equals("electronics"))
//                    buyerCenterAllPlansPage.clickButtonElectronicsBuyProtection(logTest);
//
//                //Select plans
//                if (data.get("Plan") != null)
//                    buyerCenterProductLandingPage.selectPlan(deviceType, data.get("Plan"), logTest);
//
//                //Select deductible
//                if (deviceType.equals("laptops") || deviceType.equals("tablets") || deviceType.equals("ipads") || deviceType.equals("fitnesstracker") || deviceType.equals("smartwatch")) {
//                    if (data.get("Deductible") != null)
//                        buyerCenterProductLandingPage.selectDeductible(data.get("Deductible"), logTest);
//                }
//
//                //Click Buy Protection button
//                buyerCenterProductLandingPage.clickButtonBuyProtection(logTest);
//            }
//
//            log4j.info("Go to warranty checkout page...end");
//        } catch (Exception e) {
//            log4j.error("gotoWarrantyCheckoutPage method - ERROR - " + e);
//            logException(logTest, "gotoWarrantyCheckoutPage method - ERROR", e);
//        }
//    }
//
//    /**
//     * @ActionName: Buy a warranty
//     * @CreatedDate: 6/9/2017
//     * @Author: quoc.le
//     */
//
//    public String buyWarranty(Hashtable<String, String> data, String emailAddress, boolean doesAgeBack, ExtentTest logTest) throws IOException {
//        String warrantyID = "";
//        String deviceType = data.get("DeviceType").toLowerCase();
//        String purchaseLocation = null;
//        String newOrOldPhone = data.get("For new device");
//        String couponCode = "";
//        logInfo(logTest, "Device Type: " + deviceType);
//
//        try {
//            //Generate Coupon Code from Salesforce
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                couponCode = generateCouponCodeOnSalesforce(logTest);
//            }
//
//            // Go to checkout page
//            gotoWarrantyCheckoutPage(data, logTest);
//
//            // Input billing information
//            logInfo(logTest, "Enter information for checking out warranty");
//            checkoutPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterCheckOutPage.class);
//            checkoutPage.inputBillingInfo(deviceType, newOrOldPhone, emailAddress, logTest);
//
//            // Input payment information
//            if (!ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                checkoutPage.inputPaymentInfo(logTest);
//            } else {
//                checkoutPage.inputCouponCode(couponCode, logTest);
//                checkoutPage.inputPaymentInfo(data.get("CreditCardType"), logTest);
//            }
//
//            // Click button Submit order
//            checkoutPage.clickButtonSubmit(logTest);
//
//            // Wait for thank you page displaying
//            thankYouPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterThankYouPage.class);
//            waitForControl(thankYouPage.label_ThankYouMessage);
//
//            // Get warranty ID
//            logInfo(logTest, "Get warranty ID");
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                warrantyID = getRPIDProduction(emailAddress, logTest);
//
//            } else {
//                warrantyID = validationAPIServices.getWarrantyInfoByEmail(emailAddress, 0, logTest).get("id").toString();
//            }
//
//            // Age back on all other environments other than production
//            if (doesAgeBack && !ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                logInfo(logTest, "Age back warranty: " + warrantyID);
//                automationServices.ageBackWarranty(warrantyID, AGE_BACK_DAYS, logTest);
//            }
//
//            if (!ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                logInfo(logTest, "Update phone number type: " + PHONE_TYPE);
//                String personID = validationAPIServices.getPersonInfoByEmail(emailAddress, logTest).get("id").toString();
//                validationAPIServices.updatePersonInfo(personID, "phoneNumberType", PHONE_TYPE.toUpperCase(), logTest);
//            }
//
//            log4j.info("Buy warranty...ends");
//        } catch (Exception e) {
//            log4j.error("buyWarranty method - ERROR - " + e);
//            logException(logTest, "buyWarranty method - ERROR", e);
//        }
//        logInfo(logTest, "Warranty Id: " + warrantyID);
//        return warrantyID;
//    }
//
//    /**
//     * Buy monthly smartphone, device type "monthly smartphone" or "premium smartphone"
//     * @param data
//     * @param emailAddress
//     * @param doesAgeBack
//     * @param logTest
//     * @return
//     * @throws IOException
//     */
//    public String buyMonthlySmartphoneWarranty(Hashtable<String, String> data, String emailAddress, boolean doesAgeBack, ExtentTest logTest) throws IOException {
//        String warrantyID = "";
//        String deviceType = data.get("DeviceType").toLowerCase();
//        logInfo(logTest, "Device Type: " + deviceType);
//
//        try {
//            log4j.debug("buyMonthlySmartphoneWarranty...start");
//
//            logInfo(logTest, "Go to Smartphone Monthly Checkout page");
//            gotoWarrantyCheckoutPage(data, logTest);
//
//            logInfo(logTest, "Enter information for checking out warranty");
//            checkoutPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterCheckOutPage.class);
//            checkoutPage.inputBillingInfo(deviceType, null, emailAddress, logTest);
//            checkoutPage.inputPaymentInfo(CREDIT_CARD_NUMBER, CREDIT_CARD_EXPIRATION_DATE_MONTHLY_SMARTPHONE, CVV_NUMBER_FOR_MONTHLY_PHONE, logTest);
//
//            logInfo(logTest, "Click Place My Order button");
//            checkoutPage.clickButtonSubmit(logTest);
//
//            logInfo(logTest, "Wait for Thankyou page show");
//            thankYouPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterThankYouPage.class);
//            waitForControl(thankYouPage.label_ThankYouMessage);
//
//            logInfo(logTest, "Trigger informatica job");
//            informaticaServices.runInformaticaJobForMonthlyPurchase (logTest);
//
//            logInfo(logTest, "Get warranty Id");
//            warrantyID = validationAPIServices.getWarrantyInfoByEmail(emailAddress, 0, logTest).get("id").toString();
//
//            logInfo(logTest, "Warranty ID: " + warrantyID);
//
//            if (doesAgeBack) {
//                logInfo(logTest, "Age back warranty Id " + warrantyID);
//                validationAPIServices.ageBackWarranty(warrantyID, AGE_BACK_DAYS, logTest);
//            }
//
//            logInfo(logTest, "Update phone number type: " + PHONE_TYPE);
//            String personID = validationAPIServices.getPersonInfoByEmail(emailAddress, logTest).get("id").toString();
//            validationAPIServices.updatePersonInfo(personID, "phoneNumberType", PHONE_TYPE.toUpperCase(), logTest);
//
//            log4j.info("buyMonthlySmartphoneWarranty...end");
//        } catch (Exception e) {
//            log4j.error("buyMonthlySmartphoneWarranty method - ERROR - " + e);
//            logException(logTest, "buyMonthlySmartphoneWarranty method - ERROR", e);
//        }
//        return warrantyID;
//    }
//
//    public String buyMonthlySmartphoneFamilyWarranty(Hashtable<String, String> data, String emailAddress, boolean doesAgeBack, ExtentTest logTest) throws IOException {
//        String warrantyID = "";
//        String deviceType = data.get("DeviceType").toLowerCase();
//        String validPhoneNumber1 = data.get("PhoneNumber1");
//        String validPhoneNumber2 = data.get("PhoneNumber2");
//        String validPhoneNumber3 = data.get("PhoneNumber3");
//        String validPhoneNumber4 = data.get("PhoneNumber4");
//        logInfo(logTest, "Device Type: " + deviceType);
//
//        try {
//            log4j.debug("buyMonthlySmartphoneFamilyWarranty...start");
//
//            logInfo(logTest, "Go to Smartphone Family Monthly Checkout page");
//            gotoWarrantyCheckoutPage(data, logTest);
//
//            logInfo(logTest, "Enter information for checking out warranty");
//            checkoutPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterCheckOutPage.class);
//            checkoutPage.inputBillingInfo(deviceType, null, emailAddress, logTest);
//            checkoutPage.inputPaymentInfo(CREDIT_CARD_NUMBER, CREDIT_CARD_EXPIRATION_DATE_MONTHLY_SMARTPHONE, CVV_NUMBER_FOR_MONTHLY_PHONE, logTest);
//
//            logInfo(logTest, "Click Place My Order button");
//            checkoutPage.clickButtonSubmit(logTest);
//
//            logInfo(logTest, "Enter valid unique phone numbers for each fields");
//            buyerCenterSmartphoneActivationPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterSmartphoneActivationPage.class);
//            buyerCenterSmartphoneActivationPage.enterPhoneNumber(validPhoneNumber1, "1", logTest);
//            buyerCenterSmartphoneActivationPage.enterPhoneNumber(validPhoneNumber2, "2", logTest);
//            buyerCenterSmartphoneActivationPage.enterPhoneNumber(validPhoneNumber3, "3", logTest);
//            buyerCenterSmartphoneActivationPage.enterPhoneNumber(validPhoneNumber4, "4", logTest);
//
//            logInfo(logTest, "Click 'Activate Your Plan' button");
//            buyerCenterSmartphoneActivationPage.clickButtonActivateYourPlan(logTest);
//
//
//            sleep(WAIT_TIME * 2);
//            logInfo(logTest, "Trigger informatica job");
//            informaticaServices.runInformaticaJobForMonthlyPurchase(logTest);
//
//            logInfo(logTest, "Get warranty Id");
//            warrantyID = validationAPIServices.getWarrantyInfoByEmail(emailAddress, 0, logTest).get("id").toString();
//
//            logInfo(logTest, "Warranty ID: " + warrantyID);
//
//            if (doesAgeBack) {
//                logInfo(logTest, "Age back warranty Id " + warrantyID);
//                validationAPIServices.ageBackWarranty(warrantyID, AGE_BACK_DAYS, logTest);
//            }
//
//            logInfo(logTest, "Update phone number type: " + PHONE_TYPE);
//            String personID = validationAPIServices.getPersonInfoByEmail(emailAddress, logTest).get("id").toString();
//            validationAPIServices.updatePersonInfo(personID, "phoneNumberType", PHONE_TYPE.toUpperCase(), logTest);
//
//            log4j.info("buyMonthlySmartphoneWarranty...end");
//        } catch (Exception e) {
//            log4j.error("buyMonthlySmartphoneWarranty method - ERROR - " + e);
//            logException(logTest, "buyMonthlySmartphoneWarranty method - ERROR", e);
//        }
//        return warrantyID;
//    }
//
//    public String tmaBuyWarranty(Hashtable<String, String> data, String emailAddress, String imei, boolean doesAgeBack, ExtentTest logTest) throws IOException {
//        String warrantyID = "";
//        String deviceType = data.get("DeviceType").toLowerCase();
//        logInfo(logTest, "Device Type: " + deviceType);
//        try {
//            log4j.debug("Buy warranty...starting");
//
//            logInfo(logTest, "Navigated to: " + TMA_PORTAL_URL);
//            navigateToTestSite(logTest, TMA_PORTAL_URL);
//
//            //Set the optimizelyOptOut value into cookie
//            ((JavascriptExecutor) Utility.getDriver()).executeScript("document.cookie=\"optimizelyOptOut=true\"");
//
//            logInfo(logTest, "Login to tma portal site");
//            tmaPortalLoginPage = PageFactory.initElements(Utility.getDriver(), TMAPortalLoginPage.class);
//            tmaPortalLoginPage.logInToTMAPortal(logTest);
//
//            logInfo(logTest, "Input device information");
//            tmaPortalDeviceInformationPage = PageFactory.initElements(Utility.getDriver(), TMAPortalDeviceInformationPage.class);
//            tmaPortalDeviceInformationPage.tmaInputDeviceInformation(data, imei, logTest);
//
//            logInfo(logTest, "Enter contact information for checking out warranty");
//            tmaPortalCustomerAndPaymentDetailsPage = PageFactory.initElements(Utility.getDriver(), TMAPortalCustomerAndPaymentDetailsPage.class);
//            tmaPortalCustomerAndPaymentDetailsPage.inputContactInformation(emailAddress, logTest);
//
//            logInfo(logTest, "Enter payment entry");
//            tmaPortalCustomerAndPaymentDetailsPage.inputPaymentEntry(logTest);
//
//            logInfo(logTest, "Submit device information page");
//            tmaPortalCustomerAndPaymentDetailsPage.clickButtonSubmit(logTest);
//
//            logInfo(logTest, "Wait for thank you page");
//            tmaPortalThankYouPage = PageFactory.initElements(Utility.getDriver(), TMAPortalThankYouPage.class);
//            waitForPageLoaded();
//            waitForControl(tmaPortalThankYouPage.button_Submit);
//
//            warrantyID = validationAPIServices.getWarrantyInfoByEmail(emailAddress, 0, logTest).get("id").toString();
//            //warrantyID = queryDatabase.getRPID(emailAddress, logTest);
//            logInfo(logTest, "Warranty ID: " + warrantyID);
//
//            logInfo(logTest, "Age back the warranty");
//            // Age back on all other environments other than production
//            if (doesAgeBack && !ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                logInfo(logTest, "AgeBack warranty '" + warrantyID + "'");
//                automationServices.ageBackWarranty(warrantyID, AGE_BACK_DAYS, logTest);
//            }
//
//            log4j.info("Buy warranty...end");
//        } catch (Exception e) {
//            log4j.error("buyWarranty method - ERROR - " + e);
//            logException(logTest, "buyWarranty method - ERROR", e);
//        }
//        logInfo(logTest, "Warranty Id: " + warrantyID);
//        return warrantyID;
//    }
//
//    public String ageBackWarrantyOnSalesforce(String warrantyID, String itemType, String manufacturer, String model, ExtentTest logTest) throws IOException {
//        String warrantyStartDate = null;
//        try {
//            log4j.debug("Age back a warranty on salesforce...start");
//
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnUpdateWarrantyActionLink(logTest);
//
//            salesforceUpdateWarrantyPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateWarrantyPage.class);
//            warrantyStartDate = salesforceUpdateWarrantyPage.ageBackWarranty(itemType, manufacturer, model, logTest);
//
//            // It takes some time to refresh data in SF
//            sleep(5);
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            refreshPage();
//
//            log4j.debug("Age back a warranty on salesforce...end");
//        } catch (Exception e) {
//            log4j.error("agebackWarrantyOnSalesforce method - ERROR - " + e);
//            logException(logTest, "agebackWarrantyOnSalesforce method - ERROR", e);
//        }
//        return warrantyStartDate;
//    }
//
//    /* This method is used for updating the Warranty Term on Update Warranty Action Link in Salesforce. */
//    public void updatewarrantyPlan(String planTerm, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Updating warranty plan term on salesforce...start");
//
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnUpdateWarrantyActionLink(logTest);
//
//            salesforceUpdateWarrantyPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateWarrantyPage.class);
//            salesforceUpdateWarrantyPage.updateplanTerm(planTerm, logTest);
//
//            // It takes some time to refresh data in SF
//            sleep(5);
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            refreshPage();
//
//            log4j.debug("Updating warranty plan term on salesforce...end");
//        } catch (Exception e) {
//            log4j.error("Updating warranty plan term on salesforce - ERROR - " + e);
//            logException(logTest, "Updating warranty plan term on salesforce - ERROR", e);
//        }
//    }
//
//    public void updateLiabilityLimit(String liability, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Updating warranty plan term on salesforce...start");
//
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnUpdateWarrantyActionLink(logTest);
//
//            salesforceUpdateWarrantyPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateWarrantyPage.class);
//            salesforceUpdateWarrantyPage.updateliabilityLimit(liability, logTest);
//
//            // It takes some time to refresh data in SF
//            sleep(5);
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            refreshPage();
//
//            log4j.debug("Updating warranty plan term on salesforce...end");
//        } catch (Exception e) {
//            log4j.error("Updating warranty plan term on salesforce - ERROR - " + e);
//            logException(logTest, "Updating warranty plan term on salesforce - ERROR", e);
//        }
//    }
//
//    /**
//     * @param emailAddress
//     * @param logTest      - Extend report
//     *                     This method is to setup person password, then login to Buyer center
//     */
//    public void setUpAccount(String emailAddress, ExtentTest logTest) throws IOException {
//        try {
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                log4j.debug("Setup account via email...start");
//                buyerCenterHomePage = PageFactory.initElements(Utility.getDriver(), BuyerCenterHomePage.class);
//                navigateToTestSite(logTest, ST_BASE_URL);
//
//                logInfo(logTest, "Click on login and setup link on buyer center");
//                buyerCenterHomePage.clickLinkLoginSetup(logTest);
//
//                logInfo(logTest, "Setup account on buyer center");
//                buyerCenterLoginAndSetupPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterLoginAndSetupPage.class);
//                buyerCenterLoginAndSetupPage.setup(emailAddress, logTest);
//                idc2Step1Page = PageFactory.initElements(Utility.getDriver(), IDC2Step1Page.class);
//                idc2Step1Page.IDC2Step1("Other Retailer", false, logTest);
//                idc2Step2Page = PageFactory.initElements(Utility.getDriver(), IDC2Step2Page.class);
//                idc2Step2Page.IDC2Step2(emailAddress, logTest);
//
//                idc2SetupAccountEmailPage = PageFactory.initElements(Utility.getDriver(), IDC2SetupAccountEmailPage.class);
//                idc2SetupAccountEmailPage.checkSetupAccountEmailPageDisplays(emailAddress, logTest);
//
//                emailMessage = emailActions.verifyEmailExist(null, emailAddress, CONFIRM_ACCOUNT_SUBJECT, false, logTest);
//
//                gmailEmailDetailPage = PageFactory.initElements(Utility.getDriver(), EMailDetailPage.class);
//                gmailEmailDetailPage.clickSetupYourPasswordButton(emailMessage, logTest);
//
//                buyerCenterCreatePasswordPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterCreatePasswordPage.class);
//                buyerCenterCreatePasswordPage.checkCreateNewPasswordPageDisplaySuccessfully(logTest);
//                buyerCenterCreatePasswordPage.createNewPassword(CONFIRM_PASSWORD, CONFIRM_PASSWORD, logTest);
//
//                buyerCenterLoginAndSetupPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterLoginAndSetupPage.class);
//                buyerCenterLoginAndSetupPage.login(emailAddress, CONFIRM_PASSWORD, logTest);
//
//                log4j.debug("Setup account via email...end");
//            } else {
//                log4j.debug("Setup account via API...start");
//                logInfo(logTest, "Update person password using automation service API");
//                automationServices.updatePersonPassword(emailAddress, logTest);
//
//                logInfo(logTest, "Go to Buyer center");
//                buyerCenterHomePage = PageFactory.initElements(Utility.getDriver(), BuyerCenterHomePage.class);
//                navigateToTestSite(logTest, ST_BASE_URL);
//
//                logInfo(logTest, "Click on Login link");
//                buyerCenterHomePage.clickLinkLoginSetup(logTest);
//
//                logInfo(logTest, "Login to account: " + emailAddress);
//                buyerCenterLoginAndSetupPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterLoginAndSetupPage.class);
//                buyerCenterLoginAndSetupPage.login(emailAddress, CONFIRM_PASSWORD, logTest);
//
//                log4j.debug("Setup account via API...end");
//            }
//        } catch (Exception e) {
//            log4j.error("setUpAccount method - ERROR - " + e);
//            logException(logTest, "setUpAccount method - ERROR", e);
//        }
//    }
//
//    public String fileAClaim(String warrantyID, Hashtable<String, String> data, ExtentTest logTest) throws IOException {
//        String claimID = null;
//        String deviceType = data.get("DeviceType").toLowerCase();
//        String resolutionType = data.get("Resolution type");
//        try {
//            logInfo(logTest, "Navigate and login to Sales force");
//            salesforceLoginPage = PageFactory.initElements(Utility.getDriver(), SalesforceLoginPage.class);
//            salesforceLoginPage.salesforceLogin(ENVIRONMENT, logTest);
//
//            logInfo(logTest, "Search the warranty on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(warrantyID, logTest);
//
//            logInfo(logTest, "Click on Verify Proof Of purchase action link");
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnVerifyProofOfPurchaseActionLink(logTest);
//
//            logInfo(logTest, "Verify POP for warranty");
//            proofOfPurchaseVerification = PageFactory.initElements(Utility.getDriver(), SalesforceProofOfPurchaseVerificationPage.class);
//            proofOfPurchaseVerification.verifyProofOfPurchase(data.get("Device price"), logTest);
//
//            logInfo(logTest, "Update Phone type for Shipping address");
//            HashMap personInfo = (HashMap) validationAPIServices.getWarrantyInfoById(warrantyID, logTest).get("person");
//            String personId = personInfo.get("id").toString();
//            validationAPIServices.updatePersonInfo(personId, "phoneNumberType", PHONE_TYPE.toUpperCase(), logTest);
//
//            logInfo(logTest, "Click on File A Claim action link");
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnFileAClaimActionLink(logTest);
//
//            logInfo(logTest, "File a claim on Page0");
//            updateInformationInPage0(data.get("DeviceType"), data.get("Item type"), data.get("Manufacturer"), data.get("Model"), data.get("Carrier"), data.get("Product Line"), data.get("Memory"), data.get("Color"), logTest);
//
//            if (resolutionType.equalsIgnoreCase  ("ADVANCED_EXCHANGE") || resolutionType.equalsIgnoreCase("REPLACEMENT") || resolutionType.equalsIgnoreCase("RAPID_EXCHANGE")){
//                logInfo(logTest, "Update inventory for resolution - " + resolutionType);
//                validationAPIServices.updateReplacementInventory(warrantyID, INVENTORY_AVAILABLE, logTest);
//            }
//
//            logInfo(logTest, "File a claim on Page1");
//            facaSubmitPage1Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage1Page.class);
//            if (data.get("DeviceType").equalsIgnoreCase("camera")) {
//                if (data.get("Is ADH").equals("Yes")) {
//                    //fileAClaimPage1(true, data.get("Problem category"), data.get("Problem code"), data.get("Description"), logTest);
//                    facaSubmitPage1Page.fileAClaimPage1(true, data.get("Problem code"), data.get("Description"), logTest);
//                } else
//                    facaSubmitPage1Page.fileAClaimPage1(false, data.get("Problem code"), data.get("Description"), logTest);
//            } else
//                facaSubmitPage1Page.fileAClaimPage1(false, data.get("Problem code"), data.get("Description"), logTest);
//
//            if (data.get("DeviceType").equalsIgnoreCase("televisions")) {
//                if (data.get("Not triage note") == null) {
//                    logInfo(logTest, "Record triage results");
//                    salesforceSpecialistTriagePage = PageFactory.initElements(Utility.getDriver(), SalesforceSpecialistTriagePage.class);
//                    salesforceSpecialistTriagePage.recordTriageResults(data.get("Specialist category"), data.get("Specialist code"), logTest);
//
//                    logInfo(logTest, "Keep default resolution, then click on Next button");
//                    facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                    facaResolutionPage.selectPaymentMethod("AMAZON_GIFT_CARD", logTest);
//                    facaResolutionPage.clickButtonNext(logTest);
//                    waitForPageLoaded();
//                } else {
//                    logInfo(logTest, "Unable to triage or cannot find a correct specialist code");
//                    salesforceSpecialistTriagePage = PageFactory.initElements(Utility.getDriver(), SalesforceSpecialistTriagePage.class);
//                    salesforceSpecialistTriagePage.unableToTriage(data.get("Not triage note"), logTest);
//
//                    if (data.get("Resolution type").equalsIgnoreCase("REPLACEMENT")) {
//                        logInfo(logTest, "Select 'REPLACEMENT' resolution for claim");
//                        facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                        facaResolutionPage.selectReplacementSquareTrade(logTest);
//                    }
//
//                    if (data.get("Resolution type").equalsIgnoreCase("LOCAL_REPAIR_NETWORK")) {
//                        logInfo(logTest, "Select 'LOCAL_REPAIR_NETWORK' resolution for claim");
//                        facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                        facaResolutionPage.selectLocalRepairNetwork(logTest);
//                    }
//                }
//            } else {
//                if (data.get("Resolution type").equalsIgnoreCase("DEPOT_REPAIR")) {
//                    logInfo(logTest, "Select 'DEPOT REPAIR' resolution for claim");
//                    facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                    facaResolutionPage.selectDepotRepairResolution(logTest);
//                } else if (data.get("Resolution type").equalsIgnoreCase("RAPID_REPAIR")) {
//                    logInfo(logTest, "Select 'RAPID REPAIR' resolution for claim");
//                    facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                    facaResolutionPage.selectRapidRepairResolution(logTest);
//
//                    facaDeductiblePage = PageFactory.initElements(Utility.getDriver(), FACADeductiblePage.class);
//                    facaDeductiblePage.submitDeductible("", logTest);
//                } else if (data.get("Resolution type").equalsIgnoreCase("ADVANCED_EXCHANGE")) {
//                    logInfo(logTest, "Select 'ADVANCED EXCHANGE' resolution for claim");
//                    facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                    facaResolutionPage.selectAEResolution(logTest);
//
//                    logInfo(logTest, "Select 'ADVANCED EXCHANGE' resolution for claim");
//                    facaDeductiblePage = PageFactory.initElements(Utility.getDriver(), FACADeductiblePage.class);
//                    facaDeductiblePage.submitDeductible("", logTest);
//                } else if (data.get("Resolution type").equalsIgnoreCase("LOCAL_REPAIR_AUTHORIZED")) {
//                    logInfo(logTest, "Select 'LOCAL REPAIR AUTHORIZED' resolution for claim");
//                    facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                    facaResolutionPage.selectLRAResolution(logTest);
//
//                    if (deviceType.equals("smartphones") || deviceType.equals("iphones") || deviceType.equalsIgnoreCase("familyplans")) {
//                        facaDeductiblePage = PageFactory.initElements(Utility.getDriver(), FACADeductiblePage.class);
//                        facaDeductiblePage.submitDeductible("", logTest);
//                    }
//                } else if (data.get("Resolution type").equalsIgnoreCase("LOCAL_REPAIR_INVOICE")) {
//                    logInfo(logTest, "Select 'LOCAL REPAIR INVOICE' resolution for claim");
//                    facaResolutionPage = PageFactory.initElements(Utility.getDriver(), FACAResolutionPage.class);
//                    facaResolutionPage.selectLRIResolution("AMAZON_GIFT_CARD", logTest);
//
//                    facaDeductiblePage = PageFactory.initElements(Utility.getDriver(), FACADeductiblePage.class);
//                    facaDeductiblePage.clickButtonNext(logTest);
//                }
//            }
//
//            if (data.get("Approve claim") != null && data.get("Approve claim").equalsIgnoreCase("Save in triage")) {
//                logInfo(logTest, "Select save in triage for claim");
//                salesforceClaimApprovalPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimApprovalPage.class);
//                salesforceClaimApprovalPage.clickButtonSaveInTriage(logTest);
//            } else {
//                logInfo(logTest, "Select approve for claim");
//                salesforceClaimApprovalPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimApprovalPage.class);
//                salesforceClaimApprovalPage.approveClaimFACA(logTest);
//            }
//
//            //handle for Approve dialog still displays in Approve Confirm page
////            if (doesControlExist(salesforceClaimApprovalPage.button_Approve)) {
////                salesforceClaimApprovalPage.approveClaimFACA(logTest);
////            }
//
//            logInfo(logTest, "Close confirmation Page");
//            confirmationPage = PageFactory.initElements(Utility.getDriver(), SalesforceConfirmationPage.class);
//            waitForControl(confirmationPage.button_Exit);
//            confirmationPage.closeConfirmationPage(logTest);
//
//            logInfo(logTest, "Get claim ID that just created");
//            HashMap claimInfo =  validationAPIServices.getClaimInfoByWarranty(warrantyID, 0,null, null, logTest);
//            claimID = claimInfo.get("id").toString();
//        } catch (Exception e) {
//            log4j.error("fileAClaim method - ERROR - " + e);
//            logException(logTest, "fileAClaim method - ERROR", e);
//        }
//        return claimID;
//    }
//
//    /**
//     * @ActionName: fileAClaimCustomerV3;
//     * @EditedDate: 07/23/2018
//     * @Author: thao.trinh
//     */
//    public String fileAPhoneClaimCustomerV3(String warrantyID, String imeiNum, String emailAddress, Hashtable<String, String> data, ExtentTest logTest) throws IOException {
//        String claimID = null;
//        try {
//            switchToWindowHandle();
//
//            String countryCode = data.get("countryCode").toUpperCase();
//            switch (countryCode) {
//                case "AT":
//                    logInfo(logTest, "Navigated to AT site");
//                    navigateToTestSite(logTest, ST_AUSTRIA_PORTAL_URL);
//                    break;
//                case "ES":
//                    logInfo(logTest, "Navigated to ES site");
//                    navigateToTestSite(logTest, ST_SPAIN_PORTAL_URL);
//                    break;
//                case "PT":
//                    logInfo(logTest, "Navigated to PT site");
//                    navigateToTestSite(logTest, ST_POTUGAL_PORTAL_URL);
//                    break;
//                case "SE":
//                    logInfo(logTest, "Navigated to SE site");
//                    navigateToTestSite(logTest, ST_SWEDEN_PORTAL_URL);
//                    break;
//                case "DK":
//                    logInfo(logTest, "Navigated to DK site");
//                    navigateToTestSite(logTest, ST_DENMARK_PORTAL_URL);
//                    break;
//                case "FI":
//                    logInfo(logTest, "Navigated to FI site");
//                    navigateToTestSite(logTest, ST_FINLAND_PORTAL_URL);
//                    break;
//                default:
//                    logInfo(logTest, "Set up account via API and log into Buyer center");
//                    setUpAccount(emailAddress, logTest);
//
//                    logInfo(logTest, "Select the warranty");
//                    buyerCenterMyWarrantiesListPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterMyWarrantiesListPage.class);
//                    buyerCenterMyWarrantiesListPage.selectFirstWarranty(logTest);
//
//                    logInfo(logTest, "Select the 'File/Manage my Claim' link on the right panel of the page");
//                    buyerCenterPlanDetailsPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterPlanDetailsPage.class);
//                    buyerCenterPlanDetailsPage.clickLinkFileAndManageMyClaim(logTest);
//            }
//
//            if (!data.get("countryCode").equalsIgnoreCase("US")) {
//                logInfo(logTest, "Enter the email address and IMEI");
//                registerPage = PageFactory.initElements(Utility.getDriver(), RegisterPage.class);
//                registerPage.enterEmailAddress(emailAddress, logTest);
//                registerPage.enterIMEINumber(imeiNum, logTest);
//                registerPage.clickButtonSubmit(logTest);
//            }
//
//            logInfo(logTest, "Select the 'Start Claim' button on Your Plan Coverage page.");
//            facv3PlanCoveragePage = PageFactory.initElements(Utility.getDriver(), FACV3PlanCoveragePage.class);
//            facv3PlanCoveragePage.clickStartClaimButton(logTest);
//
//            //Only US warranty need to update indentifyitem page
//            if (data.get("countryCode").equalsIgnoreCase("US")) {
//                logInfo(logTest, "Identify your device");
//                facv3IdentifyMyDevicePage = PageFactory.initElements(Utility.getDriver(), FACV3IdentifyMyDevicePage.class);
//                facv3IdentifyMyDevicePage.identifyMyDevice(data.get("Manufacturer"), data.get("Product line"), data.get("Model"), data.get("Carrier"), data.get("Memory"), data.get("Color"), logTest);
//            }
//
//            logInfo(logTest, "Select problem code");
//            facv3ProblemCodesPage = PageFactory.initElements(Utility.getDriver(), FACV3ProblemCodesPage.class);
//            facv3ProblemCodesPage.chooseProblemCode(data.get("problemCode"), logTest);
//
//            logInfo(logTest, "Confirm information at problem question page");
//            facv3ProblemQuestionPage = PageFactory.initElements(Utility.getDriver(), FACV3ProblemQuestionPage.class);
//            facv3ProblemQuestionPage.chooseProblemQuestions(data.get("isWork"), data.get("isAccident"), logTest);
//
//            if (data.get("countryCode").equalsIgnoreCase("US")) {
//                logInfo(logTest, "Enter IMEI number");
//                facv3IMEIPage = PageFactory.initElements(Utility.getDriver(), FACV3IMEIPage.class);
//                facv3IMEIPage.submitIMEINumber(IMEI_NUMBER, logTest);
//            }
//
//            logInfo(logTest, "Input your shipping address");
//            facv3ConfirmAddressPage = PageFactory.initElements(Utility.getDriver(), FACV3ConfirmAddressPage.class);
//            facv3ConfirmAddressPage.confirmYourAddress("", "", "", "", "", "", "", logTest);
//
//            if (data.get("countryCode").equalsIgnoreCase("US")) {
//                logInfo(logTest, "Select or confirm your USPS Address");
//                facv3SelectShippingAddressPage = PageFactory.initElements(Utility.getDriver(), FACV3SelectShippingAddressPage.class);
//                facv3SelectShippingAddressPage.selectShippingAddress(false, logTest);
//            }
//
//            //Handle to file a claim that is not auto-denied or intervention case
//            if (data.get("Resolution type") != null && !data.get("Resolution type").equals("")) {
//                String resolution = data.get("Resolution type").toUpperCase();
//                switch (resolution) {
//                    case "DEPOT_REPAIR":
//                        logInfo(logTest, "Select DR resolution");
//                        facv3ResolutionForPhonePage = PageFactory.initElements(Utility.getDriver(), FACV3ResolutionForPhonePage.class);
//                        facv3ResolutionForPhonePage.selectResolution(logTest, "DEPOT_REPAIR");
//                        break;
//                    case "ADVANCED_EXCHANGE":
//                        logInfo(logTest, "Choose AE resolution");
//                        facv3ResolutionForPhonePage = PageFactory.initElements(Utility.getDriver(), FACV3ResolutionForPhonePage.class);
//                        facv3ResolutionForPhonePage.selectResolution(logTest, "ADVANCED_EXCHANGE");
//
//                        logInfo(logTest, "Agree with terms");
//                        facv3AETermsAcknowledgedPage = PageFactory.initElements(Utility.getDriver(), FACV3AdvancedExchangeTermsAcknowledgedPage.class);
//                        facv3AETermsAcknowledgedPage.acknowledgeTermsForAdvancedExchange(logTest);
//
//                        logInfo(logTest, "Select a replacement device");
//                        facv3AEConfirmationPage = PageFactory.initElements(Utility.getDriver(), FACV3AdvancedExchangeConfirmationPage.class);
//                        facv3AEConfirmationPage.selectReplacedDevice(logTest);
//                        break;
//                    case "LOCAL_REPAIR_INVOICE":
//                        logInfo(logTest, "Choose LRI resolution");
//                        facv3ResolutionForPhonePage = PageFactory.initElements(Utility.getDriver(), FACV3ResolutionForPhonePage.class);
//                        facv3ResolutionForPhonePage.selectResolution(logTest, "LOCAL_REPAIR_INVOICE_CL");
//
//                        logInfo(logTest, "Choose Local repair shop location");
//                        facv3LRShopLocationPage = PageFactory.initElements(Utility.getDriver(), FACV3LocalRepairShopLocationPage.class);
//                        facv3LRShopLocationPage.selectLocalRepairShop(logTest);
//                        break;
//                    case "LOCAL_REPAIR_AUTHORIZED":
//                        logInfo(logTest, "Choose LRA resolution");
//                        facv3ResolutionForPhonePage = PageFactory.initElements(Utility.getDriver(), FACV3ResolutionForPhonePage.class);
//                        facv3ResolutionForPhonePage.selectResolution(logTest, "LOCAL_REPAIR_AUTHORIZED");
//
//                        logInfo(logTest, "Choose Local repair shop location");
//                        facv3LRShopLocationPage = PageFactory.initElements(Utility.getDriver(), FACV3LocalRepairShopLocationPage.class);
//                        facv3LRShopLocationPage.selectLocalRepairShop(logTest);
//                        break;
//                    case "PAYOUT":
//                        if (data.get("Resolution agent").equalsIgnoreCase("SQUARETRADE_FASTCASH")) {
//                            logInfo(logTest, "Choose FASTCASH resolution");
//                            facv3ResolutionForPhonePage.selectResolution(logTest, "FASTCASH_PAYOUT");
//
//                            logInfo(logTest, "Submit Payout method");
//                            facv3PaymentMethodSelectionPage = PageFactory.initElements(Utility.getDriver(), FACV3PaymentMethodSelectionPage.class);
//                            facv3PaymentMethodSelectionPage.selectPaymentMethod("Check", logTest);
//                        }
//                        break;
//                    case "REPLACEMENT":
//                        logInfo(logTest, "Choose REPLACEMENT resolution");
//                        facv3ResolutionForPhonePage = PageFactory.initElements(Utility.getDriver(), FACV3ResolutionForPhonePage.class);
//                        facv3ResolutionForPhonePage.selectResolution(logTest, "REPLACEMENT");
//
//                        logInfo(logTest, "Confirm Model");
//                        facv3ConfirmModelPage = PageFactory.initElements(Utility.getDriver(), FACV3ConfirmModelPage.class);
//                        facv3ConfirmModelPage.clickButtonNext(logTest);
//                        break;
//                    case "RAPID_REPAIR":
//                        logInfo(logTest, "Select RAPID_REPAIR resolution");
//                        facv3ResolutionForPhonePage = PageFactory.initElements(Utility.getDriver(), FACV3ResolutionForPhonePage.class);
//                        facv3ResolutionForPhonePage.selectResolution(logTest, "RAPID_REPAIR");
//                        break;
//                    case "ASSET_MANAGE_RAPID":
//                        logInfo(logTest, "Select ASSET_MANAGE_RAPID resolution");
//                        facv3ResolutionForPhonePage = PageFactory.initElements(Utility.getDriver(), FACV3ResolutionForPhonePage.class);
//                        facv3ResolutionForPhonePage.selectResolution(logTest, "REIMBURSEMENT");
//
//                        logInfo(logTest, "Submit Payout method");
//                        facv3PaymentMethodSelectionPage = PageFactory.initElements(Utility.getDriver(), FACV3PaymentMethodSelectionPage.class);
//                        facv3PaymentMethodSelectionPage.selectPaymentMethod("Check", logTest);
//                        break;
//                }
//
//                logInfo(logTest, "Confirm your shipping address");
//                facv3ConfirmAddressPage = PageFactory.initElements(Utility.getDriver(), FACV3ConfirmAddressPage.class);
//                facv3ConfirmAddressPage.confirmYourAddress("", "", "", "", "", "", PHONE_TYPE.toUpperCase(), logTest);
//
//                if (data.get("countryCode").equalsIgnoreCase("US")) {
//                    logInfo(logTest, "Select or confirm your USPS Address");
//                    facv3SelectShippingAddressPage = PageFactory.initElements(Utility.getDriver(), FACV3SelectShippingAddressPage.class);
//                    facv3SelectShippingAddressPage.selectShippingAddress(false, logTest);
//                }
//
//                if(data.get("deductible").equalsIgnoreCase("Yes")) {
//                    logInfo(logTest, "Submit deductible");
//                    facv3DeductiblePage = PageFactory.initElements(Utility.getDriver(), FACv3DeductiblePage.class);
//                    facv3DeductiblePage.submitDeductible(logTest);
//                }
//            }
//
//            logInfo(logTest, "Get claim ID that just created");
//            /*ReadingFromDB readingFromDB = new ReadingFromDB();//Initiate ReadingFromDB class
//            readingFromDB.readClaim(warrantyID, logTest);//Load claim data from database
//            claimID = getClaimID();*/
//            HashMap claimInfo =  validationAPIServices.getClaimInfoByWarranty(warrantyID, 0,null, null, logTest);
//            claimID = claimInfo.get("id").toString();
//        } catch (Exception e) {
//            log4j.error("fileAPhoneClaimCustomerV3 method - ERROR - " + e);
//            logException(logTest, "fileAPhoneClaimCustomerV3 method - ERROR", e);
//        }
//        return claimID;
//    }
//
//    /**
//     * @ActionName: closeWindow(arg1);
//     * @CreatedDate: 04/17/2017
//     * @Author: binh.le
//     */
//    public void closeWindow(ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("closeWindow...starting");
//            logInfo(logTest, "Close the window");
//            Utility.getDriver().close();
//
//            log4j.debug("closeWindow...ends");
//        } catch (Exception e) {
//            log4j.error("closeWindow method - ERROR - " + e);
//            logException(logTest, "closeWindow method - ERROR", e);
//        }
//    }
//
//    /**
//     * @param objectID
//     * @param logTest
//     * @ActionName: shortID
//     * @CreatedDate: 05/18/2017
//     * Purpose: return number of claim or warranty. E.g. objectID = RecuringPmtDef_stage2_040827999224, return: 040827999224
//     */
//    public String shortID(String objectID, ExtentTest logTest) throws IOException {
//        String shortObjectID = null;
//        try {
//            log4j.debug("Extract number of claim or warranty");
//            logInfo(logTest, "Extract number of claim or warranty");
//            String[] shortObjectIDArray = objectID.split("_");
//            int arrayCount = shortObjectIDArray.length;
//            shortObjectID = shortObjectIDArray[arrayCount - 1];
//        } catch (Exception e) {
//            log4j.error("shortID method - ERROR - " + e);
//            logException(logTest, "shortID method - ERROR", e);
//        }
//        return shortObjectID;
//    }
//
//    public void denyClaimOnSalesforce(String claimID, String reason, String reasonDetail, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Deny claim...start");
//
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            // Handle if claim is already closed
//            if (doesControlExist(salesforceUpdateClaimPage.button_DenyClaim)) {
//                salesforceUpdateClaimPage.clickButtonDenyClaim(logTest);
//
//                salesforceDenyClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceDenyClaimPage.class);
//                salesforceDenyClaimPage.denyAClaim(reason, reasonDetail, logTest);
//
//                //Handle for page load
//                sleep(2);
//
//                salesforceSuccessDenialPage = PageFactory.initElements(Utility.getDriver(), SalesforceSuccessDenialPage.class);
//                salesforceSuccessDenialPage.clickButtonCloseWindow(logTest);
//            } else {
//                salesforceUpdateClaimPage.clickButtonCancel(logTest);
//            }
//
//            log4j.info("Deny claim...end");
//        } catch (Exception e) {
//            log4j.error("denyClaimOnSalesforce method - ERROR - " + e);
//            logException(logTest, "denyClaimOnSalesforce method - ERROR", e);
//        }
//    }
//
//    public List<String> updateInformationInPage0(String deviceType, String itemType, String manufacturer, String model, String carrier, String productionLine, String memory, String color, ExtentTest logTest) throws IOException {
//        List<String> savedInfoPage0 = new ArrayList<String>();
//        try {
//            log4j.debug("updateInformationInPage0...start");
//
//            logInfo(logTest, "Update information in page0");
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            if (doesControlExist(facaSubmitPage0Page.button_UpdateItem)) {
//                logInfo(logTest, "Click Update Item button");
//                facaSubmitPage0Page.clickButtonUpdateItem(logTest);
//
//                logInfo(logTest, "Update device info");
//                facaUpdateProductInformationPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateProductInformationPage.class);
//
//                switch (deviceType.toLowerCase()) {
//
//                    case "smartphones":
//                    case "iphones":
//                        facaUpdateProductInformationPage.updatePhoneItemInfo(IMEI_NUMBER, carrier, manufacturer, productionLine, model, memory, color, logTest);
//                        break;
//                    case "electronics":
//                        facaUpdateProductInformationPage.updateElectronicItemInfo(IMEI_NUMBER, itemType, productionLine, carrier, manufacturer, model, logTest);
//                        break;
//                    case "televisions":
//                        facaUpdateProductInformationPage.updateTVItemInfo(IMEI_NUMBER, manufacturer, model, logTest);
//                        break;
//                    case "laptops":
//                    case "camera":
//                    case "printer":
//                    case "desktops":
//                    case "tablets":
//                    case "appliances":
//                        facaUpdateProductInformationPage.updateNonPhoneItemInfo(IMEI_NUMBER, itemType, manufacturer, model, logTest);
//                        break;
//                }
//
//                if (facaSubmitPage0Page.isAddressErrorDisplayed(logTest)) {
//                    facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//                    facaSubmitPage0Page.clickButtonUpdateAddress(logTest);
//
//                    facaUpdateShippingAddressPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateShippingAddressPage.class);
//                    facaUpdateShippingAddressPage.updateAddressInfo("", "", "", "", "", PHONE_TYPE, logTest);
//                }
//            }
//
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            facaSubmitPage0Page.selectCheckboxShippingConfirm(true);
//
//            //get item name and shipping info address after updating page 0
//            savedInfoPage0.add(facaSubmitPage0Page.getItemName(logTest));
//            savedInfoPage0.add(facaSubmitPage0Page.getShippingInfoAddress(logTest));
//
//            facaSubmitPage0Page.confirmShippingAddressInfo(logTest);
//            waitForPageLoaded();
//
//            log4j.debug("updateInformationInPage0...end");
//        } catch (Exception e) {
//            log4j.error("updateInformationInPage0 method - ERROR - " + e);
//            logException(logTest, "updateInformationInPage0 method - ERROR", e);
//        }
//        return savedInfoPage0;
//    }
//
//    public List<String> updateInformationWearablePage0(String deviceType, String itemType, String manufacturer1, String manufacturer, String model, String carrier, String productionLine, String memory, String color, ExtentTest logTest) throws IOException {
//        List<String> savedInfoPage0 = new ArrayList<String>();
//        try {
//            log4j.debug("Update information in page0...start");
//            deviceType = deviceType.toLowerCase();
//
//            logInfo(logTest, "Update information in page0");
//
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            facaSubmitPage0Page.clickButtonUpdateItem(logTest);
//            facaUpdateProductInformationPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateProductInformationPage.class);
//            waitForControl(facaUpdateProductInformationPage.textbox_SerialNumber);
//            //wait 2s for stability after control exist
//            sleep(2);
//
//            facaUpdateProductInformationPage.updateWearableItemInfo(IMEI_NUMBER, manufacturer1, manufacturer, model, logTest);
//
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            //Handle for the case that 'confirmation address' popup not exists
//            sleep(2);
//            facaSubmitPage0Page.selectCheckboxShippingConfirm(true);
//
//            //get item name and shipping info address after updating page 0
//            savedInfoPage0.add(facaSubmitPage0Page.getItemName(logTest));
//            savedInfoPage0.add(facaSubmitPage0Page.getShippingInfoAddress(logTest));
//
//            facaSubmitPage0Page.confirmShippingAddressInfo(logTest);
//            waitForPageLoaded();
//
//            log4j.info("Update information in page0...end");
//        } catch (Exception e) {
//            log4j.error("updateInformationInPage0 method - ERROR - " + e);
//            logException(logTest, "updateInformationInPage0 method - ERROR", e);
//        }
//        return savedInfoPage0;
//    }
//
//    public List<String> updateInformationFurniturePage0(String categoryType, String itemType, String manufacturer, String model, ExtentTest logTest) throws IOException {
//        List<String> savedInfoPage0 = new ArrayList<String>();
//        try {
//            log4j.debug("updateInformationInPage0...start");
//
//            logInfo(logTest, "Update information in page0");
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            if (doesControlExist(facaSubmitPage0Page.button_UpdateItem)) {
//                logInfo(logTest, "Click Update Item button");
//                facaSubmitPage0Page.clickButtonUpdateItem(logTest);
//
//                logInfo(logTest, "Update device info");
//                facaUpdateProductInformationPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateProductInformationPage.class);
//                facaUpdateProductInformationPage.updateFurnitureItemInfo(IMEI_NUMBER, categoryType, itemType, manufacturer, model, logTest);
//
//                if (facaSubmitPage0Page.isAddressErrorDisplayed(logTest)) {
//                    facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//                    facaSubmitPage0Page.clickButtonUpdateAddress(logTest);
//
//                    facaUpdateShippingAddressPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateShippingAddressPage.class);
//                    facaUpdateShippingAddressPage.updateAddressInfo("", "", "", "", "", PHONE_TYPE, logTest);
//                }
//            }
//
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            facaSubmitPage0Page.selectCheckboxShippingConfirm(true);
//
//            //get item name and shipping info address after updating page 0
//            savedInfoPage0.add(facaSubmitPage0Page.getItemName(logTest));
//            savedInfoPage0.add(facaSubmitPage0Page.getShippingInfoAddress(logTest));
//
//            facaSubmitPage0Page.confirmShippingAddressInfo(logTest);
//            waitForPageLoaded();
//
//            log4j.debug("updateInformationInPage0...end");
//        } catch (Exception e) {
//            log4j.error("updateInformationInPage0 method - ERROR - " + e);
//            logException(logTest, "updateInformationInPage0 method - ERROR", e);
//        }
//        return savedInfoPage0;
//    }
//
//    public String fileClaimOnOldAdminTool(String warrantyID, Hashtable<String, String> data, ExtentTest logTest) throws IOException {
//        String claimID = null;
//        try {
//            log4j.debug("File claim on old admin tool...start");
//            logInfo(logTest, "Search the warranty on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(warrantyID, logTest);
//
//            logInfo(logTest, "Click on 'File A Claim' action link");
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnFileAClaimOldAdminActionLink(logTest);
//
//            logInfo(logTest, "File a claim with valid resolution");
//            salesforceFileClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceFileClaimPage.class);
//            salesforceFileClaimPage.fileClaim(data.get("Problem code"), data.get("Problem code triage"), data.get("Problem description"), logTest);
//
//            logInfo(logTest, "Confirm person and item information");
//            salesforceConfirmPersonAndItemInformationPage = PageFactory.initElements(Utility.getDriver(), SalesforceConfirmPersonAndItemInformationPage.class);
//            salesforceConfirmPersonAndItemInformationPage.confirmPersonAndItemInformation(data.get("Device type confirmation"), data.get("Manufacturer"), data.get("Model"), logTest);
//
//            if (data.get("DeviceType").equals("smartphones")) {
//                closeWindow(logTest);
//
//                salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//                salesforceWarrantyDetailPage.clickOnFileAClaimActionLink(logTest);
//
//                logInfo(logTest, "Update information in page0");
//                facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//                facaSubmitPage0Page.clickButtonUpdateItem(logTest);
//
//                logInfo(logTest, "Update Device information in page0");
//                facaUpdateProductInformationPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateProductInformationPage.class);
//                facaUpdateProductInformationPage.updatePhoneItemInfo(IMEI_NUMBER, data.get("Carrier"), data.get("Manufacturer name"), "", data.get("Model name"), data.get("Memory"), data.get("Color"), logTest);
//
//                logInfo(logTest, "Click on Update button in page0");
//                facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//                facaSubmitPage0Page.clickButtonUpdateAddress(logTest);
//
//                waitForPageLoaded();
//                closeWindow(logTest);
//                /*readingFromDB.readClaim(warrantyID, logTest);
//                claimID = readingFromDB.getClaimID();*/
//                HashMap claimInfo =  validationAPIServices.getClaimInfoByWarranty(warrantyID, 0,null, null, logTest);
//                claimID = claimInfo.get("id").toString();
//
//                logInfo(logTest, "Search the warranty on Sales force");
//                salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//                salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//                logInfo(logTest, "Click on Update claim link");
//                salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//                salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//                logInfo(logTest, "Click on Submit For claim processing button");
//                salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//                salesforceUpdateClaimPage.clickButtonSubmitClaimForProcessing(logTest);
//
//                logInfo(logTest, "Confirm claim for processing");
//                salesforceSubmitClaimForProcessingPage = PageFactory.initElements(Utility.getDriver(), SalesforceSubmitClaimForProcessingPage.class);
//                salesforceSubmitClaimForProcessingPage.submitClaimForProcessing(logTest);
//            } else {
//                logInfo(logTest, "Submit claim for processing");
//                salesforceClaimFiledPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimFiledPage.class);
//                salesforceClaimFiledPage.clickButtonSubmitClaimForProcessing(logTest);
//
//                logInfo(logTest, "Confirm claim for processing");
//                salesforceSubmitClaimForProcessingPage = PageFactory.initElements(Utility.getDriver(), SalesforceSubmitClaimForProcessingPage.class);
//                salesforceSubmitClaimForProcessingPage.submitClaimForProcessing(logTest);
//            }
//
//            /*readingFromDB.readClaim(warrantyID, logTest);
//            claimID = readingFromDB.getClaimID();*/
//            HashMap claimInfo =  validationAPIServices.getClaimInfoByWarranty(warrantyID, 0,null, null, logTest);
//            claimID = claimInfo.get("id").toString();
//            log4j.info("File claim on old admin tool...end");
//        } catch (Exception e) {
//            log4j.error("fileAClaimViaOldAdminTool method - ERROR - " + e);
//            logException(logTest, "fileAClaimViaOldAdminTool method - ERROR", e);
//        }
//        return claimID;
//    }
//
//    public void approveClaim(String claimID, String claimType, String resolutionType, String agentName, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Approve claim...start");
//
//            logInfo(logTest, "Search the created claim on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            logInfo(logTest, "Click on 'Update claim' action link");
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            logInfo(logTest, "Click on 'Approve_Claim' button");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonApproveClaim(logTest);
//            waitForPageLoaded();
//
//            logInfo(logTest, "Approve claim with agent");
//            salesforceApproveClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceApproveClaimPage.class);
//            salesforceApproveClaimPage.approveClaim(claimType, resolutionType, agentName, logTest);
//
//            logInfo(logTest, "Refresh page after Approve claim");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            refreshPage();
//            waitForPageLoaded();
//
//            log4j.info("Approve claim...end");
//        } catch (Exception e) {
//            log4j.error("approveClaim method - ERROR - " + e);
//            logException(logTest, "approveClaim method - ERROR", e);
//        }
//    }
//
//    public void verifyProofOfPurchase(String warrantyID, String price, ExtentTest logTest) throws IOException {
//        try {
//            logInfo(logTest, "Navigate and login to Sales force");
//            salesforceLoginPage = PageFactory.initElements(Utility.getDriver(), SalesforceLoginPage.class);
//            salesforceLoginPage.salesforceLogin(ENVIRONMENT, logTest);
//
//            logInfo(logTest, "Search the warranty on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(warrantyID, logTest);
//
//            logInfo(logTest, "Click on Verify Proof Of purchase action link");
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnVerifyProofOfPurchaseActionLink(logTest);
//
//            logInfo(logTest, "Verify POP for warranty");
//            salesforceProofOfPurchaseVerificationPage = PageFactory.initElements(Utility.getDriver(), SalesforceProofOfPurchaseVerificationPage.class);
//            salesforceProofOfPurchaseVerificationPage.verifyProofOfPurchase(price, logTest);
//        } catch (Exception e) {
//            log4j.error("verifyProofOfPurchase method - ERROR - " + e);
//            logException(logTest, "verifyProofOfPurchase method - ERROR", e);
//        }
//    }
//
//    public void recordDepotConfirmation(String claimID, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Record depot confirmation for claim...start");
//
//            logInfo(logTest, "Search the created claim on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            logInfo(logTest, "Click on 'Update claim' action link");
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            logInfo(logTest, "Click on 'Record depot confirmation' button");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonRecordDepotConfirmation(logTest);
//
//            logInfo(logTest, "Click on 'Yes' button");
//            salesforceRecordDepotConfirmationPage = PageFactory.initElements(Utility.getDriver(), SalesforceRecordDepotConfirmationPage.class);
//            salesforceRecordDepotConfirmationPage.clickButtonYes(logTest);
//
//            logInfo(logTest, "Close window");
//            salesforceRecordDepotConfirmationPage.clickButtonCloseWindow(logTest);
//
//            log4j.info("Record depot confirmation for claim...end");
//        } catch (Exception e) {
//            log4j.error("recordDepotConfirmation method - ERROR - " + e);
//            logException(logTest, "recordDepotConfirmation method - ERROR", e);
//        }
//    }
//
//    public void assignTech(String claimID, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Assign Tech for TV claim...start");
//
//            logInfo(logTest, "Search the created claim on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            logInfo(logTest, "Click on 'Update claim' action link");
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            logInfo(logTest, "Click on 'Assign Tech' button");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonAssignTech(logTest);
//
//            logInfo(logTest, "Click on 'Yes' button");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonSubmitAssignTech(logTest);
//
//            logInfo(logTest, "Close window");
//            salesforceRecordDepotConfirmationPage.clickButtonCloseWindow(logTest);
//
//            log4j.info("Assign Tech for TV claim...end");
//        } catch (Exception e) {
//            log4j.error("assignTech method - ERROR - " + e);
//            logException(logTest, "assignTech method - ERROR", e);
//        }
//    }
//
//    public void recordItemAuditResults(String claimID, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Record Item Audit Results for claim...start");
//
//            logInfo(logTest, "Search the created claim on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            logInfo(logTest, "Click on 'Update claim' action link");
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            logInfo(logTest, "Click on 'Record item audit results' button");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonRecordItemAuditResults(logTest);
//
//            logInfo(logTest, "Click on 'Record Audit Results' button");
//            salesforceRecordAuditResultsPage = PageFactory.initElements(Utility.getDriver(), SalesforceRecordAuditResultsPage.class);
//            salesforceRecordAuditResultsPage.clickButtonRecordAuditResults(logTest);
//
//            logInfo(logTest, "Close window");
//            salesforceRecordAuditResultsPage.clickButtonCloseWindow(logTest);
//
//            log4j.info("Record Item Audit Results for claim...end");
//        } catch (Exception e) {
//            log4j.error("recordItemAuditResults method - ERROR - " + e);
//            logException(logTest, "recordItemAuditResults method - ERROR", e);
//        }
//    }
//
//    public void confirmSignedAffidavit(String claimID, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Confirm Signed Affidavit for claim...start");
//
//            logInfo(logTest, "Search the created claim on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            logInfo(logTest, "Click on 'Update claim' action link");
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            logInfo(logTest, "Click on 'Confirm Signed Affidavit' button");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonConfirmSignedAffidavit(logTest);
//
//            logInfo(logTest, "Close window");
//            salesforceConfirmSignedAffidavitPage = PageFactory.initElements(Utility.getDriver(), SalesforceConfirmSignedAffidavitPage.class);
//            salesforceConfirmSignedAffidavitPage.clickButtonCloseWindow(logTest);
//
//            log4j.info("Confirm Signed Affidavit for claim...end");
//        } catch (Exception e) {
//            log4j.error("confirmSignedAffidavit method - ERROR - " + e);
//            logException(logTest, "confirmSignedAffidavit method - ERROR", e);
//        }
//    }
//
//    public void markResolutionCompleted(String claimID, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Mark resolution completed for claim...start");
//
//            logInfo(logTest, "Search the created claim on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            logInfo(logTest, "Click on 'Update claim' action link");
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            logInfo(logTest, "Click on 'Mark resolution completed' button on 'Update claim' page");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonMarkResolutionComplete(logTest);
//
//            logInfo(logTest, "Confirm mark resolution completed");
//            salesforceMarkResolutionCompletePage = PageFactory.initElements(Utility.getDriver(), SalesforceMarkResolutionCompletePage.class);
//            salesforceMarkResolutionCompletePage.clickButtonMarkResolutionComplete(logTest);
//            salesforceMarkResolutionCompletePage.clickButtonCloseWindow(logTest);
//
//            log4j.info("Mark resolution completed for claim...end");
//        } catch (Exception e) {
//            log4j.error("markResolutionCompleted method - ERROR - " + e);
//            logException(logTest, "markResolutionCompleted method - ERROR", e);
//        }
//    }
//
//    public void cleanUpTestCase(String warrantyID, String claimID, String reasoneCode, String reasoneDetail, ExtentTest logDataSet) throws IOException {
//        ExtentTest logStep = null;
//        String warrantyStatus = null;
//        try {
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//
//                logStep = logStepInfo(logDataSet, "Pre-Cleanup: Check warranty status");
//                HashMap warrantyInfo = database.executeQueryAndGetFirstResult(logStep,WARRANTY,queryDatabase.GET_WARRANTY_INFO_PROD,warrantyID);
//                warrantyStatus = warrantyInfo.get("status").toString();
//
//                if (warrantyStatus.equalsIgnoreCase("Approved")) {
//                    log4j.info("Cleanup: Deny claim and cancel warranty...start");
//                    initializeDriver(logDataSet);
//
//                    if (warrantyID != null && warrantyID != "") {
//                        logStep = logStepInfo(logDataSet, "Cleanup #1: Log into Salesforce");
//                        salesforceLoginPage = PageFactory.initElements(Utility.getDriver(), SalesforceLoginPage.class);
//                        salesforceLoginPage.salesforceLogin(ENVIRONMENT, logStep);
//
//                        if (claimID != null && claimID != "") {
//                            reasoneCode = reasoneCode == null ? "TROUBLESHOT" : reasoneCode;
//                            reasoneDetail = reasoneDetail == null ? "EXISTING SOLUTION" : reasoneDetail;
//                            logStep = logStepInfo(logDataSet, "Cleanup #2: Deny claim: " + claimID);
//                            this.denyClaimOnSalesforce(claimID, reasoneCode, reasoneDetail, logStep);
//                        }
//
//                        logStep = logStepInfo(logDataSet, "Cleanup #3: Search for warranty: " + warrantyID);
//                        salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//                        salesforceHomePage.salesforceSearchRpid(warrantyID, logStep);
//
//                        logStep = logStepInfo(logDataSet, "Cleanup #4: Click on 'Cancel Warranty' action link");
//                        salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//                        salesforceWarrantyDetailPage.clickOnCancelWarrantyActionLink(logStep);
//
//                        logStep = logStepInfo(logDataSet, "Cleanup #5: Make sure 'Cancel Warranty' popup displays with valid values");
//                        salesforceCancelWarrantyPage = PageFactory.initElements(Utility.getDriver(), SalesforceCancelWarrantyPage.class);
//                        salesforceCancelWarrantyPage.checkCancelWarrantyInfo(warrantyID, "", logStep);
//
//                        logStep = logStepInfo(logDataSet, "Cleanup #6: Cancel the warranty");
//                        salesforceCancelWarrantyPage.clickButtonCancelWarranty(logStep);
//                        salesforceCancelWarrantyPage.clickButtonCloseWindow(logStep);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log4j.error("cleanUpTestCase method - ERROR - " + e);
//        } finally {
//            quit(logDataSet);
//            log4j.info("Cleanup: Deny claim and cancel warranty...end");
//        }
//    }
//
//    public void recordShippingStatus(String claimID, String shippingStatus, String itemLocation, String shippingAgent, String shippingHandlingCost, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Record shipping status for claim...start");
//
//            logInfo(logTest, "Search the created claim on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(claimID, logTest);
//
//            logInfo(logTest, "Click on 'Update claim' action link");
//            salesforceClaimDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceClaimDetailPage.class);
//            salesforceClaimDetailPage.clickOnUpdateClaimActionLink(logTest);
//
//            logInfo(logTest, "Click on 'Record Shipping Status' button on 'Update claim' page");
//            salesforceUpdateClaimPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateClaimPage.class);
//            salesforceUpdateClaimPage.clickButtonRecordShippingStatus(logTest);
//
//            logInfo(logTest, "Input value into 'record shipping status' form");
//            salesforceRecordShippingStatusPage = PageFactory.initElements(Utility.getDriver(), SalesforceRecordShippingStatusPage.class);
//            salesforceRecordShippingStatusPage.inputRecordShippingStatus(shippingStatus, itemLocation, shippingAgent, shippingHandlingCost, logTest);
//
//            log4j.info("Record shipping status for claim...end");
//        } catch (Exception e) {
//            log4j.error("recordShippingStatus method - ERROR - " + e);
//            logException(logTest, "recordShippingStatus method - ERROR", e);
//        }
//    }
//
//    /**
//     * @param isAccident
//     * @param reasonForReworkRetry
//     * @param problemCode
//     * @param desc
//     * @param logTest              - Extent Report
//     * @Action: fileAReworkRetryClaimPage1(arg1, arg2, arg3)
//     * @Purpose: file a claim with problem code on File A Claim Agent page1 for rework or retry
//     */
//    public void fileAReworkRetryClaimPage1(boolean isAccident, String reasonForReworkRetry, String problemCategory, String problemCode, String desc, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("File a claim on Page 1 for rework or retry...start");
//            facaSubmitPage1Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage1Page.class);
//
//            //----- Get format date that 'Issue start date' textbox is required
//            String formatDate = facaSubmitPage1Page.getStartDateFormatter();
//            //----- Get format date that 'Issue start date' textbox is required
//
//            String date = new SimpleDateFormat(formatDate).format(Calendar.getInstance().getTime());
//
//            logInfo(logTest, "Input issue start date:</b> " + date);
//            facaSubmitPage1Page.inputTextboxIssueStartDate(logTest, date);
//
//            logInfo(logTest, "Select problem Result of accident answer");
//            facaSubmitPage1Page.selectProblemResultOfAccident(isAccident, logTest);
//            if (!isAccident) {
//                facaSubmitPage1Page.selectComboboxItemReworkReasonCode(reasonForReworkRetry);
//            }
//
//            logInfo(logTest, "Click on 'Select problems' button(if any), then, select problem code");
//            facaSubmitPage1Page.selectProblemCodes(problemCode, logTest);
//
//
//            logInfo(logTest, "Input problem description:</b> " + desc);
//            facaSubmitPage1Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage1Page.class);
//            facaSubmitPage1Page.inputTextboxProblemDescription(desc);
//
//            logInfo(logTest, "Click on Next button on Page 1");
//            facaSubmitPage1Page.clickButtonNextOnPage1(logTest);
//
//            waitForPageLoaded();
//
//            log4j.info("File a claim on Page 1 for rework or retry...end");
//        } catch (Exception e) {
//            log4j.error("fileAClaimForReworkPage1 method - ERROR " + e);
//            logException(logTest, "fileAClaimForReworkPage1 method - ERROR ", e);
//        }
//    }
//
//    /**
//     * @param email
//     * @param logTest
//     * @ActionName: buyUKWarranty
//     * @CreatedDate: 05/18/2017
//     * Purpose: update information on FAC page 0, do not click Next button to go to FAC page 1
//     */
//    public String buyUKWarranty(String email, boolean doesAgeBack, ExtentTest logTest) throws IOException {
//        String warrantyID = null;
//        try {
//            log4j.debug("buyUKWarranty method...start");
//            Date today = Calendar.getInstance().getTime();
//            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
//            String purchaseDate = formatter.format(today);
//            String orderID = generateTimeStampString(12);
//            String emailAddress = email.replaceAll("\\+", "%2b");
//            String spoofURL = "https://www-%s.squaretrade.com/warrantyservice/warrantyOrder?version=2&method=POST&merchantID=subscrip_014719938103&orderID=ASDA%s&itemID=ordZ01&itemDescription=LCD+TV&itemPrice=1449.99&purchaseDate=%s&itemManufacturer=Samsung&itemModel=Samsung+BAMF+TV&merchantResaleWarrantySKU=14SSBAMFLCDSKU&resaleProductID=UK-CN1999N2A&warrantyPurchasePrice=165.99&buyerFirstName=%s&buyerLastName=%s&buyerEmail=%s&buyerAddress1=575+Market+Street&buyerAddress2=10th+Floor&buyerState=London&buyerCity=London&buyerZip=EC1A+9LR&buyerCountry=GB&buyerPhone=408-408-4008&source=asda";
//            spoofURL = String.format(spoofURL, ENVIRONMENT, orderID, purchaseDate, CHECKOUT_FIRST_NAME, CHECKOUT_LAST_NAME, emailAddress);
//
//            navigateToTestSite(logTest, spoofURL);
//
//            //ReadingFromDB readingFromDB = new ReadingFromDB();
//            warrantyID = validationAPIServices.getWarrantyInfoByEmail(email, 0, logTest).get ("id").toString();
//            logInfo(logTest, "Warranty ID: " + warrantyID);
//
//            // Age back on all other environments other than production
//            if (doesAgeBack && !ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                logInfo(logTest, "AgeBack warranty '" + warrantyID + "'");
//                automationServices.ageBackWarranty(warrantyID, AGE_BACK_DAYS, logTest);
//            }
//
//            log4j.info("Buy UK warranty...end");
//        } catch (Exception e) {
//            log4j.error("buyUKWarranty method - ERROR - " + e);
//            logException(logTest, "buyUKWarranty method - ERROR", e);
//        }
//        return warrantyID;
//    }
//
//    public void updateInformationInPage0ForUK(String country, String deviceType, String itemType, String manufacturer, String model, String carrier, String productionLine, String memory, String color, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Update information for non-US country in page0...start");
//            deviceType = deviceType.toLowerCase();
//            String zipcode = null;
//            if (country.equals("UK")) {
//                country = "United Kingdom";
//                zipcode = UK_SHIPPING_ADDRESS_ZIPCODE;
//            } else if (country.equals("CA")) {
//                country = "Canada";
//            }
//
////            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
////            facaSubmitPage0Page.clickButtonUpdateItem(logTest);
////
////            facaUpdateProductInformationPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateProductInformationPage.class);
////            waitForControl(facaUpdateProductInformationPage.textbox_SerialNumber);
////
////            if (deviceType.equals("televisions"))
////                facaUpdateProductInformationPage.updateTVItemInfo(IMEI_NUMBER, itemType, manufacturer, model, logTest);
////
////            else if (deviceType.equals("laptops"))
////                facaUpdateProductInformationPage.updateLaptopItemInfo(IMEI_NUMBER, manufacturer, model, logTest);
////
////            else if (deviceType.equals("smartphones") || deviceType.equals("iphones"))
////                facaUpdateProductInformationPage.updatePhoneItemInfo(IMEI_NUMBER, carrier, manufacturer, productionLine, model, memory, color, logTest);
////
////            else if (deviceType.equals("camera"))
////                facaUpdateProductInformationPage.updateCameraItemInfo(IMEI_NUMBER, itemType, manufacturer, model, logTest);
//
//            logInfo(logTest, "Update information for non-US country");
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            facaSubmitPage0Page.clickButtonUpdateAddress(logTest);
//
//            facaUpdateShippingAddressPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateShippingAddressPage.class);
//            facaUpdateShippingAddressPage.updateAddressInfo("", "", "", country, zipcode, PHONE_TYPE, logTest);
//
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            facaSubmitPage0Page.confirmShippingAddressInfo(logTest);
//
//            log4j.info("Update information in page0 for non-US country...end");
//        } catch (Exception e) {
//            log4j.error("updateInformationInPage0ForUK method - ERROR - " + e);
//            logException(logTest, "updateInformationInPage0ForUK method - ERROR", e);
//        }
//    }
//
//    public String assignAvailableWarranty(Hashtable<String, String> data, ExtentTest logTest) throws IOException {
//        String warrantyID = null;
//        try {
//            if (ENVIRONMENT.toLowerCase().equals(PRODUCTION)) {
//                warrantyID = "RecuringPmtDef_017319339127";
//                log4j.info("WarrantyID is assign on " + PRODUCTION + " environment: " + warrantyID);
//                logInfo(logTest, "WarrantyID is assign on " + PRODUCTION + " environment: " + warrantyID);
//            } else {
//                initializeDriver(logTest);
//                warrantyID = buyUKWarranty(generateRandomEmail(EMAIL_ADDRESS), true, logTest);
//                validationAPIServices.updateCategoryID(data.get("CategoryID"), warrantyID, logTest);
//                verifyProofOfPurchase(warrantyID, data.get("Device price"), logTest);
//                quit(logTest);
//            }
//        } catch (Exception e) {
//            log4j.error("assignAvailableWarranty method - ERROR - " + e);
//            logException(logTest, "assignAvailableWarranty method - ERROR", e);
//        }
//        return warrantyID;
//    }
//
//    public void checkMaxLengthOfTextBox(WebElement control, String number, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Check max length of textbox...start");
//
//            logInfo(logTest, "Check max length of textbox with number: " + number);
//            verifyExpectedAndActualResultsSubString(logTest, number, control.getAttribute("maxlength"));
//
//            log4j.info("Check max length of textbox...end");
//        } catch (Exception e) {
//            log4j.error("checkMaxLengthOfTextBox method - ERROR - " + e);
//            logException(logTest, "checkMaxLengthOfTextBox method - ERROR", e);
//        }
//    }
//    /*----------- Common Methods end here -----------*/
//
//    public synchronized String generateCouponCodeOnSalesforce(ExtentTest logTest) throws IOException {
//        String couponCode = null;
//        try {
//            logInfo(logTest, "Navigate and login to Sales force");
//            salesforceLoginPage = PageFactory.initElements(Utility.getDriver(), SalesforceLoginPage.class);
//            salesforceLoginPage.salesforceLogin(ENVIRONMENT, logTest);
//
//            logInfo(logTest, "Click on Generate Coupon Code link");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.clickLinkGenerateCouponCode(logTest);
//
//            logInfo(logTest, "Generate Coupon code:");
//            salesforceGenerateCouponCodePage = PageFactory.initElements(Utility.getDriver(), SalesforceGenerateCouponCodePage.class);
//            couponCode = salesforceGenerateCouponCodePage.generateCouponCode(CHECKOUT_CODE_NAME, logTest);
//        } catch (Exception e) {
//            log4j.error("generateCouponCodeOnSalesforce method - ERROR - " + e);
//            logException(logTest, "generateCouponCodeOnSalesforce method - ERROR", e);
//        }
//        return couponCode;
//    }
//
//    /**
//     * @ActionName: Enter checkout info
//     * @CreatedDate: 02/02/2018
//     * @Author: binh.le
//     */
//
//    public String enterCheckoutInfo(Hashtable<String, String> data, String emailAddress, ExtentTest logTest) throws IOException {
//        String warrantyID = "";
//        String deviceType = data.get("DeviceType").toLowerCase();
//        String newOrOldPhone = data.get("For new device");
//
//        try {
//            logInfo(logTest, "Enter information for checking out warranty");
//            checkoutPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterCheckOutPage.class);
//            if (doesControlExist(checkoutPage.label_LoadingMessage) || doesControlExist(checkoutPage.label_LoadingSpinner)) {
//                int i = 0;
//                while (i < WAIT_TIME && doesControlExist(checkoutPage.label_LoadingMessage) && doesControlExist(checkoutPage.label_LoadingSpinner)) {
//                    sleep(2);
//                    i++;
//                }
//            }
//
//            checkoutPage.inputBillingInfo(deviceType, newOrOldPhone, emailAddress, logTest);
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                checkoutPage.inputCouponCode(CHECKOUT_COUPON_CODE, logTest);
//                checkoutPage.inputPaymentInfo(data.get("CreditCardType"), logTest);
//            } else {
//                checkoutPage.inputPaymentInfo(CREDIT_CARD_NUMBER, CREDIT_CARD_EXPIRATION_DATE_MONTHLY_SMARTPHONE, CVV_NUMBER_FOR_MONTHLY_PHONE, logTest);
//            }
//            //Remove below code since it's already included in inputBillingInfo method
//            /*if (deviceType.equals("televisions") || deviceType.equals("laptops") || deviceType.equals("fitnesstracker") || deviceType.equals("camera")) {
//                checkoutPage.inputTextboxPurchasedLocation(CHECKOUT_PURCHASE_LOCATION, logTest);
//                checkoutPage.setCheckboxPurchaseDateConfirmation(logTest);
//            }
//
//            if (deviceType.equals("iphones") || deviceType.equals("smartphones") || deviceType.equals("familyplans")) {
//                if (data.get("For new device") != null && !data.get("For new device").equals("N/A"))
//                    checkoutPage.selectNewDeviceOrNot(data.get("For new device"), logTest);
//            } else {
//                checkoutPage.setCheckboxPurchaseDateConfirmation(logTest);
//            }
//            }*/
//
//            checkoutPage.clickButtonSubmit(logTest);
//            waitForPageLoaded();
//
//            thankYouPage = PageFactory.initElements(Utility.getDriver(), BuyerCenterThankYouPage.class);
//            waitForControl(thankYouPage.label_ThankYouMessage);
//            sleep(2);
//
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)) {
//                warrantyID = getRPIDProduction(emailAddress, logTest);
//            } else {
//                if (deviceType.equals("monthly smartphone") || deviceType.equals("premium smartphone")) {
//                    logInfo(logTest, "Trigger informatica job");
//                    informaticaServices.runInformaticaJobForMonthlyPurchase(logTest);
//                }
//                warrantyID = validationAPIServices.getWarrantyInfoByEmail(emailAddress, 0, logTest).get("id").toString();
//            }
//
//            logInfo(logTest, "Warranty ID: " + warrantyID);
//
//            log4j.info("Buy warranty...end");
//        } catch (Exception e) {
//            log4j.error("buyWarranty method - ERROR - " + e);
//            logException(logTest, "buyWarranty method - ERROR", e);
//        }
//        return warrantyID;
//    }
//
//    public void waitForClaimEventComplete(String claimID, ExtentTest logTest) throws IOException {
//        try {
//            for (int count = 0; count < WAIT_TIME * 5; count++) {
//                log4j.debug("wait for parts_order_claim_event event complete method...starts");
//
//                //Get all value from event table
//                readingFromDB.getEventClaim(claimID, logTest);
//                if (readingFromDB.getEventType().equals("parts_order_claim_event") && readingFromDB.getEventStatusReason().equals("SUCCESSFUL") && readingFromDB.getEventStatus().equals("COMPLETED"))
//                    break;
//                else {
//                    //Wait 1s for each of session
//                    sleep(1);
//                }
//
//                log4j.info("wait for parts_order_claim_event event complete method...ends");
//            }
//        } catch (Exception e) {
//            log4j.error("waitForClaimEventComplete method - ERROR - " + e);
//            logException(logTest, "waitForClaimEventComplete method - ERROR", e);
//        }
//    }
//
//    public void checkAppointmentStatusAfterUpdatingDB(String claimID, String statusAndSubStatus, String expectedAppointmentStatus, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Verify that appointment status should be changed after update data on DB...starts");
//            String[] listOfStatusAndSubStatus = statusAndSubStatus.split("-");
//            for (int i = 0; i < listOfStatusAndSubStatus.length; i++) {
//
//                logInfo(logTest, "Update status and substatus to trigger appointment status");
//                readingFromDB.updateAppointmentStatus(listOfStatusAndSubStatus[i].split(",")[0], listOfStatusAndSubStatus[i].split(",")[1], claimID, logTest);
//
//                logInfo(logTest, "Verify appointment status on Repair Status page");
//                statusPage = PageFactory.initElements(Utility.getDriver(), StatusPage.class);
//                statusPage.verifyAppointmentStatus(expectedAppointmentStatus, logTest);
//
//            }
//            log4j.info("Verify that appointment status should be changed after update data on DB...ends");
//        } catch (Exception e) {
//            log4j.error("checkAppointmentStatusAfterUpdatingDB method - ERROR - " + e);
//            logException(logTest, "checkAppointmentStatusAfterUpdatingDB method - ERROR", e);
//        }
//    }
//
//    public void verifyIdcWebformTicket(Hashtable<String, String> data, String email, ExtentTest logTest) throws IOException {
//        try {
//            logInfo(logTest, "Navigate and login to Sales force");
//            salesforceLoginPage = PageFactory.initElements(Utility.getDriver(), SalesforceLoginPage.class);
//            salesforceLoginPage.salesforceLogin(PRODUCTION, logTest);
//
//            logInfo(logTest, "Search the warranty on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(email, logTest);
//
//            logInfo(logTest, "Verify the IDC Ticket is created with correct populated data");
//            salesforceTicketDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceTicketDetailPage.class);
//            salesforceTicketDetailPage.checkContentIdcWebformTicket(data.get("Ticket PreSaleContactName"), email, data.get("Ticket PreSaleContactPhone"), data.get("Ticket Channel"), data.get("Ticket Description"), data.get("Ticket ReceiptNumber"), data.get("Ticket Subject"), data.get("Ticket Origin"), data.get("Ticket Status"), logTest);
//        } catch (Exception e) {
//            log4j.error("verifyIdcWebformTicket method - ERROR - " + e);
//            logException(logTest, "verifyIdcWebformTicket method - ERROR", e);
//        }
//    }
//
//    public String maskEmail(String email, ExtentTest logTest) throws IOException {
//        String maskedEmail = null;
//        try {
//
//            maskedEmail = email.replaceAll("(?<=.{1}).{1,100}(?=[^@]*?.@)", "..");
//
//        } catch (Exception e) {
//            log4j.error("maskEmail method - ERROR - " + e);
//            logException(logTest, "maskEmail method - ERROR", e);
//        }
//        return maskedEmail;
//    }
//
//    public void checkRouteToFileClaim(ExtentTest logTest) throws IOException {
//        try {
//            idc2ChoosePlansPage = PageFactory.initElements(Utility.getDriver(), IDC2ChoosePlansPage.class);
//            if (doesControlExist(idc2ChoosePlansPage.label_HeaderPage)) {
//                logInfo(logTest, "Verify that the Choose Plan page is displayed");
//                logPass(logTest, "Choose Plan page is displayed");
//            } else {
//                facv3IdentifyMyDevicePage = PageFactory.initElements(Utility.getDriver(), FACV3IdentifyMyDevicePage.class);
//                if (doesControlExist(facv3IdentifyMyDevicePage.text_heading)) {
//                    logInfo(logTest, "Verify that the Identify page is displayed");
//                    logPass(logTest, "Identify page is displayed");
//                } else {
//                    logFail(logTest, "User is NOT routed to File Claim flow");
//                }
//            }
//        } catch (Exception e) {
//            log4j.error("checkRouteToFileClaim method - ERROR - " + e);
//            logException(logTest, "checkRouteToFileClaim method - ERROR", e);
//        }
//    }
//
//    public List<String> readWalmartStoreRetailerInfo(String walmartStoreOrderId, ExtentTest logTest) throws IOException {
//
//        List<String> retailerInfo = new ArrayList<String>();
//        try {
//            log4j.debug("Read Walmart Store Retailer Info from Order Id...starts");
//            String[] listOfWalmartStoreOrderId = walmartStoreOrderId.split("_");
//
//            String stringPurchasedDate = listOfWalmartStoreOrderId[0];
//
//            logInfo(logTest, "Convert string date to correct date format");
//            String purchasedDate = null;
//            SimpleDateFormat df_in = new SimpleDateFormat("yyyyMMdd");
//            SimpleDateFormat df_output = new SimpleDateFormat("MM/dd/yyyy");
//            Date date = df_in.parse(stringPurchasedDate);
//            purchasedDate = df_output.format(date);
//
//            logInfo(logTest, "Fill leading zeros to Store Number, Terminal Number, Transaction Number to make length correct");
//            String storeNumber = ("00000" + listOfWalmartStoreOrderId[1]).substring(listOfWalmartStoreOrderId[1].length());
//            String terminalNumber = ("00" + listOfWalmartStoreOrderId[2]).substring(listOfWalmartStoreOrderId[2].length());
//            String transactionNumber = ("00000" + listOfWalmartStoreOrderId[3]).substring(listOfWalmartStoreOrderId[3].length());
//
//            logInfo(logTest, "Get Store Number, Terminal Number, Transaction Number and purchased Date");
//            retailerInfo.add(storeNumber);
//            retailerInfo.add(terminalNumber);
//            retailerInfo.add(transactionNumber);
//            retailerInfo.add(purchasedDate);
//
//            log4j.info("Read Walmart Store Retailer Info from Order Id...ends");
//        } catch (Exception e) {
//            log4j.error("readWalmartStoreRetailerInfo method - ERROR - " + e);
//            logException(logTest, "readWalmartStoreRetailerInfo method - ERROR", e);
//        }
//
//        return retailerInfo;
//    }
//
//    public void checkDeductibleInfo(String rpdID, String resolutionName, String deductibleType, String FACA, String subcriptionID, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("checkDeductibleInfo...start");
//            String deductibleInfo[];
//
//            if (FACA.equalsIgnoreCase("")) {
//                //File claim via FACV3- get data from claim.fillingID table using warranty ID
//                deductibleInfo = databaseValidation.getDeductibleInformation(rpdID, resolutionName, logTest);
//            } else {
//
//                //File claim via FACA - get data from event table using rpdID = claim ID
//                deductibleInfo = validationAPIServices.getResolutionInformation(rpdID, resolutionName, logTest);
//            }
//
//            if (deductibleInfo[0] == null) {
//                logFail(logTest, "The " + resolutionName + " is not offered");
//            } else {
//                double amount = Double.parseDouble(deductibleInfo[2]);
//                double originalAmount = Double.parseDouble(deductibleInfo[3]);
//
//                if (deductibleType.equalsIgnoreCase(deductibleInfo[1])) {
//                    logPass(logTest, "deductibleType = " + deductibleType);
//                    switch (deductibleType) {
//                        case "REDUCED":
//                            if (!deductibleInfo[0].contains("STGO") && (amount == Math.round(((originalAmount * 50) / 100) * 100) / 100)) {
//                                logPass(logTest, resolutionName + " has deductible amount (" + amount + ") equals half of original amount (" + originalAmount + ")");
//                            } else if (deductibleInfo[0].contains("STGO") && (amount == 25)) {
//                                logPass(logTest, resolutionName + " has deductible amount = 25");
//                            } else if ((subcriptionID.equalsIgnoreCase("subscrip_amznde08012018") || subcriptionID.equalsIgnoreCase("subscrip_014770964554")) && (amount == originalAmount - 25)) {
//                                logPass(logTest, resolutionName + " has deductible amount (" + amount + ") equals original amount (" + originalAmount + ") - 25");
//                            } else
//                                logFail(logTest, resolutionName + " has wrong deductible amount( deductible amount: " + amount + ", original amount: " + originalAmount + ")");
//                            break;
//                        case "REDUCED_FIXED":
//                            // Recheck "AMAZON" word contains
//                            if (amount == originalAmount - 50) {
//                                logPass(logTest, resolutionName + " has deductible amount (" + amount + ") equals original amount (" + originalAmount + ") -50");
//                            } else
//                                logFail(logTest, resolutionName + " has wrong deductible amount( deductible amount: " + amount + ", original amount: " + originalAmount + ")");
//                            break;
//                        case "REDUCED_LIKELY":
//                            if (amount == (originalAmount - (((originalAmount * 25) / 100) * 100) / 100)) {
//                                logPass(logTest, resolutionName + " has deductible amount (" + amount + ") equals original amount (" + originalAmount + ") -24.75");
//                            } else
//                                logFail(logTest, resolutionName + " has wrong deductible amount( deductible amount: " + amount + ", original amount: " + originalAmount + ")");
//                            break;
//                        case "WAIVED":
//                            if (amount == 0 && originalAmount <= 25) {
//                                logPass(logTest, resolutionName + " has deductible amount (" + amount + ")");
//                            } else
//                                logFail(logTest, resolutionName + " has wrong deductible amount( deductible amount: " + amount + ", original amount: " + originalAmount + ")");
//                            break;
//                        case "NONE":
//                            if (amount == 0) {
//                                logPass(logTest, resolutionName + " has deductible amount (" + amount + ")");
//                            } else
//                                logFail(logTest, resolutionName + " has wrong deductible amount( deductible amount: " + amount + ", original amount: " + originalAmount + ")");
//                            break;
//                        default:
//                            if (amount == originalAmount) {
//                                logPass(logTest, resolutionName + " has deductible amount (" + amount + ") equals original amount (" + originalAmount + ")");
//                            } else
//                                logFail(logTest, resolutionName + " has wrong deductible amount( deductible amount: " + amount + ", original amount: " + originalAmount + ")");
//                            break;
//                    }
//                } else {
//                    logFail(logTest, "Expect: " + deductibleType + ". Actual: " + deductibleInfo[1] + ".");
//                }
//            }
//            log4j.info("checkDeductibleInfo...end");
//        } catch (Exception e) {
//            log4j.error("checkDeductibleInfo method - ERROR - " + e);
//            logException(logTest, "checkDeductibleInfo method - ERROR", e);
//        }
//    }
//
//    public String getRegisterURLBaseOnLocale(String locale, ExtentTest logTest) throws IOException {
//        String URL = null;
//        try {
//            log4j.debug("getURLBaseOnLocale...start");
//            switch (locale) {
//                case "es_ES":
//                    URL = ST_SPAIN_PORTAL_URL;
//                    break;
//                case "pt_PT":
//                    URL = ST_POTUGAL_PORTAL_URL;
//                    break;
//                case "da_DK":
//                    URL = ST_DENMARK_PORTAL_URL;
//                    break;
//                case "fi_FI":
//                    URL = ST_FINLAND_PORTAL_URL;
//                    break;
//                case "sv_SE":
//                    URL = ST_SWEDEN_PORTAL_URL;
//                    break;
//                case "de_DE":
//                    URL = ST_GERMANY_PORTAL_URL;
//                    break;
//
//                //default is de_AT
//                default:
//                    URL = ST_AUSTRIA_PORTAL_URL;
//                    break;
//            }
//            log4j.info("getURLBaseOnLocale...end");
//        } catch (Exception e) {
//            log4j.error("getURLBaseOnLocale method - ERROR - " + e);
//            logException(logTest, "getURLBaseOnLocale method - ERROR", e);
//        }
//        return URL;
//    }
//
//    public void openProductInfoPage(ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Open product information page...start");
//            logInfo(logTest, "Open product information page");
//
//            facaSubmitPage0Page = PageFactory.initElements(Utility.getDriver(), FACASubmitPage0Page.class);
//            facaSubmitPage0Page.clickButtonUpdateItem(logTest);
//            facaUpdateProductInformationPage = PageFactory.initElements(Utility.getDriver(), FACAUpdateProductInformationPage.class);
//            waitForControl(facaUpdateProductInformationPage.textbox_SerialNumber);
//            //wait 2s for stability after control exist
//            sleep(2);
//
//            log4j.info("Open product information page...end");
//        } catch (Exception e) {
//            log4j.error("openProductInfoPage method - ERROR - " + e);
//            logException(logTest, "openProductInfoPage method - ERROR", e);
//        }
//    }
//
//    public void quitBrowser(ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Quit a current open browser...start");
//            Utility.getDriver().quit();
//
//            log4j.info("Click on Exit button...end");
//        } catch (Exception e) {
//            log4j.error("clickButtonExit method - ERROR - " + e);
//        }
//    }
//
//    public void updateWarrantyIMEINumber(String warrantyID, String imeiNumber, ExtentTest logTest) throws IOException {
//        try {
//            logInfo(logTest, "Navigate and login to Sales force");
//            salesforceLoginPage = PageFactory.initElements(Utility.getDriver(), SalesforceLoginPage.class);
//            salesforceLoginPage.salesforceLogin(ENVIRONMENT, logTest);
//
//            logInfo(logTest, "Search the warranty on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(warrantyID, logTest);
//
//            logInfo(logTest, "Click on Update Warranty action link");
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            salesforceWarrantyDetailPage.clickOnUpdateWarrantyActionLink(logTest);
//
//            logInfo(logTest, "Update SerialNumber");
//            salesforceUpdateWarrantyPage = PageFactory.initElements(Utility.getDriver(), SalesforceUpdateWarrantyPage.class);
//            salesforceUpdateWarrantyPage.updateSerialNumber(imeiNumber, logTest);
//
//            // It takes some time to refresh data in SF
//            sleep(5);
//            salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//            refreshPage();
//
//            log4j.debug("Updating warranty SerialNumber on salesforce...end");
//        } catch (Exception e) {
//            log4j.error("updateWarrantyIMEINumber method - ERROR - " + e);
//            logException(logTest, "updateWarrantyIMEINumber method - ERROR", e);
//        }
//    }
//
//    public void checkPartID(String warrantyID, Boolean exist, ExtentTest logTest) throws IOException {
//        try {
//            log4j.debug("Check Part ID exist...start");
//            sleep(2);
//            String partID = readingFromDB.getPartID(warrantyID, logTest);
//            if ((partID == null && exist == false) || ((partID != null && exist == true)))
//                logPass(logTest, "");
//            else
//                logFail(logTest, "");
//            log4j.info("Check Part ID exist...end");
//        } catch (Exception e) {
//            log4j.error("Check Part ID exist - ERROR - " + e);
//        }
//    }
//
//
//    /**
//     * @param
//     * @Action:
//     * @Purpose: File down a Frame list to support clickSalesforceConsoleLink() method and doesSalesforceConsoleElementExist() method
//     */
//    public List<WebElement> getFrameListInCurrentPage() {
//        By byIFrameTag = By.tagName("iframe");
//        List<WebElement> iframeList = Utility.getDriver().findElements(byIFrameTag);
//
//        return iframeList;
//    }
//
//    /**
//     * @param consoleElement
//     * @Action: clickSalesforceConsoleLink (consoleLink)
//     * @Purpose: Check a element in a frame of Console view when the there is no thing to identify frame (id, name,...are changed dynamically)
//     */
//    public boolean doesSalesforceConsoleElementExist(WebElement consoleElement) throws IOException {
//        List<WebElement> iframeList = getFrameListInCurrentPage();
//        int iFrameTotal = iframeList.size();
//        boolean checkPoint = false;
//        if (iFrameTotal > 0)
//            for (int i = 0; i < iFrameTotal; i++) {
//                WebElement iframeElement1 = iframeList.get(i);
//                Utility.getDriver().switchTo().frame(iframeElement1);
//                if (doesControlExist(consoleElement)) {
//                    System.out.println("Found" + consoleElement + " element ");
//                    Utility.getDriver().switchTo().defaultContent();
//                    checkPoint = true;
//                    break;
//                }
//                Utility.getDriver().switchTo().defaultContent();
//            }
//        else
//            System.out.println("Do not find any web element which match the input value");
//        return checkPoint;
//    }
//
//    /**
//     * @param consoleElement
//     * @Action: clickSalesforceConsoleLink (consoleLink)
//     * @Purpose: Find and click link in a frame of Console view when the there is no thing to identify frame (id, name,...are changed dynamically)
//     */
//    public void clickSalesforceConsoleElement(WebElement consoleElement) throws IOException {
//        List<WebElement> iframeList = getFrameListInCurrentPage();
//        int iFrameTotal = iframeList.size();
//        if (iFrameTotal > 0)
//            for (int i = 0; i < iFrameTotal; i++) {
//                WebElement iframeElement1 = iframeList.get(i);
//                Utility.getDriver().switchTo().frame(iframeElement1);
//                if (doesControlExist(consoleElement)) {
//                    scrollIntoView(consoleElement);
//                    waitForControlToBeClickable(consoleElement);
//                    consoleElement.click();
//                    Utility.getDriver().switchTo().defaultContent();
//                    System.out.println("Click on" + consoleElement + "console link");
//                    break;
//                }
//                Utility.getDriver().switchTo().defaultContent();
//            }
//        else
//            System.out.println("Do not find any web element which match the input value");
//    }
//
//
//    /**
//     * @param claimID,Status,Manufacturer
//     * @Action: Retirive the data from appointment info table.
//     * @Purpose: Validate the appointments are getting stored in the product column appointment info tbl.
//     */
//
//    public void checkAppointmentDetailsFromDBAfterSelectingAppointment(String claimID,String Status,String Manufacturer,ExtentTest logTest) throws IOException {
//        try {
//            HashMap<String,String>hm=new HashMap<String, String>();
//            log4j.debug("Verify that appointment details  on DB...starts");
//            logInfo(logTest, "Get appointment status and appointment details");
//            hm= readingFromDB.getAppointmentDetails(claimID, logTest);
//            logInfo(logTest, "Verifying appointments info claim id");
//            System.out.print(hm.get("a1").toString());
//            verifyExpectedAndActualResults(logTest,claimID,hm.get("a1").toString());
//            logInfo(logTest, "Verifying appointments status");
//            System.out.print(hm.get("a2").toString());
//            verifyExpectedAndActualResults(logTest,Status,hm.get("a2").toString());
//            logInfo(logTest, "Verifying manufacturer details for the device.");
//            System.out.print(hm.get("a3").toString());
//            verifyExpectedAndActualResultsSubString(logTest,Manufacturer,hm.get("a3").toString());
//
//            log4j.info("Verification for the appointments ...ends");
//        } catch (Exception e) {
//            log4j.error("checkAppointmentStatusAfterUpdatingDB method - ERROR - " + e);
//            logException(logTest, "checkAppointmentStatusAfterUpdatingDB method - ERROR", e);
//        }
//    }
//
//    /*----------- Common Methods end here -----------*/
//
//    /**
//     * @purpose: execute query and get warrany id from Hashmap result
//     * @return : return warranty ID
//     */
//    public String getRPIDProduction(String buyerEmail, ExtentTest logTest) throws IOException, SQLException {
//        String rpd = null;
//        try {
//            HashMap warrantyInfo = database.executeQueryAndGetFirstResult(logTest, MERCHANT,queryDatabase.GET_WARRANTY_ID_PROD,buyerEmail);
//            rpd = warrantyInfo.get("warranty_id").toString();
//
//        } catch (Exception e) {
//            log4j.error("getRPID method - ERROR - " + e);
//            logException(logTest, "getRPID method - ERROR", e);
//        }
//        return rpd;
//    }
//
//    /**
//     * @purpose: execute query and get claim id from Hashmap result
//     * @return : return claim ID
//     */
//    public String getClaimID(String warrantyID, ExtentTest logTest) throws IOException, SQLException {
//        String claimID = null;
//        HashMap claimInfo = null;
//        try {
//            if (ENVIRONMENT.equalsIgnoreCase(PRODUCTION)){
//                claimInfo = database.executeQueryTillNotNull(logTest,WARRANTY,"id",queryDatabase.GET_CLAIM_INFO_PROD,warrantyID);
//            }
//            else
//            {
//                claimInfo = database.executeQueryAndGetFirstResult(logTest,WARRANTY,queryDatabase.GET_CLAIM_INFO_DESC_SORT,warrantyID);
//            }
//            claimID = claimInfo.get("id").toString();
//
//        } catch (Exception e) {
//            log4j.error("getClaimID method - ERROR - " + e);
//            logException(logTest, "getClaimID method - ERROR", e);
//        }
//        return claimID;
//    }
//
//    public HashMap getEventState(String objectID, String evenType, ExtentTest logTest) throws IOException {
//        try {
//            HashMap event = database.executeQueryAndGetFirstResult(logTest, WARRANTY, queryDatabase.GET_EVENT, objectID, evenType);
//            String evenID =  event.get("id").toString();
//
//            return database.executeQueryAndGetFirstResult(logTest, WARRANTY, queryDatabase.GET_EVENT_STATE, evenID);
//
//        } catch (Exception e) {
//            log4j.error("getEventState method - ERROR - " + e);
//            logException(logTest, "getEventState method - ERROR", e);
//        }
//        return null;
//    }
//
//    /**
//     * @param RpdID,Status,origin,statusReason
//     * @Action: Retirive the data from pop submission info table.
//     * @Purpose: Validate the pop submission are getting stored in the pop submission tbl.
//     */
//
//    public void checkPopSubmissionsValidation(String RpdID,String Status,String statusReason,String origin,ExtentTest logTest) throws IOException {
//        try {
//            HashMap<String,String>hm=new HashMap<String, String>();
//            log4j.debug("Verify that appointment details  on DB...starts");
//            logInfo(logTest, "Get POP submissions details");
//            hm= readingFromDB.getPopSubmissionsDetail(RpdID, logTest);
//            logInfo(logTest, "Verifying POP submissions info rpd id");
//            verifyExpectedAndActualResults(logTest,RpdID,hm.get("a1").toString());
//            logInfo(logTest, "Verifying pop status");
//            verifyExpectedAndActualResults(logTest,Status,hm.get("a2").toString());
//            logInfo(logTest, "Verifying  POP submissions status reason");
//            verifyExpectedAndActualResultsSubString(logTest,statusReason,hm.get("a3").toString());
//            logInfo(logTest, "Verifying  POP submissions origin");
//            verifyExpectedAndActualResultsSubString(logTest,statusReason,hm.get("a3").toString());
//
//            log4j.info("Verification for the POP submissions ...ends");
//        } catch (Exception e) {
//            log4j.error("checkAppointmentStatusAfterUpdatingDB method - ERROR - " + e);
//            logException(logTest, "checkAppointmentStatusAfterUpdatingDB method - ERROR", e);
//        }
//    }
//
//    /**
//     * Resend the purchase confirmation email n times (after the first purchase confirmation email get delivered when purchasing the warranty)
//     * and verify the last email is marked as SPAM
//     * @param n The number of times the purchase confirmation email is resent
//     * @param emailAddress Email address to which the purchase confirmation email is resent
//     * @param warrantyID ID of purchased warranty
//     * @param emailTemplateID Email template ID
//     * @param logTest
//     * @throws IOException
//     */
//    public void resendPurchaseConfirmationEmailNTimesAndVerifyLastEmailMarkAsSpam(int n, String emailAddress, String warrantyID, String emailTemplateID, ExtentTest logTest) throws IOException {
//        log4j.info("resendConfirmationPurchaseEmailNTimesAndVerifyEmailStatus...starts");
//        try {
//            logInfo(logTest, "Navigate and login to Sales force");
//            salesforceLoginPage = PageFactory.initElements(Utility.getDriver(), SalesforceLoginPage.class);
//            salesforceLoginPage.salesforceLogin(ENVIRONMENT, logTest);
//
//            logInfo(logTest, "Search the warranty on Sales force");
//            salesforceHomePage = PageFactory.initElements(Utility.getDriver(), SalesforceHomePage.class);
//            salesforceHomePage.salesforceSearchRpid(warrantyID, logTest);
//
//
//            for (int i = 1; i <= n; i++) {
//
//                logInfo(logTest, "Start of re-sending email " + i + " time");
//
//                logInfo(logTest, "Click on Resend Warranty Contract link");
//                salesforceWarrantyDetailPage = PageFactory.initElements(Utility.getDriver(), SalesforceWarrantyDetailPage.class);
//                salesforceWarrantyDetailPage.clickLinkResendWarrantyContract();
//
//                logInfo(logTest, "Resend warranty contract to user");
//                salesforceResendWarrantyContractPage = PageFactory.initElements(Utility.getDriver(), SalesforceResendWarrantyContractPage.class);
//                salesforceResendWarrantyContractPage.resendWarrantyContract(logTest);
//
//                //steps for getting status from communicationDB
//                logInfo(logTest, "Get the variable Data from from communication DB");
//                if (i < n) {
//                    // The number of success emails includes the first one which is sent when purchasing the warranty
//                    databaseValidation.checkNumberSuccessEmailEventRecorded(emailTemplateID, emailAddress, i+1, logTest);
//                }
//                else {
//                    databaseValidation.checkEmailStatusRecorded(emailTemplateID, emailAddress, "SPAM", logTest);
//                }
//
//                logInfo(logTest, "End of re-sending email " + i + " time");
//
//                log4j.info("resendConfirmationPurchaseEmailNTimesAndVerifyEmailStatus...ends");
//            }
//        }catch(Exception e){
//            log4j.error("resendConfirmationPurchaseEmailNTimesAndVerifyEmailStatus method - ERROR - " + e);
//            logException(logTest, "resendConfirmationPurchaseEmailNTimesAndVerifyEmailStatus method - ERROR", e);
//        }
//    }
}

