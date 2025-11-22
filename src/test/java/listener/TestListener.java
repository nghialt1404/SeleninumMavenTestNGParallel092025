package listener;

import Utils.LogUtils;
import com.aventstack.extentreports.Status;
import constants.DataConfig;
import helpers.CaptureHelper;
import helpers.PropertiesHelper;
import helpers.SystemHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.AllureManager;
import reports.ExtentReportManager;
import reports.ExtentTestManager;

import javax.sound.midi.Soundbank;

import static constants.DataConfig.*;


public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }


    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("Setup môi trường onStart: " + result.getStartDate());
        // Initialize Report
        // Connect to Database
        // Call API get Token
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("Kết thúc bộ test: " + result.getEndDate());

        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Write log to file
        LogUtils.info("Bắt đầu chạy test case: " + result.getName());
        // count_total++;

        if (VIDEO_RECORD.equals("true")) {
            CaptureHelper.startRecord(result.getName());
        }

        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");
        LogUtils.info("==> Status: " + result.getStatus());
        //count_passsed++


        //Extent Report
        if (SCREENSHOT_SUCCESS.equals("true")) {
            ExtentTestManager.addScreenshot(result.getName());
        }
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");

        if (VIDEO_RECORD.equals("true")) {
            CaptureHelper.stopRecord();
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        LogUtils.info("==> Status: " + result.getStatus());
        //count_failed++
        LogUtils.error(" ==> Reason : " + result.getThrowable());
        CaptureHelper.takeScreenShot(result.getName());

        //Extent Report
        if (SCREENSHOT_FAILURE.equals("true")) {
            ExtentTestManager.addScreenshot(result.getName());
        }
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

        if (VIDEO_RECORD.equals("true")) {
            CaptureHelper.stopRecord();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("Test case " + result.getName() + " is skipped.");
        LogUtils.warn("==> Status: " + result.getStatus());

        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.SKIP, result.getName() + " is skipped.");

        if (VIDEO_RECORD.equals("true")) {
            CaptureHelper.stopRecord();
        }


    }
}


