package Bai29_DataProvider;

import Bai26_ParallelExcution_POM.pages.CustomersPage;
import Bai26_ParallelExcution_POM.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Demo_DataProvider_FromExcel extends BaseTest {


    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
    public void testLoginCRM_01(String email, String password) {
        System.out.println("Email: " + email + " | Password : " + password);
        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM(email,password);
        loginPage.verifyLoginSuccess();
    }

    @Test(dataProvider = "data_provider_login_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginCRM_02(Hashtable<String,String> data) {
        System.out.println("Email: " + data.get("email") + " | Password : " + data.get("password"));
        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM(data.get("email"),data.get("password"));
        loginPage.verifyLoginSuccess();
    }

    // Sử dụng DataProvider với các dòng cụ thể (1, 3, 4)
    @Test(dataProvider = "data_provider_login_excel_specific_rows", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithSpecificRows(String email, String password) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    // Sử dụng DataProvider với các dòng cụ thể dạng Hashtable
    @Test(dataProvider = "data_provider_login_excel_specific_rows_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginWithSpecificRowsHashtable(Hashtable < String, String > data) {
        String email = data.get("email");
        String password = data.get("password");

        System.out.println("Username: " + email);
        System.out.println("Password: " + password);
    }


}