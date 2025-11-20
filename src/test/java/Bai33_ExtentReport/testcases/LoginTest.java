package Bai33_ExtentReport.testcases;

import Bai33_ExtentReport.pages.BasePage;
import Bai33_ExtentReport.pages.LoginPage;
import common.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Test(priority = 1, testName = "Login Success", description = "Verify user can login with valid credentials")
    public void testLoginSuccess() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

    }

    @Test(priority = 2)
    public void testLoginFailWithInvalidEmail() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 3)
    public void testLoginFailWithInvalidPassword() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456789");
        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailWithEmailNull() {
        loginPage = new LoginPage();
        loginPage.loginCRM("", "123456789");
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailWithPasswordNull() {
        throw new SkipException("Skipping The Test Method ");
//        loginPage = new LoginPage();
//        loginPage.loginCRM("admin@example.com", "");
//        loginPage.verifyLoginFailureWithPasswordNull();
    }


}
