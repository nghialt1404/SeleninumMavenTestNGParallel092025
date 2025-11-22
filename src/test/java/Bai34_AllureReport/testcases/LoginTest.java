package Bai34_AllureReport.testcases;

import Bai34_AllureReport.pages.LoginPage;
import common.BaseTest;
import io.qameta.allure.*;
import org.testng.SkipException;
import org.testng.annotations.Test;

@Epic("CRM 2.0 Test Automation")
@Feature("Login user feature")
@Story("Login with valid and invalid credentials")
public class LoginTest extends BaseTest {

    private LoginPage loginPage;


    @Description("Verify user can login with valid credentials")
    @Link(name ="https://jira.com/login/CRM-01",url = "https://jira.com/login/CRM-01")
    @Test(priority = 1, testName = "Login Success", description = "Verify user can login with valid credentials")
    public void testLoginSuccess() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

    }

    @Description("Verify user can not login with invalid email")
    @Severity(SeverityLevel.CRITICAL)
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
