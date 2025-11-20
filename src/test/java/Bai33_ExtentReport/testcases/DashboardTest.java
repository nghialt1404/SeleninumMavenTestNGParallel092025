package Bai33_ExtentReport.testcases;

import Bai33_ExtentReport.pages.DashboardPage;
import Bai33_ExtentReport.pages.LoginPage;
import Bai33_ExtentReport.pages.ProjectsPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardpage;
    private ProjectsPage projectsPage;

    @Test
    public void testLabelProjectInProgress() {
        loginpage = new LoginPage();

        dashboardpage = loginpage.loginCRM();

        dashboardpage.verifyDashBoardPageDisplay();
        dashboardpage.verifyTotalProjectsInProgress();

    }
    
}
