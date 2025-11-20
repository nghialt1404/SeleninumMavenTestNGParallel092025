package listener;

import Utils.LogUtils;
import helpers.CaptureHelper;
import helpers.SystemHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.sound.midi.Soundbank;

public class TestListener implements ITestListener {

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
        // Generate Report
        // Send email
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Bắt đầu chạy test case: " + result.getName());
        // count_total++;
        // Write log to file
        CaptureHelper.startRecord(result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");
        LogUtils.info("==> Status: " + result.getStatus());
        //count_passsed++
        // Write log to file
        // Write Status to report
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        //LogUtils.info("==> Status: " + result.getStatus());
        //count_failed++
        LogUtils.error(" ==> Reason : " + result.getThrowable());
        CaptureHelper.takeScreenShot(result.getName());
        // Create ticket on Jira
        // Write log to file
        // Write Status to Report
        CaptureHelper.stopRecord();


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("Test case " + result.getName() + " is skipped.");
        LogUtils.warn("==> Status: " + result.getStatus());
        // Write log to file
        // Write Status to Report
        CaptureHelper.stopRecord();

    }
}


