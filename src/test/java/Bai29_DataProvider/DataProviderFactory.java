package Bai29_DataProvider;

import helpers.ExcelHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "LoginData01")
    public Object[][] getDataLogin01() {
        return new Object[][]{
                {"admin@example.com", 123456},
                {"user@example.com", 123}
        };
    }

    @DataProvider(name = "LoginData2", parallel = true)
    public Object[][] getDataLogin02() {
        return new Object[][]{{"admin@example.com", 123456, "Admin"},
                {"user@example.com", 123, "User"},
                {"customer@example.com", 123, "Customer"}
        };
    }

    @DataProvider(name = "AddNewCustomerData", parallel = false)
    public Object[][] getAddNewCustomerData() {
        return new Object[][]{
                {"Ray airfeed 01", "Gold", "EUR","Vietnamese","Vietnam"},
                {"Ray airfeed 02", "VIP", "USD","English","Germany"},
                {"Ray airfeed 03", "Silver", "USD","French","France"}
        };
    }

    @DataProvider(name = "data_provider_login_excel")
    public Object[][] data_provider_login_excel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataExcel.xlsx", "Login");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_hashtable",parallel = true)
    public Object[][] data_provider_login_excel_hashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataExcel.xlsx", "Login",2,4);
        System.out.println("Login Data from Excel (Hashtable): " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_specific_rows", parallel = true)
    public Object[][] data_provider_login_excel_specific_rows() {
        ExcelHelper excelHelper = new ExcelHelper();
        int[] specificRows = new int[] {
                1, 3, 4}; //Dòng cụ thể cần lấy
        Object[][] data = excelHelper.getDataFromSpecificRows(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataExcel.xlsx", "Login", specificRows);
        System.out.println("getDataFromSpecificRows: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_specific_rows_hashtable", parallel = true)
    public Object[][] data_provider_login_excel_specific_rows_hashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        int[] specificRows = new int[] {1, 3, 4}; //Dòng cụ thể cần lấy
        Object[][] data = excelHelper.getDataHashTableFromSpecificRows(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataExcel.xlsx", "Login", specificRows);
        System.out.println("getDataHashTableFromSpecificRows: " + data);
        return data;
    }

}
