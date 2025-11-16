package Bai30_ScreenShot_RecordVideo;

import Bai26_ParallelExcution_POM.pages.LoginPage;
import common.BaseTest;
import drivers.DriverManager;
import helpers.CaptureHelper;
import helpers.SystemHelper;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DemoVideoRecord extends BaseTest {
    @Test
    public void testVideoRecord(Method method) {

        CaptureHelper.startRecord(method.getName());
        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();

    }
}
