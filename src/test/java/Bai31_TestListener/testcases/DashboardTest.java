package Bai31_TestListener.testcases;

import Bai31_TestListener.pages.DashboardPage;
import Bai31_TestListener.pages.LoginPage;
import Bai31_TestListener.pages.ProjectsPage;
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
