package Bai32_Log4j2.pages;

import Utils.LogUtils;
import helpers.PropertiesHelper;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    // Khai báo driver trong từng trang

    private String urlCRM = "https://crm.anhtester.com/admin";


    // Khai báo đối tượng element thuộc về trang Login
    private By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By checkboxRememberMe = By.xpath("label[for='remember']");
    private By errorMessageInvalid = By.xpath("//div[@class='text-center alert alert-danger' and normalize-space()='Invalid email or password']");
    private By errorMessageRequiredEmail = By.xpath("//div[@class='alert alert-danger text-center' and normalize-space()='The Email Address field is required.']");
    private By errorMessageRequiredPassword = By.xpath("//div[@class='alert alert-danger text-center' and normalize-space()='The Password field is required.']");

    // Khai báo các hàm xử lý trong nội bộ trang Login

    public void verifyLoginPageDisplayed() {
        boolean check = WebUI.checkElementExist(headerLoginPage);
        Assert.assertTrue(check, "Login page is not displayed.");
    }

    public void navigateToLoginPage() {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        WebUI.waitForPageLoaded();
    }

    private void enterEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void enterPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickLoginButton() {
        WebUI.clickElement(buttonLogin);
    }


    public void loginCRM(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WebUI.waitForPageLoaded();
    }

    public DashboardPage loginCRM() {
        navigateToLoginPage();
        enterEmail(PropertiesHelper.getValue("email"));
        enterPassword(PropertiesHelper.getValue("password"));
        clickLoginButton();
        WebUI.waitForPageLoaded();
        verifyLoginSuccess();
        return new DashboardPage();
    }

    public void verifyLoginSuccess() {
        boolean check = WebUI.checkElementExist(By.xpath("//span[normalize-space()='Dashboard']"), 5, 1000);
        Assert.assertTrue(check, "Login failed or Dashboard not displayed.");
    }

    public void verifyLoginFailureWithEmailOrPasswordInvalid() {
        boolean check = WebUI.checkElementExist(errorMessageInvalid, 5, 1000);
        Assert.assertTrue(check, "Error message for invalid email not displayed.");
    }

    public void verifyLoginFailureWithEmailNull() {
        boolean check = WebUI.checkElementExist(errorMessageRequiredEmail, 5, 1000);
        Assert.assertTrue(check, "Error message for required email not displayed.");
    }

    public void verifyLoginFailureWithPasswordNull() {
        boolean check = WebUI.checkElementExist(errorMessageRequiredPassword, 5, 1000);
        Assert.assertTrue(check, "Error message for required password not displayed.");
    }


}
