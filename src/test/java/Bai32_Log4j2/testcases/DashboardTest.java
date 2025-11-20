package Bai32_Log4j2.testcases;

import Bai32_Log4j2.pages.DashboardPage;
import Bai32_Log4j2.pages.LoginPage;
import Bai32_Log4j2.pages.ProjectsPage;
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
