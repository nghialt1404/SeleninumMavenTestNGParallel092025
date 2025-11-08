package common;

import drivers.DriverManager;
import helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public SoftAssert softAssert;

    @BeforeSuite
    public void setupBeforeSuite() {
        PropertiesHelper.loadAllFiles();
    }


    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chorme") String browserName) {
        WebDriver driver;
        if (PropertiesHelper.getValue("BROWSER").isEmpty() || PropertiesHelper.getValue("BROWSER") == null) {
            browserName = browserName;
        } else {
            browserName = PropertiesHelper.getValue("BROWSER");
        }
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");
                ChromeOptions option = new ChromeOptions();
                if (PropertiesHelper.getValue("headless").equalsIgnoreCase("true")) {
                    option.addArguments("--headless=new"); // chạy headless
                    option.addArguments("--window-size=" + PropertiesHelper.getValue("window_size")); // set kích thước
                }
                driver = new ChromeDriver(option);
                break;
            case "firefox":
                System.out.println("Launching Firefox browser...");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Launching Edge browser...");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();

        }
        DriverManager.setDriver(driver);
        if (PropertiesHelper.getValue("headless").equalsIgnoreCase("false")) {
            DriverManager.getDriver().manage().window().maximize();
        }


        softAssert = new SoftAssert();

    }

    @AfterMethod
    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
            softAssert.assertAll();
        }
    }
}
