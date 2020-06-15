package com.logigear.training.utilities.reports;
import com.logigear.training.utilities.DriverUtils;
import com.relevantcodes.extentreports.ExtentReports;

import static com.logigear.training.common.Constants.OUTPUT_PATH;

public class ExtentManager {
    private static ExtentReports extent;
    //Initiate local variables for generating time stamp
    public static String timeStampString = DriverUtils.generateTimeStampString("yyyy-MM-dd-HH-mm-ss");
    public static String reportLocation = OUTPUT_PATH + "report-" + timeStampString + "/";
    public static String reportFilePath = reportLocation + "report-" + timeStampString + ".html";
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                extent = new ExtentReports(reportFilePath, true);
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                extent = new ExtentReports(reportFilePath, true);
            }
        }
        return extent;
    }
}
