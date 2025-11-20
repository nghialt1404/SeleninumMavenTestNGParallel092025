package Bai32_Log4j2.testcases;

import Bai32_Log4j2.pages.CustomersPage;
import Bai32_Log4j2.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private LoginPage loginPage;
    private CustomersPage customersPage;
    @Test
    public void testAddNewCustomerSuccess(){
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com","123456");

        customersPage = new CustomersPage();
        customersPage.clickMenuCustomersPage();
        customersPage.verifyCustomersPageDisplayed();


        customersPage.clickAddNewCustomer();
        customersPage.fillDataNewCustomer("Airfeed Ltd","VIP","USD","Vietnamese","Vietnam");
        customersPage.clickSaveButton();

        customersPage.verifyAddNewCustomerSuccess();

        customersPage.verifyCustomerDetails("Airfeed Ltd","VIP","USD","Vietnamese","Vietnam");
    }

}
