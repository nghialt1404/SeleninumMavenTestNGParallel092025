package Bai30_ScreenShot_RecordVideo;

import common.BaseTest;
import drivers.DriverManager;
import helpers.CaptureHelper;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DemoScreenShot extends BaseTest {
    @Test
    public void testScreenShot() {
        WebUI.openURL("https://anhtester.com");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Anh Tester Automation Testing");
        WebUI.clickElement(By.xpath("//a[@id='btn-login']"));
        WebUI.waitForPageLoaded();

    }

}