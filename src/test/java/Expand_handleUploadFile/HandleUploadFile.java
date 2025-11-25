package Expand_handleUploadFile;

import common.BaseTest;
import helpers.SystemHelper;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleUploadFile extends BaseTest {
    @Test
    public void testUploadFileWithSendKeys() {

        WebUI.openURL("https://the-internet.herokuapp.com/upload");
        WebUI.sleep(2);

        By inputFileUpload = By.xpath("//input[@id='file-upload']");

        String filePath = SystemHelper.getCurrentDir() + "src/test/resources/testdata/2025-11-22 12.41.07.jpg";
        WebUI.setText(inputFileUpload, filePath);
        WebUI.sleep(2);

        WebUI.clickElement(By.xpath("//input[@id='file-submit']"));
        WebUI.waitForPageLoaded();

        Assert.assertTrue(WebUI.checkElementExist(By.xpath("//h3[normalize-space()='File Uploaded!']")), "Upload file không thành công");
    }

    
    // Phần này đang bị lỗi không chạy được do máy Mac
    @Test
    public void testUploadFileWithRobotClass() {
        WebUI.openURL("https://files.fm/");
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);

        By textOnPage = By.xpath("//div[@id='file_select_dragndrop_text']");
        By divFileUpload = By.xpath("//div[@id='uploadifive-file_upload']");
        By inputFileUpload = By.xpath("//div[@id='file_select_button']//input[@id='file_upload']");

        String filePath = SystemHelper.getCurrentDir() + "src/test/resources/testdata/2025-11-22 12.41.07.jpg";


        WebUI.uploadFileWithRobotClass(divFileUpload,filePath);

        // Verify upload thành công
        By fileNameAfterUpload = By.xpath("//span[@class='file-name']");
        Assert.assertTrue(WebUI.checkElementExist(fileNameAfterUpload), "Upload file không thành công");
        WebUI.assertEquals(WebUI.getElementText(fileNameAfterUpload), "2025-11-22 12.41.07.jpg", "File upload không đúng");
    }

}
