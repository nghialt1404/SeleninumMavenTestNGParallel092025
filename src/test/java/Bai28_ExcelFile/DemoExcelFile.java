package Bai28_ExcelFile;

import common.BaseTest;
import helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoExcelFile extends BaseTest {
    @Test
    public void testReadExcelfile(){
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/DataExcel.xlsx","Login");

        System.out.println(excel.getCellData("email",1));
        System.out.println(excel.getCellData("password",1));

    }
}
