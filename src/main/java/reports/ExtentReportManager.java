package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("report/extentreport/extentreport.html");
        reporter.config().setReportName("AutoMation Testing Report | CRM Project");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | CRM Project ");
        extentReports.setSystemInfo("Author", "Anh Tester");
        return extentReports;
    }

}


