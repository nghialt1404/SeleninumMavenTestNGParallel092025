package Bai29_DataProvider;

import Bai26_ParallelExcution_POM.pages.CustomersPage;
import Bai26_ParallelExcution_POM.pages.LoginPage;
import common.BaseTest;
import org.apache.commons.compress.archivers.zip.X0017_StrongEncryptionHeader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider extends BaseTest {


    @Test(dataProvider = "LoginData01", dataProviderClass = DataProviderFactory.class)
    public void testLogin1(String email, int password) {
        System.out.println("Email: " + email + " | Password : " + password);
    }


    @Test(dataProvider = "LoginData2", dataProviderClass = DataProviderFactory.class)
    public void testLogin2(String email, int password, String role) {
        System.out.println("Email: " + email + " | Password : " + password + " | Role: " + role);
    }


    @Test(dataProvider = "LoginData2", dataProviderClass = DataProviderFactory.class)
    public void testLoginCRM(String email, int password, String role) {
        System.out.println("Email: " + email + " | Password : " + password + " | Role: " + role);
        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM(email, String.valueOf(password));
        loginPage.verifyLoginSuccess();
    }

    @Test(dataProvider = "AddNewCustomerData", dataProviderClass = DataProviderFactory.class)
    public void testAddNewCustomer(String company, String group, String currency, String language, String country) {
        LoginPage loginPage;
        CustomersPage customersPage;

        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");

        customersPage = new CustomersPage();
        customersPage.clickMenuCustomersPage();
        customersPage.verifyCustomersPageDisplayed();


        customersPage.clickAddNewCustomer();
        customersPage.fillDataNewCustomer(company, group, currency, language, country);
        customersPage.clickSaveButton();

        customersPage.verifyAddNewCustomerSuccess();

        customersPage.verifyCustomerDetails(company, group, currency, language, country);
    }


}