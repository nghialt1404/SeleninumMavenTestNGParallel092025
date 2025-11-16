package Bai31_TestListener.pages;

import keyword.WebUI;
import org.openqa.selenium.By;


public class BasePage {

    // Ele;;ments chung cho tất cả các page

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuContracts = By.xpath("//span[normalize-space()='Contracts']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");

    public By iconprofile = By.xpath("//li[@class='icon header-user-profile']//img");
    public By optionLogOut = By.xpath("//a[text()='Logout']");


    // methods
    public void logoutsystem() {
        WebUI.clickElement(iconprofile);
        WebUI.clickElement(optionLogOut);
    }

    public void clickMenuDashboard() {
        WebUI.clickElement(menuDashboard);
    }

    public CustomersPage clickMenuCustomers() {
        WebUI.clickElement(menuCustomers);
        return new CustomersPage();
    }

    public ProjectsPage clickMenuProject() {

        WebUI.clickElement(menuProjects);
        return new ProjectsPage();
    }

}

