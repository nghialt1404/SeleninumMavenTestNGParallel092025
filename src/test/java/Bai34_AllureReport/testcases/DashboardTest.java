package Bai34_AllureReport.testcases;

import Bai34_AllureReport.pages.DashboardPage;
import Bai34_AllureReport.pages.LoginPage;
import Bai34_AllureReport.pages.ProjectsPage;
import common.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("CRM 2.0 Test Automation")
@Feature("Dashboard feature")
@Story("Verify labels on Dashboard")

public class DashboardTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardpage;
    private ProjectsPage projectsPage;

    @Link(name = "https://jira.com/login/CRM-04", url = "https://jira.com/login/CRM-04")
    @Test(priority = 1,description = "TC_DASHBOARD_CRM_01")
    public void testLabelProjectInProgress() {
        loginpage = new LoginPage();

        dashboardpage = loginpage.loginCRM();

        dashboardpage.verifyDashBoardPageDisplay();
        dashboardpage.verifyTotalProjectsInProgress();

    }
    
}
