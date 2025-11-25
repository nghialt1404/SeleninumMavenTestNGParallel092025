package Bai26_ParallelExcution_POM.pages;

import drivers.DriverManager;
import keyword.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CustomersPage extends BasePage {


    //Locators Element trang Customers Page
    private By headerCustomersPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By labelTotalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVatNumber = By.xpath("//input[@id='vat']");
    private By inputphone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputZipcode = By.xpath("//input[@id='zip']");


    private By dropdownGroup = By.xpath("//button[contains(@data-id,'groups_in')]");
    private By inputSearchGroup = By.xpath("//button[contains(@data-id , 'groups_in')]/following-sibling::div//input[@type='search']");

    private By dropdownCurrency = By.xpath("//button[contains(@data-id , 'default_currency')]");
    private By inputSearchCurrency = By.xpath("//button[contains(@data-id , 'default_currency')]/following-sibling::div//input[@type='search']");

    private By dropdownDefaultLanguage = By.xpath("//button[contains(@data-id , 'default_language')]");
    private By optionLanguageVietnamese = By.xpath("//span[normalize-space() = 'Vietnamese'");
    //private By optionLanguageDynamic = By.xpath("//span[normalize-space()='%s']"); //%s giá trị String, %d giá trị số

    private By dropdownCountry = By.xpath("//button[contains(@data-id,'country')]");
    private By inputSearchCountry = By.xpath("//button[contains(@data-id , 'country')]/following-sibling::div//input[@type='search']");

    private By buttonSaveandCreatecontact = By.xpath("//button[normalize-space() ='Save and create contact']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']/descendant::button[normalize-space()='Save']");

    private By alertmessage = By.xpath("//span[normalize-space()='Customer added successfully.']");

    // Phương thức của trang Customer Page

    public void selectLanguage(String language) {
        WebUI.clickElement(dropdownDefaultLanguage);
        String xpathLanguage = "//span[normalize-space()='" + language + "']";
        System.out.println("Selecting language:" + language);
        WebUI.clickElement(By.xpath(xpathLanguage));

    }

    public void verifyCustomersPageDisplayed() {

        boolean CustomersPageIsDisplayed = WebUI.checkElementExist(headerCustomersPage);
        Assert.assertTrue(CustomersPageIsDisplayed, "Customers Page is not display");
    }

    public void clickMenuCustomersPage() {
        WebUI.clickElement(menuCustomers);
    }

    public void clickAddNewCustomer() {
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void fillDataNewCustomer(String company, String group, String currency, String language, String country) {

        WebUI.setText(inputCompany, company);
        WebUI.setText(inputVatNumber, "1404");
        WebUI.setText(inputphone, "0948432746");
        WebUI.setText(inputWebsite, "https//anhtester.com");
        WebUI.setText(inputAddress, "190 Hàng Đẫy");
        WebUI.setText(inputCity, "Hà Nội");
        WebUI.setText(inputState, "Hà Nội");
        WebUI.setText(inputZipcode, "700000");

        // Select Group

        WebUI.clickElement(dropdownGroup);
        WebUI.setText(inputSearchGroup, group);
        WebUI.clickElement(By.xpath("//a[normalize-space()='" + group + "']"));
        WebUI.clickElement(dropdownGroup);

        // Select Currency

        WebUI.clickElement(dropdownCurrency);
        WebUI.setText(inputSearchCurrency, currency);
        WebUI.clickElement(By.xpath("//span[contains(text(),'" + currency + "')]"));

        // Select Language

        selectLanguage(language);

        // Select  country
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, country);
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + country + "']"));

    }

    public void clickSaveButton() {
        WebUI.clickElement(buttonSave);
    }


    public void verifyAddNewCustomerSuccess() {

        boolean isAlertDisplay = WebUI.checkElementExist(alertmessage, 5, 1000);
        Assert.assertTrue(isAlertDisplay, "Alert Message is not display");

        String alertText = WebUI.getElementText(alertmessage);
        System.out.println("Alert Messgase: " + alertText);
        Assert.assertEquals(alertText, "Customer added successfully.", "Alert Message does not math expected");

    }

    public void searchAndCheckDataInTable(int column, String data, String columnName) {
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearchCustomer, data);
        WebUI.sleep(2);
        WebUI.waitForPageLoaded();
        WebUI.checkDataInTableByColumn_Contains(column, data, columnName);
    }

    public void verifyCustomerDetails(String company, String group, String currency, String language, String country) {
        String companyValue = WebUI.getElementAttribute(inputCompany, "value");
        System.out.println("Company Value: " + companyValue);
        Assert.assertEquals(companyValue, company, "Company value not match");

        String vatValue = WebUI.getElementAttribute(inputVatNumber, "value");
        ;
        System.out.println("Vat Value: " + vatValue);
        Assert.assertEquals(vatValue, "1404", "Vat value not match");

        String phoneValue = WebUI.getElementAttribute(inputphone, "value");
        System.out.println("Phone Value: " + phoneValue);
        Assert.assertEquals(phoneValue, "0948432746", "Phone value not match");

        String websiteValue = WebUI.getElementAttribute(inputWebsite, "value");
        System.out.println("Website Value: " + websiteValue);
        Assert.assertEquals(websiteValue, "https//anhtester.com", "Website value not match");
        // giá trị nào nằm trong thẻ input thì phải xài getAtribute, còn nằm trong thẻ khác thì dùng getText


    }


}
