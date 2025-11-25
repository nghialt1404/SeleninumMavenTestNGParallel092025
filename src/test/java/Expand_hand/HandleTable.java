package Expand_hand;

import common.BaseTest;
import keyword.WebUI;
import org.testng.annotations.Test;

public class HandleTable extends BaseTest {

    @Test
    public void testSearchDataInTable(){
        getLoginPage().loginCRM("admin@example.com","123456");
        getDashBoardPage().clickMenuCustomers();
        getCustomersPage().searchAndCheckDataInTable(3,"CustomerName","Company");


    }
}
