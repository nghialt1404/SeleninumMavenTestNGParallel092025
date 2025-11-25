package Bai32_Log4j2.pages;

import keyword.WebUI;
import org.openqa.selenium.By;


public class BasePage {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomersPage customersPage;
    private ProjectsPage projectsPage;

    // Elements chung cho tất cả các page

    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuContracts = By.xpath("//span[normalize-space()='Contracts']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");


    // methods
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage getDashBoardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public CustomersPage getCustomersPage() {
        if (customersPage == null) {
            customersPage = new CustomersPage();
        }
        return customersPage;
    }

    public ProjectsPage getProjectsPage() {
        if (projectsPage == null) {
            projectsPage = new ProjectsPage();
        }
        return projectsPage;
    }

    public DashboardPage clickMenuDashboard() {
        WebUI.clickElement(menuDashboard);
        return new DashboardPage();
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

