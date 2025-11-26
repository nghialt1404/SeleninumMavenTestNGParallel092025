package Expand_hand;

import Utils.LogUtils;
import common.BaseTest;
import keyword.WebUI;
import org.apache.poi.ss.formula.functions.Na;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HandleTable extends BaseTest {

    @Test
    public void testSearchDataInTable() {
        getLoginPage().loginCRM("admin@example.com", "123456");
        getDashBoardPage().clickMenuCustomers();
        getCustomersPage().searchAndCheckDataInTable(3, "CustomerName", "Company");
    }

    @Test
    public void testCheckPaginationOnTable() {
        getLoginPage().loginCRM("admin@example.com", "123456");
        getDashBoardPage().clickMenuCustomers();

        //Data search read from Properties
        String searchValue = "Anh Tester";

        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='clients_length']")));
        System.out.println(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item / trang: " + itemTotalOnePage);

        //Set Text on Search input
        getCustomersPage().searchDataCustomer(searchValue);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);

        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='clients_info']"));
        ArrayList<String> list = new ArrayList<String>();

        // Tách chuỗi theo khoảng trắng sau đó cho vào Arraylist

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        // Lấy phần tử thứ 6 ( Trong Arraylist là 5)

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            WebUI.checkDataInTableByColumn_Contains(3, searchValue, "Company");

            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[normalize-space()='Next']"));
                WebUI.sleep(2);
            }
        }

    }
}
